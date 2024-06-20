package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import net.serenitybdd.core.Serenity;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.NavigationBar;

public class LoanAndCreditServices extends BaseScreen {

  private final String android_btnPersonalInstalmentLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_btnPersonalInstalmentLoan = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnSecuredOverdraft = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Thấu chi bảo đảm tiền gửi\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_btnSecuredOverdraft = "//XCUIElementTypeStaticText[@name=\"Thấu chi bảo đảm tiền gửi\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnOverdraft = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Thấu chi không TSBĐ\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_btnOverdraft = "//XCUIElementTypeStaticText[@name=\"Thấu chi không TSBĐ\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnRepayAndFinalizeTheLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Trả nợ & tất toán vay\"]";
  private final String ios_btnRepayAndFinalizeTheLoan = "//XCUIElementTypeStaticText[@name=\"Trả nợ & tất toán vay\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnLoanHistory = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/llFunctionCredit\"]";
  private final String ios_btnLoanHistory = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_lblNumberOfLoanDocument = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanCount\"]";
  private final String ios_lblNumberOfLoanDocument = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";

  private final String android_btnLoanAwaitingConfirmation = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/parent::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanCount\"]";
  private final String ios_btnLoanAwaitingConfirmation = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeButton[@name=\"iconLineRegister\"]";


  public LoanAndCreditServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public PersonalInstalmentLoan click_personal_instalment_loan() {
    String loanDocumentNumber = getNumberOfLoanDocument();
    if(loanDocumentNumber.isEmpty()) {
      loanDocumentNumber = "0";
    }
    Serenity.setSessionVariable("loanDocumentNumber").to(loanDocumentNumber);
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnPersonalInstalmentLoan);
    } else {
      click(ios_btnPersonalInstalmentLoan);
    }
    delay(5000);
    return new PersonalInstalmentLoan(this.appiumDriver);
  }

  public SecuredOverdraft click_secured_overdraft() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnSecuredOverdraft);
    } else {
      click(ios_btnSecuredOverdraft);
    }
    return new SecuredOverdraft(this.appiumDriver);
  }

  public Overdraft click_overdraft() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnOverdraft);
    } else {
      click(ios_btnOverdraft);
    }
    return new Overdraft(this.appiumDriver);
  }

  public String getNumberOfLoanDocument() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblNumberOfLoanDocument, 20);
    } else {
      return getText(ios_lblNumberOfLoanDocument, 20);
    }
  }

  public LoanHistory click_loan_history() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnLoanHistory);
    } else {
      click(ios_btnLoanHistory);
    }
    delay(5000);
    return new LoanHistory(this.appiumDriver);
  }

  public RepayAndFinalizeTheLoan click_repay_and_finalize_the_loan() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnRepayAndFinalizeTheLoan);
    } else {
      tap(ios_btnRepayAndFinalizeTheLoan);
    }
    delay(3000);
    return new RepayAndFinalizeTheLoan(appiumDriver);
  }

  public NavigationBar navigationBar() {
    return new NavigationBar(appiumDriver);
  }

  public boolean waitUntilLoanAwaitingConfirmation() {
    if(appiumDriver instanceof AndroidDriver) {
      return waitForElementVisible(android_btnLoanAwaitingConfirmation, 10);
    } else {
      return waitForElementVisible(ios_btnLoanAwaitingConfirmation, 10);
    }
  }

  public PersonalInstalmentLoan_SuccessfulApplicationAppraisal clickLoanAwaitingConfirmation() {
    if(appiumDriver instanceof AndroidDriver) {
      tap(android_btnLoanAwaitingConfirmation);
    } else {
      click(ios_btnLoanAwaitingConfirmation);
    }
    return new PersonalInstalmentLoan_SuccessfulApplicationAppraisal(this.appiumDriver);
  }
}
