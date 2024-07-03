package vn.vietinbank.mobile.steps.iPay.UserAction.Profile;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.UserAction.Profile.UserProfileScreen;

public class UserProfileSteps {

    UserProfileScreen userProfileScreen = new UserProfileScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("nhấn Đăng xuất")
    public void nhan_dang_xuat() {
        userProfileScreen.clickBtnDangXuat();
    }
}
