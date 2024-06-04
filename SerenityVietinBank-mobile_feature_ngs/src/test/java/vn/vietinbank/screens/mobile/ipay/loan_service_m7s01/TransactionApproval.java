package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TransactionApproval extends BaseScreen {

  private final String android_txtOTPCode = "";
  private final String ios_txtOTPCode = "//XCUIElementTypeImage[@name=\"iconLineTrace\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther";

//  private final String android_ = "";
  private final String ios_btnKey1 = "//XCUIElementTypeKey[2]";

//  private final String android_ = "";
  private final String ios_btnKey2 = "//XCUIElementTypeKey[2]";

//  private final String android_ = "";
  private final String ios_btnKey3 = "//XCUIElementTypeKey[3]";

//  private final String android_ = "";
  private final String ios_btnKey4 = "//XCUIElementTypeKey[4]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[5]")
//  public WebElement btnKey5;
//
//  private final String android_ = "";
  private final String ios_btnKey5 = "//XCUIElementTypeKey[5]";

//  private final String android_ = "";
  private final String ios_btnKey6 = "//XCUIElementTypeKey[6]";

//  private final String android_btnKey7 = "";
  private final String ios_btnKey7 = "//XCUIElementTypeKey[7]";

//  private final String android_ = "";
  private final String ios_btnKey8 = "//XCUIElementTypeKey[8]";

//  private final String android_btnKey9 = "";
  private final String ios_btnKey9 = "//XCUIElementTypeKey[9]";

//  private final String android_ = "";
  private final String ios_btnKey0 = "//XCUIElementTypeKey[11]";

  private final String android_btnConfirmAndFinish = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/submit\"]";
  private final String ios_btnConfirmAndFinish = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]";

  public TransactionApproval(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public TransactionResult inputOTP(String otp) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtOTPCode, otp);
    } else {
      click(ios_txtOTPCode);
      String[] characters = otp.split("");
      for (String character : characters) {
        inputCharacter(character);
      }
    }
    clickConfirmAndFinish();
    return new TransactionResult(appiumDriver);
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

  private void clickConfirmAndFinish() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnConfirmAndFinish);
    } else {
      click(ios_btnConfirmAndFinish);
    }
  }

}
