package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_common.UserProfile;

public class NavigationBar extends BaseScreen {

    private final String ios_btnHome = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]";

    private final String ios_btnNotification = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]";

    private final String ios_btnStore = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]";

    private final String ios_btnMarket = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]";

    public NavigationBar(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Nhấn vào User Profile icon")
    public UserProfile goToUserProfile() {
        if (appiumDriver instanceof IOSDriver) {
            //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]")
            //  private WebElement btnUserProfile;
            String ios_btnUserProfile = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]";
            click(ios_btnUserProfile);
        }
        return new UserProfile(appiumDriver);
    }
}
