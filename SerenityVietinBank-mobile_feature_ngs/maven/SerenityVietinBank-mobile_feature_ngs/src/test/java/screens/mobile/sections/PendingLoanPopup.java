package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;

public class PendingLoanPopup extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvPopupResumeTitle\" and @text=\"Có khoản vay đang chờ\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Có khoản vay đang chờ\"]")
  private WebElement lblPendingLoan;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnPopupResumeNext\" and @text=\"Tiếp tục mở khoản vay\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục mở khoản vay\"]")
  private WebElement btnContinue;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnPopupResumeCancel\" and @text=\"Thực hiện lại\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Thực hiện lại\"]")
  private WebElement btnRetry;

  public PendingLoanPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void clickContinue() {
    btnContinue.click();
  }

  public void clickRetry() {
    btnRetry.click();
  }

  public boolean isDisplayed() {
    return waitForElementVisible(lblPendingLoan, 10);
  }
}
