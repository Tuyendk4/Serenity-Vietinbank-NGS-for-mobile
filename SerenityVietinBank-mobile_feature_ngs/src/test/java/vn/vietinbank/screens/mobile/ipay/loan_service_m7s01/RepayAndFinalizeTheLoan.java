package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.AccountNumberSelection;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.RepaymentSourceAccountNumberSelection;

public class RepayAndFinalizeTheLoan extends BaseScreen {

  private final String android_txtLoanAccountNumber = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Chọn khoản vay cần trả\"]";
  private final String ios_txtAccountNumber = "//XCUIElementTypeStaticText[@name=\"Tài khoản vay\"]/following-sibling::XCUIElementTypeTextField[1]";

  private final String android_iconAccountNumberSelection = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Chọn khoản vay cần trả\"]/following-sibling::android.widget.ImageView";

  private final String android_rdoRepayDebtPeriodically = "//android.widget.RadioButton[@resource-id=\"com.vietinbank.ipay:id/rad_period\" and @text=\"Trả nợ định kỳ\"]";
  private final String ios_rdoRepayDebtPeriodically = "//XCUIElementTypeButton[@name=\"Trả nợ định kỳ\"]";

  private final String android_rdoFinalSettlement = "//android.widget.RadioButton[@resource-id=\"com.vietinbank.ipay:id/rad_all\" and @text=\"Tất toán - đóng khoản vay\"]";
  private final String ios_rdoFinalSettlement = "//XCUIElementTypeButton[@name=\"Tất toán - đóng khoản vay\"]";

  private final String android_lblRepaymentSourceAccountNumber = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/lblFromAcc\" and @text=\"Tài khoản nguồn trả nợ\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAccountNo\"]";
  private final String ios_lblRepaymentSourceAccountNumber = "//XCUIElementTypeStaticText[@name=\"Tài khoản nguồn trả nợ\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[1]";

  private final String android_iconRepaymentSourceAccountNumberSelection = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/lblFromAcc\" and @text=\"Tài khoản nguồn trả nợ\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"]";
  private final String ios_iconRepaymentSourceAccountNumberSelection = "//XCUIElementTypeStaticText[@name=\"Tài khoản nguồn trả nợ\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[1]";

  private final String android_lblAccountBalance = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/lblFromAcc\" and @text=\"Tài khoản nguồn trả nợ\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAccountBalance\"]";
  private final String ios_lblAccountBalance = "//XCUIElementTypeStaticText[@name=\"Tài khoản nguồn trả nợ\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[2]";

  private final String android_txtRepaymentMoney = "//android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/wAmountWidget\"]//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Số tiền\"]";
  private final String ios_txtRepaymentMoney = "//XCUIElementTypeStaticText[@name=\"Tài khoản nguồn trả nợ\"]/ancestor::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeTextField";

  private final String android_txtNote = "//android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/wRemark\"]//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]";
  private final String ios_txtNote = "//XCUIElementTypeStaticText[@name=\"Tài khoản vay\"]/following-sibling::XCUIElementTypeTextField[2]";

  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public RepayAndFinalizeTheLoan(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void input_loan_account_number(String accountNumber) {
    if(appiumDriver instanceof AndroidDriver){
      sendKeys(android_txtLoanAccountNumber, accountNumber);
    } else {
      sendKeys(ios_txtAccountNumber, accountNumber);
    }
    hideKeyboard();
  }

  public void choose_loan_account_number_from_load_account_address_book(String accountNumber) {
    if(appiumDriver instanceof AndroidDriver){
      click(android_iconAccountNumberSelection);
    } else {
      int leftPosition = getElementLeftPosition(ios_txtAccountNumber);
      int topPosition = getElementTopPosition(ios_txtAccountNumber);
      int width = getElementWidth(ios_txtAccountNumber);
      int height = getElementHeight(ios_txtAccountNumber);
      int rightPosition = leftPosition + width - 10;
      int middlePosition = topPosition + height / 2;
      tapAt(rightPosition, middlePosition);
    }
    account_number_selection().search_and_choose_account_number(accountNumber);
    delay(5000);
  }

  public AccountNumberSelection account_number_selection() {
    return new AccountNumberSelection(appiumDriver);
  }

  public void select_loan_account_number(String accountNumber) {
    if(appiumDriver instanceof AndroidDriver){
      tap(android_iconAccountNumberSelection);
    } else {
      tap(android_txtLoanAccountNumber);
    }
    account_number_selection().choose_account_number(accountNumber);
  }

  public void choose_repayment_type(String repaymentType) {
    switch(repaymentType){
      case "Trả nợ định kỳ":
        if(appiumDriver instanceof AndroidDriver){
          tap(android_rdoRepayDebtPeriodically);
        } else {
          tap(ios_rdoRepayDebtPeriodically);
        }
        break;
      case "Tất toán - đóng khoản vay":
        if(appiumDriver instanceof AndroidDriver){
          tap(android_rdoFinalSettlement);
        } else {
          tap(ios_rdoFinalSettlement);
        }
    }
  }

  public RepaymentSourceAccountNumberSelection repayment_source_account_number_selection_popup() {
    return new RepaymentSourceAccountNumberSelection(appiumDriver);
  }

  public void choose_repayment_source_account_number(String repaymentSourceAccountNumber) {
    if(appiumDriver instanceof AndroidDriver){
      tap(android_iconRepaymentSourceAccountNumberSelection);
    } else {
      tap(ios_iconRepaymentSourceAccountNumberSelection);
    }
    account_number_selection().choose_account_number(repaymentSourceAccountNumber);
  }

  public void input_repayment_money(String repaymentMoney) {
    if(appiumDriver instanceof AndroidDriver){
      sendKeys(android_txtRepaymentMoney, repaymentMoney);
    } else {
      sendKeys(ios_txtRepaymentMoney, repaymentMoney);
    }
    hideKeyboard();
  }

  public TransactionApproval click_Continue_button() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(3000);
    return new TransactionApproval(appiumDriver);
  }
}
