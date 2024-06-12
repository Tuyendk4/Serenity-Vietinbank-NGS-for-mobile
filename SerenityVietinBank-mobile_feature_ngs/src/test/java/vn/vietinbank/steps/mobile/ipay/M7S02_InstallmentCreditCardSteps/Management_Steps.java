package vn.vietinbank.steps.mobile.ipay.M7S02_InstallmentCreditCardSteps;

import io.cucumber.java.en.When;

import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class Management_Steps extends BaseStep {


    @When("Chọn quản lý trả góp")
    public void chonQLTGTab() {

        installmentTransactionManagement = eligibleTransactions.chonQLTGTab();
    }


    @When("Chọn số thẻ {string} trong danh sách quản lý trả góp")
    public void chonQLTGThe(String soThe) {

        installmentTransactionManagement = eligibleTransactions.chonQLTGThe(soThe);
    }

    @When("Chọn giao dịch trả góp theo trạng thái {string} và số tiền {string}")
    public void chonGiaoDichTraGop(String trangThai, String soTien) {

        transactionDetails = installmentTransactionManagement.chonGiaoDichTraGop(trangThai, soTien);
    }

    @When("Hiển thị chi tiếp giao dịch")
    public void hienThiChiTietGiaoDichTraGop() {

        transactionDetails.hienThiChiTietGiaoDichTraGop();
    }
}

