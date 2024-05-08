package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AdvertisingPopup extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
    @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
    private WebElement iconClose;

    public AdvertisingPopup(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void closeAdsPopup() {
        if (waitForElementVisible(iconClose, 10)) {
            click(iconClose);
        }
    }
}
