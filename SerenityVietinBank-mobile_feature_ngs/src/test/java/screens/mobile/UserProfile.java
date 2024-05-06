package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class UserProfile extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
  private WebElement btnDangNhap;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng xuất\"]")
  private WebElement btnDangXuat;

  public UserProfile(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Home click_dang_xuat() {
    click(btnDangXuat);
    return new Home(appiumDriver);
  }
}
