package screens.mobile;

import base.BaseScreen;
import org.apache.commons.lang3.StringUtils;
import utils.keywords.MobileUI;

public class OTP extends BaseScreen {

  public OTP(MobileUI mobileUI) {
    super(mobileUI);
    setRepoName(OTP.class.getSimpleName());
  }

  public Home inputOTP(String otp) {
    String[] characters = otp.split("");
    for (String character : characters) {
      mobileUI.click(getXpathOfElementWithParam("BTN_NUMBER", character));
    }
    mobileUI.click(getXpathOfElement("BTN_HOAN_THANH"));
    return new Home(mobileUI);
  }


}
