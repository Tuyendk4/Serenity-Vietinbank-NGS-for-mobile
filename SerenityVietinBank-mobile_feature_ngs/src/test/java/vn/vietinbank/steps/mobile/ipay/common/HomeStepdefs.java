package vn.vietinbank.steps.mobile.ipay.common;

import io.cucumber.java.en.And;
import io.cucumber.java.vi.Và;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;

public class HomeStepdefs extends BaseStep {

  public HomeStepdefs() {
    super();
  }
  @And("Menu Dịch vụ vay và tín dụng")
  public void moveToLoanAndCreditServices() {
    loanAndCreditServices = home.favoriteServices().click_dich_vu_vay_va_tin_dung();
  }

  @And("Vào Danh sách tài khoản")
  public void move_to_Account_Number_List() {
    accountNumberList = home.move_to_AccountNumberList();
  }

  @Và("Di chuyển vào Chuyển tiền")
  public void moveToTransfer(){
    transferAndReceive = home.favoriteServices().click_on_transfer_money();
  }

  @Và("mở Dịch vụ thẻ")
  public void moveCardServices() {
    cardList = home.favoriteServices().chonDichVuThe();

  }

  @Và("mở Tất cả dịch vụ")
  public void moveAllServices() {

    allServicesPage = home.favoriteServices().chonTatCaDichVu();
  }

  @Và("mở Danh sách tài khoản từ màn hình chính")
  public void moveToAccountList() {

    accountListPage = home.moveToAccountList().chonAccountList();
  }
}