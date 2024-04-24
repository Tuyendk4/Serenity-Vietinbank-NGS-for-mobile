package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class Login extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Tên đăng nhập\"]")
  private WebElementFacade txtUsername;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Mật khẩu\"]")
  private WebElementFacade txtPassword;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
  private WebElementFacade btnLogin;

  public Login() {
    super();
  }

  private void inputUserName(String userName) {
    sendKeys(txtUsername, userName);
  }

  private void inputPassword(String password) {
    sendKeys(txtPassword, password);
  }

  private void clickLoginButton() {
    click(btnLogin);
  }

  public OTP login_with(String userName, String password) {
    inputUserName(userName);
    inputPassword(password);
    clickLoginButton();
    return new OTP();
  }
}
