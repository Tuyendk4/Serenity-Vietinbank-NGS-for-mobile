package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Signup extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Đăng nhập/Đăng ký\" or @text=\"Đăng nhập\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]")
//  public WebElement btnLogin;

  private final String android_btnLogin = "//android.widget.Button[@text=\"Đăng nhập/Đăng ký\" or @text=\"Đăng nhập\"]";
  private final String ios_btnLogin = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]";

  public Signup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Login click_dang_nhap_or_dang_ky_button() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnLogin, 10);
    } else {
      click(ios_btnLogin);
    }
    delay(10000);
    return new Login(appiumDriver);
  }
}
