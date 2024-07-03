package vn.vietinbank.mobile.steps.iPay.QRCode;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.QRCode.PayQRScreen;

public class PayQRSteps {

    PayQRScreen payQRScreen = new PayQRScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("nhấn Tiếp tục trên MH Thanh toán QR đến MH Xác nhận GD")
    public void nhan_tiep_tuc_tren_mh_thanh_toan_qr_den_mh_xac_nhan_gd() {
        payQRScreen.clickContinueBtn();
    }
}
