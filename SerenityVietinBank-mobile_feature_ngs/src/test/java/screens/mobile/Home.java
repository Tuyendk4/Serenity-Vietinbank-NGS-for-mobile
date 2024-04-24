package screens.mobile;

import base.BaseScreen;
import screens.mobile.sections.AdvertisingPopup;
import screens.mobile.sections.FavoriteServices;

public class Home extends BaseScreen {

  public Home() {
    super();
  }

  public FavoriteServices favoriteServices() {
    return new FavoriteServices();
  }

  public AdvertisingPopup advertisingPopup() {
    return new AdvertisingPopup();
  }


}
