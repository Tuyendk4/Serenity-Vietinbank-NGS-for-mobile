package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.annotations.Step;

public class AdvertisingPopup extends BaseScreen {

  private final String iconClose = "//XCUIElementTypeButton[@name=\"closeWhite\"]";

  public AdvertisingPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Đóng popup Quảng cáo")
  public void close() {
    if (appiumDriver instanceof IOSDriver) {
      if (waitForElementVisible(iconClose, 5)) {
        click(iconClose);
      }
    }

  }
}
