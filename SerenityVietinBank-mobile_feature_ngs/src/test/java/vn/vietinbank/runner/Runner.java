package vn.vietinbank.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber-reports/Cucumber.xml"},
        glue = {"vn.vietinbank.mobile.steps", "vn.vietinbank.api.steps", "vn.vietinbank.api.steps.qrSmartPOS", "vn.vietinbank.runner"})

public class Runner {

}
