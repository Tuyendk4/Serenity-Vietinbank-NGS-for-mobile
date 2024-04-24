package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import screens.mobile.UserProfile;

public class NavigationBar extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]")
  public WebElementFacade btnHome;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]")
  public WebElementFacade btnNotification;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]")
  public WebElementFacade btnStore;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]")
  public WebElementFacade btnMarket;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]")
  public WebElementFacade btnUserProfile;

  public NavigationBar() {
    super();
  }

  public UserProfile goToUserProfile() {
    btnUserProfile.click();
//    click(btnUserProfile);
    return new UserProfile();
  }
}
