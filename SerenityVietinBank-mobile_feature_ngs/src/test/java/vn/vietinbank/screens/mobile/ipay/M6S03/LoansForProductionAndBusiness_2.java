package vn.vietinbank.screens.mobile.ipay.M6S03;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class LoansForProductionAndBusiness_2 extends BaseScreen {

    private final String ios_createRequestBtn = "**/XCUIElementTypeStaticText[`name == \"Tạo yêu cầu giải ngân\"`][1]";
    private final String android_btnCreateRequest = "//android.widget.TextView[@text=\"Tạo yêu cầu\"]";

    public LoansForProductionAndBusiness_2(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public CreateDisbursementRequest clickCreateRequest() {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_btnCreateRequest);
        } else {
            WebElement web_CreateRequestBtn = findElement_iosClassChain(ios_createRequestBtn);
            click(web_CreateRequestBtn);
        }
        return new CreateDisbursementRequest(this.appiumDriver);
    }
}
