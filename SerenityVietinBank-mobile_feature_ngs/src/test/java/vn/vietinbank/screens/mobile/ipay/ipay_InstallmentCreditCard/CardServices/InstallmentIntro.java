package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class InstallmentIntro extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Trả góp ngay\"]")
    private WebElement btnTraGopNgay;

    private final String ios_btnTraGopNgay = "//XCUIElementTypeButton[@name=\"Trả góp ngay\"]";

    public InstallmentIntro(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn Trả góp ngay")
    public EligibleTransactions chonTraGopNgay() {
        tap(ios_btnTraGopNgay);
        return new EligibleTransactions(appiumDriver);
    }
}
