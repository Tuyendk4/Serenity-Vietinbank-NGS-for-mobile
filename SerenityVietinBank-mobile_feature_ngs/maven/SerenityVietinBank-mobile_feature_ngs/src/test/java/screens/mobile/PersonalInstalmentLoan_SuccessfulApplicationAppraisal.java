package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PersonalInstalmentLoan_SuccessfulApplicationAppraisal extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Khoản vay cá nhân\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNumberOfMoney;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblInterestRate;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblMonths;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Lựa chọn\"]")
  private WebElement btnSelect;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý vay\"]")
  private WebElement btnAgree;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Từ chối vay\"]")
  private WebElement btnReject;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hợp đồng vay vốn ký kết với VietinBank\"]/preceding-sibling::XCUIElementTypeButton")
  private WebElement chkContractAgreement;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hợp đồng vay vốn ký kết với VietinBank\"]")
  private WebElement btnContract;

  public PersonalInstalmentLoan_SuccessfulApplicationAppraisal(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }
}
