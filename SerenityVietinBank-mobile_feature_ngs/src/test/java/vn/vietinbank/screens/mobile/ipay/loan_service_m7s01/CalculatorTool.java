package vn.vietinbank.screens.mobile.ipay.loan_service_m7s01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import vn.vietinbank.screens.mobile.base.BaseScreen;
import vn.vietinbank.screens.mobile.base.ScrollDirection;

public class CalculatorTool extends BaseScreen {

    private final String android_txtNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\"]";
    private final String ios_txtNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField";

    private final String ios_btnDeleteMoney = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

    private final String android_sldNumberOfMoney = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvTitle\" and @text=\"Tôi muốn vay\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.mobile.ipay:id/sliderRange\"]/android.widget.SeekBar";
    private final String ios_sldNumberOfMoney = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeSlider";

    private final String android_txtNumberOfMonth = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.LinearLayout/android.widget.EditText[@resource-id=\"com.vietinbank.mobile.ipay:id/edtContent\"]";
    private final String ios_txtNumberOfMonth = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField";

    private final String ios_btnDeleteMonth = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

    private final String android_sldNumberOfMonth = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvTitle\" and @text=\"Tôi muốn trả trong thời gian\"]/following-sibling::android.widget.SeekBar[@resource-id=\"com.vietinbank.mobile.ipay:id/sliderRange\"]/android.widget.SeekBar";
    private final String ios_sldNumberOfMonth = "//XCUIElementTypeStaticText[@name=\"Tôi muốn trả trong thời gian\"]/following-sibling::XCUIElementTypeSlider";

    private final String android_chkSpecialOffers = "//android.widget.TextView[@resource-id=\"com.vietinbank.mobile.ipay:id/tvTitleLoanPromotion\" and (@text=\"Ưu đãi cho cán bộ VietinBank\" or @text=\"Ưu đãi đặc biệt\")]/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.vietinbank.mobile.ipay:id/rcvListLoanPromotion\"]//android.widget.ImageView[@resource-id=\"com.vietinbank.mobile.ipay:id/imvLoanPromotionJoined\"]";
    private final String ios_chkSpecialOffers = "//XCUIElementTypeStaticText[@name=\"Ưu đãi cho cán bộ VietinBank\" or @name=\"Ưu đãi đặc biệt\"]/following-sibling::XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@name=\"Mua bảo hiểm (Cán bộ chỉ hưởng ưu đãi lãi suất theo chương trình VietinBank Là Nhà)\" or contains(@name,\"Giảm ngay\")]/following-sibling::XCUIElementTypeImage";

    private final String android_btnContinue = "//android.widget.Button[@resource-id=\"com.vietinbank.mobile.ipay:id/btnNext\" and @text=\"Tiếp tục\"]";
//  private final String ios_btnContinue = "//XCUIElementTypeStaticText[@name=\"Tôi muốn vay\"]/following-sibling::XCUIElementTypeTextField/XCUIElementTypeButton[@name=\"Xóa văn bản\"]";

    private final String ios_btnExpectedPaymentScheduleViewer = "//XCUIElementTypeButton[@name=\"Xem lịch trả nợ dự kiến\"]";

    public CalculatorTool(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    private void inputNumberOfMoney(String numberOfMoney) {
        if (appiumDriver instanceof AndroidDriver) {
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
        if (appiumDriver instanceof AndroidDriver) {
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
        if (appiumDriver instanceof AndroidDriver) {
            sendKeys(android_sldNumberOfMoney, String.valueOf(percentOfMoney));
        } else {
            sendKeys(ios_sldNumberOfMoney, String.valueOf(percentOfMoney));
        }
    }

    private void slicePercentOfMonth(String months) {
        int percentOfMonths = Math.round(((float) Integer.parseInt(months) / 12));
        if (appiumDriver instanceof AndroidDriver) {
            sendKeys(android_sldNumberOfMonth, String.valueOf(percentOfMonths));
        } else {
            sendKeys(ios_sldNumberOfMonth, String.valueOf(percentOfMonths));
        }
    }

    public void editNumberOfMoney(String editType, String numberOfMoney) {
        if (editType.equals("EditText")) {
            inputNumberOfMoney(numberOfMoney);
        } else if (editType.equals("Slice")) {
            slicePercentOfMoney(numberOfMoney);
        }
    }

    public void editNumberOfMonth(String editType, String months) {
        if (editType.equals("EditText")) {
            inputNumberOfMonth(months);
        } else if (editType.equals("Slice")) {
            slicePercentOfMonth(months);
        }
    }

    public void uncheckSpecialOffer() {
        if (appiumDriver instanceof AndroidDriver) {
//      scrollToElement(android_chkSpecialOffers, ScrollDirection.DOWN, 3);
//      tap(android_chkSpecialOffers, 10);
        } else {
            scrollToElement(ios_chkSpecialOffers, ScrollDirection.DOWN, 3);
            String attribute = getAttribute(ios_chkSpecialOffers, "name");
            if (attribute == null) {
                tap(ios_chkSpecialOffers, 10);
            } else {
                if (!attribute.equals("iconChoiceRadioOff")) {
                    tap(ios_chkSpecialOffers, 10);
                }
            }
        }
    }

    public void checkSpecialOffer() {
        if (appiumDriver instanceof AndroidDriver) {
            scrollToElement(android_chkSpecialOffers, ScrollDirection.DOWN, 3);
            tap(android_chkSpecialOffers, 10);
        } else {
            scrollToElement(ios_chkSpecialOffers, ScrollDirection.DOWN, 3);
            String attribute = getAttribute(ios_chkSpecialOffers, "name");
            if (attribute.equals("iconChoiceRadioOff")) {
                tap(ios_chkSpecialOffers, 10);
            }
        }

    }

    public ReferenceRepaymentSchedule clickExpectedPaymentScheduleViewerButton() {
        if (appiumDriver instanceof AndroidDriver) {
            click(android_btnContinue);
        } else {
            click(ios_btnExpectedPaymentScheduleViewer);
        }
        delay(3000);
        return new ReferenceRepaymentSchedule(this.appiumDriver);
    }
}
