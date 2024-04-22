package screens.mobile;

import base.BaseScreen;
import utils.keywords.MobileUI;

public class Launcher extends BaseScreen {

  public Launcher(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(Launcher.class.getSimpleName());
  }

  public Signup click_khong_cho_phep_dan() {
    mobileUI.click(getXpathOfElement("BTN_KHONG_CHO_PHEP_DAN"));
    return new Signup(mobileUI);
  }

}
