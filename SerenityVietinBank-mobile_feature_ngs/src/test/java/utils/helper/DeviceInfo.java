package utils.helper;

import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.text.MessageFormat;
import org.slf4j.Logger;

public class DeviceInfo {

  private final Logger logger = LogHelper.getLogger();

  private static final String TEST_RESOURCE_PATH =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
          + File.separator + "resources";
  private static final String JSON_EXTENSION = ".json";
  private static final String DEVICE_PATH = TEST_RESOURCE_PATH + File.separator + "devices" + JSON_EXTENSION;
  private String platformName;
  private String platformVersion;
  private String deviceName;
  private String bundleId;
  private String udid;
  private String automationName;
  private String appPackage;
  private String appActivity;

  public DeviceInfo(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPlatformName() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".platformName";
    try {
      platformName = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("Platform Name: " + platformName);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get platform name. Root cause: {0}", e.getMessage()));
    }
    return platformName;
  }

  public String getPlatformVersion() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".platformVersion";
    try {
      platformVersion = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("Platform Version: " + platformVersion);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get platform version. Root cause: {0}", e.getMessage()));
    }
    return platformVersion;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public String getBundleId() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".bundleId";
    try {
      bundleId = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("bundleId: " + bundleId);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get bundleId. Root cause: {0}", e.getMessage()));
    }
    return bundleId;
  }

  public String getUdid() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".udid";
    try {
      udid = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("udid: " + udid);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get udid. Root cause: {0}", e.getMessage()));
    }
    return udid;
  }

  public String getAutomationName() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".automationName";
    try {
      automationName = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("automationName: " + automationName);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get automation name. Root cause: {0}", e.getMessage()));
    }
    return automationName;
  }

  public String getAppPackage() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".appPackage";
    try {
      appPackage = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("appPackage: " + appPackage);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get automation name. Root cause: {0}", e.getMessage()));
    }
    return appPackage;
  }

  public String getAppActivity() {
    File deviceFile = new File(DEVICE_PATH);
    String jsonPath = "$." + deviceName + ".appActivity";
    try {
      appActivity = JsonPath.read(deviceFile, jsonPath).toString();
      logger.info("appActivity: " + appActivity);
    } catch (Exception e) {
      logger.error(MessageFormat.format("Cannot get automation name. Root cause: {0}", e.getMessage()));
    }
    return appActivity;
  }
}
