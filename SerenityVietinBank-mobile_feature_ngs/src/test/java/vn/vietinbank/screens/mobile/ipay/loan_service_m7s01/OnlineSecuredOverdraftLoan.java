package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.base.ScrollDirection;

public class OnlineSecuredOverdraftLoan extends BaseScreen {

  private final String android_txtIDNumber = "";
  private final String ios_txtIDNumber = "//XCUIElementTypeStaticText[@name=\"Số giấy tờ tùy thân\"]/following-sibling::XCUIElementTypeTextField";

  private final String android_txtEmail = "";
  private final String ios_txtEmail = "//XCUIElementTypeTextField[@value=\"Email nhận hợp đồng\" or contains(@value, \"@\")]";

  private final String android_lblOverdraftAccountNumber = "";
  private final String ios_lblOverdraftAccountNumber = "//XCUIElementTypeStaticText[@name=\"Tài khoản được cấp thấu chi\"]/following-sibling::XCUIElementTypeStaticText";

  private final String android_btnOverdraftAccountNumberDownArrow = "";
  private final String ios_btnOverdraftAccountNumberDownArrow = "//XCUIElementTypeStaticText[@name=\"Tài khoản được cấp thấu chi\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]";

  private final String android_lblBankingSavingBookNumber = "";
  private final String ios_lblBankingSavingBookNumber = "//XCUIElementTypeStaticText[@name=\"Sổ tiết kiệm đảm bảo\"]";

  private final String android_btnBankingSavingBookNumberDownArrow = "";
  private final String ios_btnBankingSavingBookNumberDownArrow = "//XCUIElementTypeStaticText[@name=\"Sổ tiết kiệm đảm bảo\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]";

  private final String android_txtNumberOfMoney = "";
  private final String ios_txtNumberOfMoney = "//XCUIElementTypeTextField[@value=\"Số tiền vay\" or @value=\"100,000,000\"]";

  private final String android_txtLoanDuration = "";
  private final String ios_txtLoanDuration = "//XCUIElementTypeTextField[@value=\"Thời hạn vay\"]";

  private final String android_txtInterestRate = "";
  private final String ios_txtInterestRate = "//XCUIElementTypeTextField[@value=\"Lãi suất vay\"]";

  private final String android_btnLoanPurpose = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\" and @text=\"Mục đích vay\"]/parent::android.widget.LinearLayout";
  private final String ios_btnLoanPurpose = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]";

  private final String android_chkTermAgree = "";
  private final String ios_chkTermAgree = "//XCUIElementTypeStaticText[@name=\"Tôi cam kết tài sản đảm bảo (sổ tiết kiệm) thuộc sở hữu riêng hoặc được sự đồng ý của các đồng chủ sở hữu (nếu có.\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]";

  private final String android_btnContinue = "";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public OnlineSecuredOverdraftLoan(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void input_Identification_Card(String id) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtIDNumber, id);
    } else {
      sendKeys(ios_txtIDNumber, id);
    }
  }

  public void input_Email(String email) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtEmail, email);
    } else {
      sendKeys(ios_txtEmail, email);
    }
  }

  private void select_a_Overdraft_Account_Number(String accountNumber) {
//    List<WebElement> btnAccountNumbers;
//    if (appiumDriver instanceof AndroidDriver) {
//      btnAccountNumbers = findElements(
//          "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView/parent::android.widget.LinearLayout");
//    } else {
//      btnAccountNumbers = findElements(
//          "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeButton");
//    }
    List<WebElement> lblAccountNumbers;
    if (appiumDriver instanceof AndroidDriver) {
      lblAccountNumbers = findElements(
          "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView");
    } else {
      lblAccountNumbers = findElements(
          "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeButton/following-sibling::XCUIElementTypeStaticText");
    }
    for (WebElement lblAccountNumber : lblAccountNumbers) {
      if (getText(lblAccountNumber).equals(accountNumber)) {
        tap(lblAccountNumber);
        break;
      }
    }
  }

  public void choose_a_Overdraft_Account_Number(String accountNumber) {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnOverdraftAccountNumberDownArrow);
    } else {
      click(ios_btnOverdraftAccountNumberDownArrow);
    }
    select_a_Overdraft_Account_Number(accountNumber);
  }

  private void select_a_banking_saving_book_number(String bankingSavingBookNumber) {
//    List<WebElement> btnBankingSavingBookNumbers;
//    if (appiumDriver instanceof AndroidDriver) {
//      btnBankingSavingBookNumbers = findElements(
//          "");
//    } else {
//      btnBankingSavingBookNumbers = findElements(
//          "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeButton");
//    }
    List<WebElement> lblBankingSavingBookNumbers;
    if (appiumDriver instanceof AndroidDriver) {
      lblBankingSavingBookNumbers = findElements(
          "");
    } else {
      lblBankingSavingBookNumbers = findElements(
          "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeButton/following-sibling::XCUIElementTypeStaticText");
    }
    for (WebElement lblBankingSavingBookNumber : lblBankingSavingBookNumbers) {
      if (getText(lblBankingSavingBookNumber).equals(bankingSavingBookNumber)) {
        tap(lblBankingSavingBookNumber);
        break;
      }
    }
  }

  public void choose_a_banking_saving_book_number(String bankingSavingBookNumber) {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnBankingSavingBookNumberDownArrow);
    } else {
      click(ios_btnBankingSavingBookNumberDownArrow);
    }
    select_a_banking_saving_book_number(bankingSavingBookNumber);
  }

  public void input_loan_money(String loanMoney) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtNumberOfMoney, loanMoney);
    } else {
      sendKeys(ios_txtNumberOfMoney, loanMoney);
    }
  }


  private void select_a_Loan_Purpose(String purpose) {
//    List<WebElement> btnLoanPurposes;
//    if (appiumDriver instanceof AndroidDriver) {
//      btnLoanPurposes = findElements(
//          "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView/parent::android.widget.LinearLayout");
//    } else {
//      btnLoanPurposes = findElements(
//          "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton");
//    }
    List<WebElement> lblLoanPurposes;
    if (appiumDriver instanceof AndroidDriver) {
      lblLoanPurposes = findElements(
          "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView");
    } else {
      lblLoanPurposes = findElements(
          "//XCUIElementTypeStaticText[@name=\"Chọn mục đích vay\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText");
    }
    for (WebElement lblLoanPurpose : lblLoanPurposes) {
      if (getText(lblLoanPurpose).equals(purpose)) {
        tap(lblLoanPurpose);
        delay(3000);
        break;
      }
    }
  }

  public void choose_a_Loan_Purpose(String loanPurpose) {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnLoanPurpose);
    } else {
      click(ios_btnLoanPurpose);
    }
    select_a_Loan_Purpose(loanPurpose);
  }

  public void checkAgreement() {
    if (appiumDriver instanceof AndroidDriver) {
      scrollToElement(android_chkTermAgree, ScrollDirection.DOWN, 3);
      tap(android_chkTermAgree);
    } else {
      scrollToElement(ios_chkTermAgree, ScrollDirection.DOWN, 3);
      tap(ios_chkTermAgree);
    }
  }

  public OnlineSecuredOverdraft_LoanContractContent click_Continue_button() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(5000);
    return new OnlineSecuredOverdraft_LoanContractContent(appiumDriver);
  }

}
