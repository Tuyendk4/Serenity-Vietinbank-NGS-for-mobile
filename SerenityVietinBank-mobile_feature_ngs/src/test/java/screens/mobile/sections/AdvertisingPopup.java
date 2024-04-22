package screens.mobile.sections;

import base.BaseScreen;
import utils.keywords.MobileUI;

public class AdvertisingPopup extends BaseScreen {


  public AdvertisingPopup(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(AdvertisingPopup.class.getSimpleName());
  }

  public void close() {
    mobileUI.click(getXpathOfElement("ICON_X"));
  }
}
