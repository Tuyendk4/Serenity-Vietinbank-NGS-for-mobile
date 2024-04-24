package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class Signup extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]")
  private WebElementFacade btnDangNhap;

  public Signup() {
    super();
  }

  public Login click_dang_nhap_or_dang_ky_button() {
    click(btnDangNhap);
    return new Login();
  }
}
