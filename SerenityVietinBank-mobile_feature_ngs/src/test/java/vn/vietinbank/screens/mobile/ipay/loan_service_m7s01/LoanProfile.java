package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.NotificationPopup;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.SuccessPopup;

public class LoanProfile extends BaseScreen {

  private final String android_lblLoanProfile = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanApplication\"]";
  private final String ios_lblLoanProfile = "//XCUIElementTypeButton[@name=\"Khoản vay đang được thẩm định\"]";

  private final String android_btnAbort = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanCancel\" and @text=\"Hủy hồ sơ vay\"]";
  private final String ios_btnAbort = "//XCUIElementTypeButton[@name=\"Hủy hồ sơ vay\"]";

  private final String android_btnBackToHome = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Về Trang chủ\"]";
  private final String ios_btnBackToHome = "//XCUIElementTypeButton[@name=\"Về trang chủ\"]";

  private final String android_btnContactWithVietinBank = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnContactViettin\"] and @text=\"Liên hệ VietinBank\"";
  private final String ios_btnContactWithVietinBank = "//XCUIElementTypeButton[@name=\"Liên hệ VietinBank\"]";

  public LoanProfile(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public LoanProfileDetail viewLoanProfileDetail() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_lblLoanProfile);
    } else {
      click(ios_lblLoanProfile);
    }
    return new LoanProfileDetail(appiumDriver);
  }

  public void clickAbort() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnAbort);
    } else {
      click(ios_btnAbort);
    }
  }

  public void clickBackToHome() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnBackToHome);
    } else {
      click(ios_btnBackToHome);
    }
  }

  public void clickContactWithVietinBank() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnContactWithVietinBank);
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
