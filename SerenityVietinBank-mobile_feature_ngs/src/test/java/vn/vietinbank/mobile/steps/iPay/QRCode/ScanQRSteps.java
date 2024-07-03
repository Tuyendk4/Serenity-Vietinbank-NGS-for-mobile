package vn.vietinbank.mobile.steps.iPay.QRCode;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.QRCode.ScanQRScreen;

public class ScanQRSteps {

    ScanQRScreen scanQRScreen = new ScanQRScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("chọn ảnh thứ {string} trong album {string} đến MH Chuyển ngoài HT")
    public void chon_anh_thu_trong_album_den_mh_chuyen_ngoai_ht(String index, String albumName) {
        scanQRScreen.chooseImageInAlbumByIndex(index, albumName);
    }

    @And("chọn ảnh thứ {string} trong album mặc định đến MH Chuyển trong HT")
    public void chon_anh_thu_trong_album_mac_dinh_den_mh_chuyen_trong_ht(String index) {
        scanQRScreen.chooseImageInAlbumDefaultByIndex(index);
    }

    @And("chọn ảnh thứ {string} trong album mặc định đến MH Thanh toán QR")
    public void chon_anh_thu_trong_album_mac_dinh_den_mh_thanh_toan_qr(String index) {
        scanQRScreen.chooseImageQRInAlbumDefaultByIndex(index);
    }
}
