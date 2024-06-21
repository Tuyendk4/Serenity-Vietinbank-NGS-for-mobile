package vn.vietinbank.steps.mobile.ipay;

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
    mobileDriver.closeApplication();
  }


}
