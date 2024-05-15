package screens.mobile;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class TransactionResult extends BaseScreen {

  //Quý khách đã xác nhận Hợp đồng vay vốn thành công. Số tiền vay sẽ được giải ngân vào tài khoản thanh toán Quý khách đã lựa chọn. Hợp đồng cho vay sẽ được gửi tới Quý khách qua email
  @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"logoVietinFull\"]")
  private WebElement lblNotificationContent;

  public TransactionResult(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public String getNotificationContent() {
    return lblNotificationContent.getText();
  }
}
