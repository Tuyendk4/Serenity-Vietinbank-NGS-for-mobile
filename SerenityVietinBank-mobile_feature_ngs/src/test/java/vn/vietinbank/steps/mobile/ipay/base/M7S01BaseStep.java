package vn.vietinbank.steps.mobile.ipay.base;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.screens.mobile.base.MobileDriver;
import vn.vietinbank.screens.mobile.ipay.M2S02.TransferAndReceive;
import vn.vietinbank.screens.mobile.ipay.ipay_common.AccountNumberList;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Login;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanAndCreditServices;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.PersonalInstalmentLoan;

public class M7S01BaseStep {

  protected AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");

  protected static Login login;

  protected static Home home;

  protected static LoanAndCreditServices loanAndCreditServices;

  protected static AccountNumberList accountNumberList;

  protected static String newestAccountNumber;

  protected static TransferAndReceive transferAndReceive;

  protected static PersonalInstalmentLoan personalInstalmentLoan;

}
