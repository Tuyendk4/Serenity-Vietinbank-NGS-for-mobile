package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;
import java.util.List;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;

public class OTP extends BaseScreen {

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[1]")
//  public WebElement btnKey1;

//  private final String android_ = "";
  private final String ios_btnKey1 = "";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[2]")
//  public WebElement btnKey2;

//  private final String android_ = "";
  private final String ios_btnKey2 = "//XCUIElementTypeKey[2]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[3]")
//  public WebElement btnKey3;

//  private final String android_ = "";
  private final String ios_btnKey3 = "//XCUIElementTypeKey[3]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[4]")
//  public WebElement btnKey4;

//  private final String android_ = "";
  private final String ios_btnKey4 = "//XCUIElementTypeKey[4]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[5]")
//  public WebElement btnKey5;

//  private final String android_ = "";
  private final String ios_btnKey5 = "//XCUIElementTypeKey[5]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[6]")
//  public WebElement btnKey6;

//  private final String android_ = "";
  private final String ios_btnKey6 = "//XCUIElementTypeKey[6]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[7]")
//  public WebElement btnKey7;

//  private final String android_ = "";
  private final String ios_btnKey7 = "//XCUIElementTypeKey[7]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[8]")
//  public WebElement btnKey8;

//  private final String android_ = "";
  private final String ios_btnKey8 = "//XCUIElementTypeKey[8]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[9]")
//  public WebElement btnKey9;

//  private final String android_ = "";
  private final String ios_btnKey9 = "//XCUIElementTypeKey[9]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[11]")
//  public WebElement btnKey0;

//  private final String android_ = "";
  private final String ios_btnKey0 = "//XCUIElementTypeKey[11]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/submit\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hoàn thành\"]")
//  public WebElement btnHoanThanh;

  private final String android_btnHoanThanh = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/submit\"]";
  private final String ios_btnHoanThanh = "//XCUIElementTypeButton[@name=\"Hoàn thành\"]";

//  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/otp_editText\"]")
//  public WebElement txtOTP;

  private final String android_txtOTP = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/otp_editText\"]";
//  private final String ios_ = "";

  public OTP(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Home inputOTP(String otp) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtOTP, otp);
    } else {
      String[] characters = otp.split("");
      for (String character : characters) {
        inputCharacter(character);
      }
    }
    clickHoanThanh();
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

  private void clickHoanThanh() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnHoanThanh);
    } else {
      click(ios_btnHoanThanh);
    }
  }
}
