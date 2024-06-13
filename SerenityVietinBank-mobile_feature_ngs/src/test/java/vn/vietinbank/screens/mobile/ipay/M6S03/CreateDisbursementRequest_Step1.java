package vn.vietinbank.screens.mobile.ipay.M6S03;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class CreateDisbursementRequest_Step1 extends BaseScreen {


    private final String ios_doneBtn = "//XCUIElementTypeButton[@name=\"Xong\"]";

    private final String ios_keyBoardDownBtn = "//XCUIElementTypeButton[@name=\"ic keyboarddown\"]";

    private final String ios_beneficiaryAccountInp = "//XCUIElementTypeTextField[@value=\"Nhập số tài khoản thụ hưởng\"]";
    private final String android_beneficiaryAccountInp = "//android.widget.EditText[@text=\"Nhập số tài khoản thụ hưởng\"]";

    private final String android_beneficiaryBankInp = "//android.widget.TextView[@text=\"Ngân hàng/chi nhánh thụ hưởng\"]";
    private final String ios_beneficiaryBankInp = "//XCUIElementTypeStaticText[@name=\"Ngân hàng nhận\"]/../..";

    private final String ios_beneficiaryAmountInp = "//XCUIElementTypeTextField[@value=\"Nhập số tiền thụ hưởng\"]";
    private final String android_beneficiaryAmountInp = "//android.widget.EditText[@text=\"Nhập số tiền thụ hưởng\"]";

    private final String ios_contentLine = "//XCUIElementTypeStaticText[@name=\"THÔNG TIN NGƯỜI THỤ HƯỞNG\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";

    private final String ios_clearTextBtn= "//XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

    private final String ios_contentDisbursementInp = "//XCUIElementTypeTextField[@value=\"Nội dung\"]";
    private final String android_contentDisbursementInp= "//android.widget.TextView[@text=\"Nội dung\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText";

    private final String ios_attachContractInvoiceAdd = "//XCUIElementTypeButton[@name=\"Đính kèm hoá đơn, hợp đồng\"]";
    private final String android_attachContractInvoiceAdd = "//android.widget.TextView[@text=\"Đính kèm hoá đơn, hợp đồng\"]";

    private final String ios_confirmsAndAgreesToDisbursementBtn = "//XCUIElementTypeStaticText[@name=\"Xác nhận & đồng ý giải ngân\"]";

    public CreateDisbursementRequest_Step1(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void inputBeneficiaryAccount(String accountBeneficiary) {
        if (appiumDriver instanceof IOSDriver) {
            sendKeys(ios_beneficiaryAccountInp, accountBeneficiary);
            click(ios_doneBtn);
        }else {
            sendKeys(android_beneficiaryAccountInp, accountBeneficiary);
        }
    }

    public void inputBeneficiaryBank(String beneficiaryBankName) {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_beneficiaryBankInp);
            String android_beneficiaryBankNameInp= "//android.widget.TextView[@text=\""+ beneficiaryBankName + "\"]";
            click(android_beneficiaryBankNameInp);
        } else {
            click(ios_beneficiaryBankInp);
            String ios_beneficiaryBankNameInp= "//XCUIElementTypeStaticText[@name=\""+ beneficiaryBankName + "\"]";
            click(ios_beneficiaryBankNameInp);
        }
    }

    public void inputBeneficiaryAmount(String amountBeneficiary) {
        if (appiumDriver instanceof IOSDriver) {
            sendKeys(ios_beneficiaryAmountInp, amountBeneficiary);
            click(ios_keyBoardDownBtn);
        }else{
            sendKeys(android_beneficiaryAmountInp, amountBeneficiary);
        }
    }

    public void inputContentDisbursement(String contentDisbursement) {
        if (appiumDriver instanceof IOSDriver) {
            click(ios_contentLine);
            click(ios_clearTextBtn);
            sendKeys(ios_contentDisbursementInp, contentDisbursement);
            click(ios_doneBtn);
        } else {
            sendKeys(android_contentDisbursementInp, contentDisbursement);
        }
    }

    public UploadInvoiceDocuments clickAttachContractInvoice() {
        scrollTo("Đính kèm hoá đơn, hợp đồng");
        if (appiumDriver instanceof IOSDriver) {
            click(ios_attachContractInvoiceAdd);
        }else{
            click(android_attachContractInvoiceAdd);
        }
        return new UploadInvoiceDocuments(this.appiumDriver);
    }

    public TransactionIdentification clickConfirmsAndAgreesToDisbursement() {
        if (appiumDriver instanceof IOSDriver) {
            click(ios_confirmsAndAgreesToDisbursementBtn);
        }else{

        }
        return new TransactionIdentification(this.appiumDriver);
    }
}
