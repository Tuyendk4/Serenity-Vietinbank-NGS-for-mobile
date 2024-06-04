package vn.vietinbank.api.steps.QRCode.utilities;

import static vn.vietinbank.api.configs.DataCommonAppRestService.BASE_URL_DEVELOPMENT;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.*;

import vn.vietinbank.api.common.CommonAPI;
import io.cucumber.java.en.And;

public class QRGenerator extends CommonAPI {

    @And("gọi api QRGenerator với phương thức {string}")
    public void goi_api_qrgenerator_voi_phuong_thuc(String method) {
        callApiWithMethod(BASE_URL_DEVELOPMENT + QR_CODE + UTILITIES + QR_GENERATOR, method);
    }
}
