package screens.mobile.M2S02;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class TransferAndReceive extends BaseScreen {

    public TransferAndReceive(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[6]")
    private static WebElement btnTranferMoneyObroad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private static WebElement txtPurpose;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chuyển tiền trả các loại phí, lệ phí cho nước ngoài\"])[2]")
    private static WebElement txtLivingExpenses;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tạo điện mua/chuyển ngoại tệ\"]")
    private WebElement btnMakeNewPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    private WebElement iconBeneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement txtBeneficiaryAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lưu & tiếp tục\"]")
    private WebElement btnSaveContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement txtPaymentNote;

    private String scrollTo = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    private WebElement paymentAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xong\"]")
    private WebElement btn_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement number_total_debt_deduction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    private WebElement btn_continue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineAddnew\"]")
    private WebElement icon_add_profile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chọn từ thư viện\"]")
    private WebElement select_from_library;

    @iOSXCUITFindAll({@iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name=\"Ảnh\"]//XCUIElementTypeOther//XCUIElementTypeScrollView//XCUIElementTypeImage")})
    private List<WebElement> image;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]")
    private WebElement txt_total_debt_deduction;

    private String txt_payment_note = "Nội dung chuyển";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
    private WebElement confirm_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Người nhận\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement title_beneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement purpose_trading_results;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngân hàng nhận\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement receiving_bank;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số ngoại tệ cần chuyển\"]//preceding-sibling::XCUIElementTypeStaticText")
    private WebElement number_to_transfer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ tạm tính\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement debt_amount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nội dung\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement content;


    String total_transfer;
    String total_debt_deduction;
    String get_beneficiary;
    String get_receiving_bank;

    public TransferAndReceive click_on_transfer_money_obroad() {
        click(btnTranferMoneyObroad);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive purpose_transfer() {
        tap(txtPurpose);
        tap(txtLivingExpenses);
        click(btnMakeNewPayment);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive chooseBeneficiary() {
        click(iconBeneficiary);
        click(txtBeneficiaryAccount);
        get_beneficiary = title_beneficiary.getText();
        get_receiving_bank = receiving_bank.getText();
        scrollTo(txt_payment_note);
        tap(txtPaymentNote);
        sendKeys(txtPaymentNote, "Test");
        click(done);
        click(btnSaveContinue);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive enterPaymentAmount(String money) {
        sendKeys(paymentAmount, money);
        click(btn_done);
        waitForElementVisible(btn_continue, 20);
        scrollToElement(txt_total_debt_deduction, ScrollDirection.DOWN, 20);
        total_debt_deduction = (number_total_debt_deduction).getText();
        click(btn_continue);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive provisioning_profile() {
        for (int i = 1; i <= 2; i++) {
            click(icon_add_profile);
            click(select_from_library);
            image.get(i).click();
        }
        click(btn_continue);
        click(confirm_done);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive verifyTransactionConfirmation() {
        String[] get_number_to_transfer_split = number_to_transfer.getText().split(" ");
        String get_number_to_transfer = get_number_to_transfer_split[0];
        String get_receiving_bank = receiving_bank.getText();
        String get_beneficiary = title_beneficiary.getText();
        String[] get_debt_amount_split = debt_amount.getText().split(" ");
        String get_debt_amount = get_debt_amount_split[0];
        String get_content = content.getText();

        System.out.println("get_number_to_transfer: "+ get_number_to_transfer);
        System.out.println("get_receiving_bank: "+ get_receiving_bank);
        System.out.println("get_beneficiary: "+ get_beneficiary);
        System.out.println("get_debt_amount: "+ get_debt_amount);
        System.out.println("get_content: "+ get_content);

        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive verifyTransferAndReceive() {

        return new TransferAndReceive(this.appiumDriver);
    }
}
