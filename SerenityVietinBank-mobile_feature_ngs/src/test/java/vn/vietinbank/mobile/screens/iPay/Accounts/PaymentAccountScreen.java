package vn.vietinbank.mobile.screens.iPay.Accounts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class PaymentAccountScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền\"]/parent::XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement interbankMoneyTransferTxt;

    public PaymentAccountScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    private void clickInterbankMoneyTransferTxt() {
        click(interbankMoneyTransferTxt);
    }

    public void moveToTransferMoneyInsideAndOutsideSystemScreen() {
        clickInterbankMoneyTransferTxt();
    }

}
