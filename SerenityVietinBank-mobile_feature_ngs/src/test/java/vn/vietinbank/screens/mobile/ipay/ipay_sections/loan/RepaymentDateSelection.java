package vn.vietinbank.screens.mobile.ipay.ipay_sections.loan;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class RepaymentDateSelection extends BaseScreen {

  public RepaymentDateSelection(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void chooseADate(String date) {
    List<WebElement> btnDates;
    if(appiumDriver instanceof AndroidDriver) {
      btnDates = findElements("//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/titleText\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/liTitle\"]/following-sibling::android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.mobile.ipay:id/rcvDaysInMonth\"]//android.widget.TextView");
    } else {
      btnDates = findElements("//XCUIElementTypeStaticText[@name=\"Chọn ngày trả nợ hàng tháng\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton");
    }
    for (WebElement btnDate : btnDates) {
      if (getText(btnDate).equals(date)) {
        tap(btnDate);
        break;
      }
    }
  }
}
