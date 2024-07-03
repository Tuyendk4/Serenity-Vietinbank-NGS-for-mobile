package vn.vietinbank.mobile.screens.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

import java.util.List;

import static vn.vietinbank.utils.Constants.MONTH;

public class SearchTransactionsHistoryScreen extends BaseScreen {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Tra cứu lịch sử giao dịch\"")
    @AndroidFindBy(xpath = "")
    private WebElement traCuuLichSuGiaoDichScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Nhập thông tin giao dịch cần tìm\"")
    @AndroidFindBy(xpath = "")
    private WebElement nhapThongTinGiaoDichInput;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"calendar\"")
    @AndroidFindBy(xpath = "")
    private WebElement calendarBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chọn khoảng thời gian (tối đa 3 ngày)\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeCollectionView")
    @AndroidFindBy(xpath = "")
    private WebElement calendarScrollView;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Chọn ngày\" AND label == \"Chọn ngày\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(xpath = "")
    private WebElement chonNgayBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Tìm kiếm\" AND label == \"Tìm kiếm\" AND type == \"XCUIElementTypeButton\"")
    @AndroidFindBy(xpath = "")
    private WebElement timKiemBtn;

    public SearchTransactionsHistoryScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void historyTransactionScreenDisplayed() {
        waitForElementVisible(traCuuLichSuGiaoDichScreen, 5);
        Assert.assertTrue(traCuuLichSuGiaoDichScreen.isDisplayed());
    }

    public void clickIconCalendar() {
        click(calendarBtn);
    }

    public void searchMonth(String month) {
        Serenity.setSessionVariable(MONTH).to(month);
        for (int i = 0; i < 5; i++) {
            String MONTH_SEARCH = "//XCUIElementTypeStaticText[@name='%s']";
            List<WebElement> monthEl = appiumDriver.findElements(getByLocator(MONTH_SEARCH, month));
            if (monthEl.isEmpty()) {
                scrollUpElement(calendarScrollView);
            } else {
                break;
            }
        }
    }

    public void searchDate(String fromDate) {
        String month = Serenity.sessionVariableCalled(MONTH);
        String locator = "(//XCUIElementTypeStaticText[@name='" + month + "']/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeCell//XCUIElementTypeStaticText[@name='" + fromDate + "'])[1]";
        for (int i = 0; i < 5; i++) {
            WebElement dayEl = appiumDriver.findElement(By.xpath(locator));
            if (!dayEl.isDisplayed()) {
                scrollDownElement(calendarScrollView);
            } else {
                click(dayEl);
                break;
            }
        }
    }

    public void clickPickDateButton() {
        click(chonNgayBtn);
    }

    public void clickSearchBtn() {
        click(timKiemBtn);
    }
}
