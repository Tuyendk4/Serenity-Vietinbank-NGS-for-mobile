package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoanProfile extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanApplication\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Khoản vay đang được thẩm định\"]")
  private WebElement lblLoanProfile;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPersonalLoanCancel\" and @text=\"Hủy hồ sơ vay\"]]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hủy hồ sơ vay\"]")
  private WebElement btnAbort;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Về Trang chủ\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Về trang chủ\"]")
  public WebElement btnBackToHome;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnContactViettin\"] and @text=\"Liên hệ VietinBank\"")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Liên hệ VietinBank\"]")
  public WebElement btnContactWithVietinBank;

  public LoanProfile(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public LoanProfileDetail viewLoanProfileDetail() {
    click(lblLoanProfile);
    return new LoanProfileDetail(appiumDriver);
  }

  public void clickAbort() {
    click(btnAbort);
  }

  public void clickBackToHome() {
    click(btnBackToHome);
  }

  public void clickContactWithVietinBank() {
    click(btnContactWithVietinBank);
  }
}
