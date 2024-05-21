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
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;

public class PersonalInstalmentLoan_Step2 extends BaseScreen {

//  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THÔNG TIN NGƯỜI VAY\"]/following-sibling::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/wDatePayWidget\"]//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.ImageView")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineCalendarRound\"]")
//  private WebElement iconCalendar;

  private final String android_iconCalendar = "//android.widget.TextView[@text=\"THÔNG TIN NGƯỜI VAY\"]/following-sibling::android.widget.LinearLayout[@resource-id=\"com.vietinbank.ipay:id/wDatePayWidget\"]//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Ngày trả nợ hàng tháng\"]/following-sibling::android.widget.ImageView";
  private final String ios_iconCalendar = "//XCUIElementTypeButton[@name=\"iconLineCalendarRound\"]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Chọn trả nợ ngày\")]")
//  private WebElement btnChooseARepaymentDate;

  private final String android_btnChooseARepaymentDate = "";
  private final String ios_btnChooseARepaymentDate = "//XCUIElementTypeButton[contains(@name,\"Chọn trả nợ ngày\")]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mục đích vay\"]/parent::android.widget.LinearLayout")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]")
//  private WebElement btnLoanPurpose;

  private final String android_btnLoanPurpose = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Mục đích vay\"]/parent::android.widget.LinearLayout";
  private final String ios_btnLoanPurpose = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]";

//  @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Email nhận hợp đồng\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@value,\"Email nhận hợp đồng\") or contains(@value,\"@\")]")
//  private WebElement txtEmail;

  private final String android_txtEmail = "//android.widget.EditText[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and (@text=\"Email nhận hợp đồng\" or contains(@text,\"@\")]";
  private final String ios_txtEmail = "//XCUIElementTypeTextField[contains(@value,\"Email nhận hợp đồng\") or contains(@value,\"@\")]";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Xóa văn bản\"]")
//  private WebElement btnDeleteEmail;

//  private final String android_btnDeleteEmail = "";
  private final String ios_btnDeleteEmail = "//XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

//  @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Tỉnh/thành phố\"]/parent::android.widget.LinearLayout")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tỉnh/thành phố\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton")
//  private WebElement btnProvinces;

  private final String android_btnProvinces = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Tỉnh/thành phố\"]/parent::android.widget.LinearLayout";
  private final String ios_btnProvinces = "//XCUIElementTypeStaticText[@name=\"Tỉnh/thành phố\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton";

//  @iOSXCUITFindBys(value = {@iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")})
//  private List<WebElement> lblProvinces;

  private final String android_lblProvinces = "";
  private final String ios_lblProvinces = "//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText";

//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quận/huyện\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton")
//  private WebElement btnDistrict;

  private final String android_btnDistrict = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/edtContent\" and @text=\"Quận/huyện\"]/parent::android.widget.LinearLayout";
  private final String ios_btnDistrict = "//XCUIElementTypeStaticText[@name=\"Quận/huyện\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton";

//  @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]")
//  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
//  private WebElement btnContinue;

  private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
  private final String ios_btnContinue = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";


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
    if(appiumDriver instanceof AndroidDriver) {
      click(android_iconCalendar);
    } else {
      click(ios_iconCalendar);
    }
    chooseADate(date);
    if(appiumDriver instanceof IOSDriver) {
      click(ios_btnChooseARepaymentDate);
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
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnLoanPurpose);
    } else {
      click(ios_btnLoanPurpose);
    }
    selectALoanPurpose(loanPurpose);
  }

  public void inputEmail(String email) {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_txtEmail);
      sendKeys(android_txtEmail, email);
    } else {
      click(ios_txtEmail);
      WebElement txtEmail = findElement(ios_txtEmail);
      if(txtEmail.getAttribute("value").contains("@")) {
        click(ios_btnDeleteEmail);
      }
      sendKeys(ios_txtEmail, email);
    }
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
      scrollToElement(android_btnProvinces, ScrollDirection.DOWN, 3);
      click(android_btnProvinces);
    } else {
      scrollToElement(ios_btnProvinces, ScrollDirection.DOWN, 3);
      click(ios_btnProvinces);
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
      scrollToElement(android_btnDistrict, ScrollDirection.DOWN, 3);
      click(android_btnDistrict);
    } else {
      scrollToElement(ios_btnDistrict, ScrollDirection.DOWN, 3);
      click(ios_btnDistrict);
    }
    delay(3000);
    selectDistrict(district);
  }

  public PersonalInstalmentLoan_Step3 clickContinueButton() {
    if(appiumDriver instanceof AndroidDriver) {
      click(android_btnContinue);
    } else {
      click(ios_btnContinue);
    }
    delay(3000);
    return new PersonalInstalmentLoan_Step3(appiumDriver);
  }
}
