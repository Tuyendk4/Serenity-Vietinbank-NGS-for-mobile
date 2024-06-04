package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.PendingLoanPopup;

public class SecuredOverdraft extends BaseScreen {

  private final String android_btnProductRegulations = "";
  private final String ios_btnProductRegulations = "//XCUIElementTypeButton[@name=\"QUY ĐỊNH SẢN PHẨM\"]";

  private final String android_chkTermAgreements = "";
  private final String ios_chkTermAgreements = "//XCUIElementTypeStaticText[@name=\"Tôi đã đọc & đồng ý với Quy định sản phẩm vay thấu chi online\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]";

  private final String android_btnContinue = "";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public SecuredOverdraft(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private PendingLoanPopup pendingLoanPopup() {
    return new PendingLoanPopup(this.appiumDriver);
  }

  public OnlineSecuredOverdraftLoan click_Continue_button() {
    if(pendingLoanPopup().isDisplayed()) {
      pendingLoanPopup().clickRetry();
    }
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(3000);
    return new OnlineSecuredOverdraftLoan(appiumDriver);
  }

}
