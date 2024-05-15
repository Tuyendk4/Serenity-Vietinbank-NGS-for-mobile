package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NavigationBar;

public class LoanAndCreditServices extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnVayPersonalInstalmentLoan;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanName\" and @text=\"Lịch sử vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/llFunctionCredit\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnLoanHistory;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemLoanCount\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lịch sử vay\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText")
  private WebElement lblNumberOfLoanDocument;


  public LoanAndCreditServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public PersonalInstalmentLoan click_vay_tieu_dung_ca_nhan() {
    btnVayPersonalInstalmentLoan.click();
    return new PersonalInstalmentLoan(this.appiumDriver);
  }

  public NavigationBar navigationBar() {
    return new NavigationBar(appiumDriver);
  }

  public String getNumberOfLoanDocument() {
    return lblNumberOfLoanDocument.getText();
  }

  public LoanHistory click_loan_history() {
    click(btnLoanHistory);
    return new LoanHistory(this.appiumDriver);
  }


}
