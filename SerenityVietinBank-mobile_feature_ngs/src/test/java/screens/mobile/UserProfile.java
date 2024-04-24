package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class UserProfile extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
  private WebElementFacade btnDangNhap;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng xuất\"]")
  private WebElementFacade btnDangXuat;

  public UserProfile() {
    super();
  }

  public Home click_dang_xuat() {
    click(btnDangXuat);
    return new Home();
  }
}
