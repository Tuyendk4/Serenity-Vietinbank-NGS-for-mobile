package vn.vietinbank.screens.mobile.base;

import static org.junit.Assert.fail;

import com.epam.reportportal.annotations.Step;
import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.service.ReportPortal;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import vn.vietinbank.screens.mobile.ipay.ipay_common.Home;
import vn.vietinbank.utils.helper.LogHelper;

public class BaseScreen {

  protected static final Logger logger = LogHelper.getLogger();
  private static final Duration SCROLL_DUR = Duration.ofMillis(1000);
  private static final double SCROLL_RATIO = 0.8;
  private static final int ANDROID_SCROLL_DIVISOR = 3;
  private static final int defaultTimeOut = 20;
  public static EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
  protected AppiumDriver appiumDriver;

  public BaseScreen(AppiumDriver appiumDriver) {
    this.appiumDriver = appiumDriver;
    PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(30)), this);
  }

  public void delay(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      logger.error("Cannot delay in {}. Root cause: {}", time, e.getMessage());
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
      ReportPortal.emitLog("Cannot find the mobile element", LogLevel.ERROR.name(), new Date(),
          appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    }
    return element;
  }

  public WebElement findElement(String locator, int timeOut) {
    WebElement element = null;
    logger.info("Finding mobile element {}", locator);
    try {
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
      element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
      logger.info("Found 1 mobile element {}", locator);
    } catch (Exception e) {
      logger.error("Cannot find mobile element {}. Root cause: {}", locator, e.getMessage());
    }
    return element;
  }

  public List<WebElement> findElements(String locator) {
    List<WebElement> elements = List.of();
    logger.info("Finding mobile elements located by {}", locator);
    try {
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(defaultTimeOut));
      elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
      logger.info("Found {} mobile element(s) located by {}", elements.size(), locator);
    } catch (Exception e) {
      logger.error("Cannot find mobile elements located by {}. Root cause: {}", locator,
          e.getMessage());
    }
    return elements;
  }

  public void click(String locator) {
    try {
      logger.info("Click on mobile element located by {}", locator);
      WebElement we = findElement(locator);
      we.click();
      logger.info("Clicked on mobile element located by {} successfully", locator);
    } catch (Exception e) {
      logger.error("Cannot click on mobile element located by ''{}''. Root cause: {}",
          locator, e.getMessage());
      ReportPortal.emitLog("Cannot click clear text mobile element", LogLevel.ERROR.name(),
          new Date(),
          appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    }
  }

  public void click(String locator, int timeOut) {
    try {
      logger.info("Click on mobile element located by {}", locator);
      WebElement we = findElement(locator, timeOut);
      we.click();
      logger.info("Clicked on mobile element located by {} successfully", locator);
    } catch (Exception e) {
      logger.error("Cannot click on mobile element located by ''{}''. Root cause: {}",
          locator, e.getMessage());
      ReportPortal.emitLog("Cannot click clear text mobile element", LogLevel.ERROR.name(),
          new Date(),
          appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    }
  }

  public void clear(String locator) {
    try {
      logger.info("Clear text on mobile element located by {}", locator);
      WebElement we = findElement(locator);
      we.clear();
      logger.info("Cleared text mobile element located by {} successfully", locator);
    } catch (Exception e) {
      logger.error("Cannot clear text mobile element located by ''{}''. Root cause: {}",
          locator, e.getMessage());
      ReportPortal.emitLog("Cannot click clear text mobile element", LogLevel.ERROR.name(),
          new Date(),
          appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    }
  }

  public void clear(String locator, int timeOut) {
    try {
      logger.info("Clear text on mobile element located by {}", locator);
      WebElement we = findElement(locator, timeOut);
      we.clear();
      logger.info("Cleared text mobile element located by {} successfully", locator);
    } catch (Exception e) {
      logger.error("Cannot clear text mobile element located by ''{}''. Root cause: {}",
          locator, e.getMessage());
      ReportPortal.emitLog("Cannot clear text mobile element", LogLevel.ERROR.name(), new Date(),
          appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    }
  }

  public void click(WebElement we) {
    try {
      logger.info("Clicking on mobile element {}", we);
      we.click();
      logger.info("Clicked on mobile element {} successfully", we);
    } catch (Exception e) {
      logger.error("Cannot click on mobile element ''{}''. Root cause: {}",
              we, e.getMessage());
    }
  }

  public void tap(String locator) {
    WebElement we = findElement(locator);
    try {
      Rectangle elRect = we.getRect();
      Point point = new Point(
          elRect.x + (int) (elRect.getWidth() / 2.0),
          elRect.y + (int) (elRect.getHeight() / 2.0)
      );
      tapAtPoint(point);
      logger.info("Tapped on mobile element {} successfully", we);
    } catch (Exception e) {
      logger.error("Cannot tap on mobile element ''{}''. Root cause: {}",
          we, e.getMessage());
    }
  }

  public void tap(String locator, int timeOut) {
    WebElement we = findElement(locator, timeOut);
    try {
      Rectangle elRect = we.getRect();
      Point point = new Point(
          elRect.x + (int) (elRect.getWidth() / 2.0),
          elRect.y + (int) (elRect.getHeight() / 2.0)
      );
      tapAtPoint(point);
      logger.info("Tapped on mobile element {} successfully", we);
    } catch (Exception e) {
      logger.error("Cannot tap on mobile element ''{}''. Root cause: {}",
          we, e.getMessage());
    }
  }

  public void tap(WebElement we) {
    try {
      Rectangle elRect = we.getRect();
      Point point = new Point(
          elRect.x + (int) (elRect.getWidth() / 2.0),
          elRect.y + (int) (elRect.getHeight() / 2.0)
      );
      tapAtPoint(point);
      logger.info("Tapped on mobile element {} successfully", we);
    } catch (Exception e) {
      logger.error("Cannot tap on mobile element ''{}''. Root cause: {}",
          we, e.getMessage());
    }
  }

  private void tapAtPoint(Point point) {
    PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
    Sequence tap = new Sequence(input, 0);
    tap.addAction(input.createPointerMove(Duration.ZERO, Origin.viewport(), point.x, point.y));
    tap.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
    tap.addAction(new Pause(input, Duration.ofMillis(200)));
    tap.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
    appiumDriver.perform(ImmutableList.of(tap));
  }

  public void tapAt(int x, int y) {
    Point point = new Point(x, y);
    tapAtPoint(point);
  }

  public void sendKeys(String locator, String text) {
    WebElement element = findElement(locator);
    if (element != null) {
      try {
        element.clear();
        element.sendKeys(text);
        logger.info("Enter text ''{}'' to mobile element located by ''{}''", text, locator);
      } catch (Exception e) {
        logger.error("Cannot enter text {} into mobile element located by {}. Root cause: {}", text,
            locator,
            e.getMessage());
      }
    }
  }

  public void sendKeys(WebElement we, String text) {
    if (we != null) {
      try {
        we.sendKeys(text);
        logger.info("Enter text ''{}'' to mobile element ''{}''", text, we);
      } catch (Exception e) {
        logger.error("Cannot enter text {} into mobile element {}. Root cause: {}", text, we,
            e.getMessage());
        fail(String.format("Cannot enter text ''%s'' into mobile element %s. Root cause: %s", text,
            we,
            e.getMessage()));
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
    (appiumDriver).perform(ImmutableList.of(swipe));
  }

  public void scrollToElement(String locator, ScrollDirection scrollDirection, int numberOfTimes) {
    boolean found = false;
    WebElement we;
    Dimension size = appiumDriver.manage().window().getSize();
    Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
    int top = midPoint.y - (int) ((size.height * SCROLL_RATIO) * 0.5);
    int bottom = midPoint.y + (int) ((size.height * SCROLL_RATIO) * 0.5);
    int count = 0;
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
      } catch (NoSuchElementException ignored) {

      }
      count++;
    } while (count == numberOfTimes);
    if (!found) {
      logger.error(
          "Cannot scroll to mobile element located by {}. Root cause: the vn.vietinbank.screens.web element not fount",
          locator);
    }
  }

  public String getText(String locator) {
    WebElement element = findElement(locator);
    String text = "";
    if (element != null) {
      try {
        text = element.getText();
        ReportPortal.emitLog("Text of element is " + text, LogLevel.INFO.name(), new Date());
      } catch (Exception e) {
        logger.error("Cannot get text of mobile element located by {}. Root cause: {}", locator,
            e.getMessage());
      }
    }
    return text;
  }

  public String getText(String locator, int timeOut) {
    WebElement element = findElement(locator, timeOut);
    String text = "";
    if (element != null) {
      try {
        text = element.getText();
        ReportPortal.emitLog("Text of element is " + text, LogLevel.INFO.name(), new Date());
      } catch (Exception e) {
        logger.error("Cannot get text of mobile element located by {}. Root cause: {}", locator,
            e.getMessage());
      }
    }
    return text;
  }

  public String getText(WebElement we) {
    String text = "";
    if (we != null) {
      try {
        text = we.getText();
        logger.info("Text of mobile element {} is {}", we, text);
      } catch (Exception e) {
        logger.error("Cannot get text of mobile element {}. Root cause: {}", we, e.getMessage());
        ReportPortal.emitLog("Cannot get text of mobile element", LogLevel.ERROR.name(), new Date(),
            appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
      }
    }
    return text;
  }

  public void scrollToElement(WebElement we, ScrollDirection scrollDirection, int numberOfTimes) {
    boolean found = false;
    Dimension size = appiumDriver.manage().window().getSize();
    Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
    int top = midPoint.y - (int) ((size.height * SCROLL_RATIO) * 0.5);
    int bottom = midPoint.y + (int) ((size.height * SCROLL_RATIO) * 0.5);
    int count = 0;
    do {
      delay(1000);
      if (scrollDirection == ScrollDirection.DOWN) {
        swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
      } else if (scrollDirection == ScrollDirection.UP) {
        swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
      }
      try {
        if (we.isDisplayed()) {
          found = true;
          logger.info("Scrolled to mobile element {} successfully", we);
          break;
        }
      } catch (NoSuchElementException ignored) {

      }
      count++;
    } while (count == numberOfTimes);
    if (!found) {
      logger.error(
          "Cannot scroll to mobile element {}. Root cause: the vn.vietinbank.screens.web element not visible",
          we);
    }
  }

  public void scrollTo(String text) {
    try {
      delay(500);
      WebElement element = null;
      if (appiumDriver instanceof AndroidDriver) {
        String uiScrollable =
            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                + text + "\"))";
        element = appiumDriver.findElement(new ByAndroidUIAutomator(uiScrollable));
      } else if (appiumDriver instanceof IOSDriver) {
        List<WebElement> elements =
            appiumDriver.findElements(By.xpath(
                "//*[contains(@label, '" + text + "') or contains(@text, '" + text
                    + "') or contains(@name, '" + text + "')]"));
        logger.info("Elements found: {}", elements.size());
        if (!elements.isEmpty()) {
          logger.info("Text ''{}'' was found in {} element(s).", text, elements.size());
          RemoteWebElement remoteElement = (RemoteWebElement) elements.get(0);
          String parentID = remoteElement.getId();
          HashMap<String, String> scrollObject = new HashMap<>();
          scrollObject.put("element", parentID);
          scrollObject.put("toVisible", text);
          appiumDriver.executeScript("mobile:scroll", scrollObject);
          element = remoteElement;
        }
      }
      if (element != null) {
        logger.info("Scrolled to {} successfully", text);
      } else {
        logger.error("Text {} is not found", text);
      }
    } catch (Exception e) {
      logger.error("Cannot scroll to text {}. Root cause: {}", text, e.getMessage());
    }
  }

  public byte[] takeScreenShot() {
    byte[] image = null;
    try {
      BufferedImage bufferedImage = ImageIO.read(
          new ByteArrayInputStream(((TakesScreenshot) appiumDriver).getScreenshotAs(
              OutputType.BYTES)));
      try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", bos);
        image = bos.toByteArray();
      } catch (Exception e) {
        logger.error("Cannot mark element on image. Root cause: {}", e.getMessage());
      }
    } catch (Exception e) {
      logger.error("Cannot take screen shot. Root cause: {}", e.getMessage());
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

  public boolean verifyElementText(WebElement we, String text) {
    try {
      logger.info("Verify text {} into element located by {}", text, we);
      String actualText = we.getText();
      if (actualText.equals(text)) {
        logger.info("Text of element located by {} is {}", we, text);
        return true;
      }
    } catch (Exception e) {
      logger.error("Cannot verify text of element located by {}. Root cause: {}", we,
          e.getMessage());
    }
    return false;
  }

  public boolean waitForElementVisible(String locator, int timeOut) {
    try {
      logger.info("Waiting for mobile element {} to be visible", locator);
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
      WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
      if (we != null) {
        logger.info("Mobile element located by {} is visible", locator);
        return true;
      }
    } catch (Exception e) {
      logger.error(
          "Cannot wait for mobile element located by {} to be visible within {} second(s). Root cause: {}",
          locator, timeOut, e.getMessage());
    }
    return false;
  }

  public boolean waitForElementInvisible(String locator, int timeOut) {
    try {
      logger.info("Waiting for mobile element {} to be invisible", locator);
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
      Boolean invisibleStatus = wait.until(
          ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
      if (invisibleStatus) {
        logger.info("Mobile element located by {} is invisible", locator);
        return true;
      }
    } catch (Exception e) {
      logger.error(
          "Cannot wait for mobile element located by {} to be invisible within {} second(s). Root cause: {}",
          locator, timeOut, e.getMessage());
    }
    return false;
  }

  public boolean waitForElementVisible(WebElement we, int timeOut) {
    try {
      logger.info("Waiting for element {} to be visible", we);
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
      WebElement foundWe = wait.until(ExpectedConditions.visibilityOf(we));
      if (foundWe != null) {
        logger.info("Element {} is visible", we);
        return true;
      }
    } catch (Exception e) {
      logger.error("Cannot wait for element {} to be visible within {} second(s). Root cause: {}",
          we, timeOut, e.getMessage());
    }
    return false;
  }

  public boolean verifyElementPresent(WebElement we) {
    try {
      logger.info("Verify for element {} to be present", we);
      if (we != null) {
        logger.info("Element {} is present", we);
        return true;
      }
      logger.error("Element {} is not present", we);
    } catch (Exception e) {
      logger.error("Cannot verify element {} to be present. Root cause: {}",
          we, e.getMessage());
    }
    return false;
  }

  public boolean verifyElementEnable(String locator, int timeOut) {
    WebElement we = findElement(locator, timeOut);
    try {
      logger.info("Verify for element {} to be enable", we);
      if (we != null && we.isEnabled()) {
        logger.info("Element {} is enabled", we);
        return true;
      }
      logger.error("Element {} is not enabled", we);
    } catch (Exception e) {
      logger.error("Cannot verify element {} to be enable. Root cause: {}",
          we, e.getMessage());
    }
    return false;
  }

  public boolean verifyElementEnable(WebElement we) {
    try {
      logger.info("Verify for element {} to be enable", we);
      if (we != null && we.isEnabled()) {
        logger.info("Element {} is enabled", we);
        return true;
      }
      logger.error("Element {} is not enabled", we);
    } catch (Exception e) {
      logger.error("Cannot verify element {} to be enable. Root cause: {}",
          we, e.getMessage());
    }
    return false;
  }

  public void clickBackButton() {
    if (appiumDriver instanceof AndroidDriver) {
      String btnBack = "//android.widget.RelativeLayout[@resource-id=\"com.vietinbank.ipay:id/header_toolbar\"]/android.widget.ImageButton[@resource-id=\"com.vietinbank.ipay:id/btn_left\"]";
      click(btnBack, 5);
    } else {
      String btnBack = "//*[@name=\"ic back blue\" or @name=\"ic back white\"]";
      click(btnBack, 5);
    }
    delay(5000);
  }

  public void pressKey(String key) {
    if (appiumDriver instanceof AndroidDriver) {
      switch (key) {
        case "a":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.A));
          break;
        case "b":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.B));
          break;
        case "c":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.C));
          break;
        case "d":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.D));
          break;
        case "e":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.E));
          break;
        case "f":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.F));
          break;
        case "g":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.G));
          break;
        case "h":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.H));
          break;
        case "i":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.I));
          break;
        case "j":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.J));
          break;
        case "k":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.K));
          break;
        case "l":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.L));
          break;
        case "m":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.M));
          break;
        case "n":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.N));
          break;
        case "o":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.O));
          break;
        case "p":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.P));
          break;
        case "q":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.Q));
          break;
        case "r":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.R));
          break;
        case "s":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.S));
          break;
        case "t":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.T));
          break;
        case "u":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.U));
          break;
        case "v":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.V));
          break;
        case "w":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.W));
          break;
        case "x":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.X));
          break;
        case "y":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.Y));
          break;
        case "z":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.Z));
          break;
        case "0":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
          break;
        case "1":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
          break;
        case "2":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
          break;
        case "3":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
          break;
        case "4":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
          break;
        case "5":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
          break;
        case "6":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
          break;
        case "7":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_7));
          break;
        case "8":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_8));
          break;
        case "9":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
          break;
      }
      delay(300);
    }
  }

  public void pressNumberKey(String key) {
    if (appiumDriver instanceof AndroidDriver) {
      switch (key) {
        case "0":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_0));
          break;
        case "1":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
          break;
        case "2":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_2));
          break;
        case "3":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_3));
          break;
        case "4":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_4));
          break;
        case "5":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_5));
          break;
        case "6":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
          break;
        case "7":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_7));
          break;
        case "8":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_8));
          break;
        case "9":
          ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_9));
          break;
      }
      delay(300);
    }
  }

  public String getAttribute(String locator, String attributeName) {
    WebElement we = findElement(locator);
    if (we != null) {
      return we.getAttribute(attributeName);
    }
    return null;
  }

  public byte[] takeScreenshot() {
    byte[] image = null;
    try {
      image = appiumDriver.getScreenshotAs(OutputType.BYTES);
      BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ImageIO.write(bufferedImage, "png", bos);
      image = bos.toByteArray();
      bos.close();
      logger.info("Take screenshot successfully");
    } catch (Exception e) {
      logger.error("Cannot take screenshot. Root cause: {}", e.getMessage());
    }
    return image;
  }

  public void hideKeyboard() {
    if (appiumDriver instanceof AndroidDriver) {
      ((AndroidDriver) appiumDriver).hideKeyboard();
    } else {
      String iconKeyboardDown = "//XCUIElementTypeButton[@name=\"ic keyboarddown\" or @name=\"Xong\" or @name=\"Done\"]";
      click(iconKeyboardDown);
    }
  }

  public int getElementLeftPosition(String locator) {
    WebElement we = findElement(locator);
    if (we != null) {
      return we.getRect().getX();
    }
    return -1;
  }

  public int getElementTopPosition(String locator) {
    WebElement we = findElement(locator);
    if (we != null) {
      return we.getRect().getY();
    }
    return -1;
  }

  public int getElementWidth(String locator) {
    WebElement we = findElement(locator);
    if (we != null) {
      return we.getSize().getWidth();
    }
    return -1;
  }

  public int getElementHeight(String locator) {
    WebElement we = findElement(locator);
    if (we != null) {
      return we.getSize().getHeight();
    }
    return -1;
  }

  @Step("Trở về màn hình Home")
  public Home go_to_Home() {
    if (appiumDriver instanceof AndroidDriver) {
      String iconHome = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/btn_home\"]";
      click(iconHome, 10);
    } else {
      String iconHome = "//XCUIElementTypeButton[@name=\"iconLineHome\"]";
      click(iconHome, 10);
    }
    return new Home(appiumDriver);
  }

  public boolean waitForElementText(String locator, String expectedText, int timeOut) {
    try {
      logger.info("Waiting for text ''{}'' of mobile element {} to be visible", expectedText,
          locator);
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeOut));
      Boolean status = wait.until(ExpectedConditions.textToBe(By.xpath(locator), expectedText));
      if (status) {
        logger.info("Expected text ''{}'' of mobile element located by {} is visible", expectedText,
            locator);
        return true;
      }
    } catch (Exception e) {
      logger.error(
          "Cannot wait for text ''{}'' of mobile element located by {} to be visible within {} second(s). Root cause: {}",
          expectedText, locator, timeOut, e.getMessage());
    }
    ReportPortal.emitLog("Cannot wait for mobile element text", LogLevel.ERROR.name(), new Date(),
        appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    return false;
  }

  public boolean verifyElementContainsText(String locator, String expectedText) {
    WebElement we = findElement(locator);
    try {
      String actualText = we.getText();
      if (actualText.contains(expectedText)) {
        return true;
      }
    } catch (Exception ignored) {

    }
    ReportPortal.emitLog("Cannot verify mobile element contains text", LogLevel.ERROR.name(),
        new Date(),
        appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    return false;
  }

  public boolean verifyElementContainsText(WebElement we, String expectedText) {
    try {
      String actualText = we.getText();
      if (actualText.contains(expectedText)) {
        return true;
      }
    } catch (Exception ignored) {

    }
    ReportPortal.emitLog("Cannot verify mobile element contains text", LogLevel.ERROR.name(),
        new Date(),
        appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
    return false;
  }

  public void attachmentScreenshot() {
    ReportPortal.emitLog("Take screenshot", LogLevel.INFO.name(), new Date(),
        appiumDriver.getScreenshotAs(OutputType.FILE).getAbsoluteFile());
  }

  public WebElement findElement_iosClassChain(String locator) {
    WebElement element = null;
    logger.info("Finding mobile element {}", locator);
    try {
      WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(defaultTimeOut));
      element = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByIosClassChain.iOSClassChain(locator)));
      logger.info("Found 1 mobile element {}", locator);
    } catch (Exception e) {
      logger.error("Cannot find mobile element {}. Root cause: {}", locator, e.getMessage());
    }
    return element;
  }
}
