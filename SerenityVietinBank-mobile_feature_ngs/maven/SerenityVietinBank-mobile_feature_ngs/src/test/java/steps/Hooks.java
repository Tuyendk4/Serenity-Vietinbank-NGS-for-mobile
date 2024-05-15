package steps;

import base.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import runner.Runner;

public class Hooks extends Runner {

  @Before
  public static void beforeAll() {
    mobileDriver = new MobileDriver();
    appiumDriver = mobileDriver.newDriver();
  }

  @After
  public static void afterAll() {
    mobileDriver.closeApplication();
  }
}
