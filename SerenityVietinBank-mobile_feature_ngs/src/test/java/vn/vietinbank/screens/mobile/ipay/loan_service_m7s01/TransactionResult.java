package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TransactionResult extends BaseScreen {

  private final String android_lblNotificationContent = "";
  private final String ios_lblNotificationContent = "//XCUIElementTypeImage[@name=\"logoVietinFull\"]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText";

  public TransactionResult(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotificationContent() {
    if(appiumDriver instanceof AndroidDriver){
      return getText(android_lblNotificationContent);
    } else {
      return getText(ios_lblNotificationContent);
    }
  }
}
