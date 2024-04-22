package screens.mobile;

import base.BaseScreen;
import utils.keywords.MobileUI;

public class Signup extends BaseScreen {

  public Signup(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(Signup.class.getSimpleName());
  }

  public Login click_dang_nhap_or_dang_ky_button() {
    mobileUI.click(getXpathOfElement("BTN_DANG_NHAP_OR_DANG_KY"));
    return new Login(mobileUI);
  }
}
