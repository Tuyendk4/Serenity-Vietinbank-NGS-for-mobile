package vn.vietinbank.screens.mobile.ipay.ipay_common;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import com.epam.reportportal.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Launcher extends BaseScreen {

  private final String btnSkip = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tv_skip\"] and @text=\"Bỏ qua\"]";

  public Launcher(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn Bỏ qua")
  public Signup click_Skip() {
    if(appiumDriver instanceof AndroidDriver){
      if(waitForElementVisible(btnSkip, 20)) {
        click(btnSkip);
      } else {
        tapAt(50, 2100);
      }
    }
    return new Signup(appiumDriver);
  }

}
