package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class ReferenceRepaymentSchedule extends BaseScreen {

    private final String android_lblInterestRate = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvRepaymentAmountTitle\" and @text=\"Lãi suất\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvAmountRepayment\"]";
    private final String ios_lblInterestRate = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]";

    private final String android_lblMonthlyChargeAmount = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvRepaymentAmountTitle\" and @text=\"Số tiền phải trả hàng tháng\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvAmountRepayment\"]";
    private final String ios_lblMonthlyChargeAmount = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]";

    private final String android_lblInterestPayableTotal = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvAmountRepayment\"]";
    private final String ios_lblInterestPayableTotal = "//XCUIElementTypeStaticText[@name=\"Tổng lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]";

    private final String android_lblPrincipalAndInterestPayableTotal = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvRepaymentAmountTitle\" and @text=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvAmountRepayment\"]";
    private final String ios_lblPrincipalAndInterestPayableTotal = "//XCUIElementTypeStaticText[@name=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]";

    private final String android_btnBorrowNow = "//android.widget.Button[@resource-id=\"com.vietinbank.mobile.ipay:id/btnNext\" and @text=\"Vay ngay\"]";
    private final String ios_btnBorrowNow = "//XCUIElementTypeButton[@name=\"Vay ngay\"]";

    public ReferenceRepaymentSchedule(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getInterestRate() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblInterestRate);
        } else {
            return getText(ios_lblInterestRate);
        }
    }

    public String getMonthlyChargeAmount() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblMonthlyChargeAmount);
        } else {
            return getText(ios_lblMonthlyChargeAmount);
        }
    }

    public String getInterestPayableTotal() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblInterestPayableTotal);
        } else {
            return getText(ios_lblInterestPayableTotal);
        }
    }

    public String getPrincipalAndInterestPayableTotal() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblPrincipalAndInterestPayableTotal);
        } else {
            return getText(ios_lblPrincipalAndInterestPayableTotal);
        }
    }

    public PersonalInstalmentLoan_Step1 clickBorrowNow() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnBorrowNow);
        } else {
            click(ios_btnBorrowNow);
        }
        delay(5000);
        return new PersonalInstalmentLoan_Step1(appiumDriver);
    }
}
