package vn.vietinbank.screens.mobile.ipay.M6S03;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home;

public class TransactionResult extends BaseScreen {
    private final String ios_NotificationSuccessTxt = "//XCUIElementTypeStaticText[@name=\"Chúc mừng Quý khách! Khoản vay của Quý khách đã được cho vay thành công. Quý khách vui lòng kiểm tra thông báo giao dịch chuyển tiền để biết thêm thông tin chi tiết.\"]";

    private final String ios_BackHomeBtn = "//XCUIElementTypeButton[@name=\"iconLineHome\"]";
    public TransactionResult(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void notificationSuccess() {
        if(appiumDriver instanceof AndroidDriver) {

        } else {
            findElement(ios_NotificationSuccessTxt);
        }
    }

    public LoansForProductionAndBusiness_2 backHomePage() {
        if(appiumDriver instanceof AndroidDriver) {

        } else {
            click(ios_BackHomeBtn);
        }
        return new LoansForProductionAndBusiness_2(appiumDriver);
    }
}
