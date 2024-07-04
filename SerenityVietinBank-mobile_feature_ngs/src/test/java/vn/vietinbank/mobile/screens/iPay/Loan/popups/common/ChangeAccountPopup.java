package vn.vietinbank.mobile.screens.iPay.Loan.popups.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.mobile.common.BaseScreen;
import vn.vietinbank.mobile.screens.iPay.UserAction.Signup.SignupScreen;

public class ChangeAccountPopup extends BaseScreen {

  private final String android_btnYes = "//*[@text=\"Có\"]";
  private final String ios_btnYes = "//XCUIElementTypeButton[@name=\"Có\"]";

  private final String android_btnNo = "//*[@text=\"Không\"]";
  private final String ios_btnNo = "//XCUIElementTypeButton[@name=\"Không\"]";

  public ChangeAccountPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public SignupScreen clickYes() {
    if (appiumDriver instanceof AndroidDriver) {
      tap(android_btnYes);
    } else {
      click(ios_btnYes);
    }
    clickBackButton();
    return new SignupScreen(appiumDriver);
  }
}
