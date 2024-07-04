package vn.vietinbank.mobile.steps.iPay.Transfer;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Transfer.TransferMoneyOutsideSystemScreen;
import vn.vietinbank.mobile.screens.iPay.Transfer.TransferMoneyScreen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TransferMoneyOutsideSystemSteps {

    AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");
    TransferMoneyOutsideSystemScreen transferMoneyOutsideSystemScreen = new TransferMoneyOutsideSystemScreen(appiumDriver);
    TransferMoneyScreen transferMoneyScreen = new TransferMoneyScreen(appiumDriver);

    @Then("hiển thị tên người nhận {string} trên MH Chuyển ngoài HT")
    public void hien_thi_ten_nguoi_nhan_tren_mh_chuyen_ngoai_ht(String receiverName) {
        assertThat(transferMoneyOutsideSystemScreen.displayReceiverName(receiverName), equalTo(true));
    }

    @And("nhập số tiền để chuyển ngoài HT {string}")
    public void nhap_so_tien_de_chuyen_ngoai_ht(String amount) {
        transferMoneyOutsideSystemScreen.inputAmount(amount);
    }

    @And("ẩn bàn phím trên MH Chuyển ngoài HT")
    public void an_ban_phim_tren_mh_chuyen_ngoai_ht() {
        transferMoneyOutsideSystemScreen.clickHideKeyboardBtn();
    }

    @And("nhấn Tiếp tục đến MH Chuyển ngoài HT")
    public void nhan_tiep_tuc_den_mh_chuyen_ngoai_ht() {
        transferMoneyScreen.clickContinueBtn();
    }

    @And("nhấn Tiếp tục trên MH Chuyển ngoài HT sau khi nhập số tiền đến MH Xác nhận GD")
    public void nhan_tiep_tuc_tren_mh_chuyen_ngoai_ht_sau_khi_nhap_so_tien_den_mh_xac_nhan_gd() {
        transferMoneyOutsideSystemScreen.clickContinueBtnAfterInputAmount();
    }

    @And("bỏ chọn Tham gia bảo hiểm an ninh mạng trên MH Chuyển ngoai HT")
    public void bo_chon_tham_gia_bao_hiem_an_ninh_mang_tren_mh_chuyen_ngoai_ht() {
        transferMoneyOutsideSystemScreen.uncheckInsurance();
    }
}
