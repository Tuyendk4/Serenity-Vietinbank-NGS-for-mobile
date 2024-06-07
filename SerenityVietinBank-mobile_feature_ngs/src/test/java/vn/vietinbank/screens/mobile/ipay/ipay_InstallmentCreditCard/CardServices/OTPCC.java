package vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.CardServices;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class OTPCC extends BaseScreen {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=1]")
    public WebElement btnKey1;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=2]")
    public WebElement btnKey2;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=3]")
    public WebElement btnKey3;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=4]")
    public WebElement btnKey4;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=5]")
    public WebElement btnKey5;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=6]")
    public WebElement btnKey6;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=7]")
    public WebElement btnKey7;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=8]")
    public WebElement btnKey8;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=9]")
    public WebElement btnKey9;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name=11]")
    public WebElement btnKey0;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/otp_editText\"]")
    public WebElement otpInp;
    @AndroidFindBy(id = "com.vietinbank.ipay:id/submit")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
    public WebElement btnHoanThanh;



    public OTPCC(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Nhập OTP: {0}")

    public ResultPage inputOTP(String otp) {

        tap(otpInp);
        String[] characters = otp.split("");
        for (String character : characters) {
            inputCharacter(character);
        }
        clickHoanThanh();
        return new ResultPage(appiumDriver);
    }

    private void inputCharacter(String character) {
        switch (character) {
            case "1":
                click(btnKey1);
                break;
            case "2":
                click(btnKey2);
                break;
            case "3":
                click(btnKey3);
                break;
            case "4":
                click(btnKey4);
                break;
            case "5":
                click(btnKey5);
                break;
            case "6":
                click(btnKey6);
                break;
            case "7":
                click(btnKey7);
                break;
            case "8":
                click(btnKey8);
                break;
            case "9":
                click(btnKey9);
                break;
            case "0":
                click(btnKey0);
                break;
        }
    }

    private void clickHoanThanh() {
        tap(btnHoanThanh);
    }
}