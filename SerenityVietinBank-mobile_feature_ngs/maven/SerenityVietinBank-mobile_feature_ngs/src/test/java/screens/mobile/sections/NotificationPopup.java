package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.LoanAndCreditServices;
import screens.mobile.LoanProfile;

public class NotificationPopup extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_title\" and @text=\"Thông báo\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_content\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thông báo\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNotificationTitle;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_right\" and @text=\"Đồng ý\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý\"]")
  private WebElement btnAgree;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận hủy\"]")
  public WebElement btnConfirmToAbort;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục vay\"]")
  public WebElement btnContinueToBorrow;

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

  public LoanProfile clickConfirmToAbortButton() {
    click(btnConfirmToAbort);
    return new LoanProfile(appiumDriver);
  }

  public LoanProfile clickContinueToBorrowButton() {
    click(btnContinueToBorrow);
    return new LoanProfile(appiumDriver);
  }
}
