package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.ipay.M2S02.TransferAndReceive;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AllServices.AllServicesPage;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.CardList;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanAndCreditServices;

public class FavoriteServices extends BaseScreen {

  private final String android_iconLoanAndCreaditService = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvProvider\" and (@text=\"Sản phẩm vay\" or @text=\"Dịch vụ vay & tín dụng\")]/preceding-sibling::android.widget.FrameLayout/android.widget.ImageView";
  private final String ios_iconLoanAndCreaditService = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\" or @name=\"Sản phẩm vay\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeImage";
  private final String transfer = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền\"]";

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dịch vụ thẻ\"]")
  private WebElement btnCardsList;


  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tất cả dịch vụ\"]")
  private WebElement btnAllServices;


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
  @Step("Di chuyển vào Chuyển tiền")
  public TransferAndReceive click_on_transfer_money(){
    if(appiumDriver instanceof AndroidDriver){

    } else {
      click(transfer);
    }
    return new TransferAndReceive(appiumDriver);
  }
  @Step("Mở dịch vụ thẻ")
  public CardList chonDichVuThe() {
    if (appiumDriver instanceof IOSDriver) {
      tap(btnCardsList);
      delay(3000);
    }
    return new CardList(appiumDriver);
  }

  @Step("Mở tất cả dịch vụ")
  public AllServicesPage chonTatCaDichVu(){
    if (appiumDriver instanceof IOSDriver) {
      tap(btnAllServices);
    }
    return new AllServicesPage(appiumDriver);}
}
