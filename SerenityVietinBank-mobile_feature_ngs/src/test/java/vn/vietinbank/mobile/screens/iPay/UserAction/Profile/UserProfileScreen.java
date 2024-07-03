package vn.vietinbank.mobile.screens.iPay.UserAction.Profile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;
import vn.vietinbank.mobile.screens.iPay.Home.HomeScreen;

public class UserProfileScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng nhập\"]")
    @AndroidFindBy(xpath = "")
    private WebElement btnDangNhap;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đăng xuất\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Đăng xuất\"]")
    private WebElement btnDangXuat;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Có\"]")
    @AndroidFindBy(xpath = "")
    private WebElement yesBtn;

    public UserProfileScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickBtnDangXuat() {
        click(btnDangXuat);
        click(yesBtn);
    }

    public HomeScreen click_dang_xuat() {
        tap(btnDangXuat);
        return new HomeScreen(appiumDriver);
    }
}
