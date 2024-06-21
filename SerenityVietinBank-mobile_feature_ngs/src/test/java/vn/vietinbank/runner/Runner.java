package vn.vietinbank.runner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;
import vn.vietinbank.screens.mobile.ipay.M2S02.TransferAndReceive;
import vn.vietinbank.screens.mobile.base.MobileDriver;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Login;
import vn.vietinbank.screens.mobile.ipay.loan_service_m7s01.LoanAndCreditServices;


@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
    glue = {"vn.vietinbank.steps"})
public class Runner {

}
