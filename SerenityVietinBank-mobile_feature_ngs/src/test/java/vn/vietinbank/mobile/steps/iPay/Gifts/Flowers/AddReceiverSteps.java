package vn.vietinbank.mobile.steps.iPay.Gifts.Flowers;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.AddReceiverScreen;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.AddressReceiveFlowersScreen;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.OrderFlowersScreen;

public class AddReceiverSteps {

    AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");
    OrderFlowersScreen orderFlowersScreen = new OrderFlowersScreen(appiumDriver);
    AddReceiverScreen addReceiverScreen = new AddReceiverScreen(appiumDriver);
    AddressReceiveFlowersScreen addressReceiveFlowersScreen = new AddressReceiveFlowersScreen(appiumDriver);

    @And("chọn vào Thêm người nhận")
    public void chon_vao_them_nguoi_nhan() {
        orderFlowersScreen.clickAddReceiver();
    }

    @And("chọn người nhận thứ {string} trong danh sách")
    public void chon_nguoi_nhan_thu_trong_danh_sach(String index) {
        addReceiverScreen.clickListReceiverBtn();
        addressReceiveFlowersScreen.chooseAddressByIndex(index);
        addressReceiveFlowersScreen.clickConfirmBtn();
    }

    @And("chọn Hoa gửi tặng cho {string}")
    public void chon_hoa_gui_tang_cho(String relationship) {
        addReceiverScreen.chooseRelationship(relationship);
    }

    @And("chọn Giờ nhận hàng {string}")
    public void chon_gio_nhan_hang(String time) {
        addReceiverScreen.chooseTime(time);
    }

    @And("nhập lời nhắn cho người nhận {string}")
    public void nhap_loi_nhan_cho_nguoi_nhan(String message) {
        addReceiverScreen.inputMessage(message);
    }

    @And("nhập ghi chú cho nhà cung cấp {string}")
    public void nhap_ghi_chu_cho_nha_cung_cap(String note) {
        addReceiverScreen.inputNote(note);
    }

    @And("nhấn Thêm người nhận đến MH Đặt mua hoa")
    public void nhan_them_nguoi_nhan_den_mh_dat_mua_hoa() {
        addReceiverScreen.clickAddReceiverBtn();
    }
}
