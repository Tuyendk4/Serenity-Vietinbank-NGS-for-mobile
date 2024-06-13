package vn.vietinbank.screens.mobile.ipay.M6S03;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class TransactionIdentification extends BaseScreen {
    private final String ios_OTPInp = "//XCUIElementTypeStaticText[@name=\"Vui lòng kiểm tra kỹ thông tin trước khi xác nhận\"]/../../XCUIElementTypeOther[3]";

    private final String ios_ConfirmAndCompleteBtn = "//XCUIElementTypeStaticText[@name=\"Xác nhận & hoàn tất\"]";
    public TransactionIdentification(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void inputOTPTransaction(String OTP) {
        if(appiumDriver instanceof AndroidDriver) {

        } else {
            sendKeys(ios_OTPInp, OTP);
        }
    }

    public TransactionResult confirmAndComplete() {
        if(appiumDriver instanceof AndroidDriver) {

        } else {
            click(ios_ConfirmAndCompleteBtn);
        }
        return new TransactionResult(appiumDriver);
    }
}
