package vn.vietinbank.screens.mobile.ipay.M6S03;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class LoansForProductionAndBusiness_2 extends BaseScreen {

    private final String ios_btnCreateRequest = "**/XCUIElementTypeStaticText[`name == \"Tạo yêu cầu giải ngân\"`][1]";
    private final String android_btnCreateRequest = "//android.widget.TextView[@text=\"Tạo yêu cầu\"]";

    private final String ios_histoyDisbursementBtn = "(//XCUIElementTypeStaticText[@name=\"Lịch sử giải ngân\"])[1]";

    public LoansForProductionAndBusiness_2(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public CreateDisbursementRequest clickCreateRequest() {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_btnCreateRequest);
        } else {
            click_iosClassChain(ios_btnCreateRequest);
        }
        return new CreateDisbursementRequest(this.appiumDriver);
    }

    public void clickDisbursementLoan() {
        if(appiumDriver instanceof AndroidDriver) {

        } else {
            click(ios_histoyDisbursementBtn);
        }
    }

}
