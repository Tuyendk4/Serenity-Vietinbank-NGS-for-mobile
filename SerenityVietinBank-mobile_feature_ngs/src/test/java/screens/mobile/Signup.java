package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class Signup extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập/Đăng ký\" or @name=\"Đăng nhập\"]")
    public WebElement btnLogin;

    public Signup(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public Login clickLoginOrSignUpBtn() {
//    btnDangNhap.click();
        click(btnLogin);
        return new Login(appiumDriver);
    }
}
