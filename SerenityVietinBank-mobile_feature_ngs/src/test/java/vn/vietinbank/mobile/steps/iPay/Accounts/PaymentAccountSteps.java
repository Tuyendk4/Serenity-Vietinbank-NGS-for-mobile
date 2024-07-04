package vn.vietinbank.mobile.steps.iPay.Accounts;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Accounts.PaymentAccountScreen;

public class PaymentAccountSteps {

    PaymentAccountScreen paymentAccountScreen = new PaymentAccountScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("đến MH Chuyển trong & ngoài HT")
    public void den_mh_chuyen_trong_va_ngoai_ht() {
        paymentAccountScreen.moveToTransferMoneyInsideAndOutsideSystemScreen();
    }
}
