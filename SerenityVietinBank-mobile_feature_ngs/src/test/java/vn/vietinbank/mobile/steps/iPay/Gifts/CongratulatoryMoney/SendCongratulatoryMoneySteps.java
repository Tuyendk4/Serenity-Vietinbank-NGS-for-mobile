package vn.vietinbank.mobile.steps.iPay.Gifts.CongratulatoryMoney;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Gifts.CongratulatoryMoney.SendCongratulatoryMoneyScreen;

public class SendCongratulatoryMoneySteps {

    SendCongratulatoryMoneyScreen sendCongratulatoryMoneyScreen = new SendCongratulatoryMoneyScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("thêm mới người nhận {string}")
    public void them_moi_nguoi_nhan(String receiver) {
        sendCongratulatoryMoneyScreen.addNewReceiver(receiver);
    }

    @And("nhập số tiền muốn gửi cho từng người {string}")
    public void nhap_so_tien_muon_gui_cho_tung_nguoi(String amount) {
        sendCongratulatoryMoneyScreen.inputAmountToSend(amount);
    }

    @And("nhập lời chúc muốn gửi {string}")
    public void nhap_loi_chuc_muon_gui(String wishes) {
        sendCongratulatoryMoneyScreen.inputWishesToSend(wishes);
    }

    @And("nhấn Tiếp tục trên MH Gửi tiền mừng đến MH Xác nhận GD")
    public void nhan_tiep_tuc_tren_mh_gui_tien_mung_den_mh_xac_nhan_gd() {
        sendCongratulatoryMoneyScreen.clickContinueBtn();
    }
}
