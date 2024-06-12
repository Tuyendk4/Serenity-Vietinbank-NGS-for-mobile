package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.OTPCC;

public class OrderVoucher extends BaseScreen {

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"add\"])[1]")
    private WebElement btnAdd1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"add quantity\"]")
    private WebElement btnAddQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    private WebElement btnTiepTuc;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Nhập tên người nhận\"]")
    private WebElement txtNguoiNhan;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Nhập email\"]")
    private WebElement txtEmail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận và Thanh toán\"]")
    private WebElement btnXacNhan;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xong\"]")
    private WebElement btnXong;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
    private WebElement btnHoanTat;

//    Nhập OTT
//XCUIElementTypeButton[@name="Xác nhận & hoàn tất"]


    public OrderVoucher(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn loại voucher và số lượng ")
    public OrderVoucher chonLoaiVaSoLuong() {

            tap(btnAdd1);
            delay(10000);
            for (int i = 0; i < 10; i++) {
                tap(btnAddQuantity);
            }
            delay(1000);
            tap(btnTiepTuc);

        return new OrderVoucher(appiumDriver);
    }

    @Step("Nhập thông tin người nhận {0} và email {1}  ")
    public OrderVoucher inputThongTin(String nguoiNhan, String email ) {
        txtNguoiNhan.sendKeys(nguoiNhan);
        txtEmail.sendKeys(email);
        tap(btnXong);
        tap(btnTiepTuc);
        return new OrderVoucher(appiumDriver);
    }



    @Step("Xác nhận thanh toán ")
    public OTPCC xacNhanThanhToan() {
        tap(btnXacNhan);
        delay(10000);
        tap(btnTiepTuc);
        delay(3000);
        tap(btnHoanTat);
        return new OTPCC(appiumDriver);
    }

//    @Step("Xác nhận thanh toán ")
//    public OrderVoucher xacNhanThanhToan() {
//        tap(btnXacNhan);
//        return new OrderVoucher(appiumDriver);
//    }

}