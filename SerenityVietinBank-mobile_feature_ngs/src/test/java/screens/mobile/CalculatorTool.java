package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CalculatorTool extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField")
    private WebElement txtNumberOfMoney;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
    private WebElement btnDeleteMoney;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeSlider")
    private WebElement sldNumberOfMoney;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField")
    private WebElement txtNumberOfMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
    private WebElement btnDeleteMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeSlider")
    private WebElement sldNumberOfMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ưu đãi cho cán bộ VietinBank\"]/following-sibling::XCUIElementTypeCollectionView//XCUIElementTypeImage[@name=\"iconChoiceRadioOff\"]")
    private WebElement chkSpecialOffers;

    @iOSXCUITFindBy(xpath = "/XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")
    private WebElement btnContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch trả nợ dự kiến\"]")
    private WebElement btnExpectedPaymentScheduleViewer;

    public CalculatorTool(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    private void inputNumberOfMoney(String numberOfMoney) {
        click(txtNumberOfMoney);
        click(btnDeleteMoney);
        sendKeys(txtNumberOfMoney, numberOfMoney);
    }

    private void inputNumberOfMonth(String months) {
        click(txtNumberOfMonth);
        click(btnDeleteMonth);
        sendKeys(txtNumberOfMonth, months);
    }

    private void slicePercentOfMoney(String percentOfMoney) {
        sendKeys(sldNumberOfMoney, percentOfMoney);
    }

    private void slicePercentOfMonth(String percentOfMonths) {
        sendKeys(sldNumberOfMonth, percentOfMonths);
    }

    public void editNumberOfMoney(String editType, String numberOfMoney) {
        if (editType.equals("Edit")) {
            inputNumberOfMoney(numberOfMoney);
        } else if (editType.equals("Slice")) {
            slicePercentOfMoney(numberOfMoney);
        }
    }

    public ReferenceRepaymentSchedule editNumberOfMonth(String editType, String months) {
        if (editType.equals("Edit")) {
            inputNumberOfMonth(months);
        } else if (editType.equals("Slice")) {
            slicePercentOfMonth(months);
        }
        click(btnContinue);
        click(btnExpectedPaymentScheduleViewer);
        return new ReferenceRepaymentSchedule(this.appiumDriver);
    }
}
