package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TransactionResult extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"logoVietinFull\"]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText")
  private WebElement lblNotificationContent;

  private final String android_lblNotificationContent = "";
  private final String ios_lblNotificationContent = "//XCUIElementTypeImage[@name=\"logoVietinFull\"]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText";

  public TransactionResult(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotificationContent() {
    if(appiumDriver instanceof AndroidDriver){
      return getText(android_lblNotificationContent);
    } else {
      return getText(ios_lblNotificationContent);
    }
  }
}
