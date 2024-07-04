package vn.vietinbank.mobile.steps.iPay.Gifts.Flowers;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.PayOrderFlowerScreen;

public class PayOrderFlowerSteps {

    PayOrderFlowerScreen payOrderFlowerScreen = new PayOrderFlowerScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("nhấn Tiếp tục thanh toán đến MH Xác nhận GD")
    public void nhan_tiep_tuc_thanh_toan_den_mh_xac_nhan_gd() {
        payOrderFlowerScreen.clickContinueBtn();
    }
}
