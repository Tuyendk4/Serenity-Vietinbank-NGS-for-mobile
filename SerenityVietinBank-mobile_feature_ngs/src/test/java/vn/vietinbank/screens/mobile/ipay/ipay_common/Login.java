package vn.vietinbank.screens.mobile.ipay.ipay_common;

import com.epam.reportportal.annotations.Step;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.ChangeAccountPopup;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.NotificationPopup;

public class Login extends BaseScreen {

  private final String android_txtUserName = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/wUserName\" and @text=\"Tên đăng nhập\"]";
  private final String ios_txtUserName = "//XCUIElementTypeTextField[@value=\"Tên đăng nhập\"]";

  private final String android_txtPassword = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mật khẩu\"]";
  private final String ios_txtPassword = "//XCUIElementTypeSecureTextField[@value=\"Mật khẩu\"]";

  private final String android_btnLogin = "//*[@text=\"Đăng nhập\" or @text=\"Đăng nhập/đăng ký\"]";
  private final String ios_btnLogin = "//XCUIElementTypeButton[@name=\"Đăng nhập\" or @name=\"Đăng nhập/Đăng ký\"]";

  private final String android_lblLoginWithOtherAccount = "//*[contains(@text,\"Đăng nhập tài khoản khác\")]";
  private final String ios_lblLoginWithOtherAccount = "//*[contains(@name,\"Đăng nhập tài khoản khác\")]";


  public Login(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Input user name: {userName}")
  private void inputUserName(String userName) {
    if (appiumDriver instanceof AndroidDriver) {
      if(waitForElementVisible(android_txtUserName, 20)) {
        sendKeys(android_txtUserName, userName);
      } else {
        tapAt(30, 280);
        String[] keys = userName.split("");
        for (String key : keys) {
          pressKey(key);
        }
      }

      ((AndroidDriver) appiumDriver).hideKeyboard();
      delay(300);
    } else {
      sendKeys(ios_txtUserName, userName);
    }
  }

  @Step("Input password: {password}")
  private void inputPassword(String password) {
    if (appiumDriver instanceof AndroidDriver) {
      if(waitForElementVisible(android_txtPassword, 20)) {
        sendKeys(android_txtPassword, password);
      } else {
        tapAt(60, 680);
        String[] keys = password.split("");
        for (String key : keys) {
          pressKey(key);
        }
      }

      ((AndroidDriver) appiumDriver).hideKeyboard();
      delay(600);
    } else {
      sendKeys(ios_txtPassword, password);
    }
  }

  @Step("Click Login button")
  private void clickLoginButton() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnLogin);
      if (notificationPopup().should_show_agree_button()) {
        notificationPopup().clickAgreeButton();
        delay(3000);
        tap(android_btnLogin);
      }
//      tapAt(150, 980);
    } else {
      tap(ios_btnLogin);
      if (notificationPopup().should_show_agree_button()) {
        notificationPopup().clickAgreeButton();
        delay(3000);
        tap(ios_btnLogin);
      }
    }
  }

  @Step("Đăng nhập với tên đăng nhập {userName}/{password}")
  public OTP login_with(String userName, String password) {
    if (appiumDriver instanceof AndroidDriver) {
      if (verifyElementEnable(android_lblLoginWithOtherAccount, 5)) {
        click_change_account().clickYes();
      }
    } else {
      if (verifyElementEnable(ios_lblLoginWithOtherAccount, 5)) {
        click_change_account().clickYes();
      }
    }
    if (appiumDriver instanceof AndroidDriver) {
      if (!waitForElementVisible(android_txtUserName, 10)) {
        click(android_btnLogin);
      }
    } else {
      if (!waitForElementVisible(ios_txtUserName, 10)) {
        click(ios_btnLogin);
      }
    }
    inputUserName(userName);
    inputPassword(password);
    clickLoginButton();
    return new OTP(appiumDriver);
  }

  @Step("Nhấn Thay đổi tài khoản")
  public ChangeAccountPopup click_change_account() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_lblLoginWithOtherAccount);
    } else {
      click(ios_lblLoginWithOtherAccount);
    }
    delay(3000);
    return new ChangeAccountPopup(appiumDriver);
  }

  @Step("login")
  public OTP login_with_pass(String password){
    inputPassword(password);
    clickLoginButton();
    return new OTP(appiumDriver);
  }

  public NotificationPopup notificationPopup() {
    return new NotificationPopup(appiumDriver);
  }
}
