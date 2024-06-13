package vn.vietinbank.api.utils;

import com.jayway.jsonpath.JsonPath;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.Iterator;
import java.util.List;

import static vn.vietinbank.api.configs.APIConstants.FALSE;
import static vn.vietinbank.api.configs.APIConstants.TRUE;
import static vn.vietinbank.api.configs.GetDataConstants.RESPONSE_STATUS;

public class CompareData {

    private static final Logger logger = LogManager.getLogger(CompareData.class);

    public static void compareHttpStatusCode(int statusCodeExpected) {
        int statusCodeActual = Serenity.sessionVariableCalled(RESPONSE_STATUS);
        Assert.assertEquals(statusCodeExpected, statusCodeActual);
    }

    public static Object[] compareJSONObjects(@NotNull JSONObject jsonObject1, @NotNull JSONObject jsonObject2) throws JSONException {
        String reason = "";
        if (jsonObject1.length() != jsonObject2.length()) {
            reason = "2 Objects have different lengths";
            return new Object[]{FALSE, reason};
        }
        Iterator<String> keys = jsonObject1.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!jsonObject2.has(key)) {
                reason = "Different key: " + key;
                return new Object[]{FALSE, reason};
            }
            if (!jsonObject1.get(key).toString().equals(jsonObject2.get(key).toString())) {
                reason = "Different value for key '" + key + "': actual: " + jsonObject1.get(key) + " and expected: " + jsonObject2.get(key);
                return new Object[]{FALSE, reason};
            }
        }
        return new Object[]{TRUE, reason};
    }

    public static Object[] compareJSONObjectsWithIgnoreFields(@NotNull JSONObject jsonObject1, @NotNull JSONObject jsonObject2, List<String> ignoreFields) throws JSONException {
        String reason = "";
        if (jsonObject1.length() != jsonObject2.length()) {
            reason = "2 Objects have different lengths";
            return new Object[]{FALSE, reason};
        }
        Iterator<String> keys = jsonObject1.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!ignoreFields.contains(key)) {
                if (!jsonObject2.has(key)) {
                    reason = "Different key: " + key;
                    return new Object[]{FALSE, reason};
                }
                if (!jsonObject1.get(key).toString().equals(jsonObject2.get(key).toString())) {
                    reason = "Different value for key '" + key + "': actual: " + jsonObject1.get(key) + " and expected: " + jsonObject2.get(key);
                    return new Object[]{FALSE, reason};
                }
            }
        }
        return new Object[]{TRUE, reason};
    }

    public static Object[] compareJSONObjectsWithJsonPath(@NotNull JSONObject jsonObject1, @NotNull JSONObject jsonObject2, String key) throws JSONException {
        String reason = "";
        String jsonPath = "$." + key;
        String actual = JsonPath.read(jsonObject1.toString(), jsonPath);
        String expected = JsonPath.read(jsonObject2.toString(), jsonPath);
        if (!actual.equals(expected)) {
            reason = "Different value for key '" + key + "': actual: " + actual + " and expected: " + expected;
            return new Object[]{FALSE, reason};
        }
        return new Object[]{TRUE, reason};
    }

    public static void applyIgnoreFields(JSONObject actual, JSONObject expected, String ignoreFields) throws JSONException {
        if (actual.has(ignoreFields) && expected.has(ignoreFields)) {
            expected.put(ignoreFields, JSONObject.NULL);
            actual.put(ignoreFields, JSONObject.NULL);
        }
    }

    public static String getDataWithJsonPath(@NotNull JSONObject jsonObject, String key) throws JSONException {
        String jsonPath = "$." + key;
        String value = JsonPath.read(jsonObject.toString(), jsonPath);
        logger.info(value);
        return value;
    }
}
