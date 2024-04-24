package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdvertisingPopup extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
//  @AndroidFindBy(xpath = "//XCUIElementTypeButton[@name=\"closeWhite\"]")
  public WebElementFacade iconClose;

  public void close() {
    iconClose.click();
//    click(iconClose);
  }
}
