package vn.vietinbank.mobile.screens.iPay.QRShop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import vn.vietinbank.mobile.common.BaseScreen;

public class KeyBoardIOS extends BaseScreen {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"E\" OR name == \"e\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_E;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"W\" OR name == \"w\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_W;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"R\" OR name == \"r\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_R;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"U\" OR name == \"u\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_U;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"I\" OR name == \"i\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_I;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"O\" OR name == \"o\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_O;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"A\" OR name == \"a\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_A;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"S\" OR name == \"s\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_S;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"D\" OR name == \"d\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_D;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"J\" OR name == \"j\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_J;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Y\" OR name == \"y\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_Y;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"F\" OR name == \"f\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_F;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Return\"")
    @AndroidFindBy(xpath = "")
    private WebElement Key_DONE;

    public KeyBoardIOS(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void pressKeyIos(WebElement el, String key) {
        try {
            for (char c : key.toCharArray()) {
                switch (String.valueOf(c)) {
                    case "ó":
                        click(Key_O);
                        click(Key_S);
                        break;
                    case "á":
                        click(Key_A);
                        click(Key_S);
                        break;
                    case "ấ":
                        click(Key_A);
                        click(Key_A);
                        click(Key_S);
                        break;
                    case "ư":
                        click(Key_U);
                        click(Key_W);
                        break;
                    case "ơ":
                        click(Key_O);
                        click(Key_W);
                        break;
                    case "ờ":
                        click(Key_O);
                        click(Key_W);
                        click(Key_F);
                        break;
                    case "ở":
                        click(Key_O);
                        click(Key_W);
                        click(Key_R);
                        break;
                    case "Đ":
                        click(Key_D);
                        click(Key_D);
                        break;

                    case "ế":
                        click(Key_E);
                        click(Key_E);
                        click(Key_S);
                        break;
                    case "ệ":
                        click(Key_E);
                        click(Key_E);
                        click(Key_J);
                        break;

                    default:
                        sendKeys(el, String.valueOf(c));
                        Thread.sleep(50);
                        break;
                }
                Thread.sleep(50); // Add a slight delay between each character
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pressDoneButton() {
        click(Key_DONE);
    }

}
