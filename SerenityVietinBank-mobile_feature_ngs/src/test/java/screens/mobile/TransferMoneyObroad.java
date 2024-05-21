package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import screens.mobile.sections.NavigationBar;

public class TransferMoneyObroad extends BaseScreen {
  @AndroidFindBy(xpath = "")
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Chuyển tiền\"]")
  private WebElement iconTransferMoneyServices;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vay tiêu dùng cá nhân\"]/preceding-sibling::XCUIElementTypeButton")
  private WebElement btnVayPersonalInstalmentLoan;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mục đích sử dụng\"]")
  private WebElement txtPurpose;

  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chuyển tiền trả các loại phí, lệ phí cho nước ngoài\"])[2]")
  private WebElement txtLivingExpenses;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tạo điện mua/chuyển ngoại tệ\"]")
  private WebElement btnMakeNewPayment;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton")
  private WebElement iconBeneficiary;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
  private WebElement txtBeneficiaryAccount;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Lưu & tiếp tục\"]")
  private WebElement btnSaveContinue;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nội dung chuyển\"]")
  private WebElement txtPaymentNote;

  public TransferMoneyObroad(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public TransferMoneyObroad click_on_transfer_money_obroad() {
    btnVayPersonalInstalmentLoan.click();
    return new TransferMoneyObroad(this.appiumDriver);
  }

  public TransferMoneyObroad purpose_transfer(){
    txtPurpose.click();
    txtLivingExpenses.click();
    btnMakeNewPayment.click();
    return new TransferMoneyObroad(this.appiumDriver);
  }

  public TransferMoneyObroad chooseBeneficiary(){
    iconBeneficiary.click();
    txtBeneficiaryAccount.click();
    btnSaveContinue.click();
    txtPaymentNote.sendKeys("Test");
    return new TransferMoneyObroad(this.appiumDriver);
  }
}
