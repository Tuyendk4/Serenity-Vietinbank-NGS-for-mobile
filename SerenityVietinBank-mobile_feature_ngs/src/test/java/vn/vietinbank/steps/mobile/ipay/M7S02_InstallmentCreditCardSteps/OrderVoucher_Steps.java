package vn.vietinbank.steps.mobile.ipay.M7S02_InstallmentCreditCardSteps;

import io.cucumber.java.vi.Và;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.EVoucher.OrderVoucher;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class OrderVoucher_Steps extends BaseStep {


    @Và("Đồng ý đặt mua Voucher")
    public void dongYVoucher() {
        orderVoucher = eVoucher.dongY();
    }


    @Và("Chọn loại voucher và số lượng")
    public void chonLoaiVaSoLuong() {
        orderVoucher = orderVoucher.chonLoaiVaSoLuong();
    }

    @Và("Nhập thông tin người nhận {string} và email {string}")
    public void inputThongTin(String nguoiNhan, String email ) {
        orderVoucher=orderVoucher.inputThongTin(nguoiNhan,email);
    }

    @Và ("Xác nhận thanh toán")
    public void xacNhanThanhToan() {
        oTPCC=orderVoucher.xacNhanThanhToan();
    }

}