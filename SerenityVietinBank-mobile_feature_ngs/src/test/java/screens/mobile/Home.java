package screens.mobile;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.AdvertisingPopup;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.FavoriteServices;

public class Home extends BaseScreen {

  public Home(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public FavoriteServices favoriteServices() {
    return new FavoriteServices(appiumDriver);
  }

  public AdvertisingPopup advertisingPopup() {
    return new AdvertisingPopup(appiumDriver);
  }

}
