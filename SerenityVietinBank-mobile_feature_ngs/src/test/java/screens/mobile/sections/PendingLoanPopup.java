package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PendingLoanPopup extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPopupResumeTitle\" and @text=\"Có khoản vay đang chờ\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Có khoản vay đang chờ\"]")
//  private WebElement lblPendingLoan;

  private final String android_lblPendingLoan = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPopupResumeTitle\" and @text=\"Có khoản vay đang chờ\"]";
  private final String ios_lblPendingLoan = "//XCUIElementTypeStaticText[@name=\"Có khoản vay đang chờ\"]";

  //  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnPopupResumeNext\" and @text=\"Tiếp tục mở khoản vay\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục mở khoản vay\"]")
//  private WebElement btnContinue;
  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnPopupResumeNext\" and @text=\"Tiếp tục mở khoản vay\"]";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục mở khoản vay\"]";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnPopupResumeCancel\" and @text=\"Thực hiện lại\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Thực hiện lại\"]")
//  private WebElement btnRetry;

  private final String android_btnRetry = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnPopupResumeCancel\" and @text=\"Thực hiện lại\"]";
  private final String ios_btnRetry = "//XCUIElementTypeButton[@name=\"Thực hiện lại\"]";

  public PendingLoanPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void clickContinue() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
  }

  public void clickRetry() {
    if(appiumDriver instanceof AndroidDriver){
      click(android_btnRetry);
    } else {
      click(ios_btnRetry);
    }
  }

  public boolean isDisplayed() {
    WebElement lblPendingLoan = null;
    if(appiumDriver instanceof AndroidDriver){
      lblPendingLoan = findElement(android_lblPendingLoan, 10);
    } else {
      lblPendingLoan = findElement(ios_lblPendingLoan, 10);
    }
    return waitForElementVisible(lblPendingLoan, 10);
  }
}
