package vn.vietinbank.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import vn.vietinbank.api.common.APIHelper;
import vn.vietinbank.api.common.CommonAPI;
import vn.vietinbank.utils.converter.Converter;
import vn.vietinbank.utils.data.CompareData;
import vn.vietinbank.utils.data.DataInput;
import vn.vietinbank.utils.data.GetData;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static vn.vietinbank.utils.Constants.*;


public class CommonSteps {

    public static Map<String, String> headers;
    private static Map<String, String> params;
    private static Response responseAPI;
    private static String body;
    private static JSONObject responseExpected;
    private static JSONObject response;
    Converter converter = new Converter();
    APIHelper apiHelper = new APIHelper();
    CommonAPI commonAPI = new CommonAPI();
    CompareData compareData = new CompareData();
    DataInput dataInput = new DataInput();
    Logger logger = LogManager.getLogger(CommonSteps.class);

    public static Map<String, String> getHeaders() {
        return headers;
    }

    public static Map<String, String> getParams() {
        return params;
    }

    public static Response getResponseAPI() {
        return responseAPI;
    }

    public static String getBody() {
        return body;
    }

    public static JSONObject getResponseExpected() {
        return responseExpected;
    }

    public static JSONObject getResponse() {
        return response;
    }

    @Given("tạo headers request mặc định")
    public void tao_headers_request_mac_dinh() {
        apiHelper.createHeadersDefault("json");
        headers = apiHelper.getHeaders();
    }

    @Given("tạo headers request với Accept {string}")
    public void tao_headers_request_voi_accept(String accept) {
        apiHelper.createHeadersDefault("json");
        apiHelper.updateHeadersWithValue("Accept", accept);
        headers = apiHelper.getHeaders();
    }

    @Given("tạo headers request with authorization token {string}")
    public void tao_headers_request_with_authorization_type_and_token(String token) {
        apiHelper.createHeadersDefault("json");
        apiHelper.updateHeadersWithValue("Authorization", token);
        headers = apiHelper.getHeaders();
    }

    @And("gọi api {string} với phương thức {string}")
    public void goi_api_voi_phuong_thuc(String jsonPath, String method) {
        responseAPI = commonAPI.callAPI(jsonPath, method);
        response = converter.responseToJSONObject(responseAPI);
    }

    @Then("httpCode phải là {int}")
    public void httpcode_phai_la(int expectedHttpStatusCode) {
        compareData.compareHttpStatusCode(expectedHttpStatusCode);
    }

    @And("lấy {string} từ file json {string}")
    public void lay_tu_file_json(String source, String pathAPIDataFile) {
        pathAPIDataFile = pathAPIDataFile.replace("/", File.separator).replace("\\", File.separator);
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "api" + File.separator + "data" + File.separator + pathAPIDataFile;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);
            logger.info("{} trước khi update: {}", source, jsonObject.toString(4));
            if (source.equals(BODY_REQUEST)) {
                body = jsonObject.toString();
            }
            if (source.equals(RESPONSE_EXPECTED)) {
                responseExpected = jsonObject;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        logger.info("Nội dung của Json File {} được lưu vào biến {}", filePath, source);
    }

    @And("cập nhật lại json {string}")
    public void cap_nhat_lai_json(String source, DataTable dataTable) {
        JSONObject jsonObject = null;
        if (source.equals(BODY_REQUEST)) {
            jsonObject = converter.stringToJSONObject(body);
        }
        if (source.equals(RESPONSE_EXPECTED)) {
            jsonObject = responseExpected;
        }
        switch (source) {
            case BODY_REQUEST:
                body = dataInput.updateJSONObject(jsonObject, dataTable).toString();
                break;
            case RESPONSE_EXPECTED:
                responseExpected = dataInput.updateJSONObject(jsonObject, dataTable);
                break;
            default:
                break;
        }
    }

    @And("so sánh response thực tế với mong muốn")
    public void so_sanh_response_thuc_te_voi_mong_muon() {
        try {
            JSONAssert.assertEquals(response, responseExpected, true);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @And("so sánh response thực tế với mong muốn và không so sánh các trường {string}")
    public void so_sanh_response_thuc_te_voi_mong_muon_va_khong_so_sanh_cac_truong(String ignoreFields) {
        List<String> listIgnoreFields = converter.stringToList(ignoreFields, ", ");
        boolean actualResult = compareData.compareJSONObjectsWithIgnoreFields(response, responseExpected, listIgnoreFields);
        assertThat(actualResult, equalTo(true));
    }

    @And("so sánh trường có jsonPath {string} của response thực tế với mong muốn")
    public void so_sanh_cac_truong_co_jsonpath_cua_response_thuc_te_voi_mong_muon(String jsonPath) {
        boolean actualResult = compareData.compareValueWithJsonPathFromJSONObjects(response, responseExpected, jsonPath);
        assertThat(actualResult, equalTo(true));
    }

    @And("lấy data với jsonPath {string} và lưu vào serenity variable {string}")
    public void lay_data_voi_jsonPath_and_save_to_serenity_variable(String jsonPath, String serenityVariable) {
        String saveVariable = new GetData().getDataWithJsonPath(response, jsonPath);
        Serenity.setSessionVariable(serenityVariable).to(saveVariable);
    }

    @And("lưu giá trị của các jsonPath {string} từ {string} với danh sách sessionVariableName {string}")
    public void luu_cac_gia_tri_cua_json_path_tu_voi_danh_sach_session_variable_name(String listJsonPathStr, String source, String listSessionVariableNameStr) {
        String jsonString = null;
        if (source.equals(BODY_REQUEST)) {
            jsonString = body;
        }
        if (source.equals(RESPONSE_EXPECTED)) {
            jsonString = responseExpected.toString();
        }
        if (source.equals(RESPONSE)) {
            jsonString = response.toString();
        }
        List<String> listJsonPath = converter.stringToList(listJsonPathStr, ", ");
        List<String> listSessionVariableName = converter.stringToList(listSessionVariableNameStr, ", ");
        if (listJsonPath.size() == listSessionVariableName.size()) {
            for (int i = 0; i < listJsonPath.size(); i++) {
                String jsonPath = listJsonPath.get(i);
                String value = new GetData().getValueFromJsonString(jsonString, JSONPATH_BEGIN + jsonPath);
                Serenity.setSessionVariable(listSessionVariableName.get(i)).to(value);
                logger.info("JSONPATH '{}' có giá trị '{}' từ '{}' đã được lưu thành Serenity Session Variable '{}'", jsonPath, value, source, listSessionVariableName.get(i));
            }
        } else logger.error("Số lượng phần tử của key và value khác nhau");
    }

}