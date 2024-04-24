package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NavigationBar;

public class LoanAndCreditService extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton")
  public WebElementFacade btnVayTieuDungCaNhan;

  public LoanAndCreditService() {
    super();
  }

  public void click_vay_tieu_dung_ca_nhan() {
    click(btnVayTieuDungCaNhan);
  }

  public NavigationBar navigationBar() {
    return new NavigationBar();
  }
}
