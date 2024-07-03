package vn.vietinbank.mobile.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import vn.vietinbank.utils.data.GetData;

import java.io.File;
import java.net.URL;

import static io.appium.java_client.remote.MobilePlatform.IOS;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.useDriver;
import static vn.vietinbank.utils.Constants.*;

public class MobileDriver {

    private static final String ADDRESS = "127.0.0.1";
    private static AppiumDriverLocalService service;
    private static AppiumDriver appiumDriver;
    private final String devicesFilePath = String.format(pathMobileConfigs + "Devices.json");
    private final String platformVersion = new GetData().getValueFromJson(devicesFilePath, String.format(JSONPATH_BEGIN + "%s.%s.platformVersion", PLATFORM, udid));
    private final String deviceName = new GetData().getValueFromJson(devicesFilePath, String.format(JSONPATH_BEGIN + "%s.%s.deviceName", PLATFORM, udid));
    Logger logger = LogManager.getLogger(MobileDriver.class);

    public MobileDriver() {
    }

    public void stopAppiumServer() {
        service.stop();
    }

    private void startAppiumServer() {
        logger.info("Starting appium server");
        try {
            assert NODE_PATH != null;
            assert APPIUM_PATH != null;
            service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder().withIPAddress(ADDRESS).usingAnyFreePort()
                            .usingDriverExecutable(new File(NODE_PATH)).
                            withAppiumJS(new File(APPIUM_PATH)));
            service.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private URL getUrl() {
        return service.getUrl();
    }

    public AppiumDriver newDriver(String nameApp) {
        startAppiumServer();
        logger.info("Starting appium driver {}", PLATFORM);
        AppiumDriver driver;
        try {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability("platformName", PLATFORM);
            dc.setCapability("appium:platformVersion", platformVersion);
            dc.setCapability("appium:udid", udid);
            dc.setCapability("appium:deviceName", deviceName);
            String appConfigsPath = pathMobileConfigs + "AppConfigs.json";
            if (PLATFORM.equals(IOS)) {
                String bundleId = new GetData().getValueFromJson(appConfigsPath, String.format(JSONPATH_BEGIN + "%s.%s.bundleId", nameApp, PLATFORM));
                dc.setCapability("appium:bundleId", bundleId);
                dc.setCapability("appium:automationName", "XCUITest");
            } else {
                String appPackage = new GetData().getValueFromJson(appConfigsPath, String.format(JSONPATH_BEGIN + "%s.%s.appPackage", nameApp, PLATFORM));
                String appActivity = new GetData().getValueFromJson(appConfigsPath, String.format(JSONPATH_BEGIN + "%s.%s.appActivity", nameApp, PLATFORM));
                dc.setCapability("appium:appPackage", appPackage);
                dc.setCapability("appium:appActivity", appActivity);
                dc.setCapability("appium:automationName", "UIAutomator2");
            }
            dc.setCapability("noReset", "true");
            driver = new IOSDriver(getUrl(), dc);
            appiumDriver = driver;
            useDriver(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info("Driver {}: {}", PLATFORM, driver);
        return driver;
    }

    public void closeApplication() {
        String appID;
        if (PLATFORM.equals(IOS)) {
            appID = (String) appiumDriver.getCapabilities().getCapability("appium:bundleId");
        } else {
            appID = (String) appiumDriver.getCapabilities().getCapability("appium:appPackage");
        }
        if (appID != null)
            ((InteractsWithApps) appiumDriver).terminateApp(appID);
        getDriver().quit();
        stopAppiumServer();
    }
}
