package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PersonalInstalmentLoan_SuccessfulApplicationAppraisal extends BaseScreen {

  private final String android_lblNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanTitle\" and @text=\"Khoản vay cá nhân\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvResultLoanAmount\"]";
  private final String ios_lblNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Khoản vay cá nhân\"]/following-sibling::XCUIElementTypeStaticText[1]";

  private final String android_lblInterestRate = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLoanInterestTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLoanInterest\"]";
  private final String ios_lblInterestRate = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]";

  private final String android_lblMonths = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLoanTermTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.TextView[1]";
  private final String ios_lblMonths = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText[1]";

  private final String android_btnSelect = "//*[@text=\"Lựa chọn\"]";
  private final String ios_btnSelect = "//XCUIElementTypeButton[@name=\"Lựa chọn\"]";

  private final String android_btnAgree = "//android.widget.Button[@text=\"Đồng ý vay\" or @text=\"Đồng ý vay & mua bảo hiểm\"]]";
  private final String ios_btnAgree = "//XCUIElementTypeButton[@name=\"Đồng ý vay\" or @name=\"Đồng ý vay & mua bảo hiểm\"]";

  private final String android_btnReject = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnRejectLoan\"]";
  private final String ios_btnReject = "//XCUIElementTypeButton[@name=\"Từ chối vay\"]";

  private final String android_chkLoanContractAgreement = "//android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbConfirmAndAgreeLoanContract\"]";
  private final String ios_chkLoanContractAgreement = "//XCUIElementTypeImage[@name=\"iconChoiceCheckOff\"]/following-sibling::XCUIElementTypeButton";

  private final String android_btnLoanContract = "//android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbConfirmAndAgreeLoanContract\"]";
  private final String ios_btnLoanContract = "//XCUIElementTypeButton[@name=\"Hợp đồng vay vốn ký kết với VietinBank\"]";

  private final String android_chkInsuranceContractAgreement = "";
  private final String ios_chkInsuranceContractAgreement = "(//XCUIElementTypeImage[@name=\"iconChoiceCheckOff\"])[2]/following-sibling::XCUIElementTypeButton";

  private final String android_btnInsuranceContract = "";
  private final String ios_btnInsuranceContract = "//XCUIElementTypeButton[@name=\"Bản kê khai yêu cầu bảo hiểm\"]";

  public PersonalInstalmentLoan_SuccessfulApplicationAppraisal(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNumberOfMoney() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblNumberOfMoney);
    } else {
      for (int i = 0; i < 100; i++) {
        String actualText = getText(ios_lblNumberOfMoney);
        if(!actualText.isEmpty()) {
          break;
        }
        delay(500);
      }
      return getText(ios_lblNumberOfMoney);
    }
  }

  public String getInterestRate() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblInterestRate);
    } else {
      return getText(ios_lblInterestRate);
    }
  }

  public String getMonths() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblMonths);
    } else {
      return getText(ios_lblMonths);
    }
  }

  public void selectAccount() {
    if(appiumDriver instanceof AndroidDriver) {
      if(waitForElementVisible(android_btnSelect, 10)) {
        tap(android_btnSelect);
      }
    } else {
      if(waitForElementVisible(ios_btnSelect, 10)) {
        click(ios_btnSelect);
      }
    }
  }

  public LoanContractContent viewContract() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnLoanContract);
    } else {
      click(ios_btnLoanContract);
    }
    return new LoanContractContent(appiumDriver);
  }

  public void check_Contract_Agreement_checkbox() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_chkLoanContractAgreement);
    } else {
      click(ios_chkLoanContractAgreement);
    }
  }

  public InsuranceContractContent viewInsuranceContract() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnInsuranceContract);
    } else {
      click(ios_btnInsuranceContract);
    }
    delay(3000);
    return new InsuranceContractContent(appiumDriver);
  }

  public void check_Insurance_Contract_Agreement_checkbox() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_chkInsuranceContractAgreement);
    } else {
      click(ios_chkInsuranceContractAgreement);
    }
  }

  public TransactionApproval clickAgree() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnAgree);
    } else {
      click(ios_btnAgree);
    }
    return new TransactionApproval(appiumDriver);
  }
}
