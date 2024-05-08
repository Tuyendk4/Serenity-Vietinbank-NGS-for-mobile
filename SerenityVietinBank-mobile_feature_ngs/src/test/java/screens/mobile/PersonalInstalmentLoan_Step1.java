package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.PendingLoanPopup;

public class PersonalInstalmentLoan_Step1 extends BaseScreen {
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]")
  private WebElement btnCalculateNow;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeTextField")
  private WebElement txtNumberOfMoney;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage[@name=\"iconLineEditPencil\"]/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnEditMoney;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement txtMonths;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeButton[@name=\"iconLineEditPencil\"]")
  private WebElement btnEditMonths;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblInterestRate;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement lblMonthlyChargeAmount01;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[2]")
  private WebElement lblMonthlyChargeAmount02;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
  private WebElement btnContinue;


  public PersonalInstalmentLoan_Step1(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getInterestRate() {
    return lblInterestRate.getText();
  }

  public String getMonthlyChargeAmount01() {
    return lblMonthlyChargeAmount01.getText();
  }

  public String getMonthlyChargeAmount02() {
    return lblMonthlyChargeAmount02.getText();
  }

  public PersonalInstalmentLoan_Step2 clickContinueButton() {
    click(btnContinue);
    return new PersonalInstalmentLoan_Step2(appiumDriver);
  }
}
