package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class OnlineSecuredOverdraft_LoanContractContent extends BaseScreen {

  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public OnlineSecuredOverdraft_LoanContractContent(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public TransactionApproval click_Continue_button() {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(5000);
    return new TransactionApproval(appiumDriver);
  }
}
