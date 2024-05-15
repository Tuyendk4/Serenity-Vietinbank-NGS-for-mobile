package screens.mobile;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;
import java.util.List;
import org.openqa.selenium.WebElement;

public class PersonalInstalmentLoan_Step2 extends BaseScreen {

  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THÔNG TIN NGƯỜI VAY\"]/following-sibling::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/wDatePayWidget\"]//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.ImageView")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineCalendarRound\"]")
  private WebElement iconCalendar;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Chọn trả nợ ngày\")]")
  private WebElement btnChooseARepaymentDate;

  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mục đích vay\"]/parent::android.widget.LinearLayout")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]")
  private WebElement btnLoanPurpose;

  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Email nhận hợp đồng\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,\"Email nhận hợp đồng\") or contains(@value,\"@\")]")
  private WebElement txtEmail;

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Tỉnh/thành phố\"]/parent::android.widget.LinearLayout")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tỉnh/thành phố\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnProvinces;

  @iOSXCUITFindBys(value = {@iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")})
  private List<WebElement> lblProvinces;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quận/huyện\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnDistrict;

  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
  private WebElement btnContinue;


  public PersonalInstalmentLoan_Step2(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void chooseADate(String date) {
    List<WebElement> btnDates;
    if(appiumDriver instanceof AndroidDriver) {
      btnDates = findElements("//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/titleText\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/liTitle\"]/following-sibling::android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/rcvDaysInMonth\"]//android.widget.TextView");
    } else {
      btnDates = findElements("//XCUIElementTypeStaticText[@name=\"Chọn ngày trả nợ hàng tháng\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton");
    }
    for (WebElement btnDate : btnDates) {
      if (btnDate.getText().equals(date)) {
        click(btnDate);
        break;
      }
    }
  }

  public void chooseARepaymentDate(String date) {
    click(iconCalendar);
    chooseADate(date);
    if(appiumDriver instanceof IOSDriver) {
      click(btnChooseARepaymentDate);
    }
  }

  private void selectALoanPurpose(String purpose) {
    List<WebElement> btnLoanPurposes;
    if(appiumDriver instanceof AndroidDriver) {
      btnLoanPurposes = findElements("//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView/parent::android.widget.LinearLayout");
    } else {
      btnLoanPurposes = findElements("//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton");
    }
    List<WebElement> lblLoanPurposes;
    if(appiumDriver instanceof AndroidDriver) {
      lblLoanPurposes = findElements("//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\"]/parent::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/view_header\"]/following-sibling::android.widget.LinearLayout//android.widget.TextView");
    } else {
      lblLoanPurposes = findElements("//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText");
    }
    for (int i = 0; i < btnLoanPurposes.size(); i++) {
      if (lblLoanPurposes.get(i).getText().equals(purpose)) {
        click(btnLoanPurposes.get(i));
        break;
      }
    }
  }

  public void chooseLoanPurpose(String loanPurpose) {
    click(btnLoanPurpose);
    selectALoanPurpose(loanPurpose);
  }

  public void inputEmail(String email) {
    if(appiumDriver instanceof AndroidDriver) {
      txtEmail.clear();
    }
    sendKeys(txtEmail, email);
  }

  private void selectProvince(String province) {
    scrollTo(province);
    WebElement lblProvince = null;
    if(appiumDriver instanceof AndroidDriver) {
      lblProvince = findElement("//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\" and @text=\"Chọn tỉnh thành\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/recyclerView\"]//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and contains(@text, '" + province + "')]");
    } else {
      lblProvince = findElement("//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label, '" + province + "') or contains(@text, '" + province + "') or contains(@name, '" + province + "')]");
    }
    tap(lblProvince);
  }

  public void chooseProvince(String province) {
    if(appiumDriver instanceof AndroidDriver) {
      String xpathOfBtnProvices = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Tỉnh/thành phố\"]/parent::android.widget.LinearLayout";
      scrollToElement(xpathOfBtnProvices, ScrollDirection.DOWN, 3);
      click(xpathOfBtnProvices);
    } else {
      scrollToElement(btnProvinces, ScrollDirection.DOWN, 3);
      click(btnProvinces);
    }
    delay(3000);
    selectProvince(province);
  }

  private void selectDistrict(String district) {
    scrollTo(district);
    WebElement lblDistrict = null;
    if(appiumDriver instanceof AndroidDriver) {
      lblDistrict = findElement("//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/title_text\" and @text=\"Chọn Quận/Huyện\"]/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.ipay:id/recyclerView\"]//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvLeft\" and contains(@text, '" + district + "')]");
    } else {
      lblDistrict = findElement("//XCUIElementTypeStaticText[@name=\"Chọn Quận/Huyện\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label, '" + district + "') or contains(@text, '" + district + "') or contains(@name, '" + district + "')]");
    }
    tap(lblDistrict);
  }

  public void chooseDistrict(String district) {
    if(appiumDriver instanceof AndroidDriver) {
      String xpathOfBtnDistrict = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Quận/huyện\"]/parent::android.widget.LinearLayout";
      scrollToElement(xpathOfBtnDistrict, ScrollDirection.DOWN, 3);
      click(xpathOfBtnDistrict);
    } else {
      scrollToElement(btnDistrict, ScrollDirection.DOWN, 3);
      click(btnDistrict);
    }
    delay(3000);
    selectDistrict(district);
  }

  public PersonalInstalmentLoan_Step3 clickContinueButton() {
    click(btnContinue);
    return new PersonalInstalmentLoan_Step3(appiumDriver);
  }
}
