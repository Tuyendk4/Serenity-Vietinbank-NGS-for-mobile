package vn.vietinbank.screens.mobile.ipay.ipay_common;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AccountList.AccountListPage;


public class MoveToAccountList extends BaseScreen {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]//XCUIElementTypeScrollView//XCUIElementTypeOther[1]//XCUIElementTypeButton[2]\n")
    private WebElement buttonAccountList;

//  @iOSXCUITFindBy(xpath = "  //XCUIElementTypeTextField[@value=\"Bạn đang muốn tìm gì?\"]")
//  private WebElement inputHomeSearch;


    public MoveToAccountList(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Mở danh sách tài khoản")
    public AccountListPage chonAccountList() {
        if (appiumDriver instanceof IOSDriver) {
            delay(3000);
            tap(buttonAccountList);
        }
        return new AccountListPage(appiumDriver);
    }


}

