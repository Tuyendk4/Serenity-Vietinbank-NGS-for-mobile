package screens.mobile.sections;

import base.BaseScreen;
import screens.mobile.LoanAndCreditService;
import utils.keywords.MobileUI;

public class FavoriteServices extends BaseScreen {


  public FavoriteServices(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(FavoriteServices.class.getSimpleName());
  }

  public LoanAndCreditService click_dich_vu_vay_va_tin_dung() {
    mobileUI.click(getXpathOfElement("ICON_DICH_VU_VAY_VA_TIN_DUNG"));
    return new LoanAndCreditService(mobileUI);
  }
}
