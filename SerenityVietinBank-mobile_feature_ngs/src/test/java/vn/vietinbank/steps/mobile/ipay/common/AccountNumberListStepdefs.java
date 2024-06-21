package vn.vietinbank.steps.mobile.ipay.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;

public class AccountNumberListStepdefs extends BaseStep {

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

  @Then("MH Danh sách tài khoản - Hiển thị khoản vay mới nhất với số tiền {string}")
  public void should_show_new_loan_account_and_loand_money(String numberOfMoney) {
//    numberOfMoney = numberOfMoney.replace(" VND", "");
    newestAccountNumber = accountNumberList.get_new_loan_account();
    assertThat(accountNumberList.get_money_of_new_loan_account(newestAccountNumber)).isEqualTo(
        numberOfMoney);
  }
}
