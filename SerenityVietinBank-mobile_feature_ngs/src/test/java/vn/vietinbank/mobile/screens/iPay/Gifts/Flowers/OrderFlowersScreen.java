package vn.vietinbank.mobile.screens.iPay.Gifts.Flowers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

import static vn.vietinbank.utils.Constants.NO;
import static vn.vietinbank.utils.Constants.YES;

public class OrderFlowersScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngày nhận hoa\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement dateReceiveFlowers;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thêm người nhận\"]/following-sibling::XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "")
    private WebElement addReceiver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Giấu tên người gửi\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement hideSenderNameCheckbox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Họ tên\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement fullNameInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số điện thoại\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement mobilePhoneInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement emailInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tên công ty\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement companyNameInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mã số thuế\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement taxCodeInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Địa chỉ công ty\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement companyAddressInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email nhận hóa đơn\"]/following-sibling::XCUIElementTypeTextView")
    @AndroidFindBy(xpath = "")
    private WebElement emailToReceiveInvoiceInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Yêu cầu xuất hóa đơn\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "")
    private WebElement requestInvoiceCheckbox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Return\"]")
    @AndroidFindBy(xpath = "")
    private WebElement returnBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đặt mua hoa\"]")
    @AndroidFindBy(xpath = "")
    private WebElement orderFlowerBtn;

    public OrderFlowersScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickDateReceiveFlowers() {
        click(dateReceiveFlowers);
    }

    public void clickAddReceiver() {
        click(addReceiver);
    }

    public void clickHideSenderNameCheckbox(String answer) {
        switch (answer) {
            case YES:
                click(hideSenderNameCheckbox);
                break;
            case NO:
                break;
        }
    }

    public void clickReturnBtn() {
        click(returnBtn);
    }

    public void inputFullName(String fullName) {
        clearText(fullNameInput);
        sendKeys(fullNameInput, fullName);
    }

    public void inputMobilePhone(String mobilePhone) {
        clearText(mobilePhoneInput);
        sendKeys(mobilePhoneInput, mobilePhone);
    }

    public void inputEmail(String email) {
        clearText(emailInput);
        sendKeys(emailInput, email);
    }

    public void inputCompanyName(String companyName) {
        clearText(companyNameInput);
        sendKeys(companyNameInput, companyName);
    }

    public void inputTaxCode(String taxCode) {
        clearText(taxCodeInput);
        sendKeys(taxCodeInput, taxCode);
    }

    public void inputCompanyAddress(String companyAddress) {
        clearText(companyAddressInput);
        sendKeys(companyAddressInput, companyAddress);
    }

    public void inputEmailToReceiveInvoice(String emailToReceiveInvoice) {
        clearText(emailToReceiveInvoiceInput);
        sendKeys(emailToReceiveInvoiceInput, emailToReceiveInvoice);
    }

    public void clickRequestInvoiceCheckbox(String answer) {
        switch (answer) {
            case YES:
                click(requestInvoiceCheckbox);
                break;
            case NO:
                break;
        }
    }

    public void clickOrderFlowerBtn() {
        click(orderFlowerBtn);
    }
}
