package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class AccountNumberList extends BaseScreen {

  private final String android_btnLoanAccount = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvHomeHeaderAccountList\"]/following-sibling::android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivDropDown\"]";
  private final String ios_btnLoanAccount = "//XCUIElementTypeStaticText[contains(@name,\"Tài khoản vay\")]/preceding-sibling::XCUIElementTypeButton";

  private final String android_lblLoanAccounts = "";
  private final String ios_lblLoanAccounts = "//XCUIElementTypeStaticText[contains(@name,\"Tài khoản vay\")]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeButton[1]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]";

  private final String android_btnOverdraftLoan = "";
  private final String ios_btnOverdraftLoan = "//XCUIElementTypeButton[@name=\"Vay thấu chi\"]";

  public AccountNumberList(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void expand_Loan_Account() {
    if(appiumDriver instanceof AndroidDriver) {
      if(!waitForElementVisible(android_btnOverdraftLoan, 10)) {
        click(android_btnLoanAccount);
      }
    } else {
      if(!waitForElementVisible(ios_btnOverdraftLoan, 10)) {
        click(ios_btnLoanAccount);
      }
    }
    delay(5000);
  }

  public String get_new_loan_account() {
    List<WebElement> lblLoanAccounts;
    if(appiumDriver instanceof AndroidDriver) {
      lblLoanAccounts = findElements(android_lblLoanAccounts);
    } else {
      lblLoanAccounts = findElements(ios_lblLoanAccounts);
    }
    return lblLoanAccounts.get(lblLoanAccounts.size() - 1).getText();
  }

  public String get_money_of_new_loan_account(String loanAccount) {
    String lblLoanMoney;
    if(appiumDriver instanceof AndroidDriver) {
      lblLoanMoney = "";
    } else {
      lblLoanMoney =
          "//XCUIElementTypeStaticText[contains(@name,\"Tài khoản vay\")]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeButton[@name=\"moreRightBlue\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[@name="
              + loanAccount + "]/following-sibling::XCUIElementTypeStaticText[2]";
    }
    return getText(lblLoanMoney);
  }

  public Home back_to_Home() {
    clickBackButton();
    return new Home(appiumDriver);
  }
}
