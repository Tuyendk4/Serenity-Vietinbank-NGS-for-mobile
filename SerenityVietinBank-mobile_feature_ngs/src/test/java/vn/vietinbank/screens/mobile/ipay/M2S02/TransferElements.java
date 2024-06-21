package vn.vietinbank.screens.mobile.ipay.M2S02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

import java.util.List;

public class TransferElements extends BaseScreen {
    public TransferElements(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[6]")
    public WebElement btnTranferMoneyObroad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    public WebElement txtPurpose;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chuyển tiền trả các loại phí, lệ phí cho nước ngoài\"])[2]")
    public WebElement txtLivingExpenses;

    public String purpose = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[%value]/XCUIElementTypeButton";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tạo điện mua/chuyển ngoại tệ\"]")
    public WebElement btnMakeNewPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    public static WebElement iconBeneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public static WebElement txtBeneficiaryAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lưu & tiếp tục\"]")
    public static WebElement btnSaveContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public static WebElement txtPaymentNote;

    public static String scrollTo = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public static WebElement paymentAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    public static WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xong\"]")
    public static WebElement btn_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement number_total_debt_deduction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    public static WebElement btn_continue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineAddnew\"]")
    public static WebElement icon_add_profile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chọn từ thư viện\"]")
    public static WebElement select_from_library;

    @iOSXCUITFindAll({@iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name=\"Ảnh\"]//XCUIElementTypeOther//XCUIElementTypeScrollView//XCUIElementTypeImage")})
    public static List<WebElement> image;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]")
    public static WebElement txt_total_debt_deduction;

    public static String txt_payment_note = "Nội dung chuyển";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
    public static WebElement confirm_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Người nhận\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement title_beneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement purpose_trading_results;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ngân hàng nhận\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement receiving_bank;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số ngoại tệ cần chuyển\"]//preceding-sibling::XCUIElementTypeStaticText")
    public static WebElement number_to_transfer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số ngoại tệ cần chuyển\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement number_to_transfer_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ tạm tính\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement debt_amount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Số tiền trích nợ (tạm tính)\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement debt_amount_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nội dung\"]//following-sibling::XCUIElementTypeStaticText")
    public static WebElement content;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch sử điện ngoại tệ\"]")
    public static WebElement txt_view_history;

    String view_history = "Xem lịch sử điện ngoại tệ";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[43]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public static WebElement txt_list_history;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Trạng thái\"]//following-sibling::XCUIElementTypeStaticText")
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
