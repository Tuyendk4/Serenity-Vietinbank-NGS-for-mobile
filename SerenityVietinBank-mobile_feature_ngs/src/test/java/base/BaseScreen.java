package base;

import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.MessageFormat;
import java.time.Duration;
import javax.imageio.ImageIO;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import utils.helper.LogHelper;

public class BaseScreen {

  protected static final Logger logger = LogHelper.getLogger();
  private static final Duration SCROLL_DUR = Duration.ofMillis(1000);
  private static final double SCROLL_RATIO = 0.8;
  private static final int ANDROID_SCROLL_DIVISOR = 3;
  private static final int defaultTimeOut = 60;
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
      e.printStackTrace();
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
      logger.info("Tap on mobile element located by {}", locator);
      WebElement we = findElement(locator);
      we.click();
      logger.info("Tapped on mobile element located by {} successfully", locator);
    } catch (Exception e) {
      logger.error(
          MessageFormat.format("Cannot tap on mobile element located by ''{0}''. Root cause: {1}",
              locator, e.getMessage()));
    }
  }

  public void click(WebElement we) {
    try {
      logger.info("Tapping on mobile element {}", we);
      we.click();
      logger.info("Tapped on mobile element {} successfully", we);
    } catch (Exception e) {
      logger.error("Cannot tap on mobile element ''{}''. Root cause: {}",
          we, e.getMessage());
      fail(String.format("Cannot tap on mobile element ''%s''. Root cause: %s",
          we, e.getMessage()));
    }
  }

  public void sendKeys(String locator, String text) {
    WebElement element = findElement(locator);
    if (element != null) {
      try {
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
        fail(String.format("Cannot enter text ''%s'' into mobile element %s. Root cause: %s", text, we,
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
    int top = midPoint.y - (int) (size.height * 0.5);
    int bottom = midPoint.y + (int) (size.height * 0.5);
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
          "Cannot scroll to mobile element located by {}. Root cause: the web element not fount",
          locator);
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
}
