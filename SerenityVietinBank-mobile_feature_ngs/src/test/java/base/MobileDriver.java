package base;

import com.jayway.jsonpath.JsonPath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import utils.helper.LogHelper;

public class MobileDriver {

  private static final Logger logger = LogHelper.getLogger();

  private static final String ADDRESS = "127.0.0.1";
  private static final String APPIUM_CONFIG_PATH =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
          + File.separator + "resources" + File.separator + "appium_config.json";
  public static EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
  public static String APP_PATH = System.getProperty("user.dir") + File.separator + "apps" + File.separator;
  private static AppiumDriverLocalService service;
  private final String node_path;
  private final String appium_path;
  private static AppiumDriver appiumDriver;

  public MobileDriver() {
    File appiumConfig = new File(APPIUM_CONFIG_PATH);
    try {
      node_path = JsonPath.read(appiumConfig, "$.node_path");
      appium_path = JsonPath.read(appiumConfig, "$.appium_path");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void stopAppiumServer() {
    service.stop();
  }

  private void startAppiumServer() {
    logger.info("Starting appium server");
    try {
      service = AppiumDriverLocalService.buildService(
          new AppiumServiceBuilder().withIPAddress(ADDRESS).usingAnyFreePort()
              .usingDriverExecutable(new File(node_path)).
              withAppiumJS(new File(appium_path)));
      service.start();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private URL getUrl() {
    return service.getUrl();
  }

  public AppiumDriver newDriver() {
    if(EnvironmentSpecificConfiguration.from(env)
        .getProperty("appium_server").equals("auto")) {
      startAppiumServer();
    }
    logger.info("Starting appium driver");
    AppiumDriver driver = null;
    try {
      DesiredCapabilities dc = new DesiredCapabilities();
      dc.setCapability("platformName", EnvironmentSpecificConfiguration.from(env)
          .getProperty("platformName"));
      dc.setCapability("appium:platformVersion", EnvironmentSpecificConfiguration.from(env)
          .getProperty("platformVersion"));
      dc.setCapability("appium:udid", EnvironmentSpecificConfiguration.from(env)
          .getProperty("udid"));
      dc.setCapability("appium:deviceName", EnvironmentSpecificConfiguration.from(env)
          .getProperty("deviceName"));
      if (EnvironmentSpecificConfiguration.from(env)
          .getProperty("platformName").equalsIgnoreCase("ANDROID")) {
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:appPackage", EnvironmentSpecificConfiguration.from(env)
            .getProperty("android.appPackage"));
        dc.setCapability("appium:appActivity", EnvironmentSpecificConfiguration.from(env)
            .getProperty("android.appActivity"));
        if(EnvironmentSpecificConfiguration.from(env)
            .getProperty("appium_server").equals("auto")) {
          driver = new AndroidDriver(getUrl(), dc);
        } else {
          driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), dc);
        }
      } else {
        dc.setCapability("appium:bundleId", EnvironmentSpecificConfiguration.from(env)
            .getProperty("ios.bundleId"));
        dc.setCapability("appium:automationName", "XCUITest");
        dc.setCapability("noReset", "true");
        if(EnvironmentSpecificConfiguration.from(env)
            .getProperty("appium_server").equals("auto")) {
          driver = new IOSDriver(getUrl(), dc);
        }  else {
          driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), dc);
        }
      }
      appiumDriver = driver;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    logger.info("Driver: {}", driver);
    return driver;
  }

  public void closeApplication() {
    String appID = "";
    if (null != appiumDriver) {
      try {
        if (appiumDriver instanceof AndroidDriver) {
          appID = (String) appiumDriver.getCapabilities().getCapability("appium:appPackage");
        } else if (appiumDriver instanceof IOSDriver) {
          appID = String.valueOf(appiumDriver.getCapabilities().getCapability("appium:bundleId"));
        }
        if (appID != null)
          ((InteractsWithApps) appiumDriver).terminateApp(appID);
      } catch (Exception e) {
        logger.error(e.getMessage());
      }
      if(EnvironmentSpecificConfiguration.from(env)
          .getProperty("appium_server").equals("auto")) {
        stopAppiumServer();
      }
    }
  }

  public static AppiumDriver getAppiumDriver() {
    return appiumDriver;
  }
}
