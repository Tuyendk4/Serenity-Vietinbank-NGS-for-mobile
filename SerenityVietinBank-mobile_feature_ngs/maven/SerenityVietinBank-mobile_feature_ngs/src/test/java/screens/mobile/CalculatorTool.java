package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CalculatorTool extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField")
  private WebElement txtNumberOfMoney;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
  private WebElement btnDeleteMoney;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.ipay:id/sliderRange\"]/android.widget.SeekBar")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeSlider")
  private WebElement sldNumberOfMoney;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField")
  private WebElement txtNumberOfMonth;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
  private WebElement btnDeleteMonth;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.ipay:id/sliderRange\"]/android.widget.SeekBar")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeSlider")
  private WebElement sldNumberOfMonth;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvTitleLoanPromotion\" and @text=\"Ưu đãi cho cán bộ VietinBank\"]/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/rcvListLoanPromotion\"]//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/imvLoanPromotionJoined\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ưu đãi cho cán bộ VietinBank\"]/following-sibling::XCUIElementTypeCollectionView//XCUIElementTypeImage[@name=\"iconChoiceRadioOff\"]")
  private WebElement chkSpecialOffers;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]")
  private WebElement btnContinue;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xem lịch trả nợ dự kiến\"]")
  private WebElement btnExpectedPaymentScheduleViewer;

  public CalculatorTool(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void inputNumberOfMoney(String numberOfMoney) {
    click(txtNumberOfMoney);
    if(appiumDriver instanceof AndroidDriver) {
      txtNumberOfMoney.clear();
      sendKeys(txtNumberOfMoney, numberOfMoney);
      ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
    } else {
      click(btnDeleteMoney);
      sendKeys(txtNumberOfMoney, Keys.chord(numberOfMoney, Keys.ENTER));
    }

  }

  private void inputNumberOfMonth(String months) {
    click(txtNumberOfMonth);
    if(appiumDriver instanceof AndroidDriver) {
      txtNumberOfMonth.clear();
      sendKeys(txtNumberOfMonth, months);
      ((AndroidDriver) appiumDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
    } else {
      click(btnDeleteMonth);
      sendKeys(txtNumberOfMonth, Keys.chord(months, Keys.ENTER));
    }

  }

  private void slicePercentOfMoney(String numberOfMoney) {
    int percentOfMoney = ((Integer.parseInt(numberOfMoney) - 3000000) * 100) / 100000000;
    sendKeys(sldNumberOfMoney, String.valueOf(percentOfMoney));
  }

  private void slicePercentOfMonth(String months) {
    int percentOfMonths = Math.round(((float) Integer.parseInt(months) / 12));
    sendKeys(sldNumberOfMonth, String.valueOf(percentOfMonths));
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

  public ReferenceRepaymentSchedule clickExpectedPaymentScheduleViewerButton() {
    if(appiumDriver instanceof AndroidDriver) {
//      btnContinue.click();
      click(btnContinue);
    } else {
      click(btnExpectedPaymentScheduleViewer);
    }
    delay(3000);
    return new ReferenceRepaymentSchedule(this.appiumDriver);
  }
}
