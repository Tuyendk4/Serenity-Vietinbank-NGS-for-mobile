package vn.vietinbank.mobile.screens.iPay.Gifts.Flowers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class FlowerCartScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tất cả\"]")
    private WebElement allTxt;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đặt mua hoa\"]")
    private WebElement orderFlowerBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic header trash\"]")
    private WebElement trashBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý\"]")
    private WebElement agreePopupBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ic header back\"]")
    private WebElement backBtn;

    public FlowerCartScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickAllTxt() {
        click(allTxt);
    }

    public void clickOrderFlowerBtn() {
        click(orderFlowerBtn);
    }

    public void removeCart() {
        click(trashBtn);
        if (waitForElementVisible(agreePopupBtn, 1)) {
            click(agreePopupBtn);
        }
    }

    public void clickBackBtn() {
        click(backBtn);
    }
}
