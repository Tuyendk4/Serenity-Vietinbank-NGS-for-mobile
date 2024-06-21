package vn.vietinbank.screens.mobile.ipay.M6S03;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class LoanAndCreditService extends BaseScreen {

    private final String android_btnLoansForProductionAndBusiness = "//android.widget.TextView[@text=\"Vay sản xuất kinh doanh\"]";
    private final String ios_LoansForProductionAndBusiness = "//XCUIElementTypeStaticText[@name=\"Vay sản xuất kinh doanh\"]/..";


    public LoanAndCreditService(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoansForProductionAndBusiness_2 click_vay_san_xuat_kinh_doanh() {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_btnLoansForProductionAndBusiness);
        } else {
            click(ios_LoansForProductionAndBusiness);
        }
        return new LoansForProductionAndBusiness_2(this.appiumDriver);
    }

}
