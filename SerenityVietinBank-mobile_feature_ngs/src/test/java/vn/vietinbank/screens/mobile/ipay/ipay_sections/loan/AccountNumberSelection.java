package vn.vietinbank.screens.mobile.ipay.ipay_sections.loan;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.RepayAndFinalizeTheLoan;

public class AccountNumberSelection extends BaseScreen {

  private final String android_txtSearchAccountNumber = "//android.widget.EditText[@resource-id=\"com.vietinbank.mobile.ipay:id/edtFinter\" and @text=\"Tìm kiếm theo tên ngân hàng\"]";
  private final String ios_txtSearchAccountNumber = "//XCUIElementTypeImage[@name=\"ic_search_gray\"]/preceding-sibling::XCUIElementTypeTextField";

  private final String android_lblAccount = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.mobile.ipay:id/recyclerView\"]//android.widget.TextView";
  private final String ios_lblAccount = "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản vay\" or @name=\"Chọn tài khoản\"]/parent::XCUIElementTypeOther/following-sibling::*//XCUIElementTypeStaticText";
  public AccountNumberSelection(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public RepayAndFinalizeTheLoan choose_account_number(String accountNumber) {
    List<WebElement> lblAccountNumbers;
    if(appiumDriver instanceof AndroidDriver){
      lblAccountNumbers = findElements(android_lblAccount);
    } else {
      lblAccountNumbers = findElements(ios_lblAccount);
    }
    for (WebElement lblAccountNumber : lblAccountNumbers) {
      String actualAccountNumber = getText(lblAccountNumber);
      if (accountNumber.equals(actualAccountNumber)) {
        tap(lblAccountNumber);
        break;
      }
    }
    return new RepayAndFinalizeTheLoan(appiumDriver);
  }

  public void search_and_choose_account_number(String accountNumber) {
    if(appiumDriver instanceof AndroidDriver){
      sendKeys(android_txtSearchAccountNumber, accountNumber);
    } else {
      sendKeys(ios_txtSearchAccountNumber, accountNumber);
    }
    delay(2000);
    List<WebElement> lblAccountNumbers;
    if(appiumDriver instanceof AndroidDriver){
      lblAccountNumbers = findElements(android_lblAccount);
    } else {
      lblAccountNumbers = findElements(ios_lblAccount);
    }
    for (WebElement lblAccountNumber : lblAccountNumbers) {
      String actualAccountNumber = getText(lblAccountNumber);
      if (accountNumber.equals(actualAccountNumber)) {
        tap(lblAccountNumber);
        break;
      }
    }
  }
}
