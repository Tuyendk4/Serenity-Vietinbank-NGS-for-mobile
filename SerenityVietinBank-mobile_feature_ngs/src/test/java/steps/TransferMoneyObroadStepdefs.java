package steps;

import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import runner.Runner;
import screens.mobile.*;


public class TransferMoneyObroadStepdefs extends Runner {

    public TransferMoneyObroadStepdefs() {
        super();
    }

    @Và("Chọn Mua Chuyển ngoại tệ")
    public void moveToPersonalInstalmentLoan() {
        transferAndReceive = transferAndReceive.click_on_transfer_money_obroad();
    }

    @Và("Chọn mục đích chuyển tiền là Chuyển tiền trả các loại phí, lệ phí cho nước ngoài")
    public void studyObroadLivingExpenses() {
        transferAndReceive = transferAndReceive.purpose_transfer();
    }

    @Và("Chon người nhận")
    public void show_interest_rate_in_Reference_Payment_Schedule_as() {
        transferAndReceive = transferAndReceive.chooseBeneficiary();
    }

    @Và("Nhập số ngoại tệ cần chuyển đi là {string}")
    public void enter_payment_amount(String money) {
        transferAndReceive = transferAndReceive.enterPaymentAmount(money);
    }

    @Và("Chọn hồ sơ cung cấp")
    public void select_provisioning_profile() {
        transferAndReceive = transferAndReceive.provisioning_profile();
    }

    @Thì("Xác nhận giao dịch")
    public void verify_transaction_confirmation() {
        transferAndReceive = transferAndReceive.verifyTransactionConfirmation();
    }

    @Thì("Kiểm tra lịch sử chuyển tiền ngoại tệ")
    public void verifyHistoryTranfers() {

    }
}
