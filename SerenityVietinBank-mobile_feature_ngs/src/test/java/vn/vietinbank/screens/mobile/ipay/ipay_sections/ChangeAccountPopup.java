package vn.vietinbank.screens.mobile.ipay.ipay_sections;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Signup;

public class ChangeAccountPopup extends BaseScreen {

  private final String android_btnYes = "//android.widget.Button[@text=\"Có\"]";
  private final String ios_btnYes = "//XCUIElementTypeButton[@name=\"Có\"]";

  private final String android_btnNo = "//android.widget.Button[@text=\"Không\"]";
  private final String ios_btnNo = "//XCUIElementTypeButton[@name=\"Không\"]";

  public ChangeAccountPopup(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Signup clickYes() {
    if (appiumDriver instanceof AndroidDriver) {
      click(android_btnYes);
    } else {
      click(ios_btnYes);
    }
    clickBackButton();
    return new Signup(appiumDriver);
  }
}
