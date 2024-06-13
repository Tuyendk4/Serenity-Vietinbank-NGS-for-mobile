package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class InstallmentTransactionDetail extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private WebElement drdChonKyHan;
    //XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement kyHan6T;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='iconChoiceCheckOff']")
    private WebElement chkTerm;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement kyHan9T;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement kyHan12T;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement kyHan3T;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement kyHan18T;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[6]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement kyHan24T;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Tiếp tục']")
    private WebElement btnTiepTuc;

    public InstallmentTransactionDetail(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @Step("Chọn kỳ hạn {string}")
    public void chonKyHan(String kyHan) {
        delay(5000);
        tap(drdChonKyHan);
        switch (kyHan) {
            case "6":
                tap(kyHan6T);
                break;
            case "9":
                tap(kyHan9T);
                break;
            case "12":
                tap(kyHan12T);
                break;
            case "3":
                tap(kyHan3T);
                break;
            case "18":
                tap(kyHan18T);
                break;
            case "24":
                tap(kyHan24T);
                break;
        }
    }

    @Step("Chọn Đồng ý Điều khoản và điều kiện")
    public void chonDongYDieuKhoan() {
        chkTerm.click();
    }

    @Step("Chọn Tiếp tục")
    public OTPCC chonTiepTuc() {
        btnTiepTuc.click();
        delay(5000);
        return new OTPCC(appiumDriver);
    }
}
