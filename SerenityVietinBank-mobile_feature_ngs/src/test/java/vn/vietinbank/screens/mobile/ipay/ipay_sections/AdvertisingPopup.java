package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.annotations.Step;

public class AdvertisingPopup extends BaseScreen {

  private final String android_iconClose = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ic_cancel\"]";
  private final String ios_iconClose = "//XCUIElementTypeButton[@name=\"closeWhite\"]";

  public AdvertisingPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Đóng popup Quảng cáo")
  public void close() {
    if (appiumDriver instanceof IOSDriver) {
      if (waitForElementVisible(ios_iconClose, 5)) {
        click(ios_iconClose);
      }
    } else {
      if (waitForElementVisible(android_iconClose, 5)) {
        click(android_iconClose);
      }
    }
    delay(5000);
  }
}
