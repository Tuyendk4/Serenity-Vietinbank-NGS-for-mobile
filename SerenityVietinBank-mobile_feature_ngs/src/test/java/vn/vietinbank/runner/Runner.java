package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;


@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
    glue = {"vn.vietinbank.steps"})
public class Runner {
}
