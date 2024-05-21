package screens.mobile;

import base.BaseScreen;
import base.ScrollDirection;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CalculatorTool extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField")
//  private WebElement txtNumberOfMoney;

  private final String android_txtNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]";
  private final String ios_txtNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
//  private WebElement btnDeleteMoney;
//  private final String android_btnDeleteMoney = "";
  private final String ios_btnDeleteMoney = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.ipay:id/sliderRange\"]/android.widget.SeekBar")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeSlider")
//  private WebElement sldNumberOfMoney;

  private final String android_sldNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.ipay:id/sliderRange\"]/android.widget.SeekBar";
  private final String ios_sldNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeSlider";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField")
//  private WebElement txtNumberOfMonth;

  private final String android_txtNumberOfMonth = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]";
  private final String ios_txtNumberOfMonth = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
//  private WebElement btnDeleteMonth;

  private final String ios_btnDeleteMonth = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.ipay:id/sliderRange\"]/android.widget.SeekBar")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeSlider")
//  private WebElement sldNumberOfMonth;

  private final String android_sldNumberOfMonth = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.ipay:id/sliderRange\"]/android.widget.SeekBar";
  private final String ios_sldNumberOfMonth = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeSlider";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitleLoanPromotion\" and @text=\"Ưu đãi cho cán bộ VietinBank\"]/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/rcvListLoanPromotion\"]//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/imvLoanPromotionJoined\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ưu đãi cho cán bộ VietinBank\"]/following-sibling::XCUIElementTypeCollectionView//XCUIElementTypeImage[@name=\"iconChoiceRadioOff\"]")
//  private WebElement chkSpecialOffers;

  private final String android_chkSpecialOffers = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitleLoanPromotion\" and (@text=\"Ưu đãi cho cán bộ VietinBank\" or @text=\"Ưu đãi đặc biệt\")]/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/rcvListLoanPromotion\"]//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/imvLoanPromotionJoined\"]";
  private final String ios_chkSpecialOffers = "//XCUIElementTypeStaticText[@name=\"Ưu đãi cho cán bộ VietinBank\" or @name=\"Ưu đãi đặc biệt\"]/following-sibling::XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@name=\"Mua bảo hiểm (Cán bộ chỉ hưởng ưu đãi lãi suất theo chương trình VietinBank Là Nhà)\" or contains(@name,\"Giảm ngay\")]/following-sibling::XCUIElementTypeImage";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")
//  private WebElement btnContinue;

  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
//  private final String ios_btnContinue = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch trả nợ dự kiến\"]")
//  private WebElement btnExpectedPaymentScheduleViewer;

//  private final String android_btnDeleteMoney = "";
  private final String ios_btnExpectedPaymentScheduleViewer = "//XCUIElementTypeButton[@name=\"Xem lịch trả nợ dự kiến\"]";

  public CalculatorTool(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void inputNumberOfMoney(String numberOfMoney) {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_txtNumberOfMoney);
      clear(android_txtNumberOfMoney);
      String[] keys = numberOfMoney.split("");
      for (String key : keys) {
        pressNumberKey(key);
      }
      ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.NUMPAD_ENTER));
    } else {
      click(ios_txtNumberOfMoney);
      click(ios_btnDeleteMoney);
      sendKeys(ios_txtNumberOfMoney, Keys.chord(numberOfMoney, Keys.ENTER));
    }
  }

  private void inputNumberOfMonth(String months) {
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_txtNumberOfMonth, months + " tháng");
//      ((AndroidDriver) appiumDriver).hideKeyboard();
      delay(3000);
    } else {
      click(ios_txtNumberOfMonth);
      click(ios_btnDeleteMonth);
      sendKeys(ios_txtNumberOfMonth, Keys.chord(months, Keys.ENTER));
    }
  }

  private void slicePercentOfMoney(String numberOfMoney) {
    int percentOfMoney = ((Integer.parseInt(numberOfMoney) - 3000000) * 100) / 100000000;
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_sldNumberOfMoney, String.valueOf(percentOfMoney));
    } else {
      sendKeys(ios_sldNumberOfMoney, String.valueOf(percentOfMoney));
    }
  }

  private void slicePercentOfMonth(String months) {
    int percentOfMonths = Math.round(((float) Integer.parseInt(months) / 12));
    if(appiumDriver instanceof AndroidDriver) {
      sendKeys(android_sldNumberOfMonth, String.valueOf(percentOfMonths));
    } else {
      sendKeys(ios_sldNumberOfMonth, String.valueOf(percentOfMonths));
    }
  }

  public void editNumberOfMoney(String editType, String numberOfMoney) {
    if(editType.equals("EditText")) {
      inputNumberOfMoney(numberOfMoney);
    } else if(editType.equals("Slice")) {
      slicePercentOfMoney(numberOfMoney);
    }
  }

  public void editNumberOfMonth(String editType, String months) {
    if(editType.equals("EditText")) {
      inputNumberOfMonth(months);
    } else if(editType.equals("Slice")) {
      slicePercentOfMonth(months);
    }
  }

  public void uncheckSpecialOffer() {
    if(appiumDriver instanceof AndroidDriver) {
//      scrollToElement(android_chkSpecialOffers, ScrollDirection.DOWN, 3);
//      tap(android_chkSpecialOffers, 10);
    } else {
      scrollToElement(ios_chkSpecialOffers, ScrollDirection.DOWN, 3);
      String attribute = getAttribute(ios_chkSpecialOffers, "name");
      if(!attribute.equals("iconChoiceRadioOff")) {
        tap(ios_chkSpecialOffers, 10);
      }
    }
  }

  public void checkSpecialOffer() {
    if(appiumDriver instanceof AndroidDriver) {
      scrollToElement(android_chkSpecialOffers, ScrollDirection.DOWN, 3);
      tap(android_chkSpecialOffers, 10);
    } else {
      scrollToElement(ios_chkSpecialOffers, ScrollDirection.DOWN, 3);
      String attribute = getAttribute(ios_chkSpecialOffers, "name");
      if(attribute.equals("iconChoiceRadioOff")) {
        tap(ios_chkSpecialOffers, 10);
      }
    }

  }

  public ReferenceRepaymentSchedule clickExpectedPaymentScheduleViewerButton() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnContinue);
    } else {
      click(ios_btnExpectedPaymentScheduleViewer);
    }
    delay(3000);
    return new ReferenceRepaymentSchedule(this.appiumDriver);
  }
}
