package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.AdvertisingPopup;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.FavoriteServices;

public class Home extends BaseScreen {

  private final String android_btnAccountNumberList = "";
  private final String ios_btnAccountNumberList = "//XCUIElementTypeStaticText[@name=\"Danh sách tài khoản\"]";

  public Home(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public FavoriteServices favoriteServices() {
    return new FavoriteServices(appiumDriver);
  }

  public AdvertisingPopup advertisingPopup() {
    return new AdvertisingPopup(appiumDriver);
  }

  public AccountNumberList move_to_AccountNumberList() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnAccountNumberList);
    } else {
      tap(ios_btnAccountNumberList);
    }
    delay(3000);
    return new AccountNumberList(appiumDriver);
  }
}
