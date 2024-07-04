package vn.vietinbank.mobile.screens.iPay.Transfer.Elements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

import java.util.List;

public class TransferObroadElements extends BaseScreen {
    public TransferObroadElements(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[6]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Mua/chuyển tiền ngoại tệ\"]")
    protected WebElement btnTranferMoneyObroad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
    protected WebElement txtPurpose;

    protected String ios_purpose = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[%value]/XCUIElementTypeButton";
    protected String and_purpose = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/recyclerView\"]/android.widget.LinearLayout[%value]/android.widget.LinearLayout";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tạo điện mua/chuyển ngoại tệ\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    protected WebElement btnMakeNewPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"])[1]")
    protected WebElement iconBeneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\"]")
    protected WebElement txtBeneficiaryAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Lưu & tiếp tục\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    protected WebElement btnSaveContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Nội dung chuyển\"]")
    protected WebElement txtPaymentNote;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtAmount\"]")
    protected WebElement paymentAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Số tiền quy đổi\"]")
    protected WebElement txtNumberExchangedMoney;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Nội dung chuyển\"]")
    protected WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xong\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    protected WebElement btn_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Tổng trích nợ\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Tổng trích nợ\"]//following-sibling::android.widget.TextView")
    protected WebElement number_total_debt_deduction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    protected WebElement btn_continue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineAddnew\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/iv_addImage_validate\"]")
    protected WebElement icon_add_profile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chọn từ thư viện\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Chọn từ thư viện hình ảnh\"]")
    protected WebElement select_from_library;

    @iOSXCUITFindAll({@iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name=\"Ảnh\"]//XCUIElementTypeOther//XCUIElementTypeScrollView//XCUIElementTypeImage")})
    @AndroidFindAll({@AndroidBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])")})
    protected List<WebElement> image;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.providers.media.module:id/button_add\"]")
    protected WebElement btnAdd;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Tổng trích nợ\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id=\"com.vietinbank.ipay:id/mNestedScrollView\"]")
    protected WebElement txt_total_debt_deduction;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/root\"]/android.widget.LinearLayout[2]")
    protected WebElement screenTransectionResult;

    protected String txt_payment_note = "Nội dung chuyển";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    protected WebElement confirm_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Người nhận\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Người nhận\"]//following-sibling::android.widget.LinearLayout//android.widget.TextView")
    protected WebElement title_beneficiary;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Người nhận\"]//following-sibling::android.widget.TextView")
    protected WebElement title_beneficiary_left;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Mục đích\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Mục đích\"]//following-sibling::android.widget.TextView")
    protected WebElement purpose_trading_results;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Ngân hàng nhận\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Ngân hàng nhận\"]//following-sibling::android.widget.LinearLayout//android.widget.TextView")
    protected WebElement receiving_bank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Ngân hàng nhận\"]//following-sibling::android.widget.TextView")
    protected WebElement receiving_bank_trading_results;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Số ngoại tệ cần chuyển\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số ngoại tệ cần chuyển\"]//following-sibling::android.widget.TextView")
    protected WebElement number_to_transfer_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Số tiền trích nợ tạm tính\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số tiền trích nợ tạm tính\"]//following-sibling::android.widget.TextView")
    protected WebElement debt_amount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Số tiền trích nợ (tạm tính)\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số tiền trích nợ tạm tính\"]//following-sibling::android.widget.TextView")
    protected WebElement debt_amount_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Nội dung\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Nội dung\"]//following-sibling::android.widget.TextView")
    protected WebElement content;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch sử điện ngoại tệ\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/btnGiao_dich_tiep\"]")
    protected WebElement txt_view_history;

    protected String view_history = "Xem lịch sử điện ngoại tệ";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[43]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id=\"com.vietinbank.ipay:id/rl_itemDetail\"])[1]/android.widget.LinearLayout")
    protected WebElement txt_list_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Trạng thái\"]//following-sibling::XCUIElementTypeText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Trạng thái\"]//following-sibling::android.widget.TextView")
    protected WebElement txt_status;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Mục đích sử dụng\"]//following-sibling::XCUIElementTypeTextField")
    protected WebElement txt_popure_used;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    protected WebElement txt_other_oversear_payment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"bene icon\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Người nhận\"]")
    protected WebElement btn_beneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Số tài khoản người nhận\"]//preceding-sibling::XCUIElementTypeApplication")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Số tài khoản người nhận\"]")
    protected WebElement title_account_number;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Tên người nhận\"]//preceding-sibling::XCUIElementTypeApplication")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Tên người nhận\"]")
    protected WebElement title_recipient_name;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Địa chỉ người nhận\"]//preceding-sibling::XCUIElementTypeApplication")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Địa chỉ người nhận\"]")
    protected WebElement title_address;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Địa chỉ người nhận\"]")
    protected WebElement title_done;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"iconLineEditPencil\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Ngân hàng nhận\"]")
    protected WebElement iconLineEditPencil;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Mã nước ngân hàng nhận\"]//parent::XCUIElementTypeTextField//following-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mã nước Ngân hàng nhận\"]")
    protected WebElement icon_receiving_bank_country_code;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Tìm kiếm\"]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtFinter\"]")
    protected WebElement title_find;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"JP - JAPAN\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\"]")
    protected WebElement title_JAPAN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeText[@name=\"Mã SWIFT Ngân hàng nhận\"]//parent::XCUIElementTypeTextField//following-sibling::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mã SWIFT Ngân hàng nhận\"]")
    protected WebElement code_swift_bank;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtFinter\"]")
    protected WebElement txt_swift_code;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft1\"]")
    protected WebElement txt_swift_name;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/gotoHistory\"]")
    protected WebElement txt_view_history_home;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.vietinbank.ipay:id/btn_right\"]")
    protected WebElement btn_right_find;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_purpose\" and @text=\"Học phí du học\"]")
    protected WebElement tuition_fees_studying_abroad;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"]")
    protected WebElement btn_select_date;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"1\"])[1]")
    protected WebElement btn_calendar_grid_1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"31\"]")
    protected WebElement btn_calendar_grid_2;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    protected WebElement btn_next_find;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_search\"]")
    protected WebElement btn_search;

    @AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"com.vietinbank.ipay:id/calendar_view\"]")
    protected WebElement screen_calendar_view;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_status\"]")
    protected WebElement btn_status;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.RelativeLayout")
    protected WebElement btn_status_layout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvHistoryTransExtMoneyDetailRenew\"]")
    protected WebElement txt_trans_ext_money_detail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THÁNG 3 2024\"]")
    protected WebElement txt_3_2024;
}
