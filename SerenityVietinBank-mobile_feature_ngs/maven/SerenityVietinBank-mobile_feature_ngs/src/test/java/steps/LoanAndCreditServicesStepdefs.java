package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import org.apache.commons.lang3.StringUtils;
import runner.Runner;
import screens.mobile.CalculatorTool;
import screens.mobile.LoanHistory;
import screens.mobile.LoanProfile;
import screens.mobile.LoanProfileDetail;
import screens.mobile.PersonalInstalmentLoan_Step1;
import screens.mobile.PersonalInstalmentLoan_Step2;
import screens.mobile.PersonalInstalmentLoan_Step3;
import screens.mobile.ReferenceRepaymentSchedule;

public class LoanAndCreditServicesStepdefs extends Runner {

  private ReferenceRepaymentSchedule referenceRepaymentSchedule;
  private CalculatorTool calculatorTool;
  private PersonalInstalmentLoan_Step1 personalInstalmentLoanStep1;
  private PersonalInstalmentLoan_Step2 personalInstalmentLoanStep2;
  private PersonalInstalmentLoan_Step3 personalInstalmentLoanStep3;
  private LoanHistory loanHistory;
  private LoanProfile loanProfile;
  private LoanProfileDetail loanProfileDetail;

  public LoanAndCreditServicesStepdefs() {
    super();
  }

  @Và("Vay tiêu dùng cá nhân")
  public void moveToPersonalInstalmentLoan() {
    personalInstalmentLoan = loanAndCreditServices.click_vay_tieu_dung_ca_nhan();
  }

  @Và("Công cụ tính lãi suất - Tính toán ngay")
  public void côngCụTínhLãiSuấtTínhToánNgay() {
    calculatorTool = personalInstalmentLoan.clickCalculateNow();
  }

  @Và("Vay {string} VND, thời hạn {string} tháng, {string}")
  public void makeLoanWith(String numberOfMoneyOrPercent,
      String monthsOrPercent, String editType) {
    calculatorTool.editNumberOfMoney(editType, numberOfMoneyOrPercent);
    calculatorTool.editNumberOfMonth(editType, monthsOrPercent);
    referenceRepaymentSchedule = calculatorTool.clickExpectedPaymentScheduleViewerButton();
  }

  @Thì("Lịch trả nợ - Lãi suất {string}")
  public void show_interest_rate_in_Reference_Payment_Schedule_as(String interestRate) {
    assertThat(referenceRepaymentSchedule.getInterestRate(), equalTo(interestRate));
  }

  @Và("Lịch trả nợ - Tổng tiền phải trả {string}")
  public void show_monthly_charge_amount_in_Reference_Payment_Schedule_as(
      String monthlyChargeAmount) {
    if(appiumDriver instanceof AndroidDriver) {
      assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
    } else {
      monthlyChargeAmount = StringUtils.remove(monthlyChargeAmount, "VND ");
      assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
    }

  }

  @Và("Lịch trả nợ - Tổng lãi phải trả {string}")
  public void show_interest_payable_total_in_Reference_Payment_Schedule_as(
      String interestPayableTotal) {
    assertThat(referenceRepaymentSchedule.getInterestPayableTotal(), equalTo(interestPayableTotal));
  }

  @Và("Lịch trả nợ - Tổng số tiền gốc và lãi phải trả {string}")
  public void show_principal_and_interest_payable_total_in_Reference_Payment_Schedule_as(
      String principalAndInterestPayableTotal) {
    assertThat(referenceRepaymentSchedule.getPrincipalAndInterestPayableTotal(),
        equalTo(principalAndInterestPayableTotal));
  }


  @Khi("MH Vay - Bước 1")
  public void move_to_Personal_Instalment_Loan_Step_1() {
    personalInstalmentLoanStep1 = referenceRepaymentSchedule.clickBorrowNow();
  }

  @Thì("MH Vay - Bước 1 - Lãi suất vay {string}")
  public void show_interest_rate_in_Personal_Instalment_Loan_Step_1_as(String interestRate) {
    assertThat(personalInstalmentLoanStep1.getInterestRate(), equalTo(interestRate));
  }

  @Và("MH Vay - Bước 1 - Số tiền phải trả hàng tháng mặc định {string}")
  public void show_monthly_charge_amount_in_Personal_Instalment_Loan_Step_1_as(
      String monthlyChargeAmount) {
    String actualMonthlyChargeAmount = "";
    if(appiumDriver instanceof AndroidDriver) {
      actualMonthlyChargeAmount = personalInstalmentLoanStep1.getMonthlyChargeAmount01().replaceAll("\n ", " ");
    } else {
      actualMonthlyChargeAmount = personalInstalmentLoanStep1.getMonthlyChargeAmount01() + " "
          + personalInstalmentLoanStep1.getMonthlyChargeAmount02();
    }
    assertThat(actualMonthlyChargeAmount, equalTo(monthlyChargeAmount));
  }

  @Khi("MH Vay - Bước 2")
  public void move_to_Personal_Instalment_Loan_Step_2() {
    personalInstalmentLoanStep2 = personalInstalmentLoanStep1.clickContinueButton();
  }

  @Và("MH Vay - Bước 2 - Ngày trả nợ hàng tháng {string}, mục đích vay {string}, tỉnh {string}, huyện {string}")
  public void select_repayment_date_and_loan_purpose_and_province_and_district_in_Personal_Instalment_Loan_Step_2(
      String date, String loanPurpose, String province, String district) {
    personalInstalmentLoanStep2.chooseARepaymentDate(date);
    personalInstalmentLoanStep2.chooseLoanPurpose(loanPurpose);
    personalInstalmentLoanStep2.chooseProvince(province);
    personalInstalmentLoanStep2.chooseDistrict(district);
    personalInstalmentLoanStep3 = personalInstalmentLoanStep2.clickContinueButton();
  }

  @Và("MH Vay - Bước 2 - Ngày trả nợ hàng tháng {string}, mục đích vay {string}, email {string}, tỉnh {string}, huyện {string}")
  public void select_repayment_date_and_loan_purpose_and_email_and_province_and_district_in_Personal_Instalment_Loan_Step_2(
      String date, String loanPurpose, String email, String province, String district) {
    personalInstalmentLoanStep2.chooseARepaymentDate(date);
    personalInstalmentLoanStep2.chooseLoanPurpose(loanPurpose);
    personalInstalmentLoanStep2.inputEmail(email);
    personalInstalmentLoanStep2.chooseProvince(province);
    personalInstalmentLoanStep2.chooseDistrict(district);
    personalInstalmentLoanStep3 = personalInstalmentLoanStep2.clickContinueButton();
  }

  @Thì("MH Vay - Bước 3 - Số tiền vay {string}")
  public void should_show_number_of_money_in_Personal_Instalment_Loan_Step_3(String numberOfMoney) {
    assertThat(personalInstalmentLoanStep3.getNumberOfMoney(), equalTo(numberOfMoney));
  }

  @Và("MH Vay - Bước 3 - Thời hạn vay {string}")
  public void should_show_loan_duration_in_Personal_Instalment_Loan_Step_3(String months) {
    assertThat(personalInstalmentLoanStep3.getMonths(), equalTo(months));
  }

  @Và("MH Vay - Bước 3 - Lãi suất dự kiến là {string}")
  public void should_show_interest_rate_in_Personal_Instalment_Loan_Step_3(String interestRate) {
    assertThat(personalInstalmentLoanStep3.getInterestRate(), equalTo(interestRate));
  }

  @Và("MH Vay - Bước 3 - Mục đích vay là {string}")
  public void should_show_loan_purpose_in_Personal_Instalment_Loan_Step_3(String loanPurpose) {
    assertThat(personalInstalmentLoanStep3.getLoanPurpose(), equalTo(loanPurpose));
  }

  @Và("MH Vay - Bước 3 - Ngày trả nợ hàng tháng {string}")
  public void should_show_repayment_date_in_Personal_Instalment_Loan_Step_3(String date) {
    assertThat(personalInstalmentLoanStep3.getRepaymentDate(), equalTo(date));
  }

  @Và("MH Vay - Bước 3 - họ và tên người vay {string}")
  public void should_show_borrow_name_in_Personal_Instalment_Loan_Step_3(String name) {
    assertThat(personalInstalmentLoanStep3.getBorrowName(), equalTo(name));
  }

  @Khi("Gửi yêu cầu vay")
  public void accept_information_terms_and_conditions_and_click_Send_button_in_Personal_Instalment_Loan_Step_3() {
    personalInstalmentLoanStep3.checkExactlyInformation();
    personalInstalmentLoanStep3.checkTermsAndConditions();
    personalInstalmentLoanStep3.clickSendButton();
  }

  @Thì("Thông báo {string}")
  public void should_show_notification_popup_on_Personal_Instalment_Loan_Step_3(String message) {
    assertThat(personalInstalmentLoanStep3.notificationPopup().getNotificationTitle(),
        containsString(message));
  }

  @Khi("Chọn Đồng ý trên Popup thông báo")
  public void click_Agree_button_on_notification_popup_on_Personal_Instalment_Loan_Step_3() {
    loanAndCreditServices = personalInstalmentLoanStep3.notificationPopup().clickAgreeButton();
  }

  @Thì("hiển thị số lượng tại Lịch sử vay")
  public void should_show_number_at_Loan_History_in_Loan_And_Credit_Service() {
    assertThat(Integer.parseInt(loanAndCreditServices.getNumberOfLoanDocument()),
        greaterThanOrEqualTo(1));
  }

  @Khi("Vào MH Lịch sử vay")
  public void move_to_Loan_history() {
    loanHistory = loanAndCreditServices.click_loan_history();
  }

  @Thì("Khoản vay {string}, số tiền {string}")
  public void should_show_loan_status_and_number_of_money(String status, String numberOfMoney) {
    assertThat(loanHistory.getStatusText(), equalTo(status));
    assertThat(loanHistory.getNumberOfLoanMoneyText(), containsString(numberOfMoney));
  }

  @Khi("Vào MH Vay tiêu dùng cá nhân")
  public void move_to_Loan_Profile() {
    loanProfile = loanHistory.clickConsumerLoan();
  }


  @Và("Mở Hồ sơ vay tiêu dùng cá nhân")
  public void move_to_Loan_Profile_detail() {
    loanProfileDetail = loanProfile.viewLoanProfileDetail();
  }

  @Thì("Hồ sơ vay tiêu dùng cá nhân - Số tiền vay {string}")
  public void should_show_number_of_money_in_Loan_Profile_Detail(String money) {
    assertThat(loanProfileDetail.getNumberOfMoney(), equalTo(money));
  }

  @Và("Hồ sơ vay tiêu dùng cá nhân - Thời hạn vay {string}")
  public void should_show_loan_duration_in_Loan_Profile_Detail(String numberOfMonths) {
    assertThat(loanProfileDetail.getMonths(), equalTo(numberOfMonths));
  }


  @Và("Hồ sơ vay tiêu dùng cá nhân - Ngày trả nợ hàng tháng {string}")
  public void should_show_repayment_date_in_Loan_Profile_Detail(String date) {
    assertThat(loanProfileDetail.getRepaymentDate(), equalTo(date));
  }

  @Và("Hồ sơ vay tiêu dùng cá nhân - Mục đích vay {string}")
  public void should_show_loan_purpose_in_Loan_Profile_Detail(String loadPurpose) {
    assertThat(loanProfileDetail.getLoanPurpose(), equalTo(loadPurpose));
  }


  @Và("Hồ sơ vay tiêu dùng cá nhân - Họ và tên ngươi vay {string}")
  public void should_show_borrow_full_name_in_Loan_Profile_Detail(String fullName) {
    assertThat(loanProfileDetail.getBorrowName(), equalTo(fullName));
  }

  @Và("Hồ sơ vay tiêu dùng cá nhân - Email nhận hợp đồng {string}")
  public void should_show_email_in_Loan_Profile_Detail(String email) {
    assertThat(loanProfileDetail.getEmail(), equalTo(email));
  }
}
