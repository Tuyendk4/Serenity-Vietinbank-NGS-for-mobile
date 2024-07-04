package vn.vietinbank.mobile.screens.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static vn.vietinbank.utils.Constants.NAME_SHOP_ACTIVE;

public class StoreManagerScreen extends BaseScreen {

    public final String TAB_DYNAMIC_LOCATOR = "//XCUIElementTypeStaticText[@name=\"%s\"]/preceding-sibling::XCUIElementTypeButton";
    private final String NAME_SHOP_INACTIVE_CHECKBOX = "//XCUIElementTypeStaticText[@name=\"%s\"]/following-sibling::XCUIElementTypeButton";
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Bắt đầu'`]")
    @AndroidFindBy(xpath = "")
    private WebElement batDauBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Quý khách đang sử dụng tài khoản thanh toán cho mục đích kinh doanh?'")
    @AndroidFindBy(xpath = "")
    private WebElement cuaSoChonTaiKhoan;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Chưa từng Bắt đầu tạo cửa hàng với ViettinBank'`]")
    @AndroidFindBy(xpath = "")
    private WebElement chuaCoTaiKhoanVTBBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Có Cho tôi tuỳ chọn tài khoản kinh doanh'`]")
    @AndroidFindBy(xpath = "")
    private WebElement daCoTaiKhoanVTBBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"back\"]/following-sibling::XCUIElementTypeStaticText[@name=\"Quản lý cửa hàng\"]")
    @AndroidFindBy(xpath = "")
    private WebElement quanLyCuaHangScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cửa hàng của tôi'")
    @AndroidFindBy(xpath = "")
    private WebElement cuaHangCuaToiTab;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Đồng sở hữu/nhân viên'")
    @AndroidFindBy(xpath = "")
    private WebElement dongSoHuuHoacNhanVienTab;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Tài khoản'")
    @AndroidFindBy(xpath = "")
    private WebElement taiKhoanLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Tài khoản']/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private WebElement soTaiKhoanDangDungDrp;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'close'")
    @AndroidFindBy(xpath = "")
    private WebElement dongCuaSoBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachSoTaiKhoanNhanTien;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'dashboardSetting'")
    @AndroidFindBy(xpath = "")
    private WebElement caiDatNguonTienHienThiBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tạo cửa hàng\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement taoCuaHangBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'back'")
    @AndroidFindBy(xpath = "")
    private WebElement backBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cài đặt nguồn tiền hiển thị'")
    @AndroidFindBy(xpath = "")
    private WebElement getCaiDatNguonTienHienThiScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'ic_close'")
    @AndroidFindBy(xpath = "")
    private WebElement dongManHinhCaiDatNguonTienBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeStaticText/following-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachChonNguonTienHienThiCheckBox;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Xác nhận'")
    @AndroidFindBy(xpath = "")
    private WebElement xacNhanBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Doanh thu từng cửa hàng tháng')]")
    @AndroidFindBy(xpath = "")
    private WebElement doanhThuTungCuaHangTheoThangLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'giao dịch')]/following-sibling::XCUIElementTypeOther/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachCuaHangBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'setting'")
    @AndroidFindBy(xpath = "")
    private WebElement settingBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='setting']/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private WebElement tenCuaHangLbl;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText)[1]")
    @AndroidFindBy(xpath = "")
    private WebElement trangThaiHoatDongCuaHangLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Xem mã QR\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement xemMaQrBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chia sẻ cửa hàng\"")
    @AndroidFindBy(xpath = "")
    private WebElement chiaSeCuaHangBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tìm kiếm\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement timKiemBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Số tiền\"`][1]")
    @AndroidFindBy(xpath = "")
    private WebElement danhSachGiaoDichLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"3 ngày gần nhất\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement baNgayGanNhatBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Doanh thu từng cửa hàng tháng')]/following-sibling::XCUIElementTypeScrollView")
    @AndroidFindBy(xpath = "")
    private WebElement doanhThuTungCuaHangScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Cài đặt nguồn tiền hiển thị\"")
    @AndroidFindBy(xpath = "")
    private WebElement caiDatNguonTienHienThiPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Tài khoản')]")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachTaiKhoanLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@visible='false']/parent::XCUIElementTypeButton/preceding-sibling::XCUIElementTypeStaticText[contains(@name,'Đang hoạt động')]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachCuaHangDangHoatDongChuaChonDrp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@visible='true']/parent::XCUIElementTypeButton/preceding-sibling::XCUIElementTypeStaticText[contains(@name,'Đang hoạt động')]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachCuaHangDangHoatDongDaDuocChonDrp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@visible='false']/parent::XCUIElementTypeButton/preceding-sibling::XCUIElementTypeStaticText[contains(@name,'Đóng cửa')]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachCuaHangDongCuaChuaChonDrp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@visible='true']/parent::XCUIElementTypeButton/preceding-sibling::XCUIElementTypeStaticText[contains(@name,'Đóng cửa')]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachCuaHangDongCuaDaDuocChonDrp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Cửa hàng chưa phát sinh doanh thu')]|//XCUIElementTypeStaticText[@name=\"Triệu Đồng\"]")
    @AndroidFindBy(xpath = "")
    private WebElement cuaHangChuaPhatSinhDoanhThuLBL;

    public StoreManagerScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void storeManagerDisplayed() {
        waitForElementVisible(quanLyCuaHangScreen, 20);
        Assert.assertTrue(quanLyCuaHangScreen.isDisplayed());
    }

    public void clickCreateStoreBtn() {
        waitForElementVisible(taoCuaHangBtn, 10);
        click(taoCuaHangBtn);
    }

    public void choose1StoreActive() {
        List<WebElement> listShopActive = danhSachCuaHangDangHoatDongDaDuocChonDrp;
        WebElement element2 = appiumDriver.findElement(getByLocator(NAME_SHOP_INACTIVE_CHECKBOX, "test03"));
        element2.click();
    }

    public void confirmStoreStatus(String status) {
        Assert.assertEquals(status, getText(trangThaiHoatDongCuaHangLbl));
    }

    public void clickStoreInfo() {
        waitForElementVisible(settingBtn, 5);
        click(settingBtn);
    }

    public void choose1StoreInActive() {
        List<WebElement> listShopActive = danhSachCuaHangDongCuaDaDuocChonDrp;
        List<WebElement> listShopInActive = danhSachCuaHangDongCuaChuaChonDrp;
        if (listShopActive.isEmpty()) {
            String nameShop = listShopInActive.get(0).getText();
            Serenity.setSessionVariable(NAME_SHOP_ACTIVE).to(nameShop);
            WebElement element = appiumDriver.findElement(getByLocator(NAME_SHOP_INACTIVE_CHECKBOX, nameShop));
            click(element);
        } else {
            String nameShop = listShopActive.get(0).getText();
            Serenity.setSessionVariable(NAME_SHOP_ACTIVE).to(nameShop);
        }
    }

    public void choose1Store(String name) {
        List<WebElement> listShop = danhSachCuaHangBtn;
        if (listShop.isEmpty()) {
            delay(5000);
            listShop = danhSachCuaHangBtn;
        }
        for (WebElement webElement : listShop) {
            if (webElement.getText().equals(name)) {
                webElement.click();
            }
        }
        delay(5000);
        for (WebElement webElement : listShop) {
            if (webElement.getText().equals(name)) {
                webElement.click();
            }
        }
    }

    public void clickSearchBtn() {
        click(timKiemBtn);
    }

    public void qrCodeDisplayed() {
        waitForElementVisible(xemMaQrBtn, 20);
        Assert.assertTrue(xemMaQrBtn.isDisplayed());
    }

    public void recentTransactionsDisplayed() {
        delay(5000);
        Assert.assertEquals(danhSachGiaoDichLbl.getText(), "Số tiền");
    }

    public void verifyShopHasNotGeneratedIncomeDataUndisplayed() {
        assertThat("Cửa hàng chưa phát sinh doanh thu / biểu đồ doanh thu đang hiển thị", waitForElementInvisible(cuaHangChuaPhatSinhDoanhThuLBL, 5), is(true));
    }

    public void verifyShopHasNotGeneratedIncomeDataIsDisplayed() {

        assertThat("Cửa hàng chưa phát sinh doanh thu / biểu đồ doanh thu không hiển thị", cuaHangChuaPhatSinhDoanhThuLBL.isDisplayed(), is(true));
    }

    public void scrollUpToRevenuePerStore() {
        scrollDownElement(doanhThuTungCuaHangScreen);
    }

    public void scrollDownToRevenuePerStore() {
        scrollUpElement(doanhThuTungCuaHangScreen);
    }

    public void clickBackButtonToIPayHome() {
        click(backBtn);
    }

    public void clickToTab(String text) {
        WebElement element = appiumDriver.findElement(getByLocator(TAB_DYNAMIC_LOCATOR, text));
        element.click();
    }

    public void verifyTabIsDisplayed(String text) {
        assertThat("[ " + text + " ] không hiển thị ", appiumDriver.findElement(getByLocator(TAB_DYNAMIC_LOCATOR, text)).isDisplayed(), is(true));
    }

    public void verifyContentIsDisplayed(String text) {
        delay(1000);
        String CONTENT_DYNAMIC_LOCATOR = "//XCUIElementTypeStaticText[@name='%s']";
        assertThat("[ " + text + " ] không hiển thị ", appiumDriver.findElement(getByLocator(CONTENT_DYNAMIC_LOCATOR, text)).isDisplayed(), is(true));
    }
}
