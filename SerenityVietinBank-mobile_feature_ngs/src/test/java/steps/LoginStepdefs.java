package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import runner.Runner;
import screens.mobile.Launcher;
import screens.mobile.OTP;
import screens.mobile.Signup;


public class LoginStepdefs extends Runner {

  @Cho("^Mở VTB iPayApp$")
  public void open_Vietinbank_iPay_app() {
//    mobileDriver = new MobileDriver();
    Launcher launcher = new Launcher(appiumDriver);
//    if(appiumDriver instanceof IOSDriver) {
      Signup signup = launcher.click_Skip();
      login = signup.click_dang_nhap_or_dang_ky_button();
//    }

  }

  @Khi("Đăng nhập user {string}, password {string}")
  public void login_with(String userName, String password) {
    OTP otp;
    otp = login.login_with(userName, password);
    home = otp.inputOTP("888888");
    home.advertisingPopup().close();
  }
}
