package vn.vietinbank.mobile.steps.iPay.Accounts;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Accounts.ListAccountsScreen;
import vn.vietinbank.mobile.screens.iPay.Home.HomeScreen;
import vn.vietinbank.utils.data.GetData;

public class AccountSteps {

    ListAccountsScreen listAccountsScreen = new ListAccountsScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("chuyển bằng {string} {string}")
    public void chuyen_bang(String key, String value) {
        value = new GetData().getDataFromMultipleSources(key, value);
        listAccountsScreen.moveToAccountNumber(value);
    }

    @And("MH Danh sách tài khoản - Lấy tài khoản vay mới nhất")
    public String get_newest_account_number() {
        String newestAccountNumber = listAccountsScreen.get_new_loan_account();
        Serenity.setSessionVariable("newestAccountNumber").to(newestAccountNumber);
        return newestAccountNumber;
    }

    @And("MH Home")
    public HomeScreen back_to_Home() {
        return listAccountsScreen.back_to_Home();
    }

    @And("MH Danh sách tài khoản - Xem các tài khoản vay")
    public void view_loan_accounts() {
        listAccountsScreen.expand_Loan_Account();
    }

    @Then("MH Danh sách tài khoản - Hiển thị khoản vay mới nhất với số tiền {string}")
    public void should_show_new_loan_account_and_loand_money(String numberOfMoney) {
//      numberOfMoney = numberOfMoney.replace(" VND", "");
        String newestAccountNumber = listAccountsScreen.get_new_loan_account();
        assertThat(listAccountsScreen.get_money_of_new_loan_account(newestAccountNumber)).isEqualTo(
            numberOfMoney);
    }
}
