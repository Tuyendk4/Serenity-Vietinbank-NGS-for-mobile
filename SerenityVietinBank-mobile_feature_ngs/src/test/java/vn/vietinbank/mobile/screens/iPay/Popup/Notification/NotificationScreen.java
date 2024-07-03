package vn.vietinbank.mobile.screens.iPay.Popup.Notification;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class NotificationScreen extends BaseScreen {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Thông báo\"")
    @AndroidFindBy(xpath = "")
    private WebElement thongBaoPopup;

    public NotificationScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void notificationPopupDisplayed() {
        waitForElementVisible(thongBaoPopup, 5);
        Assert.assertTrue(thongBaoPopup.isDisplayed());
    }

    public void notificationDisplayed(String message) {
        String locator = "//XCUIElementTypeStaticText[@name=\"%s\"]";
        WebElement element = appiumDriver.findElement(getByLocator(locator, message));
        Assert.assertTrue(element.isDisplayed());
    }

    public void clickDynamicBtn(String text) {
        String locator = "//XCUIElementTypeButton[@name=\"%s\"]";
        WebElement element = appiumDriver.findElement(getByLocator(locator, text));
        click(element);
    }

    public void notificationPopupNotVisible() {
        Assert.assertFalse(waitForElementInvisible(thongBaoPopup, 5));
    }
}
