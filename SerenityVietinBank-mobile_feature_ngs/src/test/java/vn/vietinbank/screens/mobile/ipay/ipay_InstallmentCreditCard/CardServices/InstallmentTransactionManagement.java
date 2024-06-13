package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import java.util.List;

public class InstallmentTransactionManagement extends BaseScreen {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable")
    private WebElement tableTransaction;

    public InstallmentTransactionManagement(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Chọn giao dịch trả góp theo trạng thái {0} và số tiền {1}")
    public TransactionDetails chonGiaoDichTraGop(String trangThai, String soTien) {
        delay(10000);
        WebElement transactionElement = findTransactionElement(trangThai, soTien);
        if (transactionElement != null) {
            tap(transactionElement);
            return new TransactionDetails(appiumDriver);
        } else {
            throw new RuntimeException("Không tìm thấy giao dịch phù hợp.");
        }
    }

    private WebElement findTransactionElement(String trangThai, String soTien) {
        // Tìm tất cả các cell trong table
        List<WebElement> cells = tableTransaction.findElements(By.xpath(".//XCUIElementTypeCell"));

        for (WebElement cell : cells) {
            // Kiểm tra trạng thái của giao dịch trong cell hiện tại
            List<WebElement> statusElements = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='" + trangThai + "']"));
            // Kiểm tra số tiền của giao dịch trong cell hiện tại
            List<WebElement> amountElements = cell.findElements(By.xpath(".//XCUIElementTypeStaticText[@name='" + soTien + "']"));

            // Nếu cả trạng thái và số tiền đều khớp trong cùng một cell, trả về cell này
            if (!statusElements.isEmpty() && !amountElements.isEmpty()) {
                return cell;
            }
        }

        // Trả về null nếu không tìm thấy element nào
        return null;

    }


}

