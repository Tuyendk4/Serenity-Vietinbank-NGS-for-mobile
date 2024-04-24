package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import screens.mobile.LoanAndCreditService;

public class FavoriteServices extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeImage")
  public WebElementFacade iconDichVuVayVaTinDung;

  public FavoriteServices() {
    super();
  }

  public LoanAndCreditService click_dich_vu_vay_va_tin_dung() {
    iconDichVuVayVaTinDung.click();
//    click(iconDichVuVayVaTinDung);
    return new LoanAndCreditService();
  }
}
