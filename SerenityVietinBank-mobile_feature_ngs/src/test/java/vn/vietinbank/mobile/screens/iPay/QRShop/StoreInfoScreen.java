package vn.vietinbank.mobile.screens.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class StoreInfoScreen extends BaseScreen {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Thông tin cửa hàng\"")
    @AndroidFindBy(xpath = "")
    private WebElement thongTinCuaHangTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Cập nhật thông tin\"")
    @AndroidFindBy(xpath = "")
    private WebElement capNhatThongTinBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dừng hoạt động\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement dungHoatDongBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mở lại cửa hàng\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement moLaiCuaHangBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"back\"")
    @AndroidFindBy(xpath = "")
    private WebElement backButton;

    public StoreInfoScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void verifyThongTinCuaHangIsDisplayed() {
        waitForElementVisible(thongTinCuaHangTitle, 5);
        Assert.assertTrue(thongTinCuaHangTitle.isDisplayed());
    }

    public void clickInActiveBtn() {
        waitForElementVisible(dungHoatDongBtn, 5);
        dungHoatDongBtn.click();
    }

    public void clickReOpenBtn() {
        waitForElementVisible(moLaiCuaHangBtn, 5);
        moLaiCuaHangBtn.click();
    }

    public void clickBackButtonToQuanLyCuaHang() {
        click(backButton);
    }
}
