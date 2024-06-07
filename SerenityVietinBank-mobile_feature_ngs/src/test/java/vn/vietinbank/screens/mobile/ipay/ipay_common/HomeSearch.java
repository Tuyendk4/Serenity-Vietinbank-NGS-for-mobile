package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;

import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.ipay_InstallmentCreditCard.BySearch.BySearch;


public class HomeSearch extends BaseScreen {


  @iOSXCUITFindBy(xpath = "  //XCUIElementTypeButton[@name=\"iconHomeSearch\"]")
  private WebElement iconHomeSearch;

//  @iOSXCUITFindBy(xpath = "  //XCUIElementTypeTextField[@value=\"Bạn đang muốn tìm gì?\"]")
//  private WebElement inputHomeSearch;


  public HomeSearch(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }
  @Step("Mở ô tìm kiếm")
  public BySearch chonTimKiem() {
    if (appiumDriver instanceof IOSDriver) {
      tap(iconHomeSearch);
    }
    return new BySearch(appiumDriver);
  }



}

