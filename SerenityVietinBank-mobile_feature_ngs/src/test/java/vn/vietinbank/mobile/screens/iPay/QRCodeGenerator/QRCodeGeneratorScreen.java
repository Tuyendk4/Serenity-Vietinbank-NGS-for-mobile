package vn.vietinbank.mobile.screens.iPay.QRCodeGenerator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class QRCodeGeneratorScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Create\")]")
    @AndroidFindBy(xpath = "")
    private WebElement createTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Text\"]")
    @AndroidFindBy(xpath = "")
    private WebElement createQRCodeByText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Insert text here\"]")
    @AndroidFindBy(xpath = "")
    private WebElement inputTextToGenerateQRCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Generate QR Code\"]")
    @AndroidFindBy(xpath = "")
    private WebElement generateQRCodeBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "")
    private WebElement downloadImageBtn;

    public QRCodeGeneratorScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickCreateTab() {
        click(createTab);
    }

    public void clickCreateQRCodeByType(String type) {
        WebElement typeElement = findElement("//XCUIElementTypeImage[@name='" + type + "']");
        click(typeElement);
    }

    public void inputTextToGenerateImage(String text) {
        sendKeys(inputTextToGenerateQRCode, text);
    }

    public void clickGenerateQRCodeBtn() {
        click(generateQRCodeBtn);
    }

    public void clickDownloadImageBtn() {
        click(downloadImageBtn);
        delay(8000);
    }
}
