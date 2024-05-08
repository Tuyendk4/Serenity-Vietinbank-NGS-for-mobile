package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.PendingLoanPopup;

public class PersonalInstalmentLoan extends BaseScreen {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]")
    private WebElement btnCalculateNow;

    public PersonalInstalmentLoan(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public CalculatorTool clickCalculateNow() {
        if (pendingLoanPopup().isDisplayed()) {
            pendingLoanPopup().clickRetry();
        }
        btnCalculateNow.click();
        return new CalculatorTool(this.appiumDriver);
    }

    public PendingLoanPopup pendingLoanPopup() {
        return new PendingLoanPopup(this.appiumDriver);
    }
}
