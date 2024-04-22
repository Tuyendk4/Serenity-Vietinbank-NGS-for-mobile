package screens.mobile.sections;

import base.BaseScreen;
import screens.mobile.UserProfile;
import utils.keywords.MobileUI;

public class NavigationBar extends BaseScreen {

  public NavigationBar(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(NavigationBar.class.getSimpleName());
  }

  public UserProfile goToUserProfile() {
    mobileUI.click(getXpathOfElement("BTN_USER_PROFILE"));
    return new UserProfile(mobileUI);
  }
}
