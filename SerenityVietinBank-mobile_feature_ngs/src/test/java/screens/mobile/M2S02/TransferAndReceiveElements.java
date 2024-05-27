package screens.mobile.M2S02;

import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class TransferAndReceiveElements {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[6]")
    static WebElement btnTranferMoneyObroad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    static WebElement txtPurpose;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chuyển tiền trả các loại phí, lệ phí cho nước ngoài\"])[2]")
    static WebElement txtLivingExpenses;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tạo điện mua/chuyển ngoại tệ\"]")
    static WebElement btnMakeNewPayment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
    static WebElement iconBeneficiary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    static WebElement txtBeneficiaryAccount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lưu & tiếp tục\"]")
    static WebElement btnSaveContinue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeTextField")
    static WebElement txtPaymentNote;

    static String scrollTo = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeOther";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    static WebElement paymentAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    static WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xong\"]")
    static WebElement btn_done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]//following-sibling::XCUIElementTypeStaticText")
    static WebElement number_total_debt_deduction;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
    static WebElement btn_continue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineAddnew\"]")
    static WebElement icon_add_profile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Chọn từ thư viện\"]")
    static WebElement select_from_library;

    @iOSXCUITFindAll({@iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name=\"Ảnh\"]//XCUIElementTypeOther//XCUIElementTypeScrollView//XCUIElementTypeImage")})
    static WebElement image;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tổng trích nợ\"]")
    static WebElement txt_total_debt_deduction;

    @iOSXCUITFindBy(xpath = "")
    static String txt_payment_note = "Nội dung chuyển";

    static String confirm_done = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]";

    static String purpose_trading_results = "//XCUIElementTypeStaticText[@name=\"Mục đích\"]//following-sibling::XCUIElementTypeStaticText";

    static String beneficiary_trading_results = "//XCUIElementTypeStaticText[@name=\"Người nhận\"]//following-sibling::XCUIElementTypeStaticText";

    static String receiving_bank = "//XCUIElementTypeStaticText[@name=\"Ngân hàng nhận\"]following-sibling:://XCUIElementTypeStaticText";

}
