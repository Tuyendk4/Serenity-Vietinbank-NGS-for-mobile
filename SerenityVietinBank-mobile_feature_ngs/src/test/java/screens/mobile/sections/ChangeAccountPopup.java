package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.Signup;

public class ChangeAccountPopup extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Có\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Có\"]")
//  private WebElement btnYes;

  private final String android_btnYes = "//android.widget.Button[@text=\"Có\"]";
  private final String ios_btnYes = "//XCUIElementTypeButton[@name=\"Có\"]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Không\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Không\"]")
//  private WebElement btnNo;
private final String android_btnNo = "//android.widget.Button[@text=\"Không\"]";
private final String ios_btnNo = "//XCUIElementTypeButton[@name=\"Không\"]";

  public ChangeAccountPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Signup clickYes() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnYes);
    } else {
      click(ios_btnYes);
    }
    clickBackButton();
    return new Signup(appiumDriver);
  }
}
