package utils.helper;

import com.jayway.jsonpath.JsonPath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.webdriver.DriverSource;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;

public class MobileDriver implements DriverSource {

  private static final Logger logger = LogHelper.getLogger();

  private static final String ADDRESS = "127.0.0.1";
  private static final String APPIUM_CONFIG_PATH =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
          + File.separator + "resources" + File.separator + "appium_config.json";
  public static EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
  private static AppiumDriverLocalService service;
  private final String node_path;
  private final String appium_path;

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

  @Override
  public WebDriver newDriver() {
    startAppiumServer();
    WebDriver driver = null;
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
      } else {
        dc.setCapability("appium:bundleId", EnvironmentSpecificConfiguration.from(env)
            .getProperty("ios.bundleId"));
        dc.setCapability("appium:automationName", "XCUITest");
        dc.setCapability("noReset", "true");
      }
      driver = new AppiumDriver(getUrl(), dc);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return driver;
  }

  @Override
  public boolean takesScreenshots() {
    return false;
  }
}
