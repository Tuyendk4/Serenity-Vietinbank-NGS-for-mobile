package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AccountList;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class AccountListPage extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tài khoản thẻ tín dụng\"]")
    private WebElement buttonTheTinDung;

    public AccountListPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn Tài khoản thẻ tín dung {0}")
    public CreditAccountPage chonTaiKhoan(String soTaiKhoanTheTinDung) {
        delay(3000);
        tap(buttonTheTinDung);
        delay(3000);
        WebElement buttonSoTKTheTD = findElement("//XCUIElementTypeStaticText[@name='" + soTaiKhoanTheTinDung + "']");
        tap(buttonSoTKTheTD);
        return new CreditAccountPage(appiumDriver);
    }

}
