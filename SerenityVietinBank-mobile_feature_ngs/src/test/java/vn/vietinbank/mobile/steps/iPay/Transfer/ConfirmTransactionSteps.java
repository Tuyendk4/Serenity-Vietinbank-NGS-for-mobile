package vn.vietinbank.mobile.steps.iPay.Transfer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Transfer.ConfirmTransactionScreen;
import vn.vietinbank.utils.converter.Converter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ConfirmTransactionSteps {

    Converter converter = new Converter();
    ConfirmTransactionScreen confirmTransactionScreen = new ConfirmTransactionScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("nhấn Xác nhận & hoàn tất trên MH Xác nhận GD")
    public void nhan_xac_nhan_va_hoan_tat_tren_mh_xac_nhan_gd() {
        confirmTransactionScreen.clickConfirmAndCompleteBtn();
    }

    @And("hiển thị popup thông báo tạo lịch chuyển tiền thành công")
    public void hien_thi_popup_thong_bao_tao_lich_chuyen_tien_thanh_cong() {
        assertThat(confirmTransactionScreen.displayNotificationLabel(), equalTo(true));
        assertThat(confirmTransactionScreen.displayCreateASuccessfulTransferScheduleTxt(), equalTo(true));
    }

    @And("nhấn Đồng ý trên popup thông báo")
    public void nhan_dong_y_tren_popup_thong_bao() {
        confirmTransactionScreen.clickAgreeBtn();
    }

    @Then("hiển thị tên người nhận {string} và số tiền {string} trên MH Xác nhận GD")
    public void hien_thi_ten_nguoi_nhan_va_so_tien_tren_mh_xac_nhan_gd(String receiverName, String amount) {
        assertThat(confirmTransactionScreen.verifyConfirmTransactionLabel(), equalTo(true));
        assertThat(confirmTransactionScreen.getReceiverName(), containsString(receiverName));
        String amountStr = converter.format(amount, ",");
        assertThat(confirmTransactionScreen.getAmount(), containsString(amountStr));
    }
}
