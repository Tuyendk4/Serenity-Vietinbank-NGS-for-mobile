package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.ChangeAccountPopup;

public class Login extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Tên đăng nhập\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Tên đăng nhập\"]")
  private WebElement txtUsername;

  @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Mật khẩu\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Mật khẩu\"]")
  private WebElement txtPassword;

  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Đăng nhập\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
  private WebElement btnLogin;

  @AndroidFindBy(xpath = "//*[contains(@text,\"Đăng nhập tài khoản khác\")]")
  @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Đăng nhập tài khoản khác\")]")
  private WebElement lblLoginWithOtherAccount;

  public Login(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void inputUserName(String userName) {
    if (appiumDriver instanceof AndroidDriver) {
      txtUsername.sendKeys(userName);
    } else {
      sendKeys(txtUsername, userName);
    }
  }

  private void inputPassword(String password) {
    if (appiumDriver instanceof AndroidDriver) {
      txtPassword.sendKeys(password);
    } else {
      sendKeys(txtPassword, password);
    }
  }

  private void clickLoginButton() {
    if (appiumDriver instanceof AndroidDriver) {
      btnLogin.click();
    } else {
      click(btnLogin);
    }
  }

  public OTP login_with(String userName, String password) {
    if(verifyElementEnable(lblLoginWithOtherAccount)) {
      click_change_account().clickYes();
    }
    inputUserName(userName);
    inputPassword(password);
    clickLoginButton();
    return new OTP(appiumDriver);
  }

  public ChangeAccountPopup click_change_account() {
    click(lblLoginWithOtherAccount);
    return new ChangeAccountPopup(appiumDriver);
  }
}
