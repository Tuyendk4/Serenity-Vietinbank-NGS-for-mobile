package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class CardDetails extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_onl_installment\"]")
    private WebElement btnDangKyTraGop;

    public CardDetails(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn tính năng Đăng ký trả góp")
    public InstallmentIntro chonDangKyTraGop() {
        tap(btnDangKyTraGop);
        return new InstallmentIntro(appiumDriver);
    }
}
