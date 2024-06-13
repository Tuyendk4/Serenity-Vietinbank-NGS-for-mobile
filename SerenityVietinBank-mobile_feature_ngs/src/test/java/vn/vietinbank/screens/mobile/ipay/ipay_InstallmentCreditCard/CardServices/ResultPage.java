package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ResultPage extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Về trang chủ']")
    private WebElement btnBackHome;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Yêu cầu đăng ký chuyển đổi trả góp qua thẻ tín dụng của Quý khách đã được tiếp nhận. Tổng số tiền trả góp thực tế và số tiền trả góp hàng tháng sẽ được VietinBank thông báo đến Quý khách trên ứng dụng iPay sau khi chuyển đổi khoản trả góp thành công. Trân trọng Cảm ơn Quý khách\"]")
    private WebElement txtKQ;

    public ResultPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

//    @Step("Nhận thông báo thành công")
//    public ResultPage nhanThongBaoThanhCong() {
//        delay(5000);
//        String expectedText = "đã được tiếp nhận";
//        try {
//            String actualText = txtKQ.getText();
//            System.out.println(actualText);
//            assertTrue("Đăng ký thành công.", actualText.contains(expectedText));
//        } catch (NoSuchElementException e) {
//            fail("Đăng ký không thành công.");
//        }
//        return new ResultPage(appiumDriver);
//    }

    @Step("Nhận thông báo thành công")
    public void nhanThongBaoThanhCong() {

        String expectedText = "đã được tiếp nhận";
        try {
            String actualText = txtKQ.getText();
            assertTrue("Đăng ký thành công.", actualText.contains(expectedText));
        } catch (NoSuchElementException e) {
            fail("Đăng ký không thành công.");
        }
    }


    @Step("Về trang chủ")
    public ResultPage veTrangChu() {
        delay(5000);
        tap(btnBackHome);
        return new ResultPage(appiumDriver);
    }

}
