//package screens.mobile.ipay_InstallmentCreditCard.CardServices_Installment;
//
//import base.BaseScreen;
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import net.serenitybdd.annotations.Step;
//import org.openqa.selenium.WebElement;
//
//public class CardList extends BaseScreen {
//
//    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1])")
//    private WebElement btnFirstCard;
//    //XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]
//    public CardList(AppiumDriver appiumDriver) {
//        super(appiumDriver);
//    }
//
//    @Step("Chọn thẻ đầu tiên")
//    public CardDetails chonTheDauTien() {
//        tap(btnFirstCard);
//        return new CardDetails(appiumDriver);
//    }
//}
package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import java.util.List;

public class CardList extends BaseScreen {

    // Element chung chứa các thẻ
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]")

    private WebElement cardContainer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem tất cả\"]")

    private WebElement buttonXemTatCa;

    public CardList(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn thẻ dựa trên số thẻ đầy đủ {string}")
    public CardDetails chonTheTheoSo(String soThe) {
        tap(buttonXemTatCa);
        WebElement cardElement = findCardElement(soThe);
        if (cardElement != null) {
            tap(cardElement);
            return new CardDetails(appiumDriver);
        } else {
            throw new RuntimeException("Không tìm thấy thẻ phù hợp.");
        }
    }

    private WebElement findCardElement(String soThe) {
        String lastFourDigits = soThe.substring(soThe.length() - 4);

        List<WebElement> cardElements = findElements("//XCUIElementTypeStaticText[contains(@name, '****')]");
        for (WebElement cardElement : cardElements) {
            String cardText = cardElement.getAttribute("name");

            if (cardText.contains(lastFourDigits)) {
                System.out.println("return");
                return cardElement;
            }
        }

        return null;
    }
}
