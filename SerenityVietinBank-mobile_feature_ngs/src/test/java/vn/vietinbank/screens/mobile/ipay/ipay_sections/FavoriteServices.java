package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanAndCreditServices;

public class FavoriteServices extends BaseScreen {

  private final String android_iconLoanAndCreaditService = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvProvider\" and (@text=\"Sản phẩm vay\" or @text=\"Dịch vụ vay & tín dụng\")]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_iconLoanAndCreaditService = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\" or @name=\"Sản phẩm vay\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeImage";

  public FavoriteServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn vào Dịch vụ vay và tín dụng")
  public LoanAndCreditServices click_dich_vu_vay_va_tin_dung() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_iconLoanAndCreaditService);
    } else {
      click(ios_iconLoanAndCreaditService);
    }
    return new LoanAndCreditServices(appiumDriver);
  }
}
