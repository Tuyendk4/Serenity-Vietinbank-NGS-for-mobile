package vn.vietinbank.mobile.steps.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.QRShop.SearchTransactionsHistoryScreen;
import vn.vietinbank.mobile.screens.iPay.QRShop.ShareStoreScreen;
import vn.vietinbank.mobile.screens.iPay.QRShop.StoreInfoScreen;
import vn.vietinbank.mobile.screens.iPay.QRShop.StoreManagerScreen;

public class QrShopSteps {

    AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");
    StoreManagerScreen storeManagerScreen = new StoreManagerScreen(appiumDriver);
    SearchTransactionsHistoryScreen searchTransactionsHistoryScreen = new SearchTransactionsHistoryScreen(appiumDriver);
    StoreInfoScreen storeInfoScreen = new StoreInfoScreen(appiumDriver);
    ShareStoreScreen shareStoreScreen = new ShareStoreScreen(appiumDriver);

    @Then("hiển thị MH Quản lý cửa hàng")
    public void hien_thi_mh_quan_ly_cua_hang() {
        storeManagerScreen.storeManagerDisplayed();
    }

    @And("nhấn nút Tạo cửa hàng")
    public void nhan_nut_tao_cua_hang() {
        storeManagerScreen.clickCreateStoreBtn();
    }

    @And("chọn 1 cửa hàng đang hoạt động")
    public void chon_1_cua_hang_dang_hoat_dong() {
        storeManagerScreen.choose1StoreActive();
    }

    @Then("xác nhận trạng thái cửa hàng {string}")
    public void xac_nhan_trang_thai_cua_hang(String status) {
        storeManagerScreen.confirmStoreStatus(status);
    }

    @And("nhấn vào Thông tin cửa hàng")
    public void nhan_vao_thong_tin_cua_hang() {
        storeManagerScreen.clickStoreInfo();
    }

    @And("chọn 1 cửa hàng đang đóng cửa")
    public void chon_1_cua_hang_dang_dong_cua() {
        storeManagerScreen.choose1StoreInActive();
    }

    @And("chọn tài khoản {string}")
    public void chon_tai_khoan(String name) {
        storeManagerScreen.choose1Store(name);
    }

    @And("nhấn nút tìm kiếm")
    public void nhan_nut_tim_kiem() {
        storeManagerScreen.clickSearchBtn();
    }

    @Then("hiển thị MH Tra cứu lịch sử giao dịch")
    public void hien_thi_mh_tra_cuu_lich_su_giao_dich() {
        searchTransactionsHistoryScreen.historyTransactionScreenDisplayed();
    }

    @And("chọn tìm kiếm theo khoảng thời gian")
    public void chon_tim_kiem_theo_khoang_thoi_gian() {
        searchTransactionsHistoryScreen.clickIconCalendar();
    }

    @And("chọn tháng tìm kiếm {string}")
    public void chon_thang_tim_kiem(String month) {
        searchTransactionsHistoryScreen.searchMonth(month);
    }

    @And("tìm kiếm từ ngày {string}")
    public void tim_kiem_tu_ngay(String fromDate) {
        searchTransactionsHistoryScreen.searchDate(fromDate);
    }

    @And("tìm kiếm đến ngày {string}")
    public void tim_kiem_den_ngay(String toDate) {
        searchTransactionsHistoryScreen.searchDate(toDate);
    }

    @And("nhấn nút Chọn ngày")
    public void nhan_nut_chon_ngay() {
        searchTransactionsHistoryScreen.clickPickDateButton();
    }

    @Then("hiển thị mã QR")
    public void hien_thi_ma_qr() {
        storeManagerScreen.qrCodeDisplayed();
    }

    @And("hiển thị thông tin giao dịch gần đây")
    public void hien_thi_thong_tin_giao_dich_gan_day() {
        storeManagerScreen.recentTransactionsDisplayed();
    }

    @And("nhấn nút Dừng hoạt động")
    public void nhan_nut_dung_hoat_dong() {
        storeInfoScreen.clickInActiveBtn();
    }

    @And("nhấn vào Mở lại cửa hàng")
    public void click_mo_lai_cua_hang() {
        storeInfoScreen.clickReOpenBtn();
    }

    @And("nhấn nút Tìm kiếm lịch sử giao dịch")
    public void nhan_nut_tim_kiem_lich_su_giao_dich() {
        searchTransactionsHistoryScreen.clickSearchBtn();
    }

    @And("hiển thị biểu đồ doanh thu cửa hàng")
    public void hien_thi_bieu_doanh_thu_cua_hang() {
        storeManagerScreen.verifyShopHasNotGeneratedIncomeDataIsDisplayed();
    }

    @And("scroll lên để xem biểu đồ doanh thu cửa hàng")
    public void scroll_len_de_xem_bieu_do_doanh_thu_cua_hang() {
        storeManagerScreen.scrollUpToRevenuePerStore();
    }

    @Then("không hiển thị biểu đồ doanh thu cửa hàng")
    public void khong_hien_thi_bieu_doanh_thu_cua_hang() {
        storeManagerScreen.verifyShopHasNotGeneratedIncomeDataUndisplayed();
    }

    @And("scroll xuống để xem biểu đồ doanh thu cửa hàng")
    public void scroll_xuong_de_xem_bieu_do_doanh_thu_cua_hang() {
        storeManagerScreen.scrollDownToRevenuePerStore();
    }

    @Then("hiển thị MH Thông tin cửa hàng")
    public void kiem_tra_man_thong_tin_cua_hang_hien_thi() {
        storeInfoScreen.verifyThongTinCuaHangIsDisplayed();
    }

    @And("nhấn nút quay lại trong MH Thông tin cửa hàng")
    public void nhan_nut_quay_lai_trong_mh_thong_tin_cua_hang() {
        storeInfoScreen.clickBackButtonToQuanLyCuaHang();
    }

    @And("nhấn nút quay lại trong MH Quản lý cửa hàng")
    public void nhan_nut_quay_lai_trong_mh_quan_ly_cua_hang() {
        storeManagerScreen.clickBackButtonToIPayHome();
    }

    @And("chọn tab {string}")
    public void chon_tab(String text) {
        storeManagerScreen.clickToTab(text);
    }

    @Then("hiển thị text {string}")
    public void hien_thi_text(String text) {
        storeManagerScreen.verifyContentIsDisplayed(text);
    }

    @Then("hiển thị MH Chia sẻ cửa hàng")
    public void kiem_tra_chia_se_cua_hang_hien_thi() {
        shareStoreScreen.verifyShareShopScreenIsDisplayed();
    }

    @Then("hiển thị text Tab {string}")
    public void hien_thi_text_tab(String text) {
        storeManagerScreen.verifyTabIsDisplayed(text);
    }
}
