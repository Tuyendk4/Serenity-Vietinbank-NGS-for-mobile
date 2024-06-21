package vn.vietinbank.screens.mobile.ipay.ipay_common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import vn.vietinbank.screens.mobile.base.BaseScreen;


public class Login_M6S03 extends BaseScreen {
  private final String android_SigupTxt = "//android.widget.TextView[@text=\"Đăng nhập/đăng ký\"]";
  private final String ios_ClassChainSigupTxt = "**/XCUIElementTypeStaticText[`name == \"Đăng nhập/Đăng ký\"`]";

  private  final String android_LoginTxt = "//android.widget.TextView[@text=\"Đăng nhập\"]";
  private final String ios_ClassChainLoginTxt = "**/XCUIElementTypeStaticText[`name == \"Đăng nhập\"`]";

  private final String android_UserOtherTxt = "//android.widget.TextView[@text=\"Đăng nhập tài khoản khác ?\"]";
  private final String ios_ClassChainUserOtherTxt = "**/XCUIElementTypeStaticText[`name == \"Đăng nhập tài khoản khác ?\"`]";

  private final String android_YesBtn = "//android.widget.TextView[@text=\"Có\"]";
  private final String ios_ClassChainYesBtn = "**/XCUIElementTypeButton[`name == \"Có\"`]";

  private final String ios_ClassChainUserInp = "**/XCUIElementTypeTextField[`value == \"Tên đăng nhập\"`]";
  private final String android_UserNameInp = "//android.widget.EditText[@text=\"Tên đăng nhập\"]";

  private final String ios_ClassChainPasswordInp = "**/XCUIElementTypeSecureTextField[`value == \"Mật khẩu\"`]";
  private final String android_inputPassword = "//android.widget.EditText[@text=\"Mật khẩu\"]";

  private final String ios_ClassChainLoginBtn = "**/XCUIElementTypeStaticText[`name == \"Đăng nhập\"`]";
  private final String android_LoginBtn = "//android.widget.TextView[@text=\"Đăng nhập\"]";

  private final String ios_ClassChainOTPInp = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
  private final String android_OTPInp = "//android.widget.TextView[@text=\"Tiếp tục\"]/..//android.widget.EditText";

  private final String ios_ClassChainCompleteBtn = "**/XCUIElementTypeButton[`name == \"Hoàn thành\"`]";
  private final String android_ContinueBtn = "//android.widget.TextView[@text=\"Tiếp tục\"]";

  private final String android_ClosePopupBtn = "//android.widget.ImageView[@resource-id=\"com.vietinbank.ipay:id/ic_cancel\"]";
  private final String ios_ClassChainClosePopupBtn = "**/XCUIElementTypeButton[`name == \"closeWhite\"`]";

  public Login_M6S03(AppiumDriver appiumDriver) {
    super(appiumDriver);
  }

  public void login_with_M6S03(String userName, String password, String otpCode) {
    if (appiumDriver instanceof AndroidDriver) {
      if(findElement(android_SigupTxt) != null){
        click(android_SigupTxt);
      }else{
        click(android_LoginTxt);
        click(android_UserOtherTxt);
        click(android_YesBtn);
      }
      sendKeys(android_UserNameInp,userName);
      sendKeys(android_inputPassword,password);
      click(android_LoginBtn);
      sendKeys(android_OTPInp,otpCode);
      click(android_ContinueBtn);
      //click(android_ClosePopupBtn);
    }else{
      if(findElement_iosClassChain(ios_ClassChainSigupTxt) != null){
        WebElement web_SigupTxt = findElement_iosClassChain(ios_ClassChainSigupTxt);
        click(web_SigupTxt);
      }else{
        WebElement web_LoginTxt = findElement_iosClassChain(ios_ClassChainLoginTxt);
        click(web_LoginTxt);
        WebElement web_UserOtherTxt = findElement_iosClassChain(ios_ClassChainUserOtherTxt);
        click(web_UserOtherTxt);
        WebElement web_YesBtn = findElement_iosClassChain(ios_ClassChainYesBtn);
        click(web_YesBtn);
      }
      WebElement web_UserInp = findElement_iosClassChain(ios_ClassChainUserInp);
      sendKeys(web_UserInp,userName);

      WebElement web_PasswordInp = findElement_iosClassChain(ios_ClassChainPasswordInp);
      sendKeys(web_PasswordInp,password);

      WebElement web_LoginBtn = findElement_iosClassChain(ios_ClassChainLoginBtn);
      click(web_LoginBtn);
      delay(3000);
      WebElement web_OTPInp = findElement_iosClassChain(ios_ClassChainOTPInp);
      sendKeys(web_OTPInp,otpCode);
      delay(2000);
      WebElement web_CompleteBtn = findElement_iosClassChain(ios_ClassChainCompleteBtn);
      click(web_CompleteBtn);
      WebElement web_ClosePopupBtn = findElement_iosClassChain(ios_ClassChainClosePopupBtn);
      click(web_ClosePopupBtn);
    }
  }

}
