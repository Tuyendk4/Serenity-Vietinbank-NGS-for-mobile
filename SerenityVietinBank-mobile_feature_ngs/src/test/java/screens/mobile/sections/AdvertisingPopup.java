package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.annotations.Step;

public class AdvertisingPopup extends BaseScreen {

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
//  @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
//  private WebElement iconClose;

  private final String iconClose = "//XCUIElementTypeButton[@name=\"closeWhite\"]";
//  @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
//  private WebElement iconClose;

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
