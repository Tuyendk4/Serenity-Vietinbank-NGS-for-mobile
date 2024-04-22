package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import screens.mobile.Home;
import screens.mobile.Login;
import utils.keywords.MobileUI;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "json:target/cucumber.json"},
        glue = {"steps"})
public class Runner {

  protected static MobileUI mobileUI;

  protected Login login;

  protected Home home;
}
