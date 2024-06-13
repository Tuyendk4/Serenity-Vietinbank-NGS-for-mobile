package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.base.ScrollDirection;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.LoanPurposeSelection;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.loan.RepaymentDateSelection;

public class PersonalInstalmentLoan_Step2 extends BaseScreen {

    private final String android_iconCalendar = "//android.widget.TextView[@text=\"THÔNG TIN NGƯỜI VAY\"]/following-sibling::android.widget.LinearLayout[@resource-id=\"com.vietinbank.mobile.ipay:id/wDatePayWidget\"]//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.ImageView";
    private final String ios_iconCalendar = "//XCUIElementTypeButton[@name=\"iconLineCalendarRound\"]";

    private final String android_btnChooseARepaymentDate = "";
    private final String ios_btnChooseARepaymentDate = "//XCUIElementTypeButton[contains(@name,\"Chọn trả nợ ngày\")]";

    private final String android_btnLoanPurpose = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\" and @text=\"Mục đích vay\"]/parent::android.widget.LinearLayout";
    private final String ios_btnLoanPurpose = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]";

    private final String android_txtEmail = "//android.widget.EditText[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\" and (@text=\"Email nhận hợp đồng\" or contains(@text,\"@\")]";
    private final String ios_txtEmail = "//XCUIElementTypeTextField[contains(@value,\"Email nhận hợp đồng\") or contains(@value,\"@\")]";

    //  private final String android_btnDeleteEmail = "";
    private final String ios_btnDeleteEmail = "//XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

    private final String android_btnProvinces = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\" and @text=\"Tỉnh/thành phố\"]/parent::android.widget.LinearLayout";
    private final String ios_btnProvinces = "//XCUIElementTypeStaticText[@name=\"Tỉnh/thành phố\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton";

    private final String android_lblProvinces = "";
    private final String ios_lblProvinces = "//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText";

    private final String android_btnDistrict = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\" and @text=\"Quận/huyện\"]/parent::android.widget.LinearLayout";
    private final String ios_btnDistrict = "//XCUIElementTypeStaticText[@name=\"Quận/huyện\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton";

    private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.mobile.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
    private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";


    public PersonalInstalmentLoan_Step2(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public RepaymentDateSelection repaymentDateSelection() {
        return new RepaymentDateSelection(appiumDriver);
    }

    public void chooseARepaymentDate(String date) {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_iconCalendar);
        } else {
            click(ios_iconCalendar);
        }
        repaymentDateSelection().chooseADate(date);
        if (appiumDriver instanceof IOSDriver) {
            click(ios_btnChooseARepaymentDate);
        }
    }

    public LoanPurposeSelection loanPurposeSelection() {
        return new LoanPurposeSelection(appiumDriver);
    }

    public void chooseLoanPurpose(String loanPurpose) {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnLoanPurpose);
        } else {
            click(ios_btnLoanPurpose);
        }

        loanPurposeSelection().selectALoanPurpose(loanPurpose);
    }

    public void inputEmail(String email) {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_txtEmail);
            sendKeys(android_txtEmail, email);
        } else {
            click(ios_txtEmail);
            WebElement txtEmail = findElement(ios_txtEmail);
            String valueAttribute = txtEmail.getAttribute("value");
            if (valueAttribute != null) {
                if (valueAttribute.contains("@")) {
                    click(ios_btnDeleteEmail);
                }
            }
            sendKeys(ios_txtEmail, email);
        }
    }

    private void selectProvince(String province) {
        scrollTo(province);
        WebElement lblProvince = null;
        if (appiumDriver instanceof AndroidDriver) {
            lblProvince = findElement("//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\" and @text=\"Chọn tỉnh thành\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.mobile.ipay:id/recyclerView\"]//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and contains(@text, '" + province + "')]");
        } else {
            lblProvince = findElement("//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label, '" + province + "') or contains(@text, '" + province + "') or contains(@name, '" + province + "')]");
        }
        tap(lblProvince);
    }

    public void chooseProvince(String province) {
        if (appiumDriver instanceof AndroidDriver) {
            scrollToElement(android_btnProvinces, ScrollDirection.DOWN, 3);
            click(android_btnProvinces);
        } else {
            scrollToElement(ios_btnProvinces, ScrollDirection.DOWN, 3);
            click(ios_btnProvinces);
        }
        delay(3000);
        selectProvince(province);
    }

    private void selectDistrict(String district) {
        scrollTo(district);
        WebElement lblDistrict = null;
        if (appiumDriver instanceof AndroidDriver) {
            lblDistrict = findElement("//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/title_text\" and @text=\"Chọn Quận/Huyện\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.mobile.ipay:id/recyclerView\"]//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvLeft\" and contains(@text, '" + district + "')]");
        } else {
            lblDistrict = findElement("//XCUIElementTypeStaticText[@name=\"Chọn Quận/Huyện\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label, '" + district + "') or contains(@text, '" + district + "') or contains(@name, '" + district + "')]");
        }
        tap(lblDistrict);
    }

    public void chooseDistrict(String district) {
        if (appiumDriver instanceof AndroidDriver) {
            scrollToElement(android_btnDistrict, ScrollDirection.DOWN, 3);
            click(android_btnDistrict);
        } else {
            scrollToElement(ios_btnDistrict, ScrollDirection.DOWN, 3);
            click(ios_btnDistrict);
        }
        delay(3000);
        selectDistrict(district);
    }

    public PersonalInstalmentLoan_Step3 clickContinueButton() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnContinue);
        } else {
            click(ios_btnContinue);
        }
        delay(3000);
        return new PersonalInstalmentLoan_Step3(appiumDriver);
    }
}
