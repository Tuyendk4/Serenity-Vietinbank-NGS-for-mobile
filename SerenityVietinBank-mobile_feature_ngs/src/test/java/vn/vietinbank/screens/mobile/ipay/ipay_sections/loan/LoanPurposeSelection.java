package vn.vietinbank.screens.mobile.ipay.ipay_sections.loan;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import java.util.List;

public class LoanPurposeSelection extends BaseScreen {

    public LoanPurposeSelection(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void selectALoanPurpose(String purpose) {
        List<WebElement> lblLoanPurposes;
        if (appiumDriver instanceof AndroidDriver) {
            lblLoanPurposes = findElements("//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView");
        } else {
            lblLoanPurposes = findElements("//XCUIElementTypeStaticText[@name=\"Chọn mục đích vay\" or @name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeScrollView//XCUIElementTypeStaticText");
        }
        for (WebElement lblLoanPurpose : lblLoanPurposes) {
            if (verifyElementText(lblLoanPurpose, purpose)) {
                tap(lblLoanPurpose);
                break;
            }
        }
    }
}
