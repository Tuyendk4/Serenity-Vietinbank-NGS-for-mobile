package vn.vietinbank.steps.mobile.ipay;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.useDriver;

import vn.vietinbank.screens.mobile.base.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class Hooks extends BaseStep {

  @Before
  public void before() {
    mobileDriver = new MobileDriver();
    appiumDriver = mobileDriver.newDriver();

  }

  @After
  public void after() {
    useDriver(null);

    mobileDriver.closeApplication();

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
