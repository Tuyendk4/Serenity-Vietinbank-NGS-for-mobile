package vn.vietinbank.mobile.screens.iPay.Loan.LoanAndCreditServices;

import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.mobile.common.BaseScreen;

public class Overdraft_SuccessfullyAppraisal extends BaseScreen {

  private final String android_lblNumberOfMoney = "//android.widget.TextView[@text=\"Số tiền được vay\"]/following-sibling::android.widget.TextView";
  private final String ios_lblNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText";

  private final String android_chkContractAgreement = "//android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cb_rule_1\"]";
  private final String ios_chkContractAgreement = "//XCUIElementTypeStaticText[@name=\"Tôi xác nhận đã đọc, hiểu và đồng ý với:\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnContractContent = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvNameBene\"]";
  private final String ios_btnContractContent = "//XCUIElementTypeButton[@name=\"Hợp đồng vay vốn ký kết với VietinBank\"]";

  private final String android_btnConfirm = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnConfirm\"]";
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
      if(waitForElementInvisible(android_btnConfirm, 15)) {
        check_Contract_Agreement();
      }
      click(android_btnConfirm);
    } else {
      if(waitForElementInvisible(ios_btnConfirm, 15)) {
        check_Contract_Agreement();
      }
      click(ios_btnConfirm);
    }
    return new TransactionApproval(appiumDriver);
  }
}
