package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch;


import io.appium.java_client.AppiumDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class BySearch extends BaseScreen {

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Bạn đang muốn tìm gì?\"]")
//    private WebElement inputSearch;

    private final String ios_txtSearch = "//XCUIElementTypeTextField[@value=\"Bạn đang muốn tìm gì?\"]";


    public BySearch(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @Step("Nhập từ {string} cần tìm kiếm ")
    public TapResultBySearch nhapTuCanTimKiem(String tuTimKiem) {
        sendKeys(ios_txtSearch, tuTimKiem);
//      hàm nhập từ cần tìm kiếm
//        inputSearch.sendKeys(tuTimKiem);
//        tap(btnSearch);
        return new TapResultBySearch(appiumDriver);
    }
}
