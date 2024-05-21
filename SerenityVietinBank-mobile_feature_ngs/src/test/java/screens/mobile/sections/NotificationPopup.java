package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.LoanAndCreditServices;
import screens.mobile.LoanProfile;

public class NotificationPopup extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_title\" and @text=\"Thông báo\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_content\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thông báo\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblNotificationTitle;

  private final String android_lblNotificationTitle = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_title\" and @text=\"Thông báo\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_content\"]";
  private final String ios_lblNotificationTitle = "//XCUIElementTypeStaticText[@name=\"Thông báo\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_right\" and @text=\"Đồng ý\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý\"]")
//  private WebElement btnAgree;

  private final String android_btnAgree = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_right\" and @text=\"Đồng ý\"]";
  private final String ios_btnAgree = "//XCUIElementTypeButton[@name=\"Đồng ý\"]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận hủy\"]")
//  public WebElement btnConfirmToAbort;
private final String android_btnConfirmToAbort = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_right\" and @text=\"Xác nhận hủy\"]";
  private final String ios_btnConfirmToAbort = "//XCUIElementTypeButton[@name=\"Xác nhận hủy\"]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục vay\"]")
//  public WebElement btnContinueToBorrow;
  private final String android_btnContinueToBorrow = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_left\" and @text=\"Tiếp tục vay\"]";
  private final String ios_btnContinueToBorrow = "//XCUIElementTypeButton[@name=\"Tiếp tục vay\"]";

  public NotificationPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotificationTitle() {
    WebElement lblNotificationTitle = null;
    if(appiumDriver instanceof AndroidDriver) {
      lblNotificationTitle = findElement(android_lblNotificationTitle);
    } else {
      lblNotificationTitle = findElement(ios_lblNotificationTitle);
    }
    return lblNotificationTitle.getText();
  }

  public LoanAndCreditServices clickAgreeButton() {
    WebElement btnAgree = null;
    if(appiumDriver instanceof AndroidDriver) {
      btnAgree = findElement(android_btnAgree);
    } else {
      btnAgree = findElement(ios_btnAgree);
    }
    click(btnAgree);
    clickBackButton();
    return new LoanAndCreditServices(appiumDriver);
  }

  public LoanProfile clickConfirmToAbortButton() {
    WebElement btnConfirmToAbort = null;
    if(appiumDriver instanceof AndroidDriver) {
      btnConfirmToAbort = findElement(android_btnConfirmToAbort);
    } else {
      btnConfirmToAbort = findElement(ios_btnConfirmToAbort);
    }
    click(btnConfirmToAbort);
    return new LoanProfile(appiumDriver);
  }

  public LoanProfile clickContinueToBorrowButton() {
    WebElement btnContinueToBorrow = null;
    if(appiumDriver instanceof AndroidDriver) {
      btnContinueToBorrow = findElement(android_btnContinueToBorrow);
    } else {
      btnContinueToBorrow = findElement(ios_btnContinueToBorrow);
    }
    click(btnContinueToBorrow);
    return new LoanProfile(appiumDriver);
  }
}
