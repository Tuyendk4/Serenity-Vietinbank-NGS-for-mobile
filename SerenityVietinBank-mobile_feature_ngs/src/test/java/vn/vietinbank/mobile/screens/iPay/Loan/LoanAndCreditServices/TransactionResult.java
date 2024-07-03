package vn.vietinbank.mobile.screens.iPay.Loan.LoanAndCreditServices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.mobile.common.BaseScreen;

public class TransactionResult extends BaseScreen {

  private final String android_lblNotificationContent = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvNoteSuccess\"]";
  private final String ios_lblNotificationContent = "//XCUIElementTypeImage[@name=\"logoVietinFull\"]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText";

  public TransactionResult(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotificationContent() {
    if (appiumDriver instanceof AndroidDriver) {
      return getText(android_lblNotificationContent);
    } else {
      return getText(ios_lblNotificationContent);
    }
  }
}
