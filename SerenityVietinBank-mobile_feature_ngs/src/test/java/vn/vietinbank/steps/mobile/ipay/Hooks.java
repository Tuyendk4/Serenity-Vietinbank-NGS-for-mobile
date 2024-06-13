package vn.vietinbank.steps.mobile.ipay;

import io.cucumber.java.Before;
import vn.vietinbank.screens.mobile.base.MobileDriver;
import vn.vietinbank.steps.mobile.ipay.base.BaseStep;


public class Hooks extends BaseStep {

    @Before
    public void before() {
        mobileDriver = new MobileDriver();
        appiumDriver = mobileDriver.newDriver();
    }
//
//  @After
//  public void after() {
//    mobileDriver.closeApplication();
//  }
}
