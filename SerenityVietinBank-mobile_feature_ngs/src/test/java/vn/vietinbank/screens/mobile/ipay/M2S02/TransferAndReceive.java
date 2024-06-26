package vn.vietinbank.screens.mobile.ipay.M2S02;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import vn.vietinbank.screens.mobile.base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;

import javax.validation.constraints.AssertFalse;
import java.time.Duration;
import java.util.List;


public class TransferAndReceive extends TransferElements {

    public TransferAndReceive(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public String replaceXpath(String xpath, String value) {
        return xpath.replace("%value", value);
    }

    public void choose_receiving_bank(String code_swift) {
        TransferElements.iconLineEditPencil.click();
        TransferElements.icon_receiving_bank_country_code.click();
        TransferElements.title_find.sendKeys("JP");
        TransferElements.title_JAPAN.click();
        TransferElements.code_swift_bank.click();
    }

    public void enter_infomation_beneficiary() {
        btn_beneficiary.click();
        title_account_number.click();
        title_account_number.sendKeys("01132342598768");
        title_recipient_name.click();
        title_recipient_name.sendKeys("duc");
        title_address.click();
        title_address.sendKeys("cau giay");
        title_done.click();
        btnSaveContinue.click();
    }

    @Step
    public void click_on_transfer_money_obroad() {
        (btnTranferMoneyObroad).click();
    }

    public void purpose_transfer(String value) {
        txtPurpose.click();
        switch (value) {
            case "Sinh hoạt phí du học":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "1"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "1"), 10);
                }
                break;
            case "Chuyển tiền trả các loại phí, lệ phí cho nước ngoài":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "2"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "2"), 10);
                }
                break;
            case "Trợ cấp cho thân nhân ở nước ngoài":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "3"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "3"), 10);
                }
                break;
            case "Đặt cọc tiền khám chữa bệnh ở nước ngoài":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "4"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "4"), 10);
                }
                break;
            case "Viện phí khám chữa bệnh ở nước ngoài":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "5"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "5"), 10);
                }
                break;
            case "Sinh hoạt phí khám chữa bệnh ở nước ngoài":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "6"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "6"), 10);
                }
                break;
            case "Đặt cọc du học":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "7"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "7"), 10);
                }
                break;
            case "Học phí du học":
                if (appiumDriver instanceof AndroidDriver) {
                    tap(replaceXpath(and_purpose, "8"), 10);
                } else {
                    tap(replaceXpath(ios_purpose, "8"), 10);
                }
                break;
        }
        Serenity.setSessionVariable("purpose_transfer").to(value);
        click(btnMakeNewPayment);
    }

    @Step
    public TransferAndReceive other_oversear_payment() {
        tap(txtPurpose);
        txt_other_oversear_payment.click();
        Serenity.setSessionVariable("purpose_transfer").to(txt_popure_used.getText());
        click(btnMakeNewPayment);
        return new TransferAndReceive(this.appiumDriver);
    }

    public void chooseBeneficiary(String paymentNote) {
        click(iconBeneficiary);
        click(txtBeneficiaryAccount);
        String get_beneficiary = title_beneficiary.getText();
        String get_receiving_bank = receiving_bank.getText();
        Serenity.setSessionVariable("get_beneficiary").to(get_beneficiary);
        Serenity.setSessionVariable("get_receiving_bank").to(get_receiving_bank);
        scrollTo(txt_payment_note);
        if (appiumDriver instanceof AndroidDriver) {
            sendKeys(txtPaymentNote, paymentNote);
        } else {
            tap(txtPaymentNote);
            sendKeys(txtPaymentNote, paymentNote);
        }
        click(done);
        click(btnSaveContinue);
    }

    public void enterPaymentAmount(String money) {
        tap(paymentAmount);
        sendKeys(paymentAmount, money);
        Serenity.setSessionVariable("total_transfer").to(money);
        if (appiumDriver instanceof AndroidDriver) {
            click(txtNumberExchangedMoney);
        }
        click(btn_done);
        waitForElementVisible(btn_continue, 20);
        if (appiumDriver instanceof AndroidDriver) {
            scrollDownElement(txt_total_debt_deduction);
            scrollDownElement(txt_total_debt_deduction);
        } else {
            scrollToElement(txt_total_debt_deduction, ScrollDirection.DOWN, 20);
        }
        String total_debt_deduction = (number_total_debt_deduction).getText();
        Serenity.setSessionVariable("total_debt_deduction").to(total_debt_deduction);
        click(btn_continue);
    }

    public void scrollDownElement(WebElement elementParent) {
        int startPointY = elementParent.getLocation().getY() + elementParent.getSize().getHeight() / 2;
        int endPointY = elementParent.getLocation().getY();
        int anchorX = elementParent.getLocation().getX() + elementParent.getSize().getWidth() / 4;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(anchorX, startPointY);
        Point end = new Point(anchorX, endPointY);
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(List.of(swipe));
    }

    public void provisioning_profile() {
        if (appiumDriver instanceof AndroidDriver) {
            click(icon_add_profile);
            click(select_from_library);
            for (int i = 1; i <= 2; i++) {
                image.get(i).click();
            }
            btnAdd.click();
        } else {
            for (int i = 1; i <= 2; i++) {
                click(icon_add_profile);
                click(select_from_library);
                image.get(i).click();
            }
        }
        click(btn_continue);
        click(confirm_done);
    }

    public TransferAndReceive verifyTransactionConfirmation() {
        String[] get_number_to_transfer_split = number_to_transfer_history.getText().split(" ");
        String get_number_to_transfer = get_number_to_transfer_split[0];
        String get_receiving_bank_confirm = receiving_bank.getText();
        String get_beneficiary_confirm = title_beneficiary.getText();
        String[] get_debt_amount_split = debt_amount.getText().split(" ");
        String get_debt_amount = get_debt_amount_split[0];
        String get_content = content.getText();
        String[] total_debt_deduction_split = Serenity.sessionVariableCalled("total_debt_deduction").toString().split(" ");
        String total_debt_deduction = total_debt_deduction_split[0];

        assert (get_number_to_transfer.equals(Serenity.sessionVariableCalled("total_transfer")));
        assert (get_receiving_bank_confirm.equals(Serenity.sessionVariableCalled("get_receiving_bank")));
        assert (get_beneficiary_confirm.equals(Serenity.sessionVariableCalled("get_beneficiary")));
        assert (get_debt_amount.equals(total_debt_deduction));
        assert (get_content.equals("Test"));

        return new TransferAndReceive(this.appiumDriver);
    }

    public TransferAndReceive verifyTransferAndReceive() {
        scrollTo(view_history);
        click(txt_view_history);
        tap(txt_list_history);
        String[] number_to_transfer_split = number_to_transfer_history.getText().split(" ");
        String number_to_transfer = number_to_transfer_split[0];
        String[] debt_amount_split = debt_amount_history.getText().split(" ");
        String debt_amount = debt_amount_split[0];
        String[] total_debt_deduction_split = Serenity.sessionVariableCalled("total_debt_deduction").toString().split(" ");
        String total_debt_deduction = total_debt_deduction_split[0];

        assert (txt_status.getText().contains("Chờ ngân hàng xử lý"));
        assert (purpose_trading_results.getText().equals(Serenity.sessionVariableCalled("purpose_transfer")));
        assert (number_to_transfer.equals(Serenity.sessionVariableCalled("total_transfer")));
        assert (debt_amount.equals(total_debt_deduction));
        return new TransferAndReceive(this.appiumDriver);
    }
}
