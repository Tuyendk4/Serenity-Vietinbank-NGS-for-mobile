package runner;

import base.MobileDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import screens.mobile.Home;
import screens.mobile.LoanAndCreditServices;
import screens.mobile.Login;
import screens.mobile.PersonalInstalmentLoan;


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

}
