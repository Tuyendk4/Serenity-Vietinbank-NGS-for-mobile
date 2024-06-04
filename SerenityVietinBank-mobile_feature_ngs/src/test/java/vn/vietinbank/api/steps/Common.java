package vn.vietinbank.api.steps;

import static vn.vietinbank.api.common.HeaderHelper.headersDefault;
import static vn.vietinbank.api.configs.GetDataConstants.HEADERS;
import static vn.vietinbank.api.configs.QRSmartPOS.Constants.X_IBM_CLIENT_ID;
import static vn.vietinbank.api.configs.QRSmartPOS.Constants.X_IBM_CLIENT_SECRET;
import static vn.vietinbank.api.utils.ConvertData.decodeBase64String;

import vn.vietinbank.api.common.CommonAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.Map;
import net.serenitybdd.core.Serenity;

public class Common extends CommonAPI {

    @Given("tạo headers request QRSmartPOS")
    public void tao_headers_request_QRSmartPOS() {
        Map<String, String> headers = headersDefault();
        headers.put(X_IBM_CLIENT_SECRET, "2cd7b943f4d7c5115d44b81487497ae3");
        headers.put(X_IBM_CLIENT_ID, "fbbf1989a3ad0de68446317f5f104df0");
        Serenity.setSessionVariable(HEADERS).to(headers);
    }

    @And("giải mã base64 {string} và lưu với tên biến {string}")
    public void giai_ma_base64_va_luu_voi_ten_bien(String serenityVariable, String variableNameSave) {
        String saveVariable = Serenity.sessionVariableCalled(serenityVariable);
        String base64Decoded = decodeBase64String(saveVariable);
        Serenity.setSessionVariable(variableNameSave).to(base64Decoded);
    }
}
