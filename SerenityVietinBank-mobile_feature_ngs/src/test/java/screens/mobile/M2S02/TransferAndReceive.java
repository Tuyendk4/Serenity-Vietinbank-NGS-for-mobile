package screens.mobile.M2S02;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

import static screens.mobile.M2S02.TransferAndReceiveElements.*;

public class TransferAndReceive extends BaseScreen {

    public TransferAndReceive(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    String total_transfer;
    String total_debt_deduction;

    public TransferAndReceive click_on_transfer_money_obroad() {
        click(btnTranferMoneyObroad);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive purpose_transfer() {
        tap(txtPurpose);
        tap(txtLivingExpenses);
        click(btnMakeNewPayment);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive chooseBeneficiary() {
        click(iconBeneficiary);
        click(txtBeneficiaryAccount);
        scrollTo(txt_payment_note);
        tap(txtPaymentNote);
        sendKeys(txtPaymentNote, "Test");
        click(done);
        click(btnSaveContinue);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive enterPaymentAmount(String money) {
        sendKeys(paymentAmount, money);
        click(btn_done);
        waitForElementVisible(btn_continue, 20);
        scrollToElement(txt_total_debt_deduction, ScrollDirection.DOWN, 20);
        total_debt_deduction = (number_total_debt_deduction).getText();
        click(btn_continue);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive provisioning_profile() {
        for (int i = 1; i <= 2; i++) {
            click(icon_add_profile);
            click(select_from_library);
            findElements(String.valueOf(image)).get(i).click();
        }
        click(btn_continue);
        click(confirm_done);
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive verifyTradingResoult(){
        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive verifyTransferAndReceive(){

        return new TransferAndReceive(this.appiumDriver);
    }
}
