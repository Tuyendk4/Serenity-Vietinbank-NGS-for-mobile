package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SuccessPopup extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thành công\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNotification;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý\"]")
  private WebElement btnAgree;

  public SuccessPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotification() {
    return lblNotification.getText();
  }

  public void clickAgree() {
    click(btnAgree);
  }
}
