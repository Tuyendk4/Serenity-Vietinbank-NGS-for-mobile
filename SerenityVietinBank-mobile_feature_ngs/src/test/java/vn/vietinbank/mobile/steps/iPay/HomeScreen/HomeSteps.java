package vn.vietinbank.mobile.steps.iPay.HomeScreen;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Accounts.ListAccountsScreen;
import vn.vietinbank.mobile.screens.iPay.Home.HomeScreen;
import vn.vietinbank.mobile.screens.iPay.Loan.LoanAndCreditServices.LoanAndCreditServices;
import vn.vietinbank.mobile.screens.iPay.UserAction.Login.LoginScreen;

public class HomeSteps {

    AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");
    LoginScreen loginScreen = new LoginScreen(appiumDriver);
    HomeScreen homeScreen = new HomeScreen(appiumDriver);
    LoanAndCreditServices loanAndCreditServices = new LoanAndCreditServices(appiumDriver);
    ListAccountsScreen listAccountsScreen = new ListAccountsScreen(appiumDriver);

    @And("kiểm tra xem đã đăng nhập chưa")
    public void kiem_tra_da_dang_nhap_hay_chua() {
        loginScreen.checkLoggedIn();
    }

    @And("nhấn Đăng nhập trên MH Home")
    public void nhan_dang_nhap_tren_mh_home() {
        homeScreen.clickLoginBtn();
    }

    @And("đến Danh sách tài khoản")
    public void den_danh_sach_tai_khoan() {
        homeScreen.clickListAccountsTxt();
    }

    @And("đến Quét mã QR")
    public void den_quet_ma_qr() {
        homeScreen.clickScanQR();
    }

    @And("chọn icon tìm kiếm đến MH Tìm kiếm")
    public void chon_icon_tim_kiem_den_mh_tim_kiem() {
        homeScreen.clickIconSearchFeature();
    }

    @And("đến Tặng hoa tươi")
    public void den_tang_hoa_tuoi() {
        homeScreen.clickGiveFreshFlowers();
    }

    @And("vào tab user")
    public void vao_tab_user() {
        homeScreen.clickUserProfileTab();
    }

    @And("đến chức năng {string}")
    public void den_chuc_nang(String text) {
        homeScreen.clickQrShopButton(text);
    }

    @Then("hiển thị dịch vụ iShop hộ kinh hoanh")
    public void hien_thi_dich_vu_ishop_ho_kinh_hoanh() {
        homeScreen.verifyIPayServiceForBusinessHouseholdsAreDisplayed();
    }

    @And("Menu Dịch vụ vay và tín dụng")
    public void moveToLoanAndCreditServices() {
        loanAndCreditServices = homeScreen.favoriteServices().click_dich_vu_vay_va_tin_dung();
    }

    @And("Vào Danh sách tài khoản")
    public void move_to_Account_Number_List() {
        listAccountsScreen = homeScreen.move_to_AccountNumberList();
    }

//    @And("Di chuyển vào Chuyển tiền")
//    public void moveToTransfer(){
//        transferAndReceive = homeScreen.favoriteServices().click_on_transfer_money();
//    }
}
