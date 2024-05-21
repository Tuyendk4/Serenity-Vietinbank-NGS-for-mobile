package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReferenceRepaymentSchedule extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]")
//  private WebElement lblInterestRate;

  private final String android_lblInterestRate = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]";
  private final String ios_lblInterestRate = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Số tiền phải trả hàng tháng\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]")
//  private WebElement lblMonthlyChargeAmount;

  private final String android_lblMonthlyChargeAmount = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Số tiền phải trả hàng tháng\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]";
  private final String ios_lblMonthlyChargeAmount = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]")
//  private WebElement lblInterestPayableTotal;

  private final String android_lblInterestPayableTotal = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]";
  private final String ios_lblInterestPayableTotal = "//XCUIElementTypeStaticText[@name=\"Tổng lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]")
//  private WebElement lblPrincipalAndInterestPayableTotal;

  private final String android_lblPrincipalAndInterestPayableTotal = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvAmountRepayment\"]";
  private final String ios_lblPrincipalAndInterestPayableTotal = "//XCUIElementTypeStaticText[@name=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Vay ngay\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Vay ngay\"]")
//  private WebElement btnBorrowNow;

  private final String android_btnBorrowNow = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Vay ngay\"]";
  private final String ios_btnBorrowNow = "//XCUIElementTypeButton[@name=\"Vay ngay\"]";

  public ReferenceRepaymentSchedule(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getInterestRate() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblInterestRate);
    } else {
      return getText(ios_lblInterestRate);
    }
  }

  public String getMonthlyChargeAmount() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblMonthlyChargeAmount);
    } else {
      return getText(ios_lblMonthlyChargeAmount);
    }
  }

  public String getInterestPayableTotal() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblInterestPayableTotal);
    } else {
      return getText(ios_lblInterestPayableTotal);
    }
  }

  public String getPrincipalAndInterestPayableTotal() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblPrincipalAndInterestPayableTotal);
    } else {
      return getText(ios_lblPrincipalAndInterestPayableTotal);
    }
  }

  public PersonalInstalmentLoan_Step1 clickBorrowNow() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnBorrowNow);
    } else {
      click(ios_btnBorrowNow);
    }
    delay(5000);
    return new PersonalInstalmentLoan_Step1(appiumDriver);
  }
}
