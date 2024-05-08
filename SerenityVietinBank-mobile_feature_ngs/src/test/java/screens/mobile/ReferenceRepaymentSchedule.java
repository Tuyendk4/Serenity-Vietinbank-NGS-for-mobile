package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ReferenceRepaymentSchedule extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lãi suất\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private WebElement lblInterestRate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền phải trả hàng tháng\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private WebElement lblMonthlyChargeAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private WebElement lblInterestPayableTotal;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng số tiền gốc & lãi phải trả\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private WebElement lblPrincipalAndInterestPayableTotal;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Vay ngay\"]")
    private WebElement btnBorrowNow;

    public ReferenceRepaymentSchedule(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String getInterestRate() {
        return lblInterestRate.getText();
    }

    public String getMonthlyChargeAmount() {
        return lblMonthlyChargeAmount.getText();
    }

    public String getInterestPayableTotal() {
        return lblInterestPayableTotal.getText();
    }

    public String getPrincipalAndInterestPayableTotal() {
        return lblPrincipalAndInterestPayableTotal.getText();
    }

    public void clickBorrowNow() {
        click(btnBorrowNow);
    }
}
