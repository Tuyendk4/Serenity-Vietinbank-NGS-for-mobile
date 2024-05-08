package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import screens.mobile.sections.AdvertisingPopup;
import screens.mobile.sections.FavoriteServices;

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
