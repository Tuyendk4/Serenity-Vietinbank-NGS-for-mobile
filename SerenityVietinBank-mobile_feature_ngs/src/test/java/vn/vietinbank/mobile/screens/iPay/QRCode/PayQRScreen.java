package vn.vietinbank.mobile.screens.iPay.QRCode;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class PayQRScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    @AndroidFindBy(xpath = "")
    private WebElement continueBtn;

    public PayQRScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }
}
