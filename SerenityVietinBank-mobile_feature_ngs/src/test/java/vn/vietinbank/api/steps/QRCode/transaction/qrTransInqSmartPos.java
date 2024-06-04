package vn.vietinbank.api.steps.QRCode.transaction;

import static vn.vietinbank.api.configs.DataCommonAppRestService.BASE_URL_DEVELOPMENT;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.*;

import vn.vietinbank.api.common.CommonAPI;
import io.cucumber.java.en.And;

public class qrTransInqSmartPos extends CommonAPI {

    @And("gọi api QRTransInqSmartPos với phương thức {string}")
    public void goi_api_qrtransinqsmartpos_voi_phuong_thuc(String method) {
        callApiWithMethod(BASE_URL_DEVELOPMENT + QR_CODE + TRANSACTION + QR_TRANS_INQ_SMART_POS, method);
    }
}
