package vn.vietinbank.mobile.steps.iPay.Gifts.Flowers;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.DetailInfoFlowerScreen;

public class DetailInfoFlowerSteps {

    DetailInfoFlowerScreen detailInfoFlowerScreen = new DetailInfoFlowerScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("{string} số lượng {string} bó hoa")
    public void so_luong_hoa(String type, String volume) {
        detailInfoFlowerScreen.changeVolume(type, volume);
    }

    @And("nhấn Thêm vào giỏ đến MH Giỏ hàng hoa tươi")
    public void nhan_them_vao_gio_hang_den_mh_gio_hang_hoa_tuoi() {
        detailInfoFlowerScreen.clickAddToCart();
    }
}
