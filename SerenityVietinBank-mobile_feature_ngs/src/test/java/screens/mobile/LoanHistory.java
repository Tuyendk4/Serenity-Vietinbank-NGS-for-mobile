package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoanHistory extends BaseScreen {

  @iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnConsumerLoan;

  @iOSXCUITFindBy(xpath ="(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]")
  private WebElement lblConsumerLoan;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng\"])[1]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText")
  private WebElement lblStatus;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,\"Số tiền vay\")])[1]")
  private WebElement lblNumberOfLoanMoney;

  public LoanHistory(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void clickConsumerLoan() {
    click(btnConsumerLoan);
  }

  public String getConsumerLoanText() {
    return lblConsumerLoan.getText();
  }

  public String getStatusText() {
    return lblStatus.getText();
  }

  public String getNumberOfLoanMoneyText() {
    return lblNumberOfLoanMoney.getText();
  }
}
