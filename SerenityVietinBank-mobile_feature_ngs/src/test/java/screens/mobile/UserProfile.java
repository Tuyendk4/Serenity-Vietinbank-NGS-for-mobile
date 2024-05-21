package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class UserProfile extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
  private WebElement btnDangNhap;

  private final String android_btnDangNhap = "";
  private final String ios_btnDangNhap = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]";

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng xuất\"]")
  private WebElement btnDangXuat;

  private final String android_btnDangXuat = "";
  private final String ios_btnDangXuat = "//XCUIElementTypeButton[@name=\"Đăng xuất\"]";

  public UserProfile(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Home click_dang_xuat() {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnDangXuat);
    } else {
      click(ios_btnDangXuat);
    }
    return new Home(appiumDriver);
  }
}
