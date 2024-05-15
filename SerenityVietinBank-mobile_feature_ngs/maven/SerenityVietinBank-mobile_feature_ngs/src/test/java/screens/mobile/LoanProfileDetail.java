package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoanProfileDetail extends BaseScreen {

  @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"com.vietinbank.ipay:id/viewTopPopup\"]")
  private WebElement viewTopPopup;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblNumberOfMoney;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblMonths;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Lãi suất\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblInterestRate;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngày trả nợ hàng tháng\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblRepaymentDate;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Mục đích vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblLoanPurpose;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Họ & tên người vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Họ & tên người vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblBorrowName;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Email nhận hợp đồng vay\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email nhận hợp đồng vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblEmail;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Điện thoại\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Điện thoại\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblPhone;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số giấy tờ cá nhân\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số giấy tờ cá nhân\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblID;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Địa chỉ thường trú\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Địa chỉ thường trú\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblAddress;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Địa chỉ liên hệ\"]/following-sibling::android.widget.TextView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Địa chỉ liên hệ\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblAddressContact;

  public LoanProfileDetail(AppiumDriver appiumDriver) {
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

  public String getRepaymentDate() {
    return lblRepaymentDate.getText();
  }

  public String getLoanPurpose() {
    return lblLoanPurpose.getText();
  }

  public String getBorrowName() {
    return lblBorrowName.getText();
  }

  public String getEmail() {
    return lblEmail.getText();
  }

  public String getPhone() {
    return lblPhone.getText();
  }

  public String getID() {
    return lblID.getText();
  }

  public String getAddress() {
    return lblAddress.getText();
  }

  public String getAddressContact() {
    return lblAddressContact.getText();
  }

  public void closeLoanProfileDetailPopup() {
    click(viewTopPopup);
  }
}
