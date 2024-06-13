package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class TransactionDetails extends BaseScreen {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]")

    private WebElement txtTransactionDetails;


    public TransactionDetails(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Hiển thị chi tiếp giao dịch")
    public void hienThiChiTietGiaoDichTraGop() {
        String elementText = txtTransactionDetails.getText();
        System.out.println(elementText);


    }
}


