package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
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

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hoàn thành\"]")
  public WebElement btnHoanThanh;


  public OTP(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhập OTP: {0}")
  public Home inputOTP(String otp) {
    String[] characters = otp.split("");
    for (String character : characters) {
      inputCharacter(character);
    }
    clickHoanThanh();
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

  private void clickHoanThanh() {
    click(btnHoanThanh);
  }


}
