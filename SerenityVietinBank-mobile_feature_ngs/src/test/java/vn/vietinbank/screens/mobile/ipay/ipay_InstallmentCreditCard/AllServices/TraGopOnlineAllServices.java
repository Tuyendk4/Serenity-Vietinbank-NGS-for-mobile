package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AllServices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.InstallmentIntro;


public class TraGopOnlineAllServices extends BaseScreen {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private WebElement btnTraGopOnline;


    public TraGopOnlineAllServices(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Nhấn Trả góp Online từ tất cả dịch vụ")
    public InstallmentIntro chonTraGopOnlineAllServices() {
        {
            tap(btnTraGopOnline);
        }
        return new InstallmentIntro(appiumDriver);
    }
}