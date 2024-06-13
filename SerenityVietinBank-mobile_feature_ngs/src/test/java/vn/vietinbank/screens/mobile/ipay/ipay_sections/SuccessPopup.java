package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.PersonalInstalmentLoan_SuccessfulApplicationAppraisal;

public class SuccessPopup extends BaseScreen {

    private final String android_lblNotification = "";
    private final String ios_lblNotification = "//XCUIElementTypeStaticText[@name=\"Thành công\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_btnAgree = "";
    private final String ios_btnAgree = "//XCUIElementTypeButton[@name=\"Đồng ý\"]";

    public SuccessPopup(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getNotification() {
        WebElement lblNotification = null;
        if (appiumDriver instanceof AndroidDriver) {
            lblNotification = findElement(android_lblNotification);
        } else {
            lblNotification = findElement(ios_lblNotification);
        }
        return lblNotification.getText();
    }

    @Step("Nhấn Đồng ý")
    public PersonalInstalmentLoan_SuccessfulApplicationAppraisal clickAgreeButton() {
        WebElement btnAgree = null;
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnAgree);
        } else {
            click(ios_btnAgree);
        }
        delay(3000);
        return new PersonalInstalmentLoan_SuccessfulApplicationAppraisal(appiumDriver);
    }
}
