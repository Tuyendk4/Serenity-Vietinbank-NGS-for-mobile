package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;



public class EVoucher extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    private WebElement btnDongY;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Khám phá\"]")
    private WebElement btnKhamPha;


    public EVoucher(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @Step("Đồng ý đặt mua Voucher")
    public OrderVoucher dongY() {
//            tap(btnDongY);
            delay(10000);
            tap(btnKhamPha);
        return new OrderVoucher(appiumDriver);
    }
}
