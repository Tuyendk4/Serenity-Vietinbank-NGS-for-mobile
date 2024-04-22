package screens.mobile;

import base.BaseScreen;
import utils.keywords.MobileUI;

public class Login extends BaseScreen {

  public Login(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(Login.class.getSimpleName());
  }

  private void inputUserName(String userName) {
    mobileUI.sendKeys(getXpathOfElement("TXT_TEN_DANG_NHAP"), userName);
  }

  private void inputPassword(String password) {
    mobileUI.sendKeys(getXpathOfElement("TXT_MAT_KHAU"), password);
  }

  private void click_dang_nhap_button() {
    mobileUI.click(getXpathOfElement("BTN_DANG_NHAP"));
  }

  public OTP login_with(String userName, String password) {
    inputUserName(userName);
    inputPassword(password);
    click_dang_nhap_button();
    return new OTP(mobileUI);
  }
}
