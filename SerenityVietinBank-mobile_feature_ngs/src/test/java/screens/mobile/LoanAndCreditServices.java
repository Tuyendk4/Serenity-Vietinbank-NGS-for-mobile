package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import screens.mobile.sections.NavigationBar;

public class LoanAndCreditServices extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton")
//  private WebElement btnVayPersonalInstalmentLoan;

  private final String android_btnPersonalInstalmentLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_btnPersonalInstalmentLoan = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/llFunctionCredit\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/preceding-sibling::XCUIElementTypeButton")
//  private WebElement btnLoanHistory;

  private final String android_btnLoanHistory = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/llFunctionCredit\"]";
  private final String ios_btnLoanHistory = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/preceding-sibling::XCUIElementTypeButton";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanCount\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText")
//  private WebElement lblNumberOfLoanDocument;

  private final String android_lblNumberOfLoanDocument = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanCount\"]";
  private final String ios_lblNumberOfLoanDocument = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";


  public LoanAndCreditServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public PersonalInstalmentLoan click_vay_tieu_dung_ca_nhan() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnPersonalInstalmentLoan);
    } else {
      click(ios_btnPersonalInstalmentLoan);
    }
    return new PersonalInstalmentLoan(this.appiumDriver);
  }

  public NavigationBar navigationBar() {
    return new NavigationBar(appiumDriver);
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
}
