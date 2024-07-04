package vn.vietinbank.mobile.steps.iPay.Notification;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Popup.Notification.NotificationScreen;

public class NotificationSteps {

    NotificationScreen notificationScreen = new NotificationScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @Then("hiển thị thông báo {string}")
    public void hien_thi_thong_bao(String message) {
        notificationScreen.notificationDisplayed(message);
    }

    @Then("hiển thị popup thông báo")
    public void hien_thi_popup_thong_bao() {
        notificationScreen.notificationPopupDisplayed();
    }

    @And("nhấn vào {string}")
    public void nhan_vao_nut(String text) {
        notificationScreen.clickDynamicBtn(text);
    }

    @Then("popup Thông báo được đóng lại")
    public void popup_thong_bao_duoc_dong_lai() {
        notificationScreen.notificationPopupNotVisible();
    }
}
