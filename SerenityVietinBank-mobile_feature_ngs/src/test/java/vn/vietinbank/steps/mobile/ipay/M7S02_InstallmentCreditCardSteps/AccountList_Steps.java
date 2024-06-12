package vn.vietinbank.steps.mobile.ipay.M7S02_InstallmentCreditCardSteps;

import io.cucumber.java.vi.Và;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class AccountList_Steps extends BaseStep {

    @Và("Chọn Tài khoản thẻ tín dung {string}")
    public void chonTaiKhoan(String soTaiKhoanTheTinDung) {
        creditAccountPage = accountListPage.chonTaiKhoan(soTaiKhoanTheTinDung);
    }


    @Và("Chọn Trả góp Online từ màn hình Tài khoản thẻ Tín Dụng")
    public void chonTraGopOnlineTuTK() {
        installmentIntro = creditAccountPage.chonTraGopOnlineTuTK();

    }
}