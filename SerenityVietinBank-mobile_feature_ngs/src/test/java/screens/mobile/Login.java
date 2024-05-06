package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;

public class Login extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Tên đăng nhập\"]")
  private WebElement txtUsername;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Mật khẩu\"]")
  private WebElement txtPassword;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
  private WebElement btnLogin;

  public Login(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhập tên tài khoản {0}")
  private void inputUserName(String userName) {
    sendKeys(txtUsername, userName);
  }

  @Step("Nhập password {0}")
  private void inputPassword(String password) {
    sendKeys(txtPassword, password);
  }

  @Step("Nhấn Đăng nhập")
  private void clickLoginButton() {
    click(btnLogin);
  }

  @Step("Đăng nhập hệ thống với {0}/{1}")
  public OTP login_with(String userName, String password) {
    inputUserName(userName);
    inputPassword(password);
    clickLoginButton();
    return new OTP(appiumDriver);
  }
}
