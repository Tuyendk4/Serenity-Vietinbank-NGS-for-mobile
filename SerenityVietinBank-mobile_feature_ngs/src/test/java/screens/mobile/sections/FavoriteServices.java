package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import screens.mobile.LoanAndCreditServices;
import screens.mobile.TransferMoneyObroad;

public class FavoriteServices extends BaseScreen {

  @AndroidFindBy(xpath = "")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\" or @name=\"Sản phẩm vay\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeImage")
  private WebElement iconLoanAndCreditServices;

  @AndroidFindBy(xpath = "")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền\"]")
  private WebElement iconTransferMoneyServices;

  public FavoriteServices(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn vào Dịch vụ vay và tín dụng")
  public LoanAndCreditServices click_dich_vu_vay_va_tin_dung() {
    click(iconLoanAndCreditServices);
    return new LoanAndCreditServices(appiumDriver);
  }

  @Step("Di chuyển vào Chuyển tiền")
  public TransferMoneyObroad click_on_transfer_money(){
    System.out.println("1111111111111");
//    waitForElementVisible(iconTransferMoneyServices,60);
//    iconTransferMoneyServices.click();
    return new TransferMoneyObroad(appiumDriver);
  }
}
