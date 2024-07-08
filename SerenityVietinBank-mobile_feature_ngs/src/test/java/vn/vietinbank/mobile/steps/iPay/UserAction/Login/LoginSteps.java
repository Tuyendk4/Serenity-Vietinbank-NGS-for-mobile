package vn.vietinbank.mobile.steps.iPay.UserAction.Login;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Home.HomeScreen;
import vn.vietinbank.mobile.screens.iPay.Transfer.TransferMoneyScreen;
import vn.vietinbank.mobile.screens.iPay.UserAction.Login.LoginScreen;
import vn.vietinbank.mobile.screens.iPay.UserAction.OTP.OTPScreen;
import vn.vietinbank.mobile.screens.iPay.UserAction.Signup.SignupScreen;
import vn.vietinbank.utils.data.GetData;

import static vn.vietinbank.utils.Constants.*;


public class LoginSteps {

    AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");
    SignupScreen signupScreen = new SignupScreen(appiumDriver);
    LoginScreen loginScreen = new LoginScreen(appiumDriver);
    OTPScreen otpScreen = new OTPScreen(appiumDriver);
    HomeScreen homeScreen = new HomeScreen(appiumDriver);

    @And("Đăng nhập với mật khẩu {string}")
    public void dang_nhap_voi_mat_khau(String password) {
        loginScreen.loginWithPassword(password);
        homeScreen.closeAdsPopup();
    }

    @And("đăng nhập với tên đăng nhập {string} và mật khẩu {string}")
    public void dang_nhap_voi_ten_dang_nhap_va_mat_khau(String username, String password) throws InterruptedException {
        if (username.contains("FROM_")) {
            username = new GetData().getDataFromMultipleSources(USERNAME, username);
        }
        if (password.contains("FROM_")) {
            password = new GetData().getDataFromMultipleSources(PASSWORD, password);
        }
        otpScreen = new OTPScreen(appiumDriver);

        loginScreen.loginWithUsernamePassword(username, password);
        otpScreen.inputOTP(OTP);
        homeScreen.closeAdsPopup();
    }

    @And("nhấn Đăng nhập bằng tài khoản khác")
    public void nhan_dang_nhap_bang_tai_khoan_khac() {
        loginScreen.clickLoginWithOtherAccountTxt();
    }

    @And("Đăng nhập user {string}, password {string}, otp {string}")
    public void login_with(String username, String password, String otp) throws InterruptedException {
        loginScreen = signupScreen.clickLoginOrSignUpBtn();
        otpScreen = loginScreen.login_with(username, password);
        homeScreen = otpScreen.inputOTP(OTP);
        homeScreen.advertisingPopup().close();
    }
}
