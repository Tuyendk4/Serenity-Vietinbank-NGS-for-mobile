package vn.vietinbank.steps.mobile.ipay.common;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.vi.Khi;
import vn.vietinbank.screens.mobile.ipay.ipay_common.*;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class LoginStepdefs extends BaseStep {

  @Given("^Mở VTB iPayApp$")
  public void open_Vietinbank_iPay_app() {
    Launcher launcher = new Launcher(appiumDriver);
//    Signup signup = launcher.click_Skip();
//    login = signup.click_dang_nhap_or_dang_ky_button();
  }

  @When("Đăng nhập user {string}, password {string}, otp {string}")
  public void login_with(String userName, String password, String otpCode) {
    OTP otp;
    otp = login.login_with(userName, password);
    home = otp.inputOTP(otpCode);
    home.advertisingPopup().close();
  }
  @Khi("Thực hiện đăng nhập với khi đã đăng nhập một lần với mật khẩu {string}")
  public void login_with_password(String password){
    OTP otp;
    otp = login.login_with_pass(password);
    home = otp.inputOTP("");
  }
  @When("Nhập user {string}, password {string}, otp {string}")
  public void login_with_M6S03(String userName, String password, String otpCode){
      Login_M6S03 login = new Login_M6S03(appiumDriver);
      login.login_with_M6S03(userName, password, otpCode);
  }
}
