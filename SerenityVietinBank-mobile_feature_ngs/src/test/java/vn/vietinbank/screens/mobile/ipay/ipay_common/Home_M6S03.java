package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.M6S03.LoanAndCreditService;

public class Home_M6S03 extends BaseScreen {

  private final String android_btnLoanAndCreditService = "//android.widget.TextView[@text=\"Dịch vụ vay & tín dụng\"]";
  private final String ios_classChainLoanAndCreditService = "**/XCUIElementTypeStaticText[`name == \"Dịch vụ vay & tín dụng\"`]";


  public Home_M6S03(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }


  public LoanAndCreditService click_dich_vu_vay_va_tin_dung() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnLoanAndCreditService);
    } else {
      WebElement web_LoanAndCreditService = findElement_iosClassChain(ios_classChainLoanAndCreditService);
      click(web_LoanAndCreditService);
    }
    return new LoanAndCreditService(this.appiumDriver);
  }
}
