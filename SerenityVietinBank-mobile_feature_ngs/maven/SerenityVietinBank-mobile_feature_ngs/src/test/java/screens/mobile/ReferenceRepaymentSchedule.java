package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReferenceRepaymentSchedule extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement lblInterestRate;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Số tiền phải trả hàng tháng\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement lblMonthlyChargeAmount;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement lblInterestPayableTotal;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement lblPrincipalAndInterestPayableTotal;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Vay ngay\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Vay ngay\"]")
  private WebElement btnBorrowNow;

  public ReferenceRepaymentSchedule(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getInterestRate() {
    return lblInterestRate.getText();
  }

  public String getMonthlyChargeAmount() {
    return lblMonthlyChargeAmount.getText();
  }

  public String getInterestPayableTotal() {
    return lblInterestPayableTotal.getText();
  }

  public String getPrincipalAndInterestPayableTotal() {
    return lblPrincipalAndInterestPayableTotal.getText();
  }

  public PersonalInstalmentLoan_Step1 clickBorrowNow() {
    click(btnBorrowNow);
    delay(3000);
    return new PersonalInstalmentLoan_Step1(appiumDriver);
  }
}
