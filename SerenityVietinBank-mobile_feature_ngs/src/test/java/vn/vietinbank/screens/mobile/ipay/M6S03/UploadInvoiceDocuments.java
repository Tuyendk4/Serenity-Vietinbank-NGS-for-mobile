package vn.vietinbank.screens.mobile.ipay.M6S03;

import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UploadInvoiceDocuments extends BaseScreen {

    private final String ios_classChainUploadInvoicesAndDocumentsTxt = "**/XCUIElementTypeStaticText[`name == \"Tải lên hoá đơn, chứng từ\"`]";
    private final String android_uploadInvoicesAndDocumentsTxt = "//android.widget.TextView[@text=\"Tải lên chứng từ hóa đơn\"]";

    private final String ios_invoiceAndContractCodesInp = "//XCUIElementTypeTextField[@value=\"Nhập mã số hoá đơn, hợp đồng\"]";
    private final String android_invoiceAndContractCodesInp = "//android.widget.EditText[@text=\"Nhập mã số hóa đơn, hợp đồng.\"]";

    private final String ios_invoiceAndContractAmountInp = "//XCUIElementTypeTextField[@value=\"Nhập số tiền trên hợp đồng\"]";
    private final String android_invoiceAndContractAmountInp = "//android.widget.EditText[@text=\"Nhập số tiền trên hóa đơn, hợp đồng.\"]";

    private final String ios_dateOnContractInvoiceDrp = "//XCUIElementTypeStaticText[@name=\"Ngày trên hoá đơn/hợp đồng\"]/../following-sibling::XCUIElementTypeButton";
    private final String android_dateOnContractInvoiceDrp = "//android.widget.TextView[@text=\"Ngày trên hóa đơn hợp đồng\"]";

    private final String ios_attachDocumentsBtn = "//XCUIElementTypeStaticText[@name=\"Hình ảnh, tài liệu mô tả 0/20.\"]/following-sibling::XCUIElementTypeOther//XCUIElementTypeButton";
    private final String android_attachDocumentsBtn = "//android.widget.FrameLayout[@resource-id=\"com.vietinbank.ipay:id/flAvatar\"]";

    private final String ios_fromTheLibraryBtn = "//XCUIElementTypeStaticText[@name=\"Chọn từ thư viện\"]/..";
    private final String android_fromTheLibraryBtn = "//android.widget.TextView[@text=\"Chọn từ thư viện\"]";

    private final String android_allowBtn = "//android.widget.Button[@text=\"Cho phép\"]";

    private final String ios_pictureChoose = "//XCUIElementTypeNavigationBar[@name=\"Ảnh\"]/following-sibling::XCUIElementTypeOther//XCUIElementTypeImage[1]";
    private final String android_pictureChoose = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]";

    private final String ios_saveBtn= "//XCUIElementTypeButton[@name=\"Lưu\"]";
    private final String android_saveBtn = "//android.widget.TextView[@text=\"Lưu\"]";

    public UploadInvoiceDocuments(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    public Boolean findUploadInvoicesAndDocumentsTxt(){
        if(appiumDriver instanceof AndroidDriver) {
            WebElement web_UploadInvoicesAndDocumentsTxt = findElement(android_uploadInvoicesAndDocumentsTxt);
            return web_UploadInvoicesAndDocumentsTxt.isDisplayed();
        }else {
            WebElement web_UploadInvoicesAndDocumentsTxt = findElement_iosClassChain(ios_classChainUploadInvoicesAndDocumentsTxt);
            return web_UploadInvoicesAndDocumentsTxt.isDisplayed();
        }
    }

    public void inputInvoiceAndContractCodes(String txtInvoiceAndContractCodes) {
        if(appiumDriver instanceof AndroidDriver) {
            sendKeys(android_invoiceAndContractCodesInp, txtInvoiceAndContractCodes);
        } else {
            sendKeys(ios_invoiceAndContractCodesInp, txtInvoiceAndContractCodes);
        }
    }

    public void inputInvoiceAndContractAmount(String txtInvoiceAndContractAmount) {
        if(appiumDriver instanceof AndroidDriver) {
            sendKeys(android_invoiceAndContractAmountInp, txtInvoiceAndContractAmount);
        } else {
            sendKeys(ios_invoiceAndContractAmountInp, txtInvoiceAndContractAmount);
        }
    }

    public void clickDateOnContractInvoice() {
        String txtDateNow = getDateNow();
        if (appiumDriver instanceof IOSDriver) {
            click(ios_dateOnContractInvoiceDrp);
            String dateOnContractInvoiceChoose = "//XCUIElementTypeStaticText[@name=\"" + txtDateNow + "\"]";
            List<WebElement> elementList = findElements(dateOnContractInvoiceChoose);
            waitForElementVisible(elementList.get(elementList.size() -1),5);
            click(elementList.get(elementList.size() -1));
        } else {
            click(android_dateOnContractInvoiceDrp);
            String dateOnContractInvoiceChoose = "//android.widget.TextView[@text=\"" + txtDateNow + "\"]";
            List<WebElement> elementList = findElements(dateOnContractInvoiceChoose);
            waitForElementVisible(elementList.get(elementList.size() -1),5);
            click(elementList.get(elementList.size() -1));
        }

    }

    public String getDateNow(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        return String.valueOf(Integer.valueOf(formatter.format(date)));
    }

    public void clickAttachDocuments() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_attachDocumentsBtn);
            click(android_fromTheLibraryBtn);
            click(android_allowBtn);
            click(android_pictureChoose);
        }else{
            click(ios_attachDocumentsBtn);
            click(ios_fromTheLibraryBtn);
            click(ios_pictureChoose);
        }
    }

    public CreateDisbursementRequest_Step1 clickSave() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_saveBtn);
        } else {
            click(ios_saveBtn);
        }
        return new CreateDisbursementRequest_Step1(this.appiumDriver);
    }

}
