package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoanHistory extends BaseScreen {

//  @iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]/preceding-sibling::XCUIElementTypeButton")
//  private WebElement btnConsumerLoan;

  private final String android_btnConsumerLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_status\" and @text=\"Chờ thẩm định\"]/parent::android.widget.LinearLayout";
  private final String ios_btnConsumerLoan = "(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]/preceding-sibling::XCUIElementTypeButton";

//  @iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]")
//  private WebElement lblConsumerLoan;

  private final String android_lblConsumerLoan = "(//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_name\"])[1]";
  private final String ios_lblConsumerLoan = "(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]";

//  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText")
//  private WebElement lblStatus;

  private final String android_lblStatus = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_status\" and @text=\"Chờ thẩm định\"]";
  private final String ios_lblStatus = "(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText";

//  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"Số tiền vay\")])[1]")
//  private WebElement lblNumberOfLoanMoney;

  private final String android_lblNumberOfLoanMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_amount\" and contains(@text,\"Số tiền vay\")]";
  private final String ios_lblNumberOfLoanMoney = "(//XCUIElementTypeStaticText[contains(@name,\"Số tiền vay\")])[1]";

  public LoanHistory(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public LoanProfile clickConsumerLoan() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnConsumerLoan);
    } else {
      click(ios_btnConsumerLoan);
    }
    return new LoanProfile(appiumDriver);
  }

  public String getConsumerLoanText() {
    if(appiumDriver instanceof AndroidDriver){
      return getText(android_lblConsumerLoan);
    } else {
      return getText(ios_lblConsumerLoan);
    }
  }

  public String getStatusText() {
    if(appiumDriver instanceof AndroidDriver){
      return getText(android_lblStatus);
    } else {
      return getText(ios_lblStatus);
    }
  }

  public String getNumberOfLoanMoneyText() {
    if(appiumDriver instanceof AndroidDriver){
      return getText(android_lblNumberOfLoanMoney);
    } else {
      return getText(ios_lblNumberOfLoanMoney);
    }
  }
}
