package vn.vietinbank.runner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.common.MobileDriver;
import vn.vietinbank.utils.data.GetData;
import vn.vietinbank.utils.run.RunScript;

import java.io.File;

public class Hooks {

    public static MobileDriver mobileDriver;
    public static RunScript runScript;
    static String pathShellScriptFolder = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "shellScript" + File.separator;

    @Before
    public static void before() {
//        runScript = new RunScript();
//        if (new GetData().getValueOf("OS").equals("MacOS")) {
//            runScript.runShellScript(pathShellScriptFolder + "stop_appium.sh");
//        }
        mobileDriver = new MobileDriver();
    }

    @After
    public static void after() {
        AppiumDriver appiumDriver = Serenity.sessionVariableCalled("appiumDriver");
        if (appiumDriver != null) {
            mobileDriver.closeApplication();
//            runScript.runShellScript(pathShellScriptFolder + "stop_appium.sh");
        }
    }
}
