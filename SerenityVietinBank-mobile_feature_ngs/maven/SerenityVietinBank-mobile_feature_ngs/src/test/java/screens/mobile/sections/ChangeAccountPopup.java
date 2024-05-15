package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.Signup;

public class ChangeAccountPopup extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Có\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Có\"]")
  private WebElement btnYes;

  @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Không\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Không\"]")
  private WebElement btnNo;
  public ChangeAccountPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Signup clickYes() {
    click(btnYes);
    clickBackButton();
    return new Signup(appiumDriver);
  }
}
