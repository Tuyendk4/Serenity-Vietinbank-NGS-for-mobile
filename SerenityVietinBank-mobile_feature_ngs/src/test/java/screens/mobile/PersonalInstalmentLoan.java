package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.PendingLoanPopup;

public class PersonalInstalmentLoan extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/btnCalculateNow\" and @text=\"Tính toán ngay\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]")
//  private WebElement btnCalculateNow;

  private final String android_btnCalculateNow = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/btnCalculateNow\" and @text=\"Tính toán ngay\"]";
  private final String ios_btnCalculateNow = "//XCUIElementTypeButton[@name=\"Tính toán ngay\"]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Vay ngay\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Vay ngay\"]")
//  private WebElement btnBorrowNow;

  private final String android_btnBorrowNow = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Vay ngay\"]";
  private final String ios_btnBorrowNow = "//XCUIElementTypeButton[@name=\"Vay ngay\"]";


  public PersonalInstalmentLoan(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public CalculatorTool clickCalculateNow() {
    if(pendingLoanPopup().isDisplayed()) {
      pendingLoanPopup().clickRetry();
    }
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnCalculateNow);
    } else {
      click(ios_btnCalculateNow);
    }
    return new CalculatorTool(this.appiumDriver);
  }

  public PendingLoanPopup pendingLoanPopup() {
    return new PendingLoanPopup(this.appiumDriver);
  }



}
