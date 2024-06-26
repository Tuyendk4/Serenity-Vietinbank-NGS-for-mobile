package vn.vietinbank.steps.mobile.ipay.m2s02;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class TransferMoneyObroadStepdefs extends BaseStep {

    public TransferMoneyObroadStepdefs() {
        super();
    }

    @And("Chọn Mua Chuyển ngoại tệ")
    public void moveToTransferObroad() {
        transferAndReceive.click_on_transfer_money_obroad();
    }

    @And("Chọn mục đích chuyển tiền là {string}")
    public void studyObroadLivingExpenses(String purpose) {
        transferAndReceive.purpose_transfer(purpose);
    }

    @And("Chọn mục đích chuyển tiền là Trợ cấp cho thân nhân ở nước ngoài")
    public void otherOVerseas() {
        transferAndReceive = transferAndReceive.other_oversear_payment();
    }

    @And("Chon người nhận với nội dung {string}")
    public void show_interest_rate_in_Reference_Payment_Schedule_as(String paymentNote) {
        transferAndReceive.chooseBeneficiary(paymentNote);
    }

    @And("Nhập số ngoại tệ cần chuyển đi là {string}")
    public void enter_payment_amount(String money) {
        transferAndReceive.enterPaymentAmount(money);
    }

    @And("Chọn hồ sơ cung cấp")
    public void select_provisioning_profile() {
        transferAndReceive.provisioning_profile();
    }

    @Then("Xác nhận giao dịch")
    public void verify_transaction_confirmation() {
        transferAndReceive.verifyTransactionConfirmation();
    }

    @Then("Kiểm tra lịch sử chuyển tiền ngoại tệ")
    public void verifyHistoryTranfers() {
        transferAndReceive.verifyTransferAndReceive();
    }

    @And("Điền thông tin người nhận")
    public void enter_beneficiary(){
        transferAndReceive.enter_infomation_beneficiary();
    }

    @And("Điền thông tin ngân hàng nhận {string}")
    public void enter_receiving_bank(String swiftCode){
        transferAndReceive.choose_receiving_bank(swiftCode);
    }
}
