package vn.vietinbank.steps.mobile.ipay.m6s03;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import vn.vietinbank.screens.mobile.ipay.M6S03.*;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home_M6S03;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;

public class Stepdefs_M6S03 extends BaseStep {
    private Home_M6S03 home_m6S03;
    private CreateDisbursementRequest createDisbursementRequest;
    private CreateDisbursementRequest_Step1 createDisbursementRequest_step1;
    private UploadInvoiceDocuments uploadInvoiceDocuments;
    private LoansForProductionAndBusiness_2 loansForProductionAndBusiness_2;
    private TransactionIdentification transactionIdentification;
    private TransactionResult transactionResult;
    private LoanAndCreditService loanAndCreditService;

    public Stepdefs_M6S03() {
        super();
    }

    @And("Chọn Dịch vụ vay và tín dụng")
    public void ChooseLoanAndCreditService() {
        home_m6S03 = new Home_M6S03(appiumDriver);
        loanAndCreditService = home_m6S03.click_dich_vu_vay_va_tin_dung();
    }

    @And("Chọn Vay sản xuất kinh doanh")
    public void moveToLoansForProductionAndBusiness() {
        loansForProductionAndBusiness_2 = loanAndCreditService.click_vay_san_xuat_kinh_doanh();
    }

    @And("Chọn tạo yêu cầu giải ngân")
    public void createRequestLoanProductionAndBusiness() {
        createDisbursementRequest = loansForProductionAndBusiness_2.clickCreateRequest();
    }

    @And("Chọn mục đích giải ngân {string}")
    public void disbursementPurposes(String purposes) {
        createDisbursementRequest.clickDisbursementPurposes(purposes);
    }

    @And("Chọn tài khoản trả nợ gốc và lãi mặc định")
    public void PrincipalAndInterestDebtAccount() {
        createDisbursementRequest.clickSelectPrincipalAndInterestDebtAccount();
    }

    @And("Chọn thời hạn trả nợ gốc {string}")
    public void choosePrincipalRepaymentPeriod(String principalepaymentPeriod ) {
        createDisbursementRequest.clickPrincipalRepaymentPeriod(principalepaymentPeriod);
    }

    @And("Chọn ngày trả nợ tự động định kỳ {string}")
    public void RegularAutomaticRepaymentDate(String regularAutomaticRepaymentDate) {
        createDisbursementRequest.clickRegularAutomaticRepaymentDate(regularAutomaticRepaymentDate);
    }

    @And("Chọn tiếp tục tạo yêu cầu giải ngân")
    public void continueCreatingDisbursementRequest() {
        createDisbursementRequest_step1 = createDisbursementRequest.clickContinueCreatingDisbursementRequest();
    }

    @And("Nhập tài khoản thụ hưởng {string}")
    public void beneficiaryAccount(String accountBeneficiary) {
        createDisbursementRequest_step1.inputBeneficiaryAccount(accountBeneficiary);
    }

    @And("Nhập ngân hàng thụ hưởng {string}")
    public void beneficiaryBank(String beneficiaryBankName) {
        createDisbursementRequest_step1.inputBeneficiaryBank(beneficiaryBankName);
    }

    @And("Nhập số tiền thụ hưởng {string}")
    public void beneficiaryAmount(String amountBeneficiary) {
        createDisbursementRequest_step1.inputBeneficiaryAmount(amountBeneficiary);
    }

    @And("Nhập Nội dung {string}")
    public void Content(String contentDisbursement) {
        createDisbursementRequest_step1.inputContentDisbursement(contentDisbursement);
    }

    @And("Chọn Đính kèm hoá đơn, hợp đồng")
    public void attachContractInvoice() {
        uploadInvoiceDocuments = createDisbursementRequest_step1.clickAttachContractInvoice();
    }

    @And("Nhập Nhập mã số hóa đơn, hợp đồng {string}")
    public void invoiceAndContractCodes(String txtInvoiceAndContractCodes) {
        uploadInvoiceDocuments.inputInvoiceAndContractCodes(txtInvoiceAndContractCodes);
    }

    @And("Nhập số tiền trên hóa đơn, hợp đồng {string}")
    public void invoiceAndContractAmount(String txtInvoiceAndContractAmount) {
        uploadInvoiceDocuments.inputInvoiceAndContractAmount(txtInvoiceAndContractAmount);
    }

    @And("Chọn ngày trên hóa đơn hợp đồng")
    public void dateOnContractInvoice() {
        uploadInvoiceDocuments.clickDateOnContractInvoice();
    }

    @And("Chọn đính kèm tài liệu")
    public void attachDocuments() {
        uploadInvoiceDocuments.clickAttachDocuments();
    }

    @And("Chọn Lưu")
    public void chooseSave() {
        createDisbursementRequest_step1 = uploadInvoiceDocuments.clickSave();
    }

    @And("Chọn xác nhận và đồng ý giải ngân")
    public void chooseConfirmsAndAgreesToDisbursement() {
        transactionIdentification = createDisbursementRequest_step1.clickConfirmsAndAgreesToDisbursement();
    }

    @And("Nhập thông tin OTP {string} xác nhận giao dich")
    public void inputOTPConfirmTransaction(String OTP) {
        transactionIdentification.inputOTPTransaction(OTP);
    }

    @And("Chọn xác nhận và hoàn tất")
    public void confirmAndComplete() {
        transactionResult = transactionIdentification.confirmAndComplete();
    }

    @Then("Thông báo giao dich thành công")
    public void notificationSuccess() {
        transactionResult.notificationSuccess();
    }

    @And("Quay về Home")
    public void returnHomePage() {
        loansForProductionAndBusiness_2 = transactionResult.backHomePage();
    }
}
