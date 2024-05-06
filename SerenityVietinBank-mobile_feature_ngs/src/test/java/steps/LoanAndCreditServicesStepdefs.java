package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.cucumber.java.vi.Thì;
import io.cucumber.java.vi.Và;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import runner.Runner;
import screens.mobile.CalculatorTool;
import screens.mobile.ReferenceRepaymentSchedule;

public class LoanAndCreditServicesStepdefs extends Runner {

  private ReferenceRepaymentSchedule referenceRepaymentSchedule;

  public LoanAndCreditServicesStepdefs() {
    super();
  }

  @Và("Chọn Vay tiêu dùng cá nhân")
  public void moveToPersonalInstalmentLoan() {
    personalInstalmentLoan = loanAndCreditServices.click_vay_tieu_dung_ca_nhan();
  }

  @Và("Thực hiện vay {string} VND(%) bằng cách {string} trong vòng {string} tháng(%) bằng cách {string}")
  public void makeLoanWith(String numberOfMoneyOrPercent, String moneyEditType,
      String monthsOrPercent, String monthEditType) {
    CalculatorTool calculatorTool = personalInstalmentLoan.clickCalculateNow();
    calculatorTool.editNumberOfMoney(moneyEditType, numberOfMoneyOrPercent);
    referenceRepaymentSchedule = calculatorTool.editNumberOfMonth(monthEditType, monthsOrPercent);
  }

  @Thì("hiển thị lãi xuất trong Lịch trả nợ tham khảo là {string}")
  public void show_interest_rate_in_Reference_Payment_Schedule_as(String interestRate) {
    assertThat(referenceRepaymentSchedule.getInterestRate(), equalTo(interestRate));
  }

  @Và("hiển thị số tiền phải trả hàng tháng trong Lịch trả nợ tham khảo là {string}")
  public void show_monthly_charge_amount_in_Reference_Payment_Schedule_as(String monthlyChargeAmount) {
    assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
  }

  @Và("hiển thị tổng lãi phải trả trong Lịch trả nợ tham khảo là {string}")
  public void show_interest_payable_total_in_Reference_Payment_Schedule_as(String interestPayableTotal) {
    assertThat(referenceRepaymentSchedule.getInterestPayableTotal(), equalTo(interestPayableTotal));
  }

  @Và("hiển thị tổng số tiền gốc và lãi phải trả trong Lịch trả nợ tham khảo là {string}")
  public void show_principal_and_interest_payable_total_in_Reference_Payment_Schedule_as(String principalAndInterestPayableTotal) {
    assertThat(referenceRepaymentSchedule.getPrincipalAndInterestPayableTotal(), equalTo(principalAndInterestPayableTotal));
    mobileDriver.closeApplication();
  }
}
