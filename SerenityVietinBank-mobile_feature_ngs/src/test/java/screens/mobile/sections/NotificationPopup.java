package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.LoanAndCreditServices;

public class NotificationPopup extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thông báo\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNotificationTitle;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý\"]")
  private WebElement btnAgree;

  public NotificationPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotificationTitle() {
    return lblNotificationTitle.getText();
  }

  public LoanAndCreditServices clickAgreeButton() {
    click(btnAgree);
    return new LoanAndCreditServices(appiumDriver);
  }
}
