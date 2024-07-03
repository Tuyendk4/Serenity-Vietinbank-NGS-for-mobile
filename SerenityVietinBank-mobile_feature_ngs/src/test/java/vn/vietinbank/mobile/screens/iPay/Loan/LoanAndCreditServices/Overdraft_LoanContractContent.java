package vn.vietinbank.mobile.screens.iPay.Loan.LoanAndCreditServices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.mobile.common.BaseScreen;

public class Overdraft_LoanContractContent extends BaseScreen {

  private final String android_btnContinue = "";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public Overdraft_LoanContractContent(AppiumDriver appiumDriver) {
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
