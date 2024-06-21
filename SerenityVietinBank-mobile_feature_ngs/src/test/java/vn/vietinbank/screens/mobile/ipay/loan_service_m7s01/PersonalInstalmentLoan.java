package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.PendingLoanPopup;

public class PersonalInstalmentLoan extends BaseScreen {

  private final String android_btnCalculateNow = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/btnCalculateNow\" and @text=\"Tính toán ngay\"]";
  private final String ios_btnCalculateNow = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]";

  private final String android_btnBorrowNow = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Vay ngay\"]";
  private final String ios_btnBorrowNow = "//XCUIElementTypeButton[@name=\"Vay ngay\"]";


  public PersonalInstalmentLoan(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public CalculatorTool clickCalculateNow() {
    if(pendingLoanPopup().isDisplayed()) {
      pendingLoanPopup().clickRetry();
    }
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnCalculateNow);
    } else {
      click(ios_btnCalculateNow);
    }
    delay(5000);
    return new CalculatorTool(this.appiumDriver);
  }

  public PendingLoanPopup pendingLoanPopup() {
    return new PendingLoanPopup(this.appiumDriver);
  }



}
