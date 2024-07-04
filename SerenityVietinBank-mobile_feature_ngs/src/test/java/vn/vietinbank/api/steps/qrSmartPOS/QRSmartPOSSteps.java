package vn.vietinbank.api.steps.qrSmartPOS;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.api.common.APIHelper;
import vn.vietinbank.api.steps.CommonSteps;
import vn.vietinbank.utils.converter.Converter;
import vn.vietinbank.utils.data.GetData;

import java.io.File;

import static vn.vietinbank.utils.Constants.JSONPATH_BEGIN;

public class QRSmartPOSSteps {

    Converter converter = new Converter();
    APIHelper apiHelper = new APIHelper();

    @Given("tạo headers request QRSmartPOS")
    public void tao_headers_request_QRSmartPOS() {
        String configPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "configs" + File.separator + "QRSmartPOS/headerParams.json";
        String keyClientSecret = new GetData().getValueFromJson(configPath, JSONPATH_BEGIN + "qrSmartPOS[0].key");
        String valueClientSecret = new GetData().getValueFromJson(configPath, JSONPATH_BEGIN + "qrSmartPOS[0].value");
        String keyClientId = new GetData().getValueFromJson(configPath, JSONPATH_BEGIN + "qrSmartPOS[1].key");
        String valueClientId = new GetData().getValueFromJson(configPath, JSONPATH_BEGIN + "qrSmartPOS[1].value");
        apiHelper.createHeadersDefault("json");
        apiHelper.updateHeadersWithValue(keyClientSecret, valueClientSecret);
        apiHelper.updateHeadersWithValue(keyClientId, valueClientId);
        CommonSteps.headers = apiHelper.getHeaders();
    }

    @And("giải mã base64 {string} và lưu với tên biến {string}")
    public void giai_ma_base64_va_luu_voi_ten_bien(String serenityVariable, String variableNameSave) {
        String saveVariable = Serenity.sessionVariableCalled(serenityVariable);
        String base64Decoded = converter.decodeBase64String(saveVariable);
        Serenity.setSessionVariable(variableNameSave).to(base64Decoded);
    }
}