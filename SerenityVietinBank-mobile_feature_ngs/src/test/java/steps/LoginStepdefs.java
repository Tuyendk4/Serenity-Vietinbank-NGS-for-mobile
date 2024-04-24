package steps;

import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import cucumber.CucumberTestSuite;
import screens.mobile.Launcher;
import screens.mobile.OTP;
import screens.mobile.Signup;


public class LoginStepdefs extends CucumberTestSuite {

  @Cho("^[a-zA-Z].* mở Vietinbank iPay app")
  public void open_Vietinbank_iPay_app() {

    Launcher launcher = new Launcher();
    Signup signup = launcher.click_khong_cho_phep_dan();
    login = signup.click_dang_nhap_or_dang_ky_button();
  }

  @Khi("Cô ấy thực hiện đăng nhập với tên người dùng {string} và mật khẩu {string}")
  public void login_with(String userName, String password) {
    OTP otp = login.login_with("maihoa953", "12121212");
    home = otp.inputOTP("888888");
    home.advertisingPopup().close();
  }
}
