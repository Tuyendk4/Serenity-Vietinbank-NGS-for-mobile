package runner;

import base.MobileDriver;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;


@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "json:target/cucumber.json"},
        glue = {"steps"})
public class Runner {
    public static MobileDriver mobileDriver;
}
