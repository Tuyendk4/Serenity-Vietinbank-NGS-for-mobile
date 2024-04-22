package screens.mobile;

import base.BaseScreen;
import screens.mobile.sections.NavigationBar;
import utils.keywords.MobileUI;

public class LoanAndCreditService extends BaseScreen {

  public LoanAndCreditService(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(LoanAndCreditService.class.getSimpleName());
  }

  public void click_vay_tieu_dung_ca_nhan() {
    mobileUI.click(getXpathOfElement("BTN_VAY_TIEU_DUNG_CA_NHAN"));
  }

  public NavigationBar navigationBar() {
    return new NavigationBar(mobileUI);
  }
}
