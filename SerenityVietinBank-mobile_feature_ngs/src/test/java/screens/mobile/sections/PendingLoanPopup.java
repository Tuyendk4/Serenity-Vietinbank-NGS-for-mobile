package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PendingLoanPopup extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Có khoản vay đang chờ\"]")
    private WebElement lblPendingLoan;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục mở khoản vay\"]")
    private WebElement btnContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Thực hiện lại\"]")
    private WebElement btnRetry;

    public PendingLoanPopup(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickContinue() {
        btnContinue.click();
    }

    public void clickRetry() {
        btnRetry.click();
    }

    public boolean isDisplayed() {
        return waitForElementVisible(lblPendingLoan, 10);
    }
}
