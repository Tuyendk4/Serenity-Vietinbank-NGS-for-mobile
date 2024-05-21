package screens.mobile;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NotificationPopup;
import screens.mobile.sections.SuccessPopup;

public class PersonalInstalmentLoan_Step3 extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblNumberOfMoney;

  private final String android_lblNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.TextView";
  private final String ios_lblNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblMonths;

  private final String android_lblMonths = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.TextView";
  private final String ios_lblMonths = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất dự kiến\"]/following-sibling::XCUIElementTypeStaticText[1]")
//  private WebElement lblInterestRate;

  private final String android_lblInterestRate = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.TextView";
  private final String ios_lblInterestRate = "//XCUIElementTypeStaticText[@name=\"Lãi suất dự kiến\"]/following-sibling::XCUIElementTypeStaticText[1]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Chương trình ưu đãi\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chương trình ưu đãi\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblSpecialOffer;

  private final String android_lblSpecialOffer = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Chương trình ưu đãi\"]/following-sibling::android.widget.TextView";
  private final String ios_lblSpecialOffer = "//XCUIElementTypeStaticText[@name=\"Chương trình ưu đãi\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Mục đích vay\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblLoanPurpose;

  private final String android_lblLoanPurpose = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Mục đích vay\"]/following-sibling::android.widget.TextView";
  private final String ios_lblLoanPurpose = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngày trả nợ hàng tháng\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblRepaymentDate;

  private final String android_lblRepaymentDate = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.TextView";
  private final String ios_lblRepaymentDate = "//XCUIElementTypeStaticText[@name=\"Ngày trả nợ hàng tháng\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Họ & tên người vay\"]/following-sibling::android.widget.TextView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Họ & tên người vay\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblBorrowName;

  private final String android_lblBorrowName = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvItemTitle\" and @text=\"Họ & tên người vay\"]/following-sibling::android.widget.TextView";
  private final String ios_lblBorrowName = "//XCUIElementTypeStaticText[@name=\"Họ & tên người vay\"]/following-sibling::XCUIElementTypeStaticText";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Gửi yêu cầu vay\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Gửi yêu cầu vay\"]")
//  private WebElement btnSend;

  private final String android_btnSend = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Gửi yêu cầu vay\"]";
  private final String ios_btnSend = "//XCUIElementTypeButton[@name=\"Gửi yêu cầu vay\"]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnEdit\" and @text=\"Chỉnh sửa\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chỉnh sửa\"]")
//  private WebElement btnEdit;

  private final String android_btnEdit = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnEdit\" and @text=\"Chỉnh sửa\"]";
  private final String ios_btnEdit = "//XCUIElementTypeButton[@name=\"Chỉnh sửa\"]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbValidInfo\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]")
//  private WebElement chkExactlyInformation;

  private final String android_chkExactlyInformation = "";
  private final String ios_chkExactlyInformation = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTermAndService\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbTermAndService\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi đồng ý với Điều kiện & điều khoản dịch vụ Vay tiêu dùng cá nhân của VietinBank\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]")
//  private WebElement chkTermsAndConditions;

  private final String android_chkTermsAndConditions = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTermAndService\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbTermAndService\"]";
  private final String ios_chkTermsAndConditions = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name=\"Tôi đồng ý với Điều kiện & điều khoản dịch vụ Vay tiêu dùng cá nhân của VietinBank\"]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]";


  public PersonalInstalmentLoan_Step3(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNumberOfMoney() {
    scrollTo("Số tiền vay");
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblNumberOfMoney);
    } else {
      return getText(ios_lblNumberOfMoney);
    }
  }

  public String getMonths() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblMonths);
    } else {
      return getText(ios_lblMonths);
    }
  }

  public String getInterestRate() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblInterestRate);
    } else {
      return getText(ios_lblInterestRate);
    }
  }

  public String getSpecialOfferType() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblSpecialOffer);
    } else {
      return getText(ios_lblSpecialOffer);
    }
  }

  public String getLoanPurpose() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblLoanPurpose);
    } else {
      return getText(ios_lblLoanPurpose);
    }
  }

  public String getRepaymentDate() {
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblRepaymentDate);
    } else {
      return getText(ios_lblRepaymentDate);
    }
  }

  public String getBorrowName() {
    scrollTo("Họ & tên người vay");
    if(appiumDriver instanceof AndroidDriver) {
      return getText(android_lblBorrowName);
    } else {
      return getText(ios_lblBorrowName);
    }
  }

  public void checkExactlyInformation() {
    if(appiumDriver instanceof AndroidDriver) {
      scrollTo("Tôi xác nhận các thông tin trên là chính xác");
      click("//android.widget.TextView[@text=\"Tôi xác nhận các thông tin trên là chính xác\"]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbValidInfo\"]");
    } else {
      scrollToElement(ios_chkExactlyInformation, ScrollDirection.DOWN, 3);
      click(ios_chkExactlyInformation);
    }

  }

  public void checkTermsAndConditions() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_chkTermsAndConditions);
    } else {
      click(ios_chkTermsAndConditions);
    }

  }

  public void clickSendButton() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnSend);
    } else {
      click(ios_btnSend);
    }
  }

  public NotificationPopup notificationPopup() {
    return new NotificationPopup(appiumDriver);
  }

  public SuccessPopup successPopup() {
    return new SuccessPopup(appiumDriver);
  }

  public void clickEditButton() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnEdit);
    } else {
      click(ios_btnEdit);
    }
  }
}
