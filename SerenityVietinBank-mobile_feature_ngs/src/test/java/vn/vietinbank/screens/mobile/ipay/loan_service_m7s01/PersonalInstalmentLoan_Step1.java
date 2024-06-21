package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class PersonalInstalmentLoan_Step1 extends BaseScreen {

  private final String android_btnCalculateNow = "";
  private final String ios_btnCalculateNow = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]";

  private final String android_txtNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]";
  private final String ios_txtNumberOfMoney = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeTextField";

  private final String android_btnEditMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.LinearLayout/android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"]";
  private final String ios_btnEditMoney = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage[@name=\"iconLineEditPencil\"]/preceding-sibling::XCUIElementTypeButton";

//  private final String android_iconDeleteMoney = "";
  private final String ios_iconDeleteMoney = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

  private final String android_txtMonths = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]";
  private final String ios_txtMonths = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText";

  private final String android_btnEditMonths = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"]";
  private final String ios_btnEditMonths = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeButton[@name=\"iconLineEditPencil\"]";

  private final String android_txtSearchMonth = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\" and @text=\"Thời hạn vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtFinter\"]";
  private final String ios_txtSearchMonth = "//XCUIElementTypeImage[@name=\"ic_search_gray\"]/preceding-sibling::XCUIElementTypeTextField";

  private final String android_lblInterestRate = "//android.widget.TextView[@text=\"Lãi suất\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRateCurrent\"]";
  private final String ios_lblInterestRate = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]";

  private final String android_lblMonthlyChargeAmount01 = "//android.widget.TextView[contains(@text,\"Số tiền phải trả\")]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTotalIntCurrent\"]";
  private final String ios_lblMonthlyChargeAmount01 = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]";

//  private final String android_lblMonthlyChargeAmount02 = "";
  private final String ios_lblMonthlyChargeAmount02 = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[2]";

  private final String android_chkInsuranceAgreement = "//android.widget.TextView[contains(@text,\"Tôi đồng ý cho phép VietinBank cung cấp thông tin cá nhân cho Tổng công ty bảo hiểm\")]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbConfirmAgreeWithTerm\"]";
  private final String ios_chkInsuranceAgreement = "//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,\"Tôi đồng ý cho phép VietinBank cung cấp thông tin cá nhân cho Tổng công ty bảo hiểm\")]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]";

  private final String android_chkTermsAndConditions = "//android.widget.TextView[contains(@text,\"Tôi xác nhận đã đọc, hiểu và đồng ý\")]/preceding-sibling::android.widget.CheckBox[@resource-id=\"com.vietinbank.ipay:id/cbConfirmWith\"]";
  private final String ios_chkTermsAndConditions = "//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@name,\"Tôi xác nhận đã đọc, hiểu và đồng ý\")]/preceding-sibling::XCUIElementTypeButton[@name=\"iconChoiceCheckOff\"]";

  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";

  public PersonalInstalmentLoan_Step1(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public boolean should_show_InterestRate(String interestRate) {
    if (appiumDriver instanceof AndroidDriver) {
      return waitForElementText(android_lblInterestRate, interestRate, 20);
    } else {
      return waitForElementText(ios_lblInterestRate, interestRate, 20);
    }
  }

  public String getInterestRate() {
    if (appiumDriver instanceof AndroidDriver) {
      return getText(android_lblInterestRate);
    } else {
      return getText(ios_lblInterestRate);
    }
  }

  public String getMonthlyChargeAmount01() {
    if (appiumDriver instanceof AndroidDriver) {
      return getText(android_lblMonthlyChargeAmount01);
    } else {
      return getText(ios_lblMonthlyChargeAmount01);
    }
  }

  public String getMonthlyChargeAmount02() {
    if (appiumDriver instanceof IOSDriver) {
      return getText(ios_lblMonthlyChargeAmount02);
    }
    return "";
  }

  private void clickEditMoneyButton() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnEditMoney);
    } else {
      click(ios_btnEditMoney);
    }
  }

  private void clickDeleteMoneyButton() {
    if (appiumDriver instanceof IOSDriver) {
      click(ios_iconDeleteMoney);
    }
  }

  private void clickMoneyLabel() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_txtNumberOfMoney);
    } else {
      click(ios_txtNumberOfMoney);
    }
  }

  private void inputMoney(String money) {
    if (appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtNumberOfMoney, money);
    } else {
      sendKeys(ios_txtNumberOfMoney, money);
    }
  }

  public void editMoney(String money) {
    clickEditMoneyButton();
    clickMoneyLabel();
    clickDeleteMoneyButton();
    inputMoney(money);
  }

  private void clickEditMonthsButton() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnEditMonths);
    } else {
      click(ios_btnEditMonths);
    }
  }

  private void selectMonth(String month) {
    scrollTo(month);
    List<WebElement> lblMonths;
    if(appiumDriver instanceof AndroidDriver) {
      lblMonths =  findElements(
          "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\" and @text=\"Thời hạn vay\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\"]");
    } else {
      lblMonths = findElements(
          "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable//XCUIElementTypeStaticText");
    }
    for(WebElement lblMonth: lblMonths) {
      if(lblMonth.getText().equals(month)) {
        tap(lblMonth);
        break;
      }
    }
  }

  public void editMonth(String month) {
    clickEditMonthsButton();
    selectMonth(month);
  }

  public void checkInsuranceAgreement() {
    if(appiumDriver instanceof AndroidDriver) {
      scrollTo("Tôi xác nhận các thông tin trên là chính xác");
      tap(android_chkInsuranceAgreement);
    } else {
      scrollToElement(ios_chkInsuranceAgreement, ScrollDirection.DOWN, 3);
      click(ios_chkInsuranceAgreement);
    }
  }

  public void checkTermsAndConditions() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_chkTermsAndConditions);
    } else {
      click(ios_chkTermsAndConditions);
    }
  }

  public PersonalInstalmentLoan_Step2 clickContinueButton() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    return new PersonalInstalmentLoan_Step2(appiumDriver);
  }
}
