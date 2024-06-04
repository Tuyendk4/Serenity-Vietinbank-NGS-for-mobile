package vn.vietinbank.api.steps.QR.VietQR;

import static vn.vietinbank.api.configs.DataCommonAppRestService.*;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.*;
import static vn.vietinbank.api.common.CommonAPI.callApiWithMethod;
import static vn.vietinbank.api.configs.DataCommonAppRestService.BASE_URL_DEVELOPMENT;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.GEN;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.QR;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.VIET_QR;

import vn.vietinbank.api.common.CommonAPI;
import io.cucumber.java.en.And;

public class Gen extends CommonAPI {

    @And("gọi api VietQRGen với phương thức {string}")
    public void goi_api_vietqrgen_voi_phuong_thuc(String method) {
        callApiWithMethod(BASE_URL_DEVELOPMENT + QR + VIET_QR + GEN, method);
    }
}
