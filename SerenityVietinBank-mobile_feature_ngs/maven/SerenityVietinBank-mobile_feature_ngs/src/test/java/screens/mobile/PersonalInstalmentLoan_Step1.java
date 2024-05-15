package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import org.openqa.selenium.WebElement;

public class PersonalInstalmentLoan_Step1 extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]")
  private WebElement btnCalculateNow;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeTextField")
  private WebElement txtNumberOfMoney;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.LinearLayout/android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage[@name=\"iconLineEditPencil\"]/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnEditMoney;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
  private WebElement iconDeleteMoney;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement txtMonths;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLoansUnsecuredLoan\"]/following-sibling::XCUIElementTypeOther[2]//XCUIElementTypeButton[@name=\"iconLineEditPencil\"]")
  private WebElement btnEditMonths;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\" and @text=\"Thời hạn vay\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtFinter\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_search_gray\"]/preceding-sibling::XCUIElementTypeTextField")
  private WebElement txtSearchMonth;

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Lãi suất\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvRateCurrent\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText")
  private WebElement lblInterestRate;

  @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Số tiền phải trả\")]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTotalIntCurrent\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]")
  private WebElement lblMonthlyChargeAmount01;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[2]")
  private WebElement lblMonthlyChargeAmount02;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]")
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

  private void clickEditMoneyButton() {
    click(btnEditMoney);
  }

  private void clickDeleteMoneyButton() {
    click(iconDeleteMoney);
  }

  private void clickMoneyLabel() {
    click(txtNumberOfMoney);
  }

  private void inputMoney(String money) {
    sendKeys(txtNumberOfMoney, money);
  }

  public void editMoney(String money) {
    clickEditMoneyButton();
    clickMoneyLabel();
    clickDeleteMoneyButton();
    inputMoney(money);
  }

  private void clickEditMonthsButton() {
    click(btnEditMonths);
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

  public PersonalInstalmentLoan_Step2 clickContinueButton() {
    click(btnContinue);
    return new PersonalInstalmentLoan_Step2(appiumDriver);
  }
}
