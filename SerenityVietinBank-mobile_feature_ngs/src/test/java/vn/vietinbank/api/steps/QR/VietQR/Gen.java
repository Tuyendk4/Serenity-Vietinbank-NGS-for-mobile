package vn.vietinbank.api.steps.QR.VietQR;

import io.cucumber.java.en.And;
import vn.vietinbank.api.common.CommonAPI;

import static vn.vietinbank.api.configs.DataCommonAppRestService.BASE_URL_DEVELOPMENT;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.*;

public class Gen extends CommonAPI {

    @And("gọi api VietQRGen với phương thức {string}")
    public void goi_api_vietqrgen_voi_phuong_thuc(String method) {
        callApiWithMethod(BASE_URL_DEVELOPMENT + QR + VIET_QR + GEN, method);
    }
}
