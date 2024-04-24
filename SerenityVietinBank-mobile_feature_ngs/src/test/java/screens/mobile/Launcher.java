package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;

public class Launcher extends BaseScreen {

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Không cho phép dán\"]")
  public WebElementFacade btnKhongChoPhepDan;

  public Launcher() {
    super();
  }

  @Step("Click Không cho phép dán")
  public Signup click_khong_cho_phep_dan() {
    logger.info("Element {}", btnKhongChoPhepDan);
    if (btnKhongChoPhepDan != null) {
      btnKhongChoPhepDan.click();
    }
//    click(btnKhongChoPhepDan);
    return new Signup();
  }

}
