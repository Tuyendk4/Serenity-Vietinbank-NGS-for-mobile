package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import runner.Runner;
import screens.mobile.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoanAndCreditServicesSteps extends Runner {

    private static Login login;
    private static Home home;
    private static LoanAndCreditServices loanAndCreditServices;
    private static PersonalInstalmentLoan personalInstalmentLoan;

    private ReferenceRepaymentSchedule referenceRepaymentSchedule;

    public LoanAndCreditServicesSteps() {
        super();
    }

    @And("move to Personal Instalment Loan")
    public void moveToPersonalInstalmentLoan() {
        personalInstalmentLoan = loanAndCreditServices.click_vay_tieu_dung_ca_nhan();
    }

    @And("make loan with {string} VND {string} in period {string} tháng with {string}")
    public void makeLoanWith(String numberOfMoneyOrPercent, String moneyEditType,
                             String monthsOrPercent, String monthEditType) {
        CalculatorTool calculatorTool = personalInstalmentLoan.clickCalculateNow();
        calculatorTool.editNumberOfMoney(moneyEditType, numberOfMoneyOrPercent);
        referenceRepaymentSchedule = calculatorTool.editNumberOfMonth(monthEditType, monthsOrPercent);
    }

    @Then("show interest rate in reference repayment schedule as {string}")
    public void showInterestRateInReferenceRepaymentScheduleAs(String interestRate) {
        assertThat(referenceRepaymentSchedule.getInterestRate(), equalTo(interestRate));
    }

    @And("show monthly charge amount in reference payment schedule as {string}")
    public void showMonthlyChargeAmountInReferencePaymentScheduleAs(String monthlyChargeAmount) {
        assertThat(referenceRepaymentSchedule.getMonthlyChargeAmount(), equalTo(monthlyChargeAmount));
    }

    @And("show interest payable total in reference payment schedule as {string}")
    public void showInterestPayableTotalInReferencePaymentScheduleAs(String interestPayableTotal) {
        assertThat(referenceRepaymentSchedule.getInterestPayableTotal(), equalTo(interestPayableTotal));
    }

    @And("show principal and interest payable total in reference payment schedule as {string}")
    public void showPrincipalAndInterestPayableTotalInReferencePaymentScheduleAs(String principalAndInterestPayableTotal) {
        assertThat(referenceRepaymentSchedule.getPrincipalAndInterestPayableTotal(), equalTo(principalAndInterestPayableTotal));
        mobileDriver.closeApplication();
    }
}
