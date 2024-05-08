package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.LoanAndCreditServices;

public class FavoriteServices extends BaseScreen {

    @AndroidFindBy(xpath = "")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dịch vụ vay & tín dụng\" or @name=\"Sản phẩm vay\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeImage")
    private WebElement iconLoanAndCreditServices;

    public FavoriteServices(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoanAndCreditServices clickLoanAndCreditServices() {
        click(iconLoanAndCreditServices);
        return new LoanAndCreditServices(appiumDriver);
    }
}
