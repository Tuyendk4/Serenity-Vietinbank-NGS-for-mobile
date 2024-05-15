package steps;

import io.cucumber.java.vi.Và;
import runner.Runner;

public class HomeStepdefs extends Runner {

  public HomeStepdefs() {
    super();
  }

  @Và("Menu Dịch vụ vay và tín dụng")
  public void moveToLoanAndCreditServices() {
    loanAndCreditServices = home.favoriteServices().click_dich_vu_vay_va_tin_dung();
  }
}
