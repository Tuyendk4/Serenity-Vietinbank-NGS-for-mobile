package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Signup extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Đăng nhập/Đăng ký\" or @text=\"Đăng nhập\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]")
  public WebElement btnLogin;

  public Signup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Login click_dang_nhap_or_dang_ky_button() {
//    btnDangNhap.click();
//    click(btnLogin);
    btnLogin.click();
    delay(10000);
    return new Login(appiumDriver);
  }
}
