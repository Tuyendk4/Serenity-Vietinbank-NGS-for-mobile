package vn.vietinbank.mobile.screens.iPay.Loan.popups.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.mobile.common.BaseScreen;
import vn.vietinbank.mobile.screens.iPay.Loan.LoanAndCreditServices.LoanAndCreditServices;

public class FavoriteServices extends BaseScreen {

  private final String android_iconLoanAndCreaditService = "//android.widget.TextView[@text=\"Sản phẩm vay\" or @text=\"Dịch vụ vay & tín dụng\"]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_iconLoanAndCreaditService = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\" or @name=\"Sản phẩm vay\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeImage";
  private final String transfer = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền\"]";

  public FavoriteServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn vào Dịch vụ vay và tín dụng")
  public LoanAndCreditServices click_dich_vu_vay_va_tin_dung() {
    if(appiumDriver instanceof AndroidDriver){
      tap(android_iconLoanAndCreaditService, 30);
    } else {
      tap(ios_iconLoanAndCreaditService, 30);
    }
    delay(5000);
    return new LoanAndCreditServices(appiumDriver);
  }

//  @Step("Di chuyển vào Chuyển tiền")
//  public TransferAndReceive click_on_transfer_money(){
//    if(appiumDriver instanceof AndroidDriver){
//
//    } else {
//      click(transfer);
//    }
//    return new TransferAndReceive(appiumDriver);
//  }
}
