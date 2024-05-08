package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
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

    private void inputUserName(String userName) {
        sendKeys(txtUsername, userName);
    }

    private void inputPassword(String password) {
        sendKeys(txtPassword, password);
    }

    private void clickLoginButton() {
        click(btnLogin);
    }

    public OTP loginWithUsernamePassword(String userName, String password) {
        inputUserName(userName);
        inputPassword(password);
        clickLoginButton();
        return new OTP(appiumDriver);
    }
}
