package vn.vietinbank.screens.mobile.ipay.ipay_common;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Signup extends BaseScreen {

  private final String android_btnLogin = "//android.widget.TextView[@text=\"Đăng nhập/đăng ký\" or @text=\"Đăng nhập\"]";
  private final String ios_btnLogin = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]";

  public Signup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn Đăng nhập/Đăng ký")
  public Login click_dang_nhap_or_dang_ky_button() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnLogin, 10);
    } else {
      click(ios_btnLogin, 10);
    }
    delay(10000);
    return new Login(appiumDriver);
  }
}
