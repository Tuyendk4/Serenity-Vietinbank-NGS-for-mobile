package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;

public class AdvertisingPopup extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
//  @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
  private WebElement iconClose;

  public AdvertisingPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Đóng popup Quảng cáo")
  public void close() {
    if(waitForElementVisible(iconClose, 5)){
      click(iconClose);
    }
  }
}
