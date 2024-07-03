package vn.vietinbank.utils.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import net.serenitybdd.core.Serenity;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static vn.vietinbank.utils.Constants.*;

public class GetData {

    Logger logger = LogManager.getLogger(GetData.class);

    public static String getString(String source, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(source);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    @SneakyThrows
    public static JSONObject filterAndGetFromJsonArray(JSONArray jsonArray, String key, String value) {
        JSONObject jsonObject = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                jsonObject = jsonArray.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            try {
                if (jsonObject.get(key).equals(value)) {
                    break;
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return jsonObject;
    }

    /**
     * lấy giá trị từ serenity.conf
     *
     * @param key là danh sách JSONPath cần lấy giá trị
     */
    public String getValueOf(String key) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(key);
    }

    /**
     * lấy giá trị từ nhiều nguồn: file serenity.conf, command line, json file,...
     *
     * @param key là danh sách JSONPath cần lấy giá trị
     * @return giá trị của key đấy
     */
    public String getDataFromMultipleSources(String key, String source) {
        switch (source) {
            case FROM_COMMAND_LINE:
            case FROM_CONF_FILE:
                return getValueOf(key);
            case FROM_ACCOUNTS_FILE:
                String nameApp = Serenity.sessionVariableCalled("nameApp");
                String username = new GetData().getValueOf(USERNAME);
                String accountFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "mobile" + File.separator + "data" + File.separator + "accounts.json";
                return getValueFromJson(accountFile, String.format(JSONPATH_BEGIN + "%s.%s.accountsLogin.%s.%s", nameApp, ENV, username, key));
        }
        return null;
    }

    /**
     * lấy giá trị từ nhiều nguồn: file serenity.conf, command line, json file,...
     *
     * @param key là danh sách JSONPath cần lấy giá trị
     * @return giá trị của key đấy
     * mvn clean verify -Dusername="abc" -Dpassword="avc123"
     */
    public String getValue(String key) {
        if(!System.getenv(key).isEmpty()) {
            return System.getenv(key);
        }
        if(!getValueOf(key).isEmpty()) {
            return getValueOf(key);
        }
        String nameApp = Serenity.sessionVariableCalled("nameApp");
        String username = getValueOf(USERNAME);
        String accountFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "mobile" + File.separator + "data" + File.separator + "accounts.json";
        return getValueFromJson(accountFile, String.format(JSONPATH_BEGIN + "%s.%s.accountsLogin.%s.%s", nameApp, ENV, username, key));
    }

    /**
     * lấy giá trị của JSONPath từ JSON File
     *
     * @param filePath là path của JSON File
     * @param jsonPath là JSONPath cần lấy giá trị
     * @return giá trị của jsonPath đấy
     */
    public String getValueFromJson(String filePath, String jsonPath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            Object value = JsonPath.read(content, jsonPath);
            return value.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //

    /**
     * lấy giá trị của JSONPath từ JSON File
     *
     * @param jsonObject là JSONObject
     * @param key        là JSONPath cần lấy giá trị
     * @return giá trị của jsonPath đấy
     */
    public String getDataWithJsonPath(@NotNull JSONObject jsonObject, String key) {
        String jsonPath = JSONPATH_BEGIN + key;
        String value = JsonPath.read(jsonObject.toString(), jsonPath);
        logger.info(value);
        return value;
    }

    /**
     * lấy giá trị của JSONPath từ JSON String
     *
     * @param jsonString là JSON String chứa giá trị
     * @param jsonPath   là JSONPath cần lấy giá trị
     */
    public String getValueFromJsonString(String jsonString, String jsonPath) {
        if (jsonString == null || jsonString.isEmpty()) {
            throw new IllegalArgumentException("Input JSON string cannot be null or empty");
        }
        if (jsonPath == null || jsonPath.isEmpty()) {
            throw new IllegalArgumentException("JSONPath cannot be null or empty");
        }
        return JsonPath.read(jsonString, jsonPath);
    }

    /**
     * Lấy toàn bộ thông tin của json lưu vào list
     *
     * @param obj Json input
     * @return Danh sách các key path
     */
    public List<String> getAllPathJsonObject(JsonObject obj) {
        List<String> result = new ArrayList<>();
        for (String keyEntry : obj.keySet()) {
            Object value = obj.get(keyEntry);
            if (value instanceof JsonObject) {
                // Đệ quy để lấy thông tin path bên trong
                for (String s : getAllPathJsonObject((JsonObject) value)) {
                    result.add(keyEntry + "." + s);
                }
            } else if (value instanceof JsonArray) {
                result.addAll(getAllPathJsonArray((JsonArray) value, keyEntry));
            } else {
                // Add path
                result.add(keyEntry);
            }
        }
        return result;
    }

    public List<String> getAllPathJsonArray(JsonArray jsonArray, String parentKey) {
        List<String> result = new ArrayList<>();
        // Lấy thông tin về mảng trong json
        for (int i = 0; i < (jsonArray).size(); i++) {
            Object item = (jsonArray).get(i);

            // Nếu phần tử là JSONObject tiến hành đệ quy để lấy
            if (item instanceof JsonObject) {
                for (String s : getAllPathJsonObject((JsonObject) item))
                    result.add(parentKey + "[" + i + "]." + s);
                continue;
            }
            //Array normal [0,1,2,4,5]
            result.add(parentKey + "[" + i + "]");
        }
        return result;
    }
}
