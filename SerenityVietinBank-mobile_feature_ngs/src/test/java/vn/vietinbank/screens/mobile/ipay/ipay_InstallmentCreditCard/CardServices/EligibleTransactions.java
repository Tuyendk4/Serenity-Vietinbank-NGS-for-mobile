package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import java.util.List;


public class EligibleTransactions extends BaseScreen {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]//XCUIElementTypeOther[2]//XCUIElementTypeButton")
    private WebElement buttonQLTG ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private WebElement buttonQLTGThe ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]//XCUIElementTypeTable\n")
    private WebElement tableDanhSachThe ;

    public EligibleTransactions(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step ("Chọn quản lý trả góp")
public InstallmentTransactionManagement chonQLTGTab() {
    delay(10000);
        tap(buttonQLTG);

        return new InstallmentTransactionManagement(appiumDriver);
    }


    @Step("Chọn số thẻ {string} trong danh sách quản lý trả góp")
    public InstallmentTransactionManagement chonQLTGThe(String soThe) {
        delay(10000);
        tap(buttonQLTGThe);
        delay(10000);
        WebElement parentElement = findCardElementParent(soThe);
        if (parentElement != null) {
            tap(parentElement);
            return new InstallmentTransactionManagement(appiumDriver);
        } else {
            throw new RuntimeException("Không tìm thấy thẻ phù hợp.");
        }
    }

    private WebElement findCardElementParent(String soThe) {
        String lastFourDigits = soThe.substring(soThe.length() - 4);
        // Tìm tất cả các phần tử bảng (table)
        List<WebElement> tableElements = appiumDriver.findElements(By.xpath("//XCUIElementTypeTable"));

        for (WebElement tableElement : tableElements) {
            // Tìm tất cả các phần tử cha (cell) trong bảng
            List<WebElement> cellElements = tableElement.findElements(By.xpath(".//XCUIElementTypeCell"));

            for (WebElement cellElement : cellElements) {
                // Tìm tất cả các phần tử con (static text) trong cell
                List<WebElement> cardElements = cellElement.findElements(By.xpath(".//XCUIElementTypeStaticText"));

                for (WebElement cardElement : cardElements) {
                    String cardText = cardElement.getAttribute("name");
                    if (cardText.contains(lastFourDigits)) {
                        // Trả về phần tử cha của phần tử thẻ
                        return cellElement;
                    }
                }
            }
        }
        return null;

    }


    @Step("Chọn số thẻ {string} trong danh sách thẻ trả góp")
    public EligibleTransactions chonDSThe(String soThe) {
        delay(3000);
        tap(buttonQLTGThe);
        delay(3000);
        WebElement parentElement = findCardElementParent(soThe);
        if (parentElement != null) {
            tap(parentElement);
            return new EligibleTransactions(appiumDriver);
        } else {
            throw new RuntimeException("Không tìm thấy thẻ phù hợp.");
        }
    }






    @Step ("Chọn giao dịch trả góp theo số tiền {string}")
    public InstallmentTransactionDetail chonGiaoDichDauTien(String soTien) {
        WebElement transactionElement = findElement(".//XCUIElementTypeStaticText[@name='" + soTien + "']");
        if (transactionElement != null) {
            tap(transactionElement);
            return new InstallmentTransactionDetail(appiumDriver);
        } else {
            throw new RuntimeException("Không tìm thấy giao dịch phù hợp.");
        }
    }


    }

