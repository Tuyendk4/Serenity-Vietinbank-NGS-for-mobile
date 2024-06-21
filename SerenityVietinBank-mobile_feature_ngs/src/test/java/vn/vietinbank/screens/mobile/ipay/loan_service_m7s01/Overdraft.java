package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.PendingLoanPopup;

public class Overdraft extends BaseScreen {

  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public Overdraft(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private PendingLoanPopup pendingLoanPopup() {
    return new PendingLoanPopup(this.appiumDriver);
  }

  @Step("Nhấn Tiếp tục")
  public Overdraft_LoanProfileDetail click_Continue_button() {
    if(pendingLoanPopup().isDisplayed()) {
      pendingLoanPopup().clickRetry();
    }
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(3000);
    return new Overdraft_LoanProfileDetail(appiumDriver);
  }

}
