package vn.vietinbank.api.common;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import vn.vietinbank.api.steps.CommonSteps;
import vn.vietinbank.utils.converter.Converter;
import vn.vietinbank.utils.data.GetData;

import java.io.File;

import static vn.vietinbank.utils.Constants.*;

public class CommonAPI {

    Logger logger = LogManager.getLogger(CommonAPI.class);
    Converter converter = new Converter();
    String pathAPIConfigs = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "configs" + File.separator;

    /**
     * common call API, lưu RESPONSE thành Serenity Session Variable RESPONSE
     *
     * @param jsonPath là path của api nằm trong file URI.json
     * @param method   là phương thức của API
     */
    public Response callAPI(String jsonPath, @NotNull String method) {
        String APIPathFile = pathAPIConfigs + "URI.json";
        String APIUrlFile = pathAPIConfigs + "BaseUrl.json";
        String url = new GetData().getValueFromJson(APIUrlFile, String.format(JSONPATH_BEGIN + "%s.%s", converter.getStringBeforeFirstDot(jsonPath), ENV)) + new GetData().getValueFromJson(APIPathFile, String.format(JSONPATH_BEGIN + "%s", jsonPath));
        Response response;
        RequestSpecification requestSpec = SerenityRest.given()
                .baseUri(url)
                .relaxedHTTPSValidation()
                .headers(CommonSteps.getHeaders());
        switch (method) {
            case METHOD_POST:
                response = requestSpec.body(CommonSteps.getBody()).post();
                break;
            case METHOD_GET:
                response = requestSpec.get();
                break;
            case METHOD_GET_PARAMS:
                response = requestSpec.params(CommonSteps.getParams()).get();
                break;
            default:
                response = null;
                break;
        }
        assert response != null;
        logger.info("URL: {}", url);
        logger.info("Method: {}", method);
        try {
            logger.info("Response: {}", converter.responseToJSONObject(response).toString(4));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
