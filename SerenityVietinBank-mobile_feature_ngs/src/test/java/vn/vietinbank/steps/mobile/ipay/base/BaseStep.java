package vn.vietinbank.steps.mobile.ipay.base;

import io.appium.java_client.AppiumDriver;
import vn.vietinbank.screens.mobile.base.MobileDriver;
import vn.vietinbank.screens.mobile.ipay.M2S02.TransferAndReceive;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AccountList.AccountListPage;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AccountList.CreditAccountPage;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AllServices.AllServicesPage;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.AllServices.TraGopOnlineAllServices;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch.BySearch;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch.TapResultBySearch;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices.*;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher.EVoucher;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher.OrderVoucher;
import vn.vietinbank.screens.mobile.ipay.ipay_common.AccountNumberList;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home;
import vn.vietinbank.screens.mobile.ipay.ipay_common.HomeSearch;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Login;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanAndCreditServices;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.PersonalInstalmentLoan;

public class BaseStep {
    protected static MobileDriver mobileDriver;

    protected static AppiumDriver appiumDriver;

    protected static Login login;

    protected static Home home;
    protected static LoanAndCreditServices loanAndCreditServices;

    protected static PersonalInstalmentLoan personalInstalmentLoan;

    protected static AccountNumberList accountNumberList;
    protected static String newestAccountNumber;
    protected static TransferAndReceive transferAndReceive;
    protected static AllServicesPage allServicesPage;

    protected static CardList cardList;

    protected static CardDetails cardDetails;

    protected static EligibleTransactions eligibleTransactions;

    protected static InstallmentIntro installmentIntro;

    protected static InstallmentTransactionDetail installmentTransactionDetail;

    protected static ResultPage resultPage;

    protected static OTPCC oTPCC;

    protected static TraGopOnlineAllServices traGopOnlineAllServices;

    protected static HomeSearch homeSearch;

    protected static BySearch bySearch;

    protected static TapResultBySearch tapResultBySearch;

    protected static InstallmentTransactionManagement installmentTransactionManagement;

    protected static TransactionDetails transactionDetails;

    protected static AccountListPage accountListPage;

    protected static CreditAccountPage creditAccountPage;

    protected static EVoucher eVoucher;

    protected static OrderVoucher orderVoucher;


}
