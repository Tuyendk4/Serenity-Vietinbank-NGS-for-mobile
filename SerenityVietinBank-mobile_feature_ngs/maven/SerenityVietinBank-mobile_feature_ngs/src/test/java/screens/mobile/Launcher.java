package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;

public class Launcher extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Không cho phép dán\"]")
  public WebElement btnKhongChoPhepDan;

  public Launcher(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public Signup click_khong_cho_phep_dan() {
//    startApplication();
//    logger.info("Element {}", btnKhongChoPhepDan);
//    if (btnKhongChoPhepDan != null) {
//      btnKhongChoPhepDan.click();
//    }
//    click(btnKhongChoPhepDan);
//    setDriver(mobileDriver.newDriver());
    return new Signup(appiumDriver);
  }

}
