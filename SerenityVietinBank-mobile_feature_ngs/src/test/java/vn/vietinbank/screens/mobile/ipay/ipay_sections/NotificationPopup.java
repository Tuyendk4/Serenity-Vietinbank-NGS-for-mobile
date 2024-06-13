package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanAndCreditServices;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanProfile;

public class NotificationPopup extends BaseScreen {

    private final String android_lblNotificationTitle = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tv_title\" and @text=\"Thông báo\"]/following-sibling::android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tv_content\"]";
    private final String ios_lblNotificationTitle = "//XCUIElementTypeStaticText[@name=\"Thông báo\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_btnAgree = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/bt_right\" and @text=\"Đồng ý\"]";
    private final String ios_btnAgree = "//XCUIElementTypeButton[@name=\"Đồng ý\"]";

    private final String android_btnConfirmToAbort = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/bt_right\" and @text=\"Xác nhận hủy\"]";
    private final String ios_btnConfirmToAbort = "//XCUIElementTypeButton[@name=\"Xác nhận hủy\"]";

    private final String android_btnContinueToBorrow = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/bt_left\" and @text=\"Tiếp tục vay\"]";
    private final String ios_btnContinueToBorrow = "//XCUIElementTypeButton[@name=\"Tiếp tục vay\"]";

    public NotificationPopup(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getNotificationTitle() {
        WebElement lblNotificationTitle = null;
        if (appiumDriver instanceof AndroidDriver) {
            lblNotificationTitle = findElement(android_lblNotificationTitle);
        } else {
            lblNotificationTitle = findElement(ios_lblNotificationTitle);
        }
        return lblNotificationTitle.getText();
    }

    public LoanAndCreditServices clickAgreeButton() {
        WebElement btnAgree = null;
        if (appiumDriver instanceof AndroidDriver) {
            btnAgree = findElement(android_btnAgree);
        } else {
            btnAgree = findElement(ios_btnAgree);
        }
        click(btnAgree);
//    clickBackButton();
        return new LoanAndCreditServices(appiumDriver);
    }

    public LoanProfile clickConfirmToAbortButton() {
        WebElement btnConfirmToAbort = null;
        if (appiumDriver instanceof AndroidDriver) {
            btnConfirmToAbort = findElement(android_btnConfirmToAbort);
        } else {
            btnConfirmToAbort = findElement(ios_btnConfirmToAbort);
        }
        click(btnConfirmToAbort);
        return new LoanProfile(appiumDriver);
    }

    public LoanProfile clickContinueToBorrowButton() {
        WebElement btnContinueToBorrow = null;
        if (appiumDriver instanceof AndroidDriver) {
            btnContinueToBorrow = findElement(android_btnContinueToBorrow);
        } else {
            btnContinueToBorrow = findElement(ios_btnContinueToBorrow);
        }
        click(btnContinueToBorrow);
        return new LoanProfile(appiumDriver);
    }
}
