package steps;

import base.MobileDriver;
import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import net.serenitybdd.core.Serenity;
import runner.Runner;
import screens.mobile.Launcher;
import screens.mobile.OTP;
import screens.mobile.Signup;


public class LoginStepdefs extends Runner {

  @Cho("^Mở Vietinbank iPay app$")
  public void open_Vietinbank_iPay_app() {
//    mobileDriver = new MobileDriver();
    Launcher launcher = new Launcher(appiumDriver);
    Signup signup = launcher.click_khong_cho_phep_dan();
    login = signup.click_dang_nhap_or_dang_ky_button();
  }

  @Khi("Thực hiện đăng nhập với tên người dùng {string} và mật khẩu {string}")
  public void login_with(String userName, String password) {
    OTP otp = login.login_with(userName, password);
    home = otp.inputOTP("888888");
    home.advertisingPopup().close();
  }

  @Khi("Thực hiện đăng nhập với khi đã đăng nhập một lần với mật khẩu {string}")
  public void login_with_password(String password){
    login.login_with_pass(password);
  }
}
