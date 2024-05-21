package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;

public class Launcher extends BaseScreen {

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Không cho phép dán\"]")
//  public WebElement btnKhongChoPhepDan;

  private final String btnSkip = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tv_skip\"] and @text=\"Bỏ qua\"]";

  public Launcher(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Signup click_Skip() {
    if(appiumDriver instanceof AndroidDriver){
//      click(btnSkip);
      delay(3000);
      tapAt(50, 2100);
    }
    return new Signup(appiumDriver);
  }

}
