package vn.vietinbank.screens.mobile.ipay.ipay_common;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class UserProfile extends BaseScreen {

  private final String android_btnDangNhap = "";
  private final String ios_btnDangNhap = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]";

  private final String android_btnDangXuat = "//*[@text=\"Đăng xuất\"]";
  private final String ios_btnDangXuat = "//XCUIElementTypeButton[@name=\"Đăng xuất\"]";

  public UserProfile(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }


  public Home click_dang_xuat() {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnDangXuat);
    } else {
      click(ios_btnDangXuat);
    }
    return new Home(appiumDriver);
  }
}
