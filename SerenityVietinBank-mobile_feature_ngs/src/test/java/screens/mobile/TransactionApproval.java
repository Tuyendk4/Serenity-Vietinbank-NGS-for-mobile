package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TransactionApproval extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"iconLineTrace\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther")
  private WebElement txtOTPCode;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[1]")
  public WebElement btnKey1;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[2]")
  public WebElement btnKey2;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[3]")
  public WebElement btnKey3;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[4]")
  public WebElement btnKey4;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[5]")
  public WebElement btnKey5;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[6]")
  public WebElement btnKey6;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[7]")
  public WebElement btnKey7;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[8]")
  public WebElement btnKey8;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[9]")
  public WebElement btnKey9;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[11]")
  public WebElement btnKey0;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/submit\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xác nhận & hoàn tất\"]")
  public WebElement btnConfirmAndFinish;

  public TransactionApproval(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Home inputOTP(String otp) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(txtOTPCode, otp);
    } else {
      click(txtOTPCode);
      String[] characters = otp.split("");
      for (String character : characters) {
        inputCharacter(character);
      }
    }
    clickConfirmAndFinish();
    return new Home(appiumDriver);
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

  private void clickConfirmAndFinish() {
    click(btnConfirmAndFinish);
  }

}
