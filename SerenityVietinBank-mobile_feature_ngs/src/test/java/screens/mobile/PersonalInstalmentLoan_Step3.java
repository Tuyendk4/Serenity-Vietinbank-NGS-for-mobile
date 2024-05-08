package screens.mobile;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NotificationPopup;

public class PersonalInstalmentLoan_Step3 extends BaseScreen {
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNumberOfMoney;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblMonths;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất dự kiến\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblInterestRate;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblLoanPurpose;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngày trả nợ hàng tháng\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblRepaymentDate;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Họ & tên người vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblBorrowName;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Gửi yêu cầu vay\"]")
  private WebElement btnSend;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chỉnh sửa\"]")
  private WebElement btnEdit;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]")
  private WebElement chkExactlyInformation;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi đồng ý với Điều kiện & điều khoản dịch vụ Vay tiêu dùng cá nhân của VietinBank\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]")
  private WebElement chkTermsAndConditions;


  public PersonalInstalmentLoan_Step3(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNumberOfMoney() {
    return lblNumberOfMoney.getText();
  }

  public String getMonths() {
    return lblMonths.getText();
  }

  public String getInterestRate() {
    return lblInterestRate.getText();
  }

  public String getLoanPurpose() {
    return lblLoanPurpose.getText();
  }

  public String getRepaymentDate() {
    return lblRepaymentDate.getText();
  }

  public String getBorrowName() {
    return lblBorrowName.getText();
  }

  public void checkExactlyInformation() {
    scrollToElement(chkExactlyInformation, ScrollDirection.DOWN, 3);
    click(chkExactlyInformation);
  }

  public void checkTermsAndConditions() {
    click(chkTermsAndConditions);
  }

  public void clickSendButton() {
    click(btnSend);
  }

  public NotificationPopup notificationPopup() {
    return new NotificationPopup(appiumDriver);
  }

  public void clickEditButton() {
    click(btnEdit);
  }
}
