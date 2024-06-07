package vn.vietinbank.steps.mobile.ipay.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.vi.Khi;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Launcher;
import vn.vietinbank.screens.mobile.ipay.ipay_common.OTP;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Signup;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class LoginStepdefs extends BaseStep {

  @Given("^Mở VTB iPayApp$")
  public void open_Vietinbank_iPay_app() {
    Launcher launcher = new Launcher(appiumDriver);
    Signup signup = launcher.click_Skip();
    login = signup.click_dang_nhap_or_dang_ky_button();
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

  @Khi("Đăng nhập với password {string}")
  public void login_with_pass(String password){
    home = login.login_with_password_only(password);
  }
}
