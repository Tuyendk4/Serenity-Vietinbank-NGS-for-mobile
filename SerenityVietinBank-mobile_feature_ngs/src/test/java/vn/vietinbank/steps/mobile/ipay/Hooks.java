package vn.vietinbank.steps.mobile.ipay;

import vn.vietinbank.screens.mobile.base.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import vn.vietinbank.steps.mobile.ipay.base.M7S01BaseStep;

public class Hooks extends M7S01BaseStep {

  @Before
  public void before() {
    mobileDriver = new MobileDriver();
    appiumDriver = mobileDriver.newDriver();
  }

  @After
  public void after() {
    mobileDriver.closeApplication();
  }
}
