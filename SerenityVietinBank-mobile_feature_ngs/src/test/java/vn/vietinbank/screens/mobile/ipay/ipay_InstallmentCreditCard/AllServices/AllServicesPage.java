package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AllServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;


public class AllServicesPage extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tài khoản\"]")
    private WebElement btnTaiKhoan;

    public AllServicesPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Đi tới màn hình Trả góp online từ Tất cả dịch vụ")
    public TraGopOnlineAllServices tapTaiKhoan() {
        tap(btnTaiKhoan);

        return new TraGopOnlineAllServices(appiumDriver);
    }


}
