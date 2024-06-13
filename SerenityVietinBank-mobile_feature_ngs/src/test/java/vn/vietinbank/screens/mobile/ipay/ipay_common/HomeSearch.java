package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.base.ScrollDirection;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch.BySearch;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher.EVoucher;


public class HomeSearch extends BaseScreen {


    private final String iconEVoucher = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]//XCUIElementTypeScrollView//XCUIElementTypeOther[1]//XCUIElementTypeOther[6]//XCUIElementTypeOther[2]//XCUIElementTypeOther[3]\n";

    //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name="VietinBank iPay"]//XCUIElementTypeScrollView//XCUIElementTypeOther[1]//XCUIElementTypeOther[6]//XCUIElementTypeOther[2]//XCUIElementTypeOther[3]")
//  private WebElement iconEVoucher;
    @iOSXCUITFindBy(xpath = "  //XCUIElementTypeButton[@name=\"iconHomeSearch\"]")
    private WebElement iconHomeSearch;

    public HomeSearch(AppiumDriver appiumDriver) {

        super(appiumDriver);
    }

    @Step("Mở ô tìm kiếm")
    public BySearch chonTimKiem() {
        if (appiumDriver instanceof IOSDriver) {
            tap(iconHomeSearch);
        }
        return new BySearch(appiumDriver);
    }

    @Step("Chọn E-voucher")
    public EVoucher chonEVoucher() {
        if (appiumDriver instanceof IOSDriver) {
            scrollToElement(iconEVoucher, ScrollDirection.DOWN, 1);
            delay(3000);
            tap(iconEVoucher);
        }
        return new EVoucher(appiumDriver);
    }


}

