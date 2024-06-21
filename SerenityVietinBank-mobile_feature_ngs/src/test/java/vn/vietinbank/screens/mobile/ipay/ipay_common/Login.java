package vn.vietinbank.screens.mobile.ipay.ipay_common;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.ChangeAccountPopup;

public class Login extends BaseScreen {

  private final String android_txtUserName = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/wUserName\" and @text=\"Tên đăng nhập\"]";
  private final String ios_txtUserName = "//XCUIElementTypeTextField[@value=\"Tên đăng nhập\"]";

  private final String android_txtPassword = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mật khẩu\"]";
  private final String ios_txtPassword = "//XCUIElementTypeSecureTextField[@value=\"Mật khẩu\"]";

  private final String android_btnLogin = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/submit\" and @text=\"Đăng nhập\"]";
  private final String ios_btnLogin = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]";

  private final String android_lblLoginWithOtherAccount = "//*[contains(@text,\"Đăng nhập tài khoản khác\")]";
  private final String ios_lblLoginWithOtherAccount = "//*[contains(@name,\"Đăng nhập tài khoản khác\")]";

  public Login(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void inputUserName(String userName) {
    if (appiumDriver instanceof AndroidDriver) {
      tapAt(30, 280);
      String[] keys = userName.split("");
      for (String key : keys) {
        pressKey(key);
      }
      ((AndroidDriver) appiumDriver).hideKeyboard();
      delay(300);
    } else {
      sendKeys(ios_txtUserName, userName);
    }
  }

  private void inputPassword(String password) {
    if (appiumDriver instanceof AndroidDriver) {
      tapAt(60, 680);
      String[] keys = password.split("");
      for (String key : keys) {
//        if(key.equals("1")){
//          tapAt(30, 1580);
//        }
//        if(key.equals("2")){
//          tapAt(110, 1580);
//        }
        pressKey(key);
      }
      ((AndroidDriver) appiumDriver).hideKeyboard();
      delay(600);
    } else {
      sendKeys(ios_txtPassword, password);
    }
  }

  private void clickLoginButton() {
    if (appiumDriver instanceof AndroidDriver) {
//      click(android_btnLogin);
      tapAt(150, 980);
    } else {
      click(ios_btnLogin);
//      WebElementFacade btnLogin = find(ios_btnLogin);
//      Click.on(ios_btnLogin);
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
    hideKeyboard();
    inputUserName(userName);
    inputPassword(password);
    clickLoginButton();
    return new OTP(appiumDriver);
  }

  @Step("Nhấn Thay đổi tài khoản")
  public ChangeAccountPopup click_change_account() {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_lblLoginWithOtherAccount);
    } else {
      click(ios_lblLoginWithOtherAccount);
    }
    return new ChangeAccountPopup(appiumDriver);
  }

  @Step("login")
  public OTP login_with_pass(String password){
    inputPassword(password);
    clickLoginButton();
    return new OTP(appiumDriver);
  }
}
