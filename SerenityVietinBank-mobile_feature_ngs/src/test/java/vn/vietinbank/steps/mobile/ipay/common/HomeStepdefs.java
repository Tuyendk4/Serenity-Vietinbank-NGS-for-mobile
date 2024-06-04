package vn.vietinbank.steps.mobile.ipay.common;

import io.cucumber.java.en.And;
import runner.Runner;
import vn.vietinbank.steps.mobile.ipay.base.M7S01BaseStep;

public class HomeStepdefs extends M7S01BaseStep {

  public HomeStepdefs() {
    super();
  }

  @And("Menu Dịch vụ vay và tín dụng")
  public void moveToLoanAndCreditServices() {
    loanAndCreditServices = home.favoriteServices().click_dich_vu_vay_va_tin_dung();
  }

  @And("Vào Danh sách tài khoản")
  public void move_to_Account_Number_List() {
    accountNumberList = home.move_to_AccountNumberList();
  }
}
