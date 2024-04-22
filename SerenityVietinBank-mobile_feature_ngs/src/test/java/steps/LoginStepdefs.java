package steps;

import io.cucumber.java.vi.Cho;
import io.cucumber.java.vi.Khi;
import runner.Runner;
import screens.mobile.Home;
import screens.mobile.Launcher;
import screens.mobile.OTP;
import screens.mobile.Signup;
import utils.helper.DeviceInfo;
import utils.keywords.MobileUI;

public class LoginStepdefs extends Runner {

  @Cho("^[a-zA-Z].* mở Vietinbank iPay app")
  public void open_Vietinbank_iPay_app() {
    DeviceInfo deviceInfo = new DeviceInfo("iPhoneX");
    mobileUI = new MobileUI();
    mobileUI.startApplication(deviceInfo);
    Launcher launcher = new Launcher(mobileUI);
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
