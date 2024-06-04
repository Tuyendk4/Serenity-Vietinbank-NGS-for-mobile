package vn.vietinbank.api.steps.virtualAccount.v2;

import static vn.vietinbank.api.configs.DataCommonAppRestService.BASE_URL_DEVELOPMENT;
import static vn.vietinbank.api.configs.QRSmartPOS.APIPath.*;

import vn.vietinbank.api.common.CommonAPI;
import io.cucumber.java.en.And;


public class Statusinq extends CommonAPI {

    @And("gọi api VietQRStatusinq với phương thức {string}")
    public void goi_api_vietqrstatusinq_voi_phuong_thuc(String method) {
        callApiWithMethod(BASE_URL_DEVELOPMENT + VIRTUAL_ACCOUNT + V2 + STATUSINQ, method);
    }
}
