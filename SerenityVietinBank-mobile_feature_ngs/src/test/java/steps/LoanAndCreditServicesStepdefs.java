package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasToString;

import io.cucumber.java.vi.Khi;
import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import runner.Runner;
import screens.mobile.CalculatorTool;
import screens.mobile.LoanHistory;
import screens.mobile.PersonalInstalmentLoan_Step1;
import screens.mobile.PersonalInstalmentLoan_Step2;
import screens.mobile.PersonalInstalmentLoan_Step3;
import screens.mobile.ReferenceRepaymentSchedule;

public class LoanAndCreditServicesStepdefs extends Runner {

  private ReferenceRepaymentSchedule referenceRepaymentSchedule;
  private PersonalInstalmentLoan_Step1 personalInstalmentLoanStep1;
  private PersonalInstalmentLoan_Step2 personalInstalmentLoanStep2;
  private PersonalInstalmentLoan_Step3 personalInstalmentLoanStep3;
  private LoanHistory loanHistory;

  public LoanAndCreditServicesStepdefs() {
    super();
  }

  @Và("Chọn Vay tiêu dùng cá nhân")
  public void moveToPersonalInstalmentLoan() {
    personalInstalmentLoan = loanAndCreditServices.click_vay_tieu_dung_ca_nhan();
  }

  @Và("Thực hiện vay {string} VND bằng cách {string} trong vòng {string} tháng bằng cách {string}")
  public void makeLoanWith(String numberOfMoneyOrPercent, String moneyEditType,
      String monthsOrPercent, String monthEditType) {
    CalculatorTool calculatorTool = personalInstalmentLoan.clickCalculateNow();
    calculatorTool.editNumberOfMoney(moneyEditType, numberOfMoneyOrPercent);
    calculatorTool.editNumberOfMonth(monthEditType, monthsOrPercent);
    referenceRepaymentSchedule = calculatorTool.clickExpectedPaymentScheduleViewerButton();
  }

  @Thì("hiển thị lãi xuất trong Lịch trả nợ tham khảo là {string}")
  public void show_interest_rate_in_Reference_Payment_Schedule_as(String interestRate) {
    assertThat(referenceRepaymentSchedule.getInterestRate(), equalTo(interestRate));
  }

  @Và("hiển thị số tiền phải trả hàng tháng trong Lịch trả nợ tham khảo là {string}")
  public void show_monthly_charge_amount_in_Reference_Payment_Schedule_as(
      String monthlyChargeAmount) {
    assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
  }

  @Và("hiển thị tổng lãi phải trả trong Lịch trả nợ tham khảo là {string}")
  public void show_interest_payable_total_in_Reference_Payment_Schedule_as(
      String interestPayableTotal) {
    assertThat(referenceRepaymentSchedule.getInterestPayableTotal(), equalTo(interestPayableTotal));
  }

  @Và("hiển thị tổng số tiền gốc và lãi phải trả trong Lịch trả nợ tham khảo là {string}")
  public void show_principal_and_interest_payable_total_in_Reference_Payment_Schedule_as(
      String principalAndInterestPayableTotal) {
    assertThat(referenceRepaymentSchedule.getPrincipalAndInterestPayableTotal(),
        equalTo(principalAndInterestPayableTotal));
  }


  @Khi("di chuyển sang Vay Tín dụng Cá nhân - Bước 1")
  public void move_to_Personal_Instalment_Loan_Step_1() {
    personalInstalmentLoanStep1 = referenceRepaymentSchedule.clickBorrowNow();
  }

  @Thì("hiển thị lãi xuất trong Vay Tín dụng cá nhân - Bước 1 là {string}")
  public void show_interest_rate_in_Personal_Instalment_Loan_Step_1_as(String interestRate) {
    assertThat(personalInstalmentLoanStep1.getInterestRate(), equalTo(interestRate));
  }

  @Và("hiển thị số tiền phải trả hàng tháng trong Vay Tín dụng cá nhân - Bước 1 là {string}")
  public void show_monthly_charge_amount_in_Personal_Instalment_Loan_Step_1_as(
      String monthlyChargeAmount) {
    String actualMonthlyChargeAmount = personalInstalmentLoanStep1.getMonthlyChargeAmount01() + " "
        + personalInstalmentLoanStep1.getMonthlyChargeAmount02();
    assertThat(actualMonthlyChargeAmount, equalTo(monthlyChargeAmount));
  }

  @Khi("di chuyển sang Vay Tín dụng Cá nhân - Bước 2")
  public void move_to_Personal_Instalment_Loan_Step_2() {
    personalInstalmentLoanStep2 = personalInstalmentLoanStep1.clickContinueButton();
  }

  @Và("chọn ngày trả nợ hàng tháng là ngày {string}, mục đích vay {string}, tỉnh {string}, huyện {string} tại Vay Tín dụng Cá nhân - Bước 2")
  public void select_repayment_date_and_loan_purpose_and_province_and_district_in_Personal_Instalment_Loan_Step_2(
      String date, String loanPurpose, String province, String district) {
    personalInstalmentLoanStep2.chooseARepaymentDate(date);
    personalInstalmentLoanStep2.chooseLoanPurpose(loanPurpose);
    personalInstalmentLoanStep2.chooseProvince(province);
    personalInstalmentLoanStep2.chooseDistrict(district);
    personalInstalmentLoanStep3 = personalInstalmentLoanStep2.clickContinueButton();
  }

  @Thì("hiển thị số tiền vay là {string} trong Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_number_of_money_in_Personal_Instalment_Loan_Step_3(String numberOfMoney) {
    assertThat(personalInstalmentLoanStep3.getNumberOfMoney(), equalTo(numberOfMoney));
  }

  @Và("hiển thị thời hạn vay là {string} trong Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_loan_duration_in_Personal_Instalment_Loan_Step_3(String months) {
    assertThat(personalInstalmentLoanStep3.getMonths(), equalTo(months));
  }

  @Và("hiển thị lãi suất dự kiến là {string} trong Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_interest_rate_in_Personal_Instalment_Loan_Step_3(String interestRate) {
    assertThat(personalInstalmentLoanStep3.getInterestRate(), equalTo(interestRate));
  }

  @Và("hiển thị mục đích vay là {string} trong Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_loan_purpose_in_Personal_Instalment_Loan_Step_3(String loanPurpose) {
    assertThat(personalInstalmentLoanStep3.getLoanPurpose(), equalTo(loanPurpose));
  }

  @Và("hiển thị ngày trả nợ hàng tháng là ngày {string} trong Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_repayment_date_in_Personal_Instalment_Loan_Step_3(String date) {
    assertThat(personalInstalmentLoanStep3.getRepaymentDate(), equalTo(date));
  }

  @Và("hiển thị họ và tên người vay là {string} trong Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_borrow_name_in_Personal_Instalment_Loan_Step_3(String name) {
    assertThat(personalInstalmentLoanStep3.getBorrowName(), equalTo(name));
  }

  @Khi("thực hiện gửi yêu cầu vay trong Vay Tín dụng Cá nhân - Bước 3")
  public void accept_information_terms_and_conditions_and_click_Send_button_in_Personal_Instalment_Loan_Step_3() {
    personalInstalmentLoanStep3.checkExactlyInformation();
    personalInstalmentLoanStep3.checkTermsAndConditions();
    personalInstalmentLoanStep3.clickSendButton();
  }

  @Thì("hiển thị thông báo {string} trên Vay Tín dụng Cá nhân - Bước 3")
  public void should_show_notification_popup_on_Personal_Instalment_Loan_Step_3(String message) {
    assertThat(personalInstalmentLoanStep3.notificationPopup().getNotificationTitle(), hasToString(message));
  }

  @Khi("thực hiện đồng ý trên popup thông báo trong Vay Tín dụng Cá nhân - Bước 3")
  public void click_Agree_button_on_notification_popup_on_Personal_Instalment_Loan_Step_3() {
    loanAndCreditServices = personalInstalmentLoanStep3.notificationPopup().clickAgreeButton();
  }

  @Thì("hiển thị số lượng tại Lịch sử vay trong Dịch vụ vay và tín dụng")
  public void should_show_number_at_Loan_History_in_Loan_And_Credit_Service() {
    assertThat(Integer.parseInt(loanAndCreditServices.getNumberOfLoanDocument()), greaterThanOrEqualTo(1));
  }

  @Khi("truy cập vào Lịch sử vay")
  public void move_to_Loan_history() {
    loanHistory = loanAndCreditServices.click_loan_history();
  }

  @Thì("hiển thị khoản vay tiêu dùng có trạng thái {string} với số tiền vay là {string}")
  public void should_show_loan_status_and_number_of_money(String status, String numberOfMoney) {
    assertThat(loanHistory.getStatusText(), equalTo(status));
    assertThat(loanHistory.getNumberOfLoanMoneyText(), hasToString(numberOfMoney));
  }
}
