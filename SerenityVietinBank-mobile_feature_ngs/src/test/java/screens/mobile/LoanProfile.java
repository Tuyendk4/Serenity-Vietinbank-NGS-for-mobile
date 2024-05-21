package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NotificationPopup;
import screens.mobile.sections.SuccessPopup;

public class LoanProfile extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanApplication\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Khoản vay đang được thẩm định\"]")
//  private WebElement lblLoanProfile;

  private final String android_lblLoanProfile = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanApplication\"]";
  private final String ios_lblLoanProfile = "//XCUIElementTypeButton[@name=\"Khoản vay đang được thẩm định\"]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanCancel\" and @text=\"Hủy hồ sơ vay\"]]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hủy hồ sơ vay\"]")
//  private WebElement btnAbort;

  private final String android_btnAbort = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanCancel\" and @text=\"Hủy hồ sơ vay\"]";
  private final String ios_btnAbort = "//XCUIElementTypeButton[@name=\"Hủy hồ sơ vay\"]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Về Trang chủ\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Về trang chủ\"]")
//  public WebElement btnBackToHome;

  private final String android_btnBackToHome = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Về Trang chủ\"]";
  private final String ios_btnBackToHome = "//XCUIElementTypeButton[@name=\"Về trang chủ\"]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnContactViettin\"] and @text=\"Liên hệ VietinBank\"")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Liên hệ VietinBank\"]")
//  public WebElement btnContactWithVietinBank;

  private final String android_btnContactWithVietinBank = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnContactViettin\"] and @text=\"Liên hệ VietinBank\"";
  private final String ios_btnContactWithVietinBank = "//XCUIElementTypeButton[@name=\"Liên hệ VietinBank\"]";

  public LoanProfile(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public LoanProfileDetail viewLoanProfileDetail() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_lblLoanProfile);
    } else {
      click(ios_lblLoanProfile);
    }
    return new LoanProfileDetail(appiumDriver);
  }

  public void clickAbort() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnAbort);
    } else {
      click(ios_btnAbort);
    }
  }

  public void clickBackToHome() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnBackToHome);
    } else {
      click(ios_btnBackToHome);
    }
  }

  public void clickContactWithVietinBank() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnContactWithVietinBank);
    } else {
      click(ios_btnContactWithVietinBank);
    }
  }

  public NotificationPopup notificationPopup() {
    return new NotificationPopup(appiumDriver);
  }

  public SuccessPopup successPopup() {
    return new SuccessPopup(appiumDriver);
  }
}
