package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NavigationBar;

public class LoanAndCreditServices extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton")
    private WebElement btnVayPersonalInstalmentLoan;

    public LoanAndCreditServices(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public PersonalInstalmentLoan click_vay_tieu_dung_ca_nhan() {
        btnVayPersonalInstalmentLoan.click();
        return new PersonalInstalmentLoan(this.appiumDriver);
    }

    public NavigationBar navigationBar() {
        return new NavigationBar(appiumDriver);
    }
}
