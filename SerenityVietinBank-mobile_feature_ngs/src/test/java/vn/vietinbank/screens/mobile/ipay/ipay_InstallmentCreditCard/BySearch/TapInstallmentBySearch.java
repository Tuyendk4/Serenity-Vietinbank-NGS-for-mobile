package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch;


import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.InstallmentIntro;


public class TapInstallmentBySearch extends BaseScreen {

//    @iOSXCUITFindBy(xpath = " //XCUIElementTypeTable/XCUIElementTypeCell[23]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
//    private WebElement btnTraGopBySearch;

    private final String ios_btnTraGopTheTinDung = "//XCUIElementTypeTable/XCUIElementTypeCell[1]";


    public TapInstallmentBySearch(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn Trả góp thẻ tín dụng bằng tìm kiếm")
    public InstallmentIntro  chonTraGopTheBangTimKiem() {
        tap(ios_btnTraGopTheTinDung, 20);
        return new InstallmentIntro(appiumDriver);
    }
}
