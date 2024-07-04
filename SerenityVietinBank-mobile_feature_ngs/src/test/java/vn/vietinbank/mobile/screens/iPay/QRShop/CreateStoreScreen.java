package vn.vietinbank.mobile.screens.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static vn.vietinbank.utils.Constants.BLANK;

public class CreateStoreScreen extends BaseScreen {

    KeyBoardIOS keyBoardIOS = new KeyBoardIOS(appiumDriver);

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Tạo cửa hàng\"")
    @AndroidFindBy(xpath = "")
    private WebElement taoCuaHangScreenLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"back\"")
    @AndroidFindBy(xpath = "")
    private WebElement backButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Xác nhận\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement xacNhanBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "")
    private WebElement tenCuaHangInput;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Lĩnh vực kinh doanh\"")
    @AndroidFindBy(xpath = "")
    private WebElement linhVucKinhDoanhDrp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tài khoản nhận tiền\"]/following-sibling::XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "")
    private WebElement taiKhoanNhanTienLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Tỉnh/Thành phố\"")
    @AndroidFindBy(xpath = "")
    private WebElement tinhThanhPhoDrp;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Quận/Huyện\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonQuanHuyenDrp;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Phường/Xã\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonPhuongXaDrp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[7]/XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "")
    private WebElement diaChiCuTheInput;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Địa chỉ cụ thể\"")
    @AndroidFindBy(xpath = "")
    private WebElement diaChiCuTheLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chọn lĩnh vực kinh doanh\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonLinhVucKinhDoanhScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Tìm kiếm\"")
    @AndroidFindBy(xpath = "")
    private WebElement timKiemInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"close\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachDuLieuDrp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == 'Chọn tài khoản nhận tiền'`]")
    @AndroidFindBy(xpath = "")
    private WebElement cuaSoChonTaiKhoanNhanTien;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"close\"]/preceding-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "")
    private WebElement closeCuaSoBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản nhận tiền\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable//XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "")
    private List<WebElement> danhSachSoTaiKhoanNhanTienLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chọn tỉnh/thành phố\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonTinhThanhPhoScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chọn quận/huyện\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonQuanHuyenScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chọn phường/xã\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonPhuongXaScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Thành công\"")
    @AndroidFindBy(xpath = "")
    private WebElement thanhCongLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Quý khách đã đăng kí thành công cửa hàng\"")
    @AndroidFindBy(xpath = "")
    private WebElement quyKhachDaDangKiThanhCongCuaHangLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"OK\" AND label == \"OK\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(xpath = "")
    private WebElement okBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Back_round\"")
    @AndroidFindBy(xpath = "")
    private WebElement backRoundBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"VietinLogo\"")
    @AndroidFindBy(xpath = "")
    private WebElement vietinLogoImg;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Napas247\"")
    @AndroidFindBy(xpath = "")
    private WebElement napas247Img;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"vietqr\"")
    @AndroidFindBy(xpath = "")
    private WebElement vietQrImg;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Tới quản lý cửa hàng\" AND label == \"Tới quản lý cửa hàng\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(xpath = "")
    private WebElement toiQuanLyCuahangBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Alias cửa hàng:')]")
    @AndroidFindBy(xpath = "")
    private WebElement aliasCuaHangLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Tài khoản:')]")
    @AndroidFindBy(xpath = "")
    private WebElement taiKhoanLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Tài khoản:')]/preceding-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    private WebElement tenCuaHangDaTaoLbl;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Lưu QR\"")
    @AndroidFindBy(xpath = "")
    private WebElement luuQrBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chia sẻ\"")
    @AndroidFindBy(xpath = "")
    private WebElement chiaSeBtn;

    public CreateStoreScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void createStoreScreenDisplayed() {
        waitForElementVisible(taoCuaHangScreenLbl, 10);
        Assert.assertTrue(taoCuaHangScreenLbl.isDisplayed());
    }

    public void inputStoreName(String storeName) {
        tenCuaHangInput.click();
        if (storeName.equalsIgnoreCase(BLANK.toLowerCase())) {
            keyBoardIOS.pressDoneButton();
        } else {
            keyBoardIOS.pressKeyIos(tenCuaHangInput, storeName);
            keyBoardIOS.pressDoneButton();
        }
    }

    public void clickConfirmBtn() {
        waitForElementVisible(xacNhanBtn, 5);
        click(xacNhanBtn);
    }

    public void inputAddress(String address) {
        click(diaChiCuTheInput);
        if (address.equalsIgnoreCase(BLANK.toLowerCase())) {
            keyBoardIOS.pressDoneButton();
        } else {
            keyBoardIOS.pressKeyIos(diaChiCuTheInput, address);
            keyBoardIOS.pressDoneButton();
        }
    }

    public void chooseWard(String ward) {
        chooseWard();
        if (ward.equalsIgnoreCase(BLANK.toLowerCase())) {
            click(closeCuaSoBtn);
        } else {
            waitForElementVisible(chonPhuongXaDrp, 5);
            inputSearchValue(ward);
        }
    }

    public void chooseDistrict(String district) {
        chooseDistrict();
        if (district.equalsIgnoreCase(BLANK.toLowerCase())) {
            click(closeCuaSoBtn);
        } else {
            waitForElementVisible(chonQuanHuyenScreen, 5);
            inputSearchValue(district);
        }
    }

    public void chooseProvince(String city) {
        chooseProvince();
        if (city.equalsIgnoreCase(BLANK.toLowerCase())) {
            click(closeCuaSoBtn);
        } else {
            waitForElementVisible(chonTinhThanhPhoScreen, 5);
            inputSearchValue(city);
        }
    }

    public void selectAccountNumberToReceiveMoney(String account) {
    }

    public void chooseBusinessField(String business) {
        clickBusinessField();
        if (business.equalsIgnoreCase(BLANK.toLowerCase())) {
            click(closeCuaSoBtn);
        } else {
            waitForElementVisible(chonLinhVucKinhDoanhScreen, 5);
            inputSearchValue(business);
        }
    }

    public void clickBusinessField() {
        waitForElementVisible(linhVucKinhDoanhDrp, 5);
        doubleClick(linhVucKinhDoanhDrp);
    }

    public void chooseProvince() {
        waitForElementVisible(tinhThanhPhoDrp, 5);
        doubleClick(tinhThanhPhoDrp);
    }

    public void chooseDistrict() {
        waitForElementVisible(chonQuanHuyenDrp, 5);
        doubleClick(chonQuanHuyenDrp);
    }

    public void chooseWard() {
        waitForElementVisible(chonPhuongXaDrp, 5);
        doubleClick(chonPhuongXaDrp);
    }

    public void inputSearchValue(String search) {
        waitForElementVisible(timKiemInput, 5);
        click(timKiemInput);
        sendKeys(timKiemInput, search);
        List<WebElement> elementList = danhSachDuLieuDrp;
        for (WebElement webElement : elementList) {
            if (webElement.getText().equalsIgnoreCase(search)) {
                webElement.click();
            }
        }
    }

    public void doneBtnDisplayed() {
        waitForElementVisible(toiQuanLyCuahangBtn, 10);
        Assert.assertTrue(toiQuanLyCuahangBtn.isDisplayed());
    }

    public void verifyNameShopInput(String name) {
        if (name.equals("NULL")) {
            name = null;
        }
        Assert.assertEquals(tenCuaHangInput.getText().toLowerCase(), name.toLowerCase());
    }

    public void clickDynamicField(String field) {
        String DYNAMIC_FIELD = "//XCUIElementTypeTextField[@value=\"%s\"]";
        click(getDynamicXpath(DYNAMIC_FIELD, field));
    }

    public void inputSearchData(String value) {
        waitForElementVisible(timKiemInput, 5);
        click(timKiemInput);
        clearText(timKiemInput);
        sendKeys(timKiemInput, value);
    }

    public void verifyResponseSearch(String response) {
        List<WebElement> elementList = danhSachDuLieuDrp;
        assertThat("The text should contain '" + response.toLowerCase() + "' but was '" + elementList.get(0).getText().toLowerCase() + "'",
                elementList.get(0).getText().toLowerCase(), containsString(response.toLowerCase()));
    }

    public void clickFirstDataResponse(String value) {
        List<WebElement> elementList = danhSachDuLieuDrp;
        for (WebElement webElement : elementList) {
            if (webElement.getText().toLowerCase().contains(value.toLowerCase())) {
                click(webElement);
                break;
            }
        }
    }

    public void clickBackToButtonToShopManager() {
        click(backButton);
    }
}
