package screens.mobile;

import base.BaseScreen;
import utils.keywords.MobileUI;

public class UserProfile extends BaseScreen {

  public UserProfile(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(UserProfile.class.getSimpleName());
  }

  public Home click_dang_xuat() {
    mobileUI.click(getXpathOfElement("BTN_DANG_XUAT"));
    return new Home(mobileUI);
  }
}
