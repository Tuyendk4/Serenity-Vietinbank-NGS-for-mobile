package vn.vietinbank.mobile.steps.iPay.Transfer;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Transfer.TransferAndReceiveMoneyScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TransferAndReceiveMoneySteps {

    TransferAndReceiveMoneyScreen transferAndReceiveMoneyScreen = new TransferAndReceiveMoneyScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("hiển thị MH Chuyển trong & ngoài HT")
    public void hien_thi_mh_chuyen_trong_va_ngoai_ht() {
        assertThat(transferAndReceiveMoneyScreen.displayTransferAndReceiveMoneyTitle(), equalTo(true));
    }
}
