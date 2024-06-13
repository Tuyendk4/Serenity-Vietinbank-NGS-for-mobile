package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AccountList;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.InstallmentIntro;


public class CreditAccountPage extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private WebElement buttonTraGopOnline;

    public CreditAccountPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng")
    public InstallmentIntro chonTraGopOnlineTuTK() {
//        delay(3000);
        tap(buttonTraGopOnline);

        return new InstallmentIntro(appiumDriver);
    }


}
