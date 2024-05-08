package steps;

import base.MobileDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import runner.Runner;

public class Hooks extends Runner {

  @BeforeAll
  public static void beforeAll() {
    mobileDriver = new MobileDriver();
    appiumDriver = mobileDriver.newDriver();
  }

  @AfterAll
  public static void afterAll() {
    mobileDriver.closeApplication();
  }
}
