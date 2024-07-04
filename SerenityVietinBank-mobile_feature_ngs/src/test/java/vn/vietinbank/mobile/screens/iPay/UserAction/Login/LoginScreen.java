package vn.vietinbank.mobile.screens.iPay.UserAction.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;
import vn.vietinbank.mobile.screens.iPay.Loan.popups.common.ChangeAccountPopup;
import vn.vietinbank.mobile.screens.iPay.Loan.popups.common.NotificationPopup;
import vn.vietinbank.mobile.screens.iPay.UserAction.OTP.OTPScreen;

public class LoginScreen extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Tên đăng nhập\"]")
  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/wUserName\" and @text=\"Tên đăng nhập\"]")
  private WebElement txtUsername;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value=\"Mật khẩu\"]")
  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mật khẩu\"]")
  private WebElement txtPassword;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\" or @name=\"Đăng nhập/Đăng ký\"]")
  @AndroidFindBy(xpath = "//*[@text=\"Đăng nhập\" or @text=\"Đăng nhập/đăng ký\"]")
  private WebElement btnLogin;

  @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Đăng nhập tài khoản khác\")]")
  @AndroidFindBy(xpath = "//*[contains(@text,\"Đăng nhập tài khoản khác\")]")
  private WebElement lblLoginWithOtherAccount;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Có\"]")
  @AndroidFindBy(xpath = "")
  private WebElement btnYes;

  public LoginScreen(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void inputUserName(String userName) {
    sendKeys(txtUsername, userName);
  }

  private void inputPassword(String password) {
    sendKeys(txtPassword, password);
  }

  private void clickLoginButton() {
    tap(btnLogin);
    if (notificationPopup().should_show_agree_button()) {
      notificationPopup().clickAgreeButton();
      delay(3000);
      tap(btnLogin);
    }
  }

  public void loginWithPassword(String password) {
    inputPassword(password);
    clickLoginButton();
  }

  public void loginWithUsernamePassword(String username, String password) {
    inputUserName(username);
    inputPassword(password);
    clickLoginButton();
  }

  public void clickLoginWithOtherAccountTxt() {
    click(lblLoginWithOtherAccount);
    click(btnYes);
    delay(1000);
  }

  public void checkLoggedIn() {
    if (waitForElementVisible(lblLoginWithOtherAccount, 3)) {
      clickLoginWithOtherAccountTxt();
    }
  }

  public ChangeAccountPopup click_change_account() {
    tap(lblLoginWithOtherAccount);
    delay(3000);
    return new ChangeAccountPopup(appiumDriver);
  }

  public OTPScreen login_with(String userName, String password) {
    if (verifyElementEnable(lblLoginWithOtherAccount)) {
      click_change_account().clickYes();
    }
    if (!waitForElementVisible(txtUsername, 10)) {
      click(btnLogin);
    }
    inputUserName(userName);
    inputPassword(password);
    clickLoginButton();
    return new OTPScreen(appiumDriver);
  }

  public NotificationPopup notificationPopup() {
    return new NotificationPopup(appiumDriver);
  }
}
