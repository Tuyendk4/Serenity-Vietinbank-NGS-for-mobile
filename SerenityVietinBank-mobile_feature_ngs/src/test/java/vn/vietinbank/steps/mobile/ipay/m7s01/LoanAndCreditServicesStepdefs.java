package vn.vietinbank.steps.mobile.ipay.m7s01;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.*;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoanAndCreditServicesStepdefs extends BaseStep {

    private ReferenceRepaymentSchedule referenceRepaymentSchedule;
    private CalculatorTool calculatorTool;
    private PersonalInstalmentLoan_Step1 personalInstalmentLoanStep1;
    private PersonalInstalmentLoan_Step2 personalInstalmentLoanStep2;
    private PersonalInstalmentLoan_Step3 personalInstalmentLoanStep3;
    private LoanHistory loanHistory;
    private LoanProfile loanProfile;
    private LoanProfileDetail loanProfileDetail;
    private PersonalInstalmentLoan_SuccessfulApplicationAppraisal successfulApplicationAppraisal;
    private LoanContractContent loanContractContent;
    private InsuranceContractContent insuranceContractContent;
    private TransactionApproval transactionApproval;
    private TransactionResult transactionResult;
    private RepayAndFinalizeTheLoan repayAndFinalizeTheLoan;
    private Overdraft overdraft;
    private Overdraft_LoanProfileDetail overdraftLoanProfileDetail;
    private SecuredOverdraft securedOverdraft;
    private OnlineSecuredOverdraftLoan onlineSecuredOverdraftLoan;
    private OnlineSecuredOverdraft_LoanContractContent onlineSecuredOverdraft_loanContractContent;
    private Overdraft_LoanContractContent overdraftLoanContractContent;
    private Overdraft_SuccessfullyAppraisal overdraftSuccessfullyAppraisal;

    public LoanAndCreditServicesStepdefs() {
        super();
    }

    @And("Vay tiêu dùng cá nhân")
    public void moveToPersonalInstalmentLoan() {
        personalInstalmentLoan = loanAndCreditServices.click_personal_instalment_loan();
    }

    @And("Công cụ tính lãi suất - Tính toán ngay")
    public void click_Calculate_Now() {
        calculatorTool = personalInstalmentLoan.clickCalculateNow();
    }

    @And("Vay {string} VND, thời hạn {string} tháng không có ưu đãi đặc biệt, {string}")
    public void make_a_Loan_with(String numberOfMoneyOrPercent,
                                 String monthsOrPercent, String editType) {
        calculatorTool.editNumberOfMoney(editType, numberOfMoneyOrPercent);
        calculatorTool.editNumberOfMonth(editType, monthsOrPercent);
        calculatorTool.uncheckSpecialOffer();
        referenceRepaymentSchedule = calculatorTool.clickExpectedPaymentScheduleViewerButton();
    }

    @And("Vay {string} VND, thời hạn {string} tháng có ưu đãi đặc biệt, {string}")
    public void make_a_Loan_with_Special_Offer(String numberOfMoneyOrPercent,
                                               String monthsOrPercent, String editType) {
        calculatorTool.editNumberOfMoney(editType, numberOfMoneyOrPercent);
        calculatorTool.editNumberOfMonth(editType, monthsOrPercent);
        calculatorTool.checkSpecialOffer();
        referenceRepaymentSchedule = calculatorTool.clickExpectedPaymentScheduleViewerButton();
    }

    @Then("Lịch trả nợ - Lãi suất {string}")
    public void show_interest_rate_in_Reference_Payment_Schedule_as(String interestRate) {
        assertThat(referenceRepaymentSchedule.getInterestRate(), equalTo(interestRate));
    }

    @And("Lịch trả nợ - Số tiền phải trả hàng tháng {string}")
    public void show_monthly_charge_amount_in_Reference_Payment_Schedule_as(
            String monthlyChargeAmount) {
        if (appiumDriver instanceof AndroidDriver) {
            assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
        } else {
            monthlyChargeAmount = StringUtils.remove(monthlyChargeAmount, "VND ");
            assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
        }

    }

    @And("Lịch trả nợ - Tổng lãi phải trả {string}")
    public void show_interest_payable_total_in_Reference_Payment_Schedule_as(
            String interestPayableTotal) {
        assertThat(referenceRepaymentSchedule.getInterestPayableTotal(), equalTo(interestPayableTotal));
    }

    @And("Lịch trả nợ - Tổng số tiền gốc và lãi phải trả {string}")
    public void show_principal_and_interest_payable_total_in_Reference_Payment_Schedule_as(
            String principalAndInterestPayableTotal) {
        assertThat(referenceRepaymentSchedule.getPrincipalAndInterestPayableTotal(),
                equalTo(principalAndInterestPayableTotal));
    }

    @When("MH Vay - Bước 1")
    public void move_to_Personal_Instalment_Loan_Step_1() {
        personalInstalmentLoanStep1 = referenceRepaymentSchedule.clickBorrowNow();
    }

    @Then("MH Vay - Bước 1 - Lãi suất vay {string}")
    public void show_interest_rate_in_Personal_Instalment_Loan_Step_1_as(String interestRate) {
        assertThat(personalInstalmentLoanStep1.getInterestRate(), equalTo(interestRate));
    }

    @And("MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định {string}")
    public void show_monthly_charge_amount_in_Personal_Instalment_Loan_Step_1_as(
            String monthlyChargeAmount) {
        String actualMonthlyChargeAmount = "";
        if (appiumDriver instanceof AndroidDriver) {
            actualMonthlyChargeAmount = personalInstalmentLoanStep1.getMonthlyChargeAmount01()
                    .replaceAll("\n ", " ");
        } else {
            actualMonthlyChargeAmount = personalInstalmentLoanStep1.getMonthlyChargeAmount01() + " "
                    + personalInstalmentLoanStep1.getMonthlyChargeAmount02();
        }
        assertThat(actualMonthlyChargeAmount, equalTo(monthlyChargeAmount));
    }

    @When("MH Vay - Bước 1 - Xác nhận sử dụng bảo hiểm VietinBank")
    public void check_insurance_agreement_and_check_terms_and_conditions_in_Personal_Instalment_Loan_Step_1() {
        personalInstalmentLoanStep1.checkInsuranceAgreement();
        personalInstalmentLoanStep1.checkTermsAndConditions();
    }

    @When("MH Vay - Bước 2")
    public void move_to_Personal_Instalment_Loan_Step_2() {
        personalInstalmentLoanStep2 = personalInstalmentLoanStep1.clickContinueButton();
    }

    @And("MH Vay - Bước 2 - Ngày trả nợ hàng tháng {string}, mục đích vay {string}, tỉnh {string}, huyện {string}")
    public void select_repayment_date_and_loan_purpose_and_province_and_district_in_Personal_Instalment_Loan_Step_2(
            String date, String loanPurpose, String province, String district) {
        personalInstalmentLoanStep2.chooseARepaymentDate(date);
        personalInstalmentLoanStep2.chooseLoanPurpose(loanPurpose);
        personalInstalmentLoanStep2.chooseProvince(province);
        personalInstalmentLoanStep2.chooseDistrict(district);
        personalInstalmentLoanStep3 = personalInstalmentLoanStep2.clickContinueButton();
    }

    @And("MH Vay - Bước 2 - Ngày trả nợ hàng tháng {string}, mục đích vay {string}, email {string}, tỉnh {string}, huyện {string}")
    public void select_repayment_date_and_loan_purpose_and_email_and_province_and_district_in_Personal_Instalment_Loan_Step_2(
            String date, String loanPurpose, String email, String province, String district) {
        personalInstalmentLoanStep2.chooseARepaymentDate(date);
        personalInstalmentLoanStep2.chooseLoanPurpose(loanPurpose);
        personalInstalmentLoanStep2.inputEmail(email);
        personalInstalmentLoanStep2.chooseProvince(province);
        personalInstalmentLoanStep2.chooseDistrict(district);
        personalInstalmentLoanStep3 = personalInstalmentLoanStep2.clickContinueButton();
    }

    @Then("MH Vay - Bước 3 - Số tiền vay {string}")
    public void should_show_number_of_money_in_Personal_Instalment_Loan_Step_3(String numberOfMoney) {
        assertThat(personalInstalmentLoanStep3.getNumberOfMoney(), equalTo(numberOfMoney));
    }

    @And("MH Vay - Bước 3 - Thời hạn vay {string}")
    public void should_show_loan_duration_in_Personal_Instalment_Loan_Step_3(String months) {
        assertThat(personalInstalmentLoanStep3.getMonths(), equalTo(months));
    }

    @And("MH Vay - Bước 3 - Lãi suất dự kiến là {string}")
    public void should_show_interest_rate_in_Personal_Instalment_Loan_Step_3(String interestRate) {
        assertThat(personalInstalmentLoanStep3.getInterestRate(), equalTo(interestRate));
    }

    @And("MH Vay - Bước 3 - Chương trình ưu đãi là {string}")
    public void should_show_type_special_offer_in_Personal_Instalment_Loan_Step_3(String type) {
        assertThat(personalInstalmentLoanStep3.getSpecialOfferType(), equalTo(type));
    }

    @And("MH Vay - Bước 3 - Mục đích vay là {string}")
    public void should_show_loan_purpose_in_Personal_Instalment_Loan_Step_3(String loanPurpose) {
        assertThat(personalInstalmentLoanStep3.getLoanPurpose(), equalTo(loanPurpose));
    }

    @And("MH Vay - Bước 3 - Ngày trả nợ hàng tháng {string}")
    public void should_show_repayment_date_in_Personal_Instalment_Loan_Step_3(String date) {
        assertThat(personalInstalmentLoanStep3.getRepaymentDate(), equalTo(date));
    }

    @And("MH Vay - Bước 3 - họ và tên người vay {string}")
    public void should_show_borrow_name_in_Personal_Instalment_Loan_Step_3(String name) {
        assertThat(personalInstalmentLoanStep3.getBorrowName(), equalTo(name));
    }

    @When("Gửi yêu cầu vay")
    public void accept_information_terms_and_conditions_and_click_Send_button_in_Personal_Instalment_Loan_Step_3() {
        personalInstalmentLoanStep3.checkExactlyInformation();
        personalInstalmentLoanStep3.checkTermsAndConditions();
        personalInstalmentLoanStep3.clickSendButton();
    }

    @Then("Thông báo {string}")
    public void should_show_notification_popup_on_Personal_Instalment_Loan_Step_3(String message) {
        assertThat(personalInstalmentLoanStep3.notificationPopup().getNotificationTitle(),
                containsString(message));
    }

    @When("Chọn Đồng ý trên Popup thông báo")
    public void click_Agree_button_on_notification_popup_on_Personal_Instalment_Loan_Step_3() {
        loanAndCreditServices = personalInstalmentLoanStep3.notificationPopup().clickAgreeButton();
    }

    @Then("hiển thị số lượng tại Lịch sử vay")
    public void should_show_number_at_Loan_History_in_Loan_And_Credit_Service() {
        assertThat(Integer.parseInt(loanAndCreditServices.getNumberOfLoanDocument()),
                greaterThanOrEqualTo(1));
    }

    @When("Vào MH Lịch sử vay")
    public void move_to_Loan_history() {
        loanHistory = loanAndCreditServices.click_loan_history();
    }

    @Then("Khoản vay {string}, số tiền {string}")
    public void should_show_loan_status_and_number_of_money(String status, String numberOfMoney) {
        assertThat(loanHistory.getStatusText(), equalTo(status));
        assertThat(loanHistory.getNumberOfLoanMoneyText(), containsString(numberOfMoney));
    }

    @When("Vào MH Vay tiêu dùng cá nhân")
    public void move_to_Loan_Profile() {
        loanProfile = loanHistory.clickConsumerLoan();
    }

    @Then("Vào MH Vay tiêu dùng cá nhân của khoản vay {string}")
    public void move_to_Loan_Profile(String status) {
        if (loanHistory.getStatusText().equals(status)) {
            loanProfile = loanHistory.clickConsumerLoan();
        }
    }

    @When("MH Vay tiêu dùng cá nhân - Hủy khoản vay")
    public void abort_the_Loan_in_Loan_Profile() {
        loanProfile.clickAbort();
    }

    @Then("MH Vay tiêu dùng cá nhân - Thông báo {string}")
    public void show_aborting_confirmation_notification_in_Loan_Profile(String message) {
        assertThat(loanProfile.notificationPopup().getNotificationTitle(), equalTo(message));
    }

    @When("MH Vay tiêu dùng cá nhân - Xác nhận hủy")
    public void confirm_to_abort_the_Loan_in_Loan_Profile() {
        loanProfile.notificationPopup().clickConfirmToAbortButton();
    }

    @Then("MH Vay tiêu dùng cá nhân - Thông báo thành công: {string}")
    public void show_aborting_success_notification_in_Loan_Profile(String message) {
        assertThat(loanProfile.successPopup().getNotification(), equalTo(message));
        loanProfile.successPopup().clickAgreeButton();
    }

    @And("Mở Hồ sơ vay tiêu dùng cá nhân")
    public void move_to_Loan_Profile_detail() {
        loanProfileDetail = loanProfile.viewLoanProfileDetail();
    }

    @Then("Hồ sơ vay tiêu dùng cá nhân - Số tiền vay {string}")
    public void should_show_number_of_money_in_Loan_Profile_Detail(String money) {
        assertThat(loanProfileDetail.getNumberOfMoney(), equalTo(money));
    }

    @And("Hồ sơ vay tiêu dùng cá nhân - Thời hạn vay {string}")
    public void should_show_loan_duration_in_Loan_Profile_Detail(String numberOfMonths) {
        assertThat(loanProfileDetail.getMonths().toLowerCase(), equalTo(numberOfMonths));
    }

    @And("Hồ sơ vay tiêu dùng cá nhân - Ngày trả nợ hàng tháng {string}")
    public void should_show_repayment_date_in_Loan_Profile_Detail(String date) {
        assertThat(loanProfileDetail.getRepaymentDate(), equalTo(date));
    }

    @And("Hồ sơ vay tiêu dùng cá nhân - Mục đích vay {string}")
    public void should_show_loan_purpose_in_Loan_Profile_Detail(String loadPurpose) {
        assertThat(loanProfileDetail.getLoanPurpose(), equalTo(loadPurpose));
    }

    @And("Hồ sơ vay tiêu dùng cá nhân - Họ và tên ngươi vay {string}")
    public void should_show_borrow_full_name_in_Loan_Profile_Detail(String fullName) {
        assertThat(loanProfileDetail.getBorrowName(), equalTo(fullName));
    }

    @And("Hồ sơ vay tiêu dùng cá nhân - Email nhận hợp đồng {string}")
    public void should_show_email_in_Loan_Profile_Detail(String email) {
        assertThat(loanProfileDetail.getEmail(), equalTo(email));
    }

    @Then("Thông báo thành công: {string}")
    public void should_show_success_popup_on_Personal_Instalment_Loan_Step_3(String message) {
        message = StringUtils.replaceChars(message, "D", "Đ");
        assertThat(personalInstalmentLoanStep3.successPopup().getNotification(),
                containsString(message));
    }

    @When("Nhấn Đồng ý trên Thành công popup")
    public void click_Agree_button_on_success_popup_on_Personal_Instalment_Loan_Step_3() {
        successfulApplicationAppraisal = personalInstalmentLoanStep3.successPopup().clickAgreeButton();
    }

    @Then("Thẩm định hồ sơ thành công - Số tiền vay {string}")
    public void should_show_number_of_money_in_Personal_Instalment_Loan_Successful_Application_Appraisal(
            String money) {
        assertThat(successfulApplicationAppraisal.getNumberOfMoney(), equalTo(money));
    }

    @And("Thẩm định hồ sơ thành công - Lãi suất {string}")
    public void should_show_loan_duration_in_Personal_Instalment_Loan_Successful_Application_Appraisal(
            String interestRate) {
        assertThat(successfulApplicationAppraisal.getInterestRate(), equalTo(interestRate));
    }

    @And("Thẩm định hồ sơ thành công - Thời hạn vay {string}")
    public void should_show_repayment_date_in_Personal_Instalment_Loan_Successful_Application_Appraisal(
            String numberOfMonths) {
        assertThat(successfulApplicationAppraisal.getMonths(), equalTo(numberOfMonths));
    }

    @When("Thẩm định hồ sơ thành công - lựa chọn tài khoản")
    public void select_account_in_Personal_Instalment_Loan_Successful_Application_Appraisal() {
        successfulApplicationAppraisal.selectAccount();
    }

    @And("Xem nội dung hợp đồng vay")
    public void view_content_contract_in_Personal_Instalment_Loan_Successful_Application_Appraisal() {
        loanContractContent = successfulApplicationAppraisal.viewContract();
    }

    @And("MH Hợp động vay - quay trở lại Thẩm định hồ sơ thành công")
    public void back_to_Personal_Instalment_Loan_Successful_Application_Appraisal_from_Insurance_Contract_Content() {
        loanContractContent.clickBackButton();
    }

    @And("Xem nội dung hợp đồng bảo hiểm")
    public void view_insurance_content_contract_in_Personal_Instalment_Loan_Successful_Application_Appraisal() {
        insuranceContractContent = successfulApplicationAppraisal.viewInsuranceContract();
    }

    @And("MH Hợp đồng bảo hiểm - quay trở lại Thẩm định hồ sơ thành công")
    public void back_to_Personal_Instalment_Loan_Successful_Application_Appraisal() {
        insuranceContractContent.clickBackButton();
    }

    @And("Đồng ý vay")
    public void check_checkbox_and_click_agree_button_in_Personal_Instalment_Loan_Successful_Application_Appraisal() {
        successfulApplicationAppraisal.check_Contract_Agreement_checkbox();
        transactionApproval = successfulApplicationAppraisal.clickAgree();
    }

    @And("Đồng ý vay và mua bảo hiểm")
    public void check_checkbox_and_click_agree_and_buy_insurance_button_in_Personal_Instalment_Loan_Successful_Application_Appraisal() {
        successfulApplicationAppraisal.check_Contract_Agreement_checkbox();
        successfulApplicationAppraisal.check_Insurance_Contract_Agreement_checkbox();
        transactionApproval = successfulApplicationAppraisal.clickAgree();
    }

    @And("Xác nhận hợp đồng - Nhập OTP {string}")
    public void input_OTP_in_Transaction_Approval(String otp) {
        transactionResult = transactionApproval.inputOTP(otp);
    }

    @Then("Kết quả giao dịch - hiển thị {string}")
    public void show_notification_in_Transaction_Result(String message) {
        assertThat(transactionResult.getNotificationContent(), equalTo(message));
    }

    @And("Vào MH Trả nợ & tất toán vay")
    public void move_to_Repay_And_Finalize_The_Loan() {
        repayAndFinalizeTheLoan = loanAndCreditServices.click_repay_and_finalize_the_loan();
    }

    @And("Thực hiện {string}, nhập tài khoản vay {string}")
    public void repay_or_finalize_the_loan(String repayment_type, String loan_account_number) {
        repayAndFinalizeTheLoan.choose_repayment_type(repayment_type);
        repayAndFinalizeTheLoan.input_loan_account_number(loan_account_number);
        transactionApproval = repayAndFinalizeTheLoan.click_Continue_button();
    }

    @And("Thực hiện {string}, chọn tài khoản vay {string} từ address book")
    public void repay_or_finalize_the_loan_using_loan_account_address_book(String repayment_type,
                                                                           String loan_account_number) {
        repayAndFinalizeTheLoan.choose_repayment_type(repayment_type);
        repayAndFinalizeTheLoan.choose_loan_account_number_from_load_account_address_book(
                loan_account_number);
        transactionApproval = repayAndFinalizeTheLoan.click_Continue_button();
    }

    @And("Thực hiện {string}, tài khoản vay {string}, số tiền phải trả {string}")
    public void repay_or_finalize_the_loan(String repayment_type, String loan_account_number,
                                           String repayment_money) {
        repayAndFinalizeTheLoan.choose_repayment_type(repayment_type);
        repayAndFinalizeTheLoan.input_loan_account_number(loan_account_number);
        repayAndFinalizeTheLoan.input_repayment_money(repayment_money);
        transactionApproval = repayAndFinalizeTheLoan.click_Continue_button();
    }

    @And("Thực hiện {string}, chọn tài khoản vay {string} từ address book, số tiền phải trả {string}")
    public void repay_or_finalize_the_loan_using_loan_account_address_book(String repayment_type,
                                                                           String loan_account_number,
                                                                           String repayment_money) {
        repayAndFinalizeTheLoan.choose_repayment_type(repayment_type);
        repayAndFinalizeTheLoan.choose_loan_account_number_from_load_account_address_book(
                loan_account_number);
        repayAndFinalizeTheLoan.input_repayment_money(repayment_money);
        transactionApproval = repayAndFinalizeTheLoan.click_Continue_button();
    }

    @And("Thực hiện {string}, tài khoản vay {string}, tài khoản nguồn trả nợ {string}, số tiền phải trả {string}")
    public void repay_or_finalize_the_loan(String repayment_type, String loan_account_number,
                                           String repayment_source_account_number, String repayment_money) {
        repayAndFinalizeTheLoan.choose_repayment_type(repayment_type);
        repayAndFinalizeTheLoan.input_loan_account_number(loan_account_number);
        repayAndFinalizeTheLoan.choose_repayment_source_account_number(repayment_source_account_number);
        repayAndFinalizeTheLoan.input_repayment_money(repayment_money);
        transactionApproval = repayAndFinalizeTheLoan.click_Continue_button();
    }

    @And("Thực hiện {string}, tài khoản nguồn trả nợ {string}")
    public void finalize_the_loan(String repayment_type,
                                  String repayment_source_account_number) {
        repayAndFinalizeTheLoan.choose_repayment_type(repayment_type);
        repayAndFinalizeTheLoan.input_loan_account_number(newestAccountNumber);
        repayAndFinalizeTheLoan.choose_repayment_source_account_number(repayment_source_account_number);
        transactionApproval = repayAndFinalizeTheLoan.click_Continue_button();
    }

    @And("Thấu chi không tài sản đảm bảo")
    public void move_to_Overdraft() {
        overdraft = loanAndCreditServices.click_overdraft();
    }

    @And("Thực hiện vay thấu chi không tài sản đảm bảo với số tiền là {string}, thời hạn vay là {string}, ngày trả nợ hàng tháng là {string}, mục đích vay {string}, không ưu đãi, email {string}, tỉnh {string}, huyện {string}")
    public void make_a_overdraft_loan_with(
            String numberOfMoney, String loanDuration, String repaymentDate, String loanPurpose,
            String email, String province, String district) {
        overdraftLoanProfileDetail = overdraft.click_Continue_button();
        overdraftLoanProfileDetail.inputLoanMoney(numberOfMoney);
        overdraftLoanProfileDetail.chooseLoanDuration(loanDuration);
        overdraftLoanProfileDetail.chooseARepaymentDate(repaymentDate);
        overdraftLoanProfileDetail.chooseLoanPurpose(loanPurpose);
        overdraftLoanProfileDetail.do_not_use_special_offer();
        overdraftLoanProfileDetail.click_Continue_button();
        overdraftLoanProfileDetail.chooseProvince(province);
        overdraftLoanProfileDetail.chooseDistrict(district);
        overdraftLoanProfileDetail.inputEmail(email);
        overdraftSuccessfullyAppraisal = overdraftLoanProfileDetail.click_Continue_button();
        transactionApproval = overdraftSuccessfullyAppraisal.confirmOverdraftLoanContract();
    }


    @And("Thấu chi có tài sản đảm bảo")
    public void move_to_Secured_Overdraft() {
        securedOverdraft = loanAndCreditServices.click_secured_overdraft();
    }


    @And("Thực hiện vay thấu chi online với số giấy tờ tùy thân {string}, email nhận hợp đồng {string}, tài khoản được cấp thấu chi {string}, số tiết kiêm đảm bảo {string}, số tiền vay {string}, mục đích vay {string}")
    public void make_a_secured_overdraft_loan_with(
            String id, String email, String overdraft_account_number, String banking_saving_book_number,
            String loanMoney, String loanPurpose) {
        onlineSecuredOverdraftLoan = securedOverdraft.click_Continue_button();
        onlineSecuredOverdraftLoan.input_Identification_Card(id);
        onlineSecuredOverdraftLoan.input_Email(email);
        onlineSecuredOverdraftLoan.choose_a_Overdraft_Account_Number(overdraft_account_number);
        onlineSecuredOverdraftLoan.choose_a_banking_saving_book_number(banking_saving_book_number);
        onlineSecuredOverdraftLoan.input_loan_money(loanMoney);
        onlineSecuredOverdraftLoan.choose_a_Loan_Purpose(loanPurpose);
        onlineSecuredOverdraftLoan.checkAgreement();
        onlineSecuredOverdraft_loanContractContent = onlineSecuredOverdraftLoan.click_Continue_button();
        transactionApproval = onlineSecuredOverdraft_loanContractContent.click_Continue_button();
    }
}
