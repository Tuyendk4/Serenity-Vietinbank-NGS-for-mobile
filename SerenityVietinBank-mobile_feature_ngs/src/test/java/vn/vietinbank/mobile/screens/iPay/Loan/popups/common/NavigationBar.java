package vn.vietinbank.mobile.screens.iPay.Loan.popups.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;
import vn.vietinbank.mobile.common.BaseScreen;
import vn.vietinbank.mobile.screens.iPay.UserAction.Profile.UserProfileScreen;

public class NavigationBar extends BaseScreen {

  private final String android_btnHome = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/home\"]";
  private final String ios_btnHome = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]";

  private final String android_btnNotification = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/notifi\"]";
  private final String ios_btnNotification = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]";

  private final String android_btnStore = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/search\"]";
  private final String ios_btnStore = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]";

  private final String android_btnMarket = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/thi_truong\"]";
  private final String ios_btnMarket = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]";

  private final String android_btnUserProfile = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/setting\"]";
  private final String ios_btnUserProfile = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]";

  public NavigationBar(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn vào User Profile icon")
  public UserProfileScreen goToUserProfile() {
     if(appiumDriver instanceof AndroidDriver) {
       click(android_btnUserProfile);
     } else {
       click(ios_btnUserProfile);
     }
     delay(3000);
    return new UserProfileScreen(appiumDriver);
  }
}
