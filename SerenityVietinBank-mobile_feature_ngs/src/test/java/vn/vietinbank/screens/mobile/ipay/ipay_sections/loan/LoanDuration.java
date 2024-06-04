package vn.vietinbank.screens.mobile.ipay.ipay_sections.loan;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class LoanDuration extends BaseScreen {

  public LoanDuration(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void selectMonth(String month) {
    scrollTo(month);
    WebElement lblMonth;
    if(appiumDriver instanceof AndroidDriver) {
      lblMonth =  findElement(
          "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\" and @text=\"Thời hạn vay\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\"]");
    } else {
      lblMonth = findElement(
          "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\" or @name=\"Chọn kỳ hạn\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText[contains(@label, '" + month + "') or contains(@text, '" + month + "') or contains(@name, '" + month + "')]");
    }
    tap(lblMonth);
//    for(WebElement lblMonth: lblMonths) {
//      if(getText(lblMonth).trim().equals(month)) {
//        tap(lblMonth);
//        break;
//      }
//    }
  }
}
