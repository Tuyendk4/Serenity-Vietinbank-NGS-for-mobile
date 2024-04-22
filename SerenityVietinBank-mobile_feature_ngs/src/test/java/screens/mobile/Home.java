package screens.mobile;

import base.BaseScreen;
import screens.mobile.sections.AdvertisingPopup;
import screens.mobile.sections.FavoriteServices;
import utils.keywords.MobileUI;

public class Home extends BaseScreen {

  public Home(MobileUI mobileUI) {
    super(mobileUI);
  }

  public FavoriteServices favoriteServices() {
    return new FavoriteServices(mobileUI);
  }

  public AdvertisingPopup advertisingPopup() {
    return new AdvertisingPopup(mobileUI);
  }


}
