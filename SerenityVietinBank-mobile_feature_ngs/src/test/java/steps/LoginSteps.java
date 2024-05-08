package steps;

import base.MobileDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import runner.Runner;
import screens.mobile.Home;
import screens.mobile.Launcher;
import screens.mobile.OTP;
import screens.mobile.Signup;


public class LoginSteps extends Runner {
    @Given("open Vietinbank app")
    public void openVietinbankApp() {
        mobileDriver = new MobileDriver();
        Launcher launcher = new Launcher(mobileDriver.newDriver());
        Signup signup = launcher.clickDoNotAllowPasting();
        login = signup.clickLoginOrSignUpBtn();
    }

    @And("login Vietinbank app with username {string} and password {string}")
    public void loginWithUsernamePassword(String userName, String password) {
        OTP otp = login.loginWithUsernamePassword(userName, password);
        Home home = otp.inputOTP("888888");
        home.advertisingPopup().closeAdsPopup();
    }
}
