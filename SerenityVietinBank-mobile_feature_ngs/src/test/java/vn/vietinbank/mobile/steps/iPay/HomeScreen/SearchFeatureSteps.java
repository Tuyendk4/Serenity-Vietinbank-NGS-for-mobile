package vn.vietinbank.mobile.steps.iPay.HomeScreen;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Home.HomeScreen;

public class SearchFeatureSteps {

    HomeScreen homeScreen = new HomeScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("nhập tìm kiếm và đến MH {string}")
    public void nhap_tim_kiem_va_den_mh(String feature) {
        if (feature.equals("Gửi tiền mừng lễ, Tết")) {
            homeScreen.goToSendCongratulatoryMoneyScreen(feature);
        }
    }
}
