package vn.vietinbank.screens.mobile.ipay.ipay_sections.loan;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class PendingLoanPopup extends BaseScreen {

    private final String android_lblPendingLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvPopupResumeTitle\" and @text=\"Có khoản vay đang chờ\"]";
    private final String ios_lblPendingLoan = "//XCUIElementTypeStaticText[@name=\"Có khoản vay đang chờ\"]";

    private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.mobile.ipay:id/btnPopupResumeNext\" and @text=\"Tiếp tục mở khoản vay\"]";
    private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục mở khoản vay\"]";

    private final String android_btnRetry = "//android.widget.Button[@resource-id=\"com.vietinbank.mobile.ipay:id/btnPopupResumeCancel\" and @text=\"Thực hiện lại\"]";
    private final String ios_btnRetry = "//XCUIElementTypeButton[@name=\"Thực hiện lại\"]";

    public PendingLoanPopup(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickContinue() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnContinue);
        } else {
            click(ios_btnContinue);
        }
    }

    public void clickRetry() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnRetry);
        } else {
            click(ios_btnRetry);
        }
    }

    public boolean isDisplayed() {
        WebElement lblPendingLoan = null;
        if (appiumDriver instanceof AndroidDriver) {
            lblPendingLoan = findElement(android_lblPendingLoan, 20);
        } else {
            lblPendingLoan = findElement(ios_lblPendingLoan, 20);
        }
        return waitForElementVisible(lblPendingLoan, 10);
    }
}
