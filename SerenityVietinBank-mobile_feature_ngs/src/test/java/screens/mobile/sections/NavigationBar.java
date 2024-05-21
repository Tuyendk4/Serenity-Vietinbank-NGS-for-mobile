package screens.mobile.sections;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import screens.mobile.UserProfile;

public class NavigationBar extends BaseScreen {

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]")
//  private WebElement btnHome;
  private final String ios_btnHome = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[1]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]")
//  private WebElement btnNotification;

  private final String ios_btnNotification = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[2]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]")
//  private WebElement btnStore;

  private final String ios_btnStore = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[3]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]")
//  private WebElement btnMarket;
  private final String ios_btnMarket = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[4]";

  public NavigationBar(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  @Step("Nhấn vào User Profile icon")
  public UserProfile goToUserProfile() {
     if(appiumDriver instanceof IOSDriver) {
       //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]")
       //  private WebElement btnUserProfile;
       String ios_btnUserProfile = "//XCUIElementTypeTabBar[@name=\"Thanh tab\"]/XCUIElementTypeButton[5]";
       click(ios_btnUserProfile);
     }
    return new UserProfile(appiumDriver);
  }
}
