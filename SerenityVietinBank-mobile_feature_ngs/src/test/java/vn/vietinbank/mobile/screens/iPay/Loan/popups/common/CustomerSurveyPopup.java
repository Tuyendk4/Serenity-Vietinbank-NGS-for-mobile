package vn.vietinbank.mobile.screens.iPay.Loan.popups.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.mobile.common.BaseScreen;

public class CustomerSurveyPopup extends BaseScreen {

  private final String android_iconClose = "//*[@text=\"Có\"]";
  private final String ios_iconClose = "//XCUIElementTypeButton[@name=\"iconCloseBlue\"]";

  private final String android_lblTitle = "//*[@text=\"Không\"]";
  private final String ios_lblTitle= "//XCUIElementTypeStaticText[@name=\"Khảo sát KH\"]";

  private final String android_txtComment = "";
  private final String ios_txtComment = "//XCUIElementTypeTextView[@value=\"Nhập ý kiến\"]";

  private final String android_btnContinue = "";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  private final String android_btnBack = "";
  private final String ios_btnBack = "//XCUIElementTypeButton[@name=\"Quay lại\"]";

  public CustomerSurveyPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public boolean isShown() {
    if(appiumDriver instanceof AndroidDriver) {
      return waitForElementVisible(android_lblTitle, 20);
    } else {
      return waitForElementVisible(ios_lblTitle, 20);
    }
  }

  public void clickCloseIcon() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_iconClose);
    } else {
      click(ios_iconClose);
    }
    delay(3000);
  }

  public void clickContinueButton() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(3000);
  }

  public void clickBackButton() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnBack);
    } else {
      click(ios_btnBack);
    }
    delay(3000);
  }

  public void inputComment(String comment) {
    if (appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtComment, comment);
    } else {
      sendKeys(ios_txtComment, comment);
    }
    hideKeyboard();
  }
}
