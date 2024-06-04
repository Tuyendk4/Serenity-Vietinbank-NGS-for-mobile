package steps;

import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import runner.Runner;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Launcher;;
import vn.vietinbank.screens.mobile.ipay.ipay_common.OTP;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Signup;

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

  @Khi("Thực hiện đăng nhập với khi đã đăng nhập một lần với mật khẩu {string}")
  public void login_with_password(String password){
    OTP otp;
    otp = login.login_with_pass(password);
    home = otp.inputOTP("");
  }
}
