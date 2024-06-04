package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.NavigationBar;

public class LoanAndCreditServices extends BaseScreen {

  private final String android_btnPersonalInstalmentLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvProvider\" and @text=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_btnPersonalInstalmentLoan = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnSecuredOverdraft = "";
  private final String ios_btnSecuredOverdraft = "//XCUIElementTypeStaticText[@name=\"Thấu chi bảo đảm tiền gửi\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnOverdraft = "";
  private final String ios_btnOverdraft = "//XCUIElementTypeStaticText[@name=\"Thấu chi không TSBĐ\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnRepayAndFinalizeTheLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvItemLoanName\" and @text=\"Trả nợ & tất toán vay\"]";
  private final String ios_btnRepayAndFinalizeTheLoan = "//XCUIElementTypeStaticText[@name=\"Trả nợ & tất toán vay\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_btnLoanHistory = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/llFunctionCredit\"]";
  private final String ios_btnLoanHistory = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/preceding-sibling::XCUIElementTypeButton";

  private final String android_lblNumberOfLoanDocument = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvItemLoanCount\"]";
  private final String ios_lblNumberOfLoanDocument = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";


  public LoanAndCreditServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public PersonalInstalmentLoan click_personal_instalment_loan() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnPersonalInstalmentLoan);
    } else {
      click(ios_btnPersonalInstalmentLoan);
    }
    return new PersonalInstalmentLoan(this.appiumDriver);
  }

  public SecuredOverdraft click_secured_overdraft() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnSecuredOverdraft);
    } else {
      click(ios_btnSecuredOverdraft);
    }
    return new SecuredOverdraft(this.appiumDriver);
  }

  public Overdraft click_overdraft() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnOverdraft);
    } else {
      click(ios_btnOverdraft);
    }
    return new Overdraft(this.appiumDriver);
  }

  public String getNumberOfLoanDocument() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblNumberOfLoanDocument);
    } else {
      return getText(ios_lblNumberOfLoanDocument);
    }
  }

  public LoanHistory click_loan_history() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnLoanHistory);
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
}
