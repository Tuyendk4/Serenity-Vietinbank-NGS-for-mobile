package screens.mobile;

import base.BaseScreen;
import base.ScrollDirection;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import org.openqa.selenium.WebElement;

public class PersonalInstalmentLoan_Step2 extends BaseScreen {
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"iconLineCalendarRound\"]")
  private WebElement iconCalendar;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Chọn trả nợ ngày\")]")
  private WebElement btnChooseARepaymentDate;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích vay\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton[@name=\"ic drop down blue\"]")
  private WebElement btnLoanPurpose;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tỉnh/thành phố\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnProvinces;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quận/huyện\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnDistrict;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]")
  private WebElement btnContinue;


  public PersonalInstalmentLoan_Step2(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  private void chooseADate(String date) {
    List<WebElement> btnDates = findElements("//XCUIElementTypeStaticText[@name=\"Chọn ngày trả nợ hàng tháng\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton");
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
    click(btnChooseARepaymentDate);
  }

  private void selectALoanPurpose(String purpose) {
    List<WebElement> btnLoanPurposes = findElements("//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton");
    List<WebElement> lblLoanPurposes = findElements("//XCUIElementTypeApplication[@name=\"VietinBank iPay\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText");
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

  private void selectProvince(String province) {
    scrollTo(province);
    WebElement lblProvince = findElement("//XCUIElementTypeStaticText[@name=\"Chọn Tỉnh/Thành phố\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label, '" + province + "') or contains(@text, '" + province + "') or contains(@name, '" + province + "')]");
    tap(lblProvince);
  }

  public void chooseProvince(String province) {
    scrollToElement(btnProvinces, ScrollDirection.DOWN, 3);
    click(btnProvinces);
    delay(3000);
    selectProvince(province);
  }

  private void selectDistrict(String district) {
    scrollTo(district);
    WebElement lblDistrict = findElement("//XCUIElementTypeStaticText[@name=\"Chọn Quận/Huyện\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@label, '" + district + "') or contains(@text, '" + district + "') or contains(@name, '" + district + "')]");
    tap(lblDistrict);
  }

  public void chooseDistrict(String district) {
    scrollToElement(btnDistrict, ScrollDirection.DOWN, 3);
    click(btnDistrict);
    delay(3000);
    selectDistrict(district);
  }

  public PersonalInstalmentLoan_Step3 clickContinueButton() {
    click(btnContinue);
    return new PersonalInstalmentLoan_Step3(appiumDriver);
  }
}
