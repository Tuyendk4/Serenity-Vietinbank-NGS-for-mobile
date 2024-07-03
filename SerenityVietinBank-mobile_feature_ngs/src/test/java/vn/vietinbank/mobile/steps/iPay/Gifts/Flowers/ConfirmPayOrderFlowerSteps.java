package vn.vietinbank.mobile.steps.iPay.Gifts.Flowers;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.ConfirmPayOrderFlowerScreen;

public class ConfirmPayOrderFlowerSteps {

    ConfirmPayOrderFlowerScreen confirmPayOrderFlowerScreen = new ConfirmPayOrderFlowerScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("nhấn Xác nhận đến MH Thanh toán đặt hoa")
    public void nhan_xac_nhan_den_mh_thanh_toan_dat_hoa() {
        confirmPayOrderFlowerScreen.clickConfirmBtn();
    }
}
