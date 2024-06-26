package vn.vietinbank.screens.mobile.ipay.M2S02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import java.util.List;

public class TransferElements extends BaseScreen {
    public TransferElements(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[6]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvProvider\" and @text=\"Mua/chuyển tiền ngoại tệ\"]")
    public WebElement btnTranferMoneyObroad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
    public WebElement txtPurpose;

    public String ios_purpose = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[%value]/XCUIElementTypeButton";
    public String and_purpose = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/recyclerView\"]/android.widget.LinearLayout[%value]/android.widget.LinearLayout";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tạo điện mua/chuyển ngoại tệ\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    public WebElement btnMakeNewPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ivSelect\"])[1]")
    public static WebElement iconBeneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\"]")
    public static WebElement txtBeneficiaryAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lưu & tiếp tục\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    public static WebElement btnSaveContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Nội dung chuyển\"]")
    public static WebElement txtPaymentNote;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtAmount\"]")
    public static WebElement paymentAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Số tiền quy đổi\"]")
    public static WebElement txtNumberExchangedMoney;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Nội dung chuyển\"]")
    public static WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xong\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    public static WebElement btn_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Tổng trích nợ\"]//following-sibling::android.widget.TextView")
    public static WebElement number_total_debt_deduction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    public static WebElement btn_continue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineAddnew\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/iv_addImage_validate\"]")
    public static WebElement icon_add_profile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chọn từ thư viện\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Chọn từ thư viện hình ảnh\"]")
    public static WebElement select_from_library;

    @iOSXCUITFindAll({@iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name=\"Ảnh\"]//XCUIElementTypeOther//XCUIElementTypeScrollView//XCUIElementTypeImage")})
    @AndroidFindAll({@AndroidBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])")})
    public static List<WebElement> image;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.google.android.providers.media.module:id/button_add\"]")
    public static WebElement btnAdd;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id=\"com.vietinbank.ipay:id/mNestedScrollView\"]")
    public static WebElement txt_total_debt_deduction;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/root\"]/android.widget.LinearLayout[2]")
    public static WebElement screenTransectionResult;

    public static String txt_payment_note = "Nội dung chuyển";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]")
    public static WebElement confirm_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Người nhận\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Người nhận\"]//following-sibling::android.widget.LinearLayout//android.widget.TextView")
    public static WebElement title_beneficiary;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Người nhận\"]//following-sibling::android.widget.TextView")
    public static WebElement title_beneficiary_left;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Mục đích\"]//following-sibling::android.widget.TextView")
    public static WebElement purpose_trading_results;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngân hàng nhận\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Ngân hàng nhận\"]//following-sibling::android.widget.LinearLayout//android.widget.TextView")
    public static WebElement receiving_bank;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Ngân hàng nhận\"]//following-sibling::android.widget.TextView")
    public static WebElement receiving_bank_trading_results;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số ngoại tệ cần chuyển\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số ngoại tệ cần chuyển\"]//following-sibling::android.widget.TextView")
    public static WebElement number_to_transfer_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ tạm tính\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số tiền trích nợ tạm tính\"]//following-sibling::android.widget.TextView")
    public static WebElement debt_amount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ (tạm tính)\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Số tiền trích nợ tạm tính\"]//following-sibling::android.widget.TextView")
    public static WebElement debt_amount_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nội dung\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Nội dung\"]//following-sibling::android.widget.TextView")
    public static WebElement content;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch sử điện ngoại tệ\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/btnGiao_dich_tiep\"]")
    public static WebElement txt_view_history;

    String view_history = "Xem lịch sử điện ngoại tệ";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[43]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout[@resource-id=\"com.vietinbank.ipay:id/rl_itemDetail\"])[1]/android.widget.LinearLayout")
    public static WebElement txt_list_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Trạng thái\"]//following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and @text=\"Trạng thái\"]//following-sibling::android.widget.TextView")
    public static WebElement txt_status;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích sử dụng\"]//following-sibling::XCUIElementTypeTextField")
    public static WebElement txt_popure_used;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    public static WebElement txt_other_oversear_payment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"bene icon\"]")
    public static WebElement btn_beneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tài khoản người nhận\"]//preceding-sibling::XCUIElementTypeApplication")
    public static WebElement title_account_number;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tên người nhận\"]//preceding-sibling::XCUIElementTypeApplication")
    public static WebElement title_recipient_name;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Địa chỉ người nhận\"]//preceding-sibling::XCUIElementTypeApplication")
    public static WebElement title_address;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    public static WebElement title_done;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"iconLineEditPencil\"])[1]")
    public static WebElement iconLineEditPencil;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mã nước ngân hàng nhận\"]//parent::XCUIElementTypeTextField//following-sibling::XCUIElementTypeButton")
    public static WebElement icon_receiving_bank_country_code;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value=\"Tìm kiếm\"]")
    public static WebElement title_find;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"JP - JAPAN\"]")
    public static WebElement title_JAPAN;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mã SWIFT Ngân hàng nhận\"]//parent::XCUIElementTypeTextField//following-sibling::XCUIElementTypeButton")
    public static WebElement code_swift_bank;
}
