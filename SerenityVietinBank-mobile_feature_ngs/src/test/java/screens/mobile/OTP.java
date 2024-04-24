package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class OTP extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hoàn thành\"]")
  private WebElementFacade btnHoanThanh;
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey")
  private List<WebElementFacade> btnKeys;

  public OTP() {
    super();
  }

  public Home inputOTP(String otp) {
    String[] characters = otp.split("");
    for (int i = 0; i < characters.length; i++) {
      String actualKey = btnKeys.get(i).getText();
      if(actualKey.equals(characters[i])){
        click(btnKeys.get(i));
        break;
      }
    }
    click(btnHoanThanh);
    return new Home();
  }


}
