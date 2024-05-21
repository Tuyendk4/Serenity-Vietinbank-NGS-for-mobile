package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.PersonalInstalmentLoan_SuccessfulApplicationAppraisal;

public class SuccessPopup extends BaseScreen {

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Thành công\"]/following-sibling::XCUIElementTypeStaticText")
//  private WebElement lblNotification;

  private final String android_lblNotification = "";
  private final String ios_lblNotification = "//XCUIElementTypeStaticText[@name=\"Thành công\"]/following-sibling::XCUIElementTypeStaticText";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Đồng ý\"]")
//  private WebElement btnAgree;

  private final String android_btnAgree = "";
  private final String ios_btnAgree = "//XCUIElementTypeButton[@name=\"Đồng ý\"]";

  public SuccessPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotification() {
    WebElement lblNotification = null;
    if(appiumDriver instanceof AndroidDriver) {
      lblNotification = findElement(android_lblNotification);
    } else {
      lblNotification = findElement(ios_lblNotification);
    }
    return lblNotification.getText();
  }

  public PersonalInstalmentLoan_SuccessfulApplicationAppraisal clickAgreeButton() {
    WebElement btnAgree = null;
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnAgree);
    } else {
      btnAgree = findElement(ios_btnAgree);
    }
    delay(3000);
    return new PersonalInstalmentLoan_SuccessfulApplicationAppraisal(appiumDriver);
  }
}
