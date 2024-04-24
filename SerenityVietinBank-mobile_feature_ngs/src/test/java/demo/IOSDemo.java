package demo;

import screens.mobile.Home;
import screens.mobile.Launcher;
import screens.mobile.LoanAndCreditService;
import screens.mobile.Login;
import screens.mobile.OTP;
import screens.mobile.Signup;
import screens.mobile.UserProfile;
import utils.helper.DeviceInfo;

public class IOSDemo {

  public static void main(String[] args) {
//    DeviceInfo deviceInfo = new DeviceInfo("iPhoneX");
//    MobileUI mobileUI = new MobileUI();
//    mobileUI.startApplication(deviceInfo);
    Launcher launcher = new Launcher();
    Signup signup = launcher.click_khong_cho_phep_dan();
    Login login = signup.click_dang_nhap_or_dang_ky_button();
    OTP otp = login.login_with("maihoa953", "12121212");
    Home home = otp.inputOTP("888888");
    home.advertisingPopup().close();
    LoanAndCreditService loanAndCreditService = home.favoriteServices()
        .click_dich_vu_vay_va_tin_dung();
    loanAndCreditService.click_vay_tieu_dung_ca_nhan();
    UserProfile userProfile = loanAndCreditService.navigationBar().goToUserProfile();
    home = userProfile.click_dang_xuat();
//    mobileUI.delay(5000);
//    mobileUI.closeApplication();
  }
}
