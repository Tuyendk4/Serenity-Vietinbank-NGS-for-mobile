package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class LoanProfileDetail extends BaseScreen {

    private final String android_viewTopPopup = "//android.view.View[@resource-id=\"com.vietinbank.mobile.ipay:id/viewTopPopup\"]";
    private final String ios_viewTopPopup = "";

    private final String android_lblNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Số tiền vay\"]/following-sibling::android.widget.TextView";
    private final String ios_lblNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Số tiền vay\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblMonths = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Thời hạn vay\"]/following-sibling::android.widget.TextView";
    private final String ios_lblMonths = "//XCUIElementTypeStaticText[@name=\"Thời hạn vay\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblInterestRate = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Lãi suất\"]/following-sibling::android.widget.TextView";
    private final String ios_lblInterestRate = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblRepaymentDate = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.TextView";
    private final String ios_lblRepaymentDate = "//XCUIElementTypeStaticText[@name=\"Ngày trả nợ hàng tháng\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblLoanPurpose = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Mục đích vay\"]/following-sibling::android.widget.TextView";
    private final String ios_lblLoanPurpose = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblBorrowName = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Họ & tên người vay\"]/following-sibling::android.widget.TextView";
    private final String ios_lblBorrowName = "//XCUIElementTypeStaticText[@name=\"Họ & tên người vay\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblEmail = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Email nhận hợp đồng vay\"]/following-sibling::android.widget.TextView";
    private final String ios_lblEmail = "//XCUIElementTypeStaticText[@name=\"Email nhận hợp đồng vay\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblPhone = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Điện thoại\"]/following-sibling::android.widget.TextView";
    private final String ios_lblPhone = "//XCUIElementTypeStaticText[@name=\"Điện thoại\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblID = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Số giấy tờ cá nhân\"]/following-sibling::android.widget.TextView";
    private final String ios_lblID = "//XCUIElementTypeStaticText[@name=\"Số giấy tờ cá nhân\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblAddress = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Địa chỉ thường trú\"]/following-sibling::android.widget.TextView";
    private final String ios_lblAddress = "//XCUIElementTypeStaticText[@name=\"Địa chỉ thường trú\"]/following-sibling::XCUIElementTypeStaticText";

    private final String android_lblAddressContact = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and @text=\"Địa chỉ liên hệ\"]/following-sibling::android.widget.TextView";
    private final String ios_lblAddressContact = "//XCUIElementTypeStaticText[@name=\"Địa chỉ liên hệ\"]/following-sibling::XCUIElementTypeStaticText";

    public LoanProfileDetail(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getNumberOfMoney() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblNumberOfMoney);
        } else {
            return getText(ios_lblNumberOfMoney);
        }
    }

    public String getMonths() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblMonths);
        } else {
            return getText(ios_lblMonths);
        }
    }

    public String getInterestRate() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblInterestRate);
        } else {
            return getText(ios_lblInterestRate);
        }
    }

    public String getRepaymentDate() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblRepaymentDate);
        } else {
            return getText(ios_lblRepaymentDate);
        }
    }

    public String getLoanPurpose() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblLoanPurpose);
        } else {
            return getText(ios_lblLoanPurpose);
        }
    }

    public String getBorrowName() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblBorrowName);
        } else {
            return getText(ios_lblBorrowName);
        }
    }

    public String getEmail() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblEmail);
        } else {
            return getText(ios_lblEmail);
        }
    }

    public String getPhone() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblPhone);
        } else {
            return getText(ios_lblPhone);
        }
    }

    public String getID() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblID);
        } else {
            return getText(ios_lblID);
        }
    }

    public String getAddress() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblAddress);
        } else {
            return getText(ios_lblAddress);
        }
    }

    public String getAddressContact() {
        if (appiumDriver instanceof AndroidDriver) {
            return getText(android_lblAddressContact);
        } else {
            return getText(ios_lblAddressContact);
        }
    }

    public void closeLoanProfileDetailPopup() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_viewTopPopup);
        } else {
            click(ios_viewTopPopup);
        }
    }
}
