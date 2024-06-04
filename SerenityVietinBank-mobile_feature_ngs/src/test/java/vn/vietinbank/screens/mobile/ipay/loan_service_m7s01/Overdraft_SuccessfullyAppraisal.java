package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_common.OTP;

public class Overdraft_SuccessfullyAppraisal extends BaseScreen {

  private final String android_lblNumberOfMoney = "";
  private final String ios_lblNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText";

  private final String android_chkContractAgreement = "";
  private final String ios_chkContractAgreement = "//XCUIElementTypeStaticText[@name=\"Tôi xác nhận đã đọc, hiểu và đồng ý với:\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnContractContent = "";
  private final String ios_btnContractContent = "//XCUIElementTypeButton[@name=\"Hợp đồng vay vốn ký kết với VietinBank\"]";

  private final String android_btnConfirm = "";
  private final String ios_btnConfirm = "//XCUIElementTypeButton[@name=\"Xác nhận vay\"]";

  public Overdraft_SuccessfullyAppraisal(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Tick \"Tôi xác nhận đã đọc, hiểu và đồng ý với\"")
  private void check_Contract_Agreement() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_chkContractAgreement);
    } else {
      tap(ios_chkContractAgreement);
    }
  }

  @Step("Nhấn Xác nhận vay")
  public TransactionApproval confirmOverdraftLoanContract() {
    if(appiumDriver instanceof AndroidDriver) {
      if(!waitForElementVisible(android_btnConfirm, 15)) {
        check_Contract_Agreement();
      }
      click(android_btnConfirm);
    } else {
      if(!waitForElementVisible(ios_btnConfirm, 15)) {
        check_Contract_Agreement();
      }
      click(ios_btnConfirm);
    }
    return new TransactionApproval(appiumDriver);
  }
}
