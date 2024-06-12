package vn.vietinbank.steps.mobile.ipay.M7S02_InstallmentCreditCardSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class CardSevices_Steps extends BaseStep {


    @When("Chọn thẻ dựa trên số thẻ đầy đủ {string}")
    public void chonTheTheoSo(String soThe) {
        cardDetails = cardList.chonTheTheoSo(soThe);
    }

//    @When("Chọn thẻ đầu tiên")
//    public void chonTheDauTien() {
//        cardDetails = cardList.chonTheDauTien();
//    }

    @When("Chọn tính năng Đăng ký trả góp")
    public void chonTinhNangDangKyTraGop() {
        installmentIntro = cardDetails.chonDangKyTraGop();
    }

    @When("Chọn Trả góp ngay")
    public void chonTraGopNgay() {
        eligibleTransactions = installmentIntro.chonTraGopNgay();
    }

    @When("Chọn giao dịch trả góp theo số tiền {string}")
    public void chonGiaoDichDauTien(String soTien) {
        installmentTransactionDetail = eligibleTransactions.chonGiaoDichDauTien(soTien);
    }

    @When("Chọn kỳ hạn {string} tháng")
    public void chonKyHan(String kyHan) {
        installmentTransactionDetail.chonKyHan(kyHan);
    }

    @When("Chọn Đồng ý Điều khoản và điều kiện")
    public void chonDongYDieuKhoan() {
        installmentTransactionDetail.chonDongYDieuKhoan();
    }

    @When("Chọn Tiếp tục")
    public void chonTiepTuc() {
        oTPCC = installmentTransactionDetail.chonTiepTuc();
    }

    @When("Nhập OTP {string}")
    public void inputOTP(String otp) {
        oTPCC.inputOTP(otp);
    }

    @Then("Nhận thông báo thành công")
    public void nhanThongBaoThanhCong() {
        resultPage.nhanThongBaoThanhCong();
    }

    @And("Về trang chủ")
    public void veTrangChu() {
        resultPage.veTrangChu();
    }
}

