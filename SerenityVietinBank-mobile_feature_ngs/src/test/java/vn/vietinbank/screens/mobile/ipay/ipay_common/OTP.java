package vn.vietinbank.screens.mobile.ipay.ipay_common;

import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class OTP extends BaseScreen {

    private final String ios_btnKey1 = "//XCUIElementTypeKey[1]";

    //  private final String android_ = "";
    private final String ios_btnKey2 = "//XCUIElementTypeKey[2]";

    //  private final String android_ = "";
    private final String ios_btnKey3 = "//XCUIElementTypeKey[3]";

    //  private final String android_ = "";
    private final String ios_btnKey4 = "//XCUIElementTypeKey[4]";

    //  private final String android_ = "";
    private final String ios_btnKey5 = "//XCUIElementTypeKey[5]";

    //  private final String android_ = "";
    private final String ios_btnKey6 = "//XCUIElementTypeKey[6]";

    //  private final String android_ = "";
    private final String ios_btnKey7 = "//XCUIElementTypeKey[7]";

    //  private final String android_ = "";
    private final String ios_btnKey8 = "//XCUIElementTypeKey[8]";

    //  private final String android_ = "";
    private final String ios_btnKey9 = "//XCUIElementTypeKey[9]";

    //  private final String android_ = "";
    private final String ios_btnKey0 = "//XCUIElementTypeKey[11]";

    private final String android_btnDone = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/submit\"]";
    private final String ios_btnDone = "//XCUIElementTypeButton[@name=\"Hoàn thành\"]";

    private final String android_txtOTP = "//android.widget.EditText[@resource-id=\"com.vietinbank.mobile.ipay:id/otp_editText\"]";
//  private final String ios_ = "";

    public OTP(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @Step("Nhập OTP: {otp}")
    public Home inputOTP(String otp) {
        if (appiumDriver instanceof AndroidDriver) {
            sendKeys(android_txtOTP, otp);
        } else {
            String[] characters = otp.split("");
            for (String character : characters) {
                inputCharacter(character);
            }
        }
        clickDone();
        return new Home(appiumDriver);
    }

    private void inputCharacter(String character) {
        switch (character) {
            case "1":
                click(ios_btnKey1);
                break;
            case "2":
                click(ios_btnKey2);
                break;
            case "3":
                click(ios_btnKey3);
                break;
            case "4":
                click(ios_btnKey4);
                break;
            case "5":
                click(ios_btnKey5);
                break;
            case "6":
                click(ios_btnKey6);
                break;
            case "7":
                click(ios_btnKey7);
                break;
            case "8":
                click(ios_btnKey8);
                break;
            case "9":
                click(ios_btnKey9);
                break;
            case "0":
                click(ios_btnKey0);
                break;
        }
    }

    private void clickDone() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnDone);
        } else {
            click(ios_btnDone);
        }
    }
}
