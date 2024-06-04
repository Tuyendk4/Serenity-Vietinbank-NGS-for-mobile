package vn.vietinbank.steps.mobile.ipay.common;

import io.cucumber.java.en.And;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home;
import vn.vietinbank.steps.mobile.ipay.base.M7S01BaseStep;

public class AccountNumberListStepdefs extends M7S01BaseStep {

  @And("MH Danh sách tài khoản - Lấy tài khoản vay mới nhất")
  public String get_newest_account_number() {
    newestAccountNumber = accountNumberList.get_new_loan_account();
    return newestAccountNumber;
  }

  @And("MH Home")
  public void back_to_Home() {
    home = accountNumberList.back_to_Home();
  }

  @And("MH Danh sách tài khoản - Xem các tài khoản vay")
  public void view_loan_accounts() {
    accountNumberList.expand_Loan_Account();
  }
}
