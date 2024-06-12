package vn.vietinbank.steps.mobile.ipay.M7S02_InstallmentCreditCardSteps;

import io.cucumber.java.vi.Và;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class AllServices_Steps extends BaseStep {
    //    @Và("mở Tất cả dịch vụ")
//    public void moveAllServices() {
//        allServicesPage = home.favoriteServices().chonTatCaDichVu();
//    }
    @Và("Đi tới màn hình Trả góp online từ Tất cả dịch vụ")
    public void moveTraGopOnlineFromAllServices() {

        traGopOnlineAllServices = allServicesPage.tapTaiKhoan();
    }

    @Và("Nhấn Trả góp Online từ tất cả dịch vụ")
    public void tapTraGopOnlineFromAllServices() {
        installmentIntro = traGopOnlineAllServices.chonTraGopOnlineAllServices();

    }
}