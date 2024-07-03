package vn.vietinbank.steps.mobile.ipay;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.screens.mobile.base.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {

  private static MobileDriver mobileDriver;

  @Before
  public void before() {
    mobileDriver = new MobileDriver();
    AppiumDriver appiumDriver = mobileDriver.newDriver();
    Serenity.setSessionVariable("appiumDriver").to(appiumDriver);
  }

  @After
  public void after() {
    mobileDriver.closeApplication();

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
