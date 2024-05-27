package runner;

import base.MobileDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;
import screens.mobile.*;
import screens.mobile.M2S02.TransferAndReceive;


@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {"pretty", "json:target/cucumber.json"},
    glue = {"steps"})
public class Runner {

//  @Managed(driver = "provided")
  public static MobileDriver mobileDriver;

  protected static AppiumDriver appiumDriver;

  protected static Login login;

  protected static Home home;

  protected static LoanAndCreditServices loanAndCreditServices;

  protected static PersonalInstalmentLoan personalInstalmentLoan;

  protected static TransferAndReceive transferAndReceive;

}
