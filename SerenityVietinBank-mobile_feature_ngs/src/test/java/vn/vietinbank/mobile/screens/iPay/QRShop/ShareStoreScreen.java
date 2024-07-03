package vn.vietinbank.mobile.screens.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ShareStoreScreen extends BaseScreen {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chia sẻ cửa hàng\"")
    @AndroidFindBy(xpath = "")
    private WebElement chiaSeCuaHangScreenTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chia sẻ tiền vào cửa hàng\" AND label == \"Chia sẻ tiền vào cửa hàng\" AND value == \"Chia sẻ tiền vào cửa hàng\"")
    @AndroidFindBy(xpath = "")
    private WebElement chiaSeTienVaoCuaHangBtn;

    public ShareStoreScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void verifyShareShopScreenIsDisplayed() {
        assertThat("Chia sẻ cửa hàng không hiển thị", chiaSeCuaHangScreenTitle.isDisplayed(), is(true));
    }
}
