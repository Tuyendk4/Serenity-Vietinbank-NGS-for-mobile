package cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.annotations.Managed;
import org.junit.runner.RunWith;
import screens.mobile.Home;
import screens.mobile.Login;
import utils.helper.MobileDriver;


@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {"pretty", "json:target/cucumber.json"},
    glue = {"steps"})
public class CucumberTestSuite {

//  @Managed(driver = "provided")
//  public static MobileDriver driver;

  protected Login login;

  protected Home home;
}
