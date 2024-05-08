package steps;

import io.cucumber.java.en.And;
import runner.Runner;
import screens.mobile.LoanAndCreditServices;

public class HomeSteps extends Runner {
    public HomeSteps() {
        super();
    }

    @And("move to Loan And Credit Services")
    public void moveToLoanAndCreditServices() {
        LoanAndCreditServices loanAndCreditServices = home.favoriteServices().clickLoanAndCreditServices();
    }
}
