package vn.vietinbank.utils.data;

import com.jayway.jsonpath.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import vn.vietinbank.api.steps.CommonSteps;

import java.util.Iterator;
import java.util.List;

import static vn.vietinbank.utils.Constants.JSONPATH_BEGIN;

public class CompareData {

    Logger logger = LogManager.getLogger(CompareData.class);

    /**
     * so sánh httpStatusCode
     *
     * @param statusCodeExpected là httpStatusCode mong muốn
     */
    public void compareHttpStatusCode(int statusCodeExpected) {
        int statusCodeActual = CommonSteps.getResponseAPI().statusCode();
        logger.info("statusCodeActual: {}", statusCodeActual);
        logger.info("statusCodeExpected: {}", statusCodeExpected);
        Assert.assertEquals(statusCodeExpected, statusCodeActual);
    }

    /**
     * so sánh 2 JSONObject
     *
     * @param jsonObject1 là jsonObject thứ 1
     * @param jsonObject2 là jsonObject thứ 2
     * @return kết quả so sánh 2 JSONObject
     */
    public boolean compareJSONObjects(@NotNull JSONObject jsonObject1, @NotNull JSONObject jsonObject2) {
        if (jsonObject1.length() != jsonObject2.length()) {
            logger.error("2 Objects have different lengths");
            return false;
        }
        Iterator<String> keys = jsonObject1.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!jsonObject2.has(key)) {
                logger.error(String.format("Different key: %s", key));
                return false;
            }
            try {
                if (!jsonObject1.get(key).toString().equals(jsonObject2.get(key).toString())) {
                    logger.error(String.format("Different value for key '%s': actual: %s and expected: %s", key, jsonObject1.get(key), jsonObject2.get(key)));
                    return false;
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    /**
     * so sánh 2 JSONObject ngoại trừ một số trường
     *
     * @param jsonObject1  là jsonObject thứ 1
     * @param jsonObject2  là jsonObject thứ 2
     * @param ignoreFields là những trường không so sánh
     * @return kết quả so sánh 2 JSONObject
     */
    public boolean compareJSONObjectsWithIgnoreFields(@NotNull JSONObject jsonObject1, @NotNull JSONObject jsonObject2, List<String> ignoreFields) {
        if (jsonObject1.length() != jsonObject2.length()) {
            logger.error("2 Objects have different lengths");
            return false;
        }
        Iterator<String> keys = jsonObject1.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!ignoreFields.contains(key)) {
                if (!jsonObject2.has(key)) {
                    logger.error(String.format("Different key: %s", key));
                    return false;
                }
                try {
                    if (!jsonObject1.get(key).toString().equals(jsonObject2.get(key).toString())) {
                        logger.error(String.format("Different value for key '%s': actual: %s and expected: %s", key, jsonObject1.get(key), jsonObject2.get(key)));
                        return false;
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    /**
     * so sánh giá trị của 2 trường sử dụng JSONPath trong JSONObject
     *
     * @param jsonObject1 là jsonObject thứ 1
     * @param jsonObject2 là jsonObject thứ 2
     * @param key         là JSONPath cần so sánh
     * @return kết quả so sánh 2 key của 2 JSONObject
     */
    public boolean compareValueWithJsonPathFromJSONObjects(@NotNull JSONObject jsonObject1, @NotNull JSONObject jsonObject2, String key) {
        String jsonPath = JSONPATH_BEGIN + key;
        Object actual = JsonPath.read(jsonObject1.toString(), jsonPath);
        Object expected = JsonPath.read(jsonObject2.toString(), jsonPath);
        if (!actual.equals(expected)) {
            try {
                logger.error(String.format("Different value for key '%s': actual: %s and expected: %s", key, jsonObject1.get(key), jsonObject2.get(key)));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return false;
        }
        return true;
    }
}
