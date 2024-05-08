package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.UserProfile;

public class NavigationBar extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]")
    private WebElement btnHome;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]")
    private WebElement btnNotification;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]")
    private WebElement btnStore;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]")
    private WebElement btnMarket;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]")
    private WebElement btnUserProfile;

    public NavigationBar(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public UserProfile clickUserProfile() {
//    btnUserProfile.click();
        click(btnUserProfile);
        return new UserProfile(appiumDriver);
    }
}
