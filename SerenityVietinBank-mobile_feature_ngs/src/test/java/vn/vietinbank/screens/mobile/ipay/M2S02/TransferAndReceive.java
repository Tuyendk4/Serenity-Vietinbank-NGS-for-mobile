package vn.vietinbank.screens.mobile.ipay.M2S02;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.Serenity;
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

    private String purpose = "(//XCUIElementTypeStaticText[@name=\"%value\"])[2]";

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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số ngoại tệ cần chuyển\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement number_to_transfer_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ tạm tính\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement debt_amount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ (tạm tính)\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement debt_amount_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nội dung\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement content;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch sử điện ngoại tệ\"]")
    private WebElement txt_view_history;

    String view_history = "Xem lịch sử điện ngoại tệ";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[43]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement txt_list_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Trạng thái\"]//following-sibling::XCUIElementTypeStaticText")
    private WebElement txt_status;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích sử dụng\"]//following-sibling::XCUIElementTypeTextField")
    private WebElement txt_popure_used;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private WebElement txt_other_oversear_payment;

    public String replaceXpath(String xpath, String value){
        return xpath.replace("%value", value);
    }

    public TransferAndReceive click_on_transfer_money_obroad() {
        click(btnTranferMoneyObroad);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive purpose_transfer(String value) {
        tap(txtPurpose);
        tap(replaceXpath(purpose, value),10);
        Serenity.setSessionVariable("purpose_transfer").to(value);
        click(btnMakeNewPayment);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive other_oversear_payment() {
        tap(txtPurpose);
        txt_other_oversear_payment.click();
        logger.info("================ "+ txt_popure_used.getText());
        System.out.println("aaaaaaa: "+txt_popure_used.getText());
        Serenity.setSessionVariable("purpose_transfer").to(txt_popure_used.getText());
        click(btnMakeNewPayment);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive chooseBeneficiary() {
        click(iconBeneficiary);
        click(txtBeneficiaryAccount);
        String get_beneficiary = title_beneficiary.getText();
        String get_receiving_bank = receiving_bank.getText();
        Serenity.setSessionVariable("get_beneficiary").to(get_beneficiary);
        Serenity.setSessionVariable("get_receiving_bank").to(get_receiving_bank);
        scrollTo(txt_payment_note);
        tap(txtPaymentNote);
        sendKeys(txtPaymentNote, "Test");
        click(done);
        click(btnSaveContinue);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive enterPaymentAmount(String money) {
        sendKeys(paymentAmount, money);
        Serenity.setSessionVariable("total_transfer").to(money);
        click(btn_done);
        waitForElementVisible(btn_continue, 20);
        scrollToElement(txt_total_debt_deduction, ScrollDirection.DOWN, 20);
        String total_debt_deduction = (number_total_debt_deduction).getText();
        Serenity.setSessionVariable("total_debt_deduction").to(total_debt_deduction);
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
        String[] get_number_to_transfer_split = number_to_transfer_history.getText().split(" ");
        String get_number_to_transfer = get_number_to_transfer_split[0];
        String get_receiving_bank_confirm = receiving_bank.getText();
        String get_beneficiary_confirm = title_beneficiary.getText();
        String[] get_debt_amount_split = debt_amount.getText().split(" ");
        String get_debt_amount = get_debt_amount_split[0];
        String get_content = content.getText();
        String[] total_debt_deduction_split = Serenity.sessionVariableCalled("total_debt_deduction").toString().split(" ");
        String total_debt_deduction = total_debt_deduction_split[0];

        assert (get_number_to_transfer.equals(Serenity.sessionVariableCalled("total_transfer")));
        assert (get_receiving_bank_confirm.equals(Serenity.sessionVariableCalled("get_receiving_bank")));
        assert (get_beneficiary_confirm.equals(Serenity.sessionVariableCalled("get_beneficiary")));
        assert (get_debt_amount.equals(total_debt_deduction));
        assert (get_content.equals("Test"));

        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive verifyTransferAndReceive() {
        scrollTo(view_history);
        click(txt_view_history);
        tap (txt_list_history);
        String[] number_to_transfer_split = number_to_transfer_history.getText().split(" ");
        String number_to_transfer = number_to_transfer_split[0];
        String[] debt_amount_split = debt_amount_history.getText().split(" ");
        String debt_amount = debt_amount_split[0];
        String[] total_debt_deduction_split = Serenity.sessionVariableCalled("total_debt_deduction").toString().split(" ");
        String total_debt_deduction = total_debt_deduction_split[0];

        assert (txt_status.getText().contains("Chờ ngân hàng xử lý"));
        assert (purpose_trading_results.getText().equals(Serenity.sessionVariableCalled("purpose_transfer")));
        assert (number_to_transfer.equals(Serenity.sessionVariableCalled("total_transfer")));
        assert (debt_amount.equals(total_debt_deduction));
        return new TransferAndReceive(this.appiumDriver);
    }
}
