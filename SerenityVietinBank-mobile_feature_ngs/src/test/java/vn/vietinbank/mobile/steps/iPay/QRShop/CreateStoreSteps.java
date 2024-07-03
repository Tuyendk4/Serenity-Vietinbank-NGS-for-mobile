package vn.vietinbank.mobile.steps.iPay.QRShop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.QRShop.CreateStoreScreen;

public class CreateStoreSteps {

    CreateStoreScreen createStoreScreen = new CreateStoreScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @Then("hiển thị MH Tạo cửa hàng")
    public void hien_thi_mh_tao_cua_hang() {
        createStoreScreen.createStoreScreenDisplayed();
    }

    @And("nhập tên cửa hàng {string}")
    public void nhap_ten_cua_hang(String storeName) {
        createStoreScreen.inputStoreName(storeName);
    }

    @And("chọn lĩnh vực kinh doanh {string}")
    public void chon_linh_vuc_kinh_doanh(String business) {
        createStoreScreen.chooseBusinessField(business);
    }

    @And("chọn tài khoản nhận tiền {string}")
    public void chon_tai_khoan_nhan_tien(String account) {
        createStoreScreen.selectAccountNumberToReceiveMoney(account);
    }

    @And("chọn tỉnh - thành phố {string}")
    public void chon_tinh_thanh_pho(String city) {
        createStoreScreen.chooseProvince(city);
    }

    @And("chọn quận huyện {string}")
    public void chon_quan_huyen(String district) {
        createStoreScreen.chooseDistrict(district);
    }

    @And("chọn phường - xã {string}")
    public void chon_phuong_xa(String ward) {
        createStoreScreen.chooseWard(ward);
    }

    @And("nhập địa chỉ {string}")
    public void nhap_dia_chi(String address) {
        createStoreScreen.inputAddress(address);
    }

    @And("nhấn nút Xác nhận")
    public void nhan_nut_xac_nhan() {
        createStoreScreen.clickConfirmBtn();
    }

    @Then("tạo cửa hàng thành công")
    public void tao_cua_hang_thanh_cong() {
        createStoreScreen.doneBtnDisplayed();
    }

    @Then("kiểm tra tên cửa hàng hiển thị {string}")
    public void kiem_tra_ten_cua_hang_hien_thi(String name) {
        createStoreScreen.verifyNameShopInput(name);
    }

    @And("chọn vào {string}")
    public void chon_vao(String field) {
        createStoreScreen.clickDynamicField(field);
    }

    @And("nhập nội dung tìm kiếm {string}")
    public void nhap_noi_dung_tim_kiem(String value) {
        createStoreScreen.inputSearchData(value);
    }

    @Then("kiểm tra dữ liệu đã hiển thị chứa {string}")
    public void kiem_tra_du_lieu_da_hien_thi_chua(String value) {
        createStoreScreen.verifyResponseSearch(value);
    }

    @And("chọn dữ liệu đầu tiên chứa {string}")
    public void chon_du_lieu_dau_tien_chua(String value) {
        createStoreScreen.clickFirstDataResponse(value);
    }

    @And("nhấn quay lại MH Quản lý cửa hàng")
    public void click_nut_back_tao_cua_hang_moi() {
        createStoreScreen.clickBackToButtonToShopManager();
    }
}