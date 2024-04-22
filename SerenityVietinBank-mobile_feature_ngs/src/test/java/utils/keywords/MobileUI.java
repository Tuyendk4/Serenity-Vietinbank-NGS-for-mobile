package utils.keywords;

import com.google.common.collect.ImmutableList;
import com.jayway.jsonpath.JsonPath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.time.Duration;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import utils.helper.DeviceInfo;
import utils.helper.LogHelper;

public class MobileUI {


  private static final int defaultTimeOut = 60;
  private static final Logger logger = LogHelper.getLogger();
  private static final String ADDRESS = "127.0.0.1";
  private static final String APPIUM_CONFIG_PATH =
      System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
          + File.separator + "resources" + File.separator + "appium_config.json";
  private static final Duration SCROLL_DUR = Duration.ofMillis(1000);
  private static final double SCROLL_RATIO = 0.8;
  private static final int ANDROID_SCROLL_DIVISOR = 3;
  private final String node_path;
  private final String appium_path;
  private AppiumDriverLocalService service;
  private AppiumDriver appiumDriver;
  private String platformName;

  public MobileUI() {
    File appiumConfig = new File(APPIUM_CONFIG_PATH);
    try {
      node_path = JsonPath.read(appiumConfig, "$.node_path");
      appium_path = JsonPath.read(appiumConfig, "$.appium_path");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void startAppiumServer() {
    logger.info("Starting appium server");
    try {
      service = AppiumDriverLocalService.buildService(
          new AppiumServiceBuilder().withIPAddress(ADDRESS).usingAnyFreePort()
              .usingDriverExecutable(new File(node_path)).
              withAppiumJS(new File(appium_path)));
      service.start();
      logger.info("Started appium server successfully");
    } catch (Exception e) {
      logger.error("Cannot start appium server. Root cause: {}", e.getMessage());
    }
  }

  private void stopAppiumServer() {
    service.stop();
  }

  private URL getUrl() {
    return service.getUrl();
  }

  public void startApplication(DeviceInfo deviceInfo) {
    startAppiumServer();
    logger.info("Starting application");
    try {
      DesiredCapabilities dc = new DesiredCapabilities();
      dc.setCapability("platformName", deviceInfo.getPlatformName());
      platformName = deviceInfo.getPlatformName();
      dc.setCapability("appium:platformVersion", deviceInfo.getPlatformVersion());
      dc.setCapability("appium:udid", deviceInfo.getUdid());
      dc.setCapability("appium:deviceName", deviceInfo.getDeviceName());
      if (deviceInfo.getPlatformName().equalsIgnoreCase("ANDROID")) {
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:appPackage", deviceInfo.getAppPackage());
        dc.setCapability("appium:appActivity", deviceInfo.getAppActivity());
      } else {
        dc.setCapability("appium:bundleId", deviceInfo.getBundleId());
        dc.setCapability("appium:deviceName", deviceInfo.getDeviceName());
        dc.setCapability("appium:automationName", "XCUITest");
      }
      appiumDriver = new AndroidDriver(getUrl(), dc);
      logger.info("Started the application successfully");
    } catch (Exception e) {
      logger.error("Cannot start the application. Root cause: {}", e.getMessage());
    }

  }

  public String getPlatformName() {
    return platformName;
  }

  public void delay(int number) {
    try {
      Thread.sleep(number);
      logger.info("Delayed {}", number);
    } catch (InterruptedException e) {
      logger.error("Cannot delay {}", number);
    }
  }

  public void closeApplication() {
    if (null != appiumDriver) {
      appiumDriver.quit();
      appiumDriver = null;
      stopAppiumServer();
    }
  }

  public WebElement findElement(String locator) {
    WebElement element = null;
    logger.info("Finding mobile element {}", locator);
    try {
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(defaultTimeOut));
      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
      logger.info("Found 1 mobile element {}", locator);
    } catch (Exception e) {
      logger.error("Cannot find mobile element {}. Root cause: {}", locator, e.getMessage());
    }
    return element;
  }

  public void click(String locator) {
    try {
      logger.info("Tap on mobile element {}", locator);
      WebElement we = findElement(locator);
      new TouchAction<>((PerformsTouchActions) appiumDriver).tap(
              TapOptions.tapOptions().withElement(ElementOption.element(we)))
          .perform();
      logger.info("Tapped on mobile element located by {} successfully", locator);
    } catch (Exception e) {
      logger.error(
          MessageFormat.format("Cannot tap on mobile element located by ''{0}''. Root cause: {1}",
              locator, e.getMessage()));
    }
  }

  public void sendKeys(String locator, String text) {
    WebElement element = findElement(locator);
    if (element != null) {
      try {
        element.sendKeys(text);
        logger.info("Enter text {} to mobile element located by {}", text, locator);
      } catch (Exception e) {
        logger.error("Cannot enter text {} into element {}. Root cause: {}", text, locator,
            e.getMessage());
      }
    }
  }

  private void swipe(Point start, Point end, Duration duration) {
    boolean isAndroid = appiumDriver instanceof AndroidDriver;

    PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
    Sequence swipe = new Sequence(input, 0);
    swipe.addAction(input.createPointerMove(Duration.ZERO, Origin.viewport(), start.x, start.y));
    swipe.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
    if (isAndroid) {
      duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
    } else {
      swipe.addAction(new Pause(input, duration));
      duration = Duration.ZERO;
    }
    swipe.addAction(input.createPointerMove(duration, Origin.viewport(), end.x, end.y));
    swipe.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
    appiumDriver.perform(ImmutableList.of(swipe));
  }

  public void scrollToElement(String locator, ScrollDirection scrollDirection) {
    boolean found = false;
    WebElement we;
    Dimension size = appiumDriver.manage().window().getSize();
    Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
    int top = midPoint.y - (int) (size.height * 0.5);
    int bottom = midPoint.y + (int) (size.height * 0.5);
    do {
      delay(1000);
      if (scrollDirection == ScrollDirection.DOWN) {
        swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
      } else if (scrollDirection == ScrollDirection.UP) {
        swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
      }
      By by = By.xpath(locator);
      try {
        we = appiumDriver.findElement(by);
        if (we != null) {
          found = true;
          logger.info("Scrolled to mobile element located by {} successfully", locator);
          break;
        }
      } catch (NoSuchElementException e) {

      }
    } while (true);
    if (!found) {
      logger.error(
          "Cannot scroll to mobile element located by {}. Root cause: the web element not fount",
          locator);
    }
  }

  public byte[] takeScreenShot() {
    byte[] image = null;
    try {
      BufferedImage bufferedImage = ImageIO.read(
          new ByteArrayInputStream(appiumDriver.getScreenshotAs(
              OutputType.BYTES)));
      try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", bos);
        image = bos.toByteArray();
      } catch (Exception e) {
        logger.error(
            MessageFormat.format("Cannot mark element on image. Root cause: {0}", e.getMessage()));
      }
    } catch (Exception e) {
      logger.error(
          MessageFormat.format(
              "Cannot take screen shot. Root cause: {1}", e.getMessage()));
    }
    return image;
  }

  public boolean verifyElementText(String locator, String text) {
    WebElement element = findElement(locator);
    try {
      logger.info("Verify text {} into element located by {}", text, locator);
      String actualText = element.getText();
      if (actualText.equals(text)) {
        logger.info("Text of element located by {} is {}", locator, text);
        return true;
      }
    } catch (Exception e) {
      logger.error("Cannot verify text of element located by {}. Root cause: {}", locator,
          e.getMessage());
    }
    return false;
  }

  public boolean waitForElementVisible(String locator, int timeOut) {
    try {
      logger.info("Waiting for element {} to be visible", locator);
      WebDriver driver = appiumDriver;
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
      WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
      if (we != null) {
        logger.info("Element {} is visible", locator);
        return true;
      }
    } catch (Exception e) {
      logger.error("Cannot wait for element {} to be visible within {} second(s). Root cause: {}",
          locator, timeOut, e.getMessage());
    }
    return false;
  }

}
