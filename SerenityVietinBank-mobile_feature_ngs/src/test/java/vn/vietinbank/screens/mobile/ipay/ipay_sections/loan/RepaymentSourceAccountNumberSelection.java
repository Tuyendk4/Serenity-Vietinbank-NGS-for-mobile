package vn.vietinbank.screens.mobile.ipay.ipay_sections.loan;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class RepaymentSourceAccountNumberSelection extends BaseScreen {

  private final String android_txtSearchAccountNumber = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtFinter\" and @text=\"Tìm kiếm theo tên ngân hàng\"]";
  private final String ios_txtSearchAccountNumber = "//XCUIElementTypeImage[@name=\"ic_search_gray\"]/preceding-sibling::XCUIElementTypeTextField";

  private final String android_lblAccount = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/recyclerView\"]//android.widget.TextView";
  private final String ios_lblAccount = "//XCUIElementTypeTable//XCUIElementTypeStaticText";

  public RepaymentSourceAccountNumberSelection(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void choose_account_number(String accountNumber) {
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
