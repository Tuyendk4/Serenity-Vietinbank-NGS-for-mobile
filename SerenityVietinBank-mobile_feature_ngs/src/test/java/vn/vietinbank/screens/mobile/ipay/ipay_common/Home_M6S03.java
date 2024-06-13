package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.ipay.M6S03.LoansForProductionAndBusiness_2;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.AdvertisingPopup;
import vn.vietinbank.screens.mobile.ipay.ipay_sections.FavoriteServices;

public class Home_M6S03 extends BaseScreen {

  private final String android_btnLoansForProductionAndBusiness = "//android.widget.TextView[@text=\"Vay sản xuất kinh doanh\"]";
  private final String ios_btnLoansForProductionAndBusiness = "**/XCUIElementTypeStaticText[`name == \"Vay sản xuất kinh doanh\"`]";

  public Home_M6S03(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public LoansForProductionAndBusiness_2 click_vay_san_xuat_kinh_doanh() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnLoansForProductionAndBusiness);
    } else {
      click_iosClassChain(ios_btnLoansForProductionAndBusiness);
    }
    return new LoansForProductionAndBusiness_2(this.appiumDriver);
  }
}
