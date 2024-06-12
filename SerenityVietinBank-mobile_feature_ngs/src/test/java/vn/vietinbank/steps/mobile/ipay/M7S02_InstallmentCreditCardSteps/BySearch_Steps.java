package vn.vietinbank.steps.mobile.ipay.M7S02_InstallmentCreditCardSteps;

import io.cucumber.java.vi.Và;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class BySearch_Steps extends BaseStep {


    @Và("Mở ô tìm kiếm")
    public void homeSearch() {
        bySearch = home.homeSearch().chonTimKiem();
    }


    @Và("Nhập từ {string} cần tìm kiếm")
    public void nhapTuCanTimKiem(String tuTimKiem) {

        tapResultBySearch = bySearch.nhapTuCanTimKiem(tuTimKiem);
    }

    @Và("Chọn Trả góp thẻ tín dụng bằng tìm kiếm")
    public void chonTraGopTheBangTimKiem() {

        installmentIntro = tapResultBySearch.chonTraGopTheBangTimKiem();
    }

    @Và("Chọn mua e-Voucher tìm kiếm")
    public void chonEVoucherBangTimKiem() {

        eVoucher = tapResultBySearch.chonEVoucherBangTimKiem();
    }

    @Và("Chọn số thẻ {string} trong danh sách thẻ trả góp")
    public void chonDSThe(String soThe) {

        eligibleTransactions = eligibleTransactions.chonDSThe(soThe);
    }

}