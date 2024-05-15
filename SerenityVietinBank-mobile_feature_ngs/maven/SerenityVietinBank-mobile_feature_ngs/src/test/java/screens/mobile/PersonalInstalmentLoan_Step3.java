package screens.mobile;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NotificationPopup;

public class PersonalInstalmentLoan_Step3 extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNumberOfMoney;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblMonths;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất dự kiến\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblInterestRate;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Mục đích vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblLoanPurpose;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngày trả nợ hàng tháng\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblRepaymentDate;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Họ & tên người vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Họ & tên người vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblBorrowName;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Gửi yêu cầu vay\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Gửi yêu cầu vay\"]")
  private WebElement btnSend;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnEdit\" and @text=\"Chỉnh sửa\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chỉnh sửa\"]")
  private WebElement btnEdit;

//  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbValidInfo\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]")
  private WebElement chkExactlyInformation;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTermAndService\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbTermAndService\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi đồng ý với Điều kiện & điều khoản dịch vụ Vay tiêu dùng cá nhân của VietinBank\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]")
  private WebElement chkTermsAndConditions;


  public PersonalInstalmentLoan_Step3(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNumberOfMoney() {
    scrollTo("Số tiền vay");
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
    scrollTo("Họ & tên người vay");
    return lblBorrowName.getText();
  }

  public void checkExactlyInformation() {
    if(appiumDriver instanceof AndroidDriver) {
      scrollTo("Tôi xác nhận các thông tin trên là chính xác");
      click("//android.widget.TextView[@text=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbValidInfo\"]");
    } else {
      scrollToElement(chkExactlyInformation, ScrollDirection.DOWN, 3);
      click(chkExactlyInformation);
    }

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
