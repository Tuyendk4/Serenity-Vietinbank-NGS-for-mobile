package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch;


import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.InstallmentIntro;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher.EVoucher;


public class TapResultBySearch extends BaseScreen {

//    @iOSXCUITFindBy(xpath = " //XCUIElementTypeTable/XCUIElementTypeCell[23]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
//    private WebElement btnTraGopBySearch;

    private final String ios_btnKQ = "//XCUIElementTypeTable/XCUIElementTypeCell[1]";


    public TapResultBySearch(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn Trả góp thẻ tín dụng bằng tìm kiếm")
    public InstallmentIntro  chonTraGopTheBangTimKiem() {
        tap(ios_btnKQ, 20);
        return new InstallmentIntro(appiumDriver);
    }

    @Step("Chọn mua e-Voucher tìm kiếm")
    public EVoucher chonEVoucherBangTimKiem() {
        tap(ios_btnKQ, 20);
//        delay(10000);
        return new EVoucher(appiumDriver);
    }
}
