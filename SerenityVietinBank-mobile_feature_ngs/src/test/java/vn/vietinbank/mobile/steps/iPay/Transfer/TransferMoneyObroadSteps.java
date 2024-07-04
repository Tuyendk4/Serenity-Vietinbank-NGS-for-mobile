package vn.vietinbank.mobile.steps.iPay.Transfer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Transfer.TransferObroadScreen;


public class TransferMoneyObroadSteps {

    TransferObroadScreen transferObroadScreen = new TransferObroadScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("Chọn Mua Chuyển ngoại tệ")
    public void moveToTransferObroad() {
        transferObroadScreen.click_on_transfer_money_obroad();
    }

    @And("Chọn mục đích chuyển tiền là {string}")
    public void studyObroadLivingExpenses(String purpose) {
        transferObroadScreen.purpose_transfer(purpose);
    }

    @And("Chọn mục đích chuyển tiền là Trợ cấp cho thân nhân ở nước ngoài")
    public void otherOVerseas() {
        transferObroadScreen.other_oversear_payment();
    }

    @And("Chon người nhận với nội dung {string}")
    public void show_interest_rate_in_Reference_Payment_Schedule_as(String paymentNote) {
        transferObroadScreen.chooseBeneficiary(paymentNote);
    }

    @And("Nhập số ngoại tệ cần chuyển đi là {string}")
    public void enter_payment_amount(String money) {
        transferObroadScreen.enterPaymentAmount(money);
    }

    @And("Chọn hồ sơ cung cấp")
    public void select_provisioning_profile() {
        transferObroadScreen.provisioning_profile();
    }

    @Then("Xác nhận giao dịch")

    public void verify_transaction_confirmation() {
        transferObroadScreen.verifyTransactionConfirmation();
    }

    @Then("Kiểm tra lịch sử chuyển tiền ngoại tệ")
    public void verifyHistoryTranfers() {
        transferObroadScreen.verifyTransferAndReceive();
    }

    @And("Điền thông tin người nhận")
    public void enter_beneficiary(){
        transferObroadScreen.enter_infomation_beneficiary();
    }

    @And("Điền thông tin ngân hàng nhận {string}")
    public void enter_receiving_bank(String swiftCode){
        transferObroadScreen.choose_receiving_bank(swiftCode);
    }
}
