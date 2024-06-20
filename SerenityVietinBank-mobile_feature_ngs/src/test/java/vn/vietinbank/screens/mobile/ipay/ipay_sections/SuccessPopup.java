package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.PersonalInstalmentLoan_SuccessfulApplicationAppraisal;

public class SuccessPopup extends BaseScreen {

  private final String android_lblNotification = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_title\"]/following-sibling::android.widget.TextView";
  private final String ios_lblNotification = "//XCUIElementTypeStaticText[@name=\"Thành công\"]/following-sibling::XCUIElementTypeStaticText";

  private final String android_btnAgree = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/bt_right\" and @text=\"Đồng ý\"]";
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
    return getText(lblNotification);
  }

  @Step("Nhấn Đồng ý")
  public PersonalInstalmentLoan_SuccessfulApplicationAppraisal clickAgreeButton() {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnAgree);
    } else {
      click(ios_btnAgree);
    }
    delay(5000);
    return new PersonalInstalmentLoan_SuccessfulApplicationAppraisal(appiumDriver);
  }
}
