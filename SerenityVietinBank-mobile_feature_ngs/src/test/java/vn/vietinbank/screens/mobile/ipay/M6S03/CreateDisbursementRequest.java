package vn.vietinbank.screens.mobile.ipay.M6S03;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import vn.vietinbank.screens.mobile.base.BaseScreen;

public class CreateDisbursementRequest extends BaseScreen {

    private final String ios_disbursementPurposesDrp = "//XCUIElementTypeStaticText[@name=\"Chọn mục đích giải ngân\"]/../..";
    private final String android_disbursementPurposesDrp = "//android.widget.TextView[@text=\"Chọn mục đích giải ngân\"]";

    private final String ios_selectPrincipalAndInterestDebtAccountDrp = "//XCUIElementTypeStaticText[@name=\"Chọn tài khoản trả nợ gốc và lãi\"]/../following-sibling::XCUIElementTypeButton";
    private final String android_selectPrincipalAndInterestDebtAccountDrp = "//android.widget.TextView[@text=\"Chọn tài khoản trả nợ gốc và lãi mặc định\"]";

    private final String ios_principalAndInterestDebtAccountChoose = "(//XCUIElementTypeStaticText[@name=\"Chọn tài khoản trả nợ gốc và lãi\"])[2]/../following-sibling::XCUIElementTypeTable/XCUIElementTypeCell[1]";
    private final String android_principalAndInterestDebtAccountChoose = "//android.widget.TextView[@resource-id=\"com.vietinbank.ipay:id/tvDDANumber\"]";

    private final String ios_principalRepaymentPeriodDrp = "//XCUIElementTypeStaticText[@name=\"Chọn thời hạn trả nợ gốc\"]/../following-sibling::XCUIElementTypeButton";
    private final String android_principalRepaymentPeriodDrp = "//android.widget.TextView[@text=\"Chọn thời hạn trả nợ gốc\"]";

    private final String ios_regularAutomaticRepaymentDateDrp = "//XCUIElementTypeStaticText[@name=\"Thời hạn trả nợ tự động định kỳ\"]/../following-sibling::XCUIElementTypeButton";
    private final String android_regularAutomaticRepaymentDateDrp = "//android.widget.TextView[@text=\"Chọn ngày trả nợ tự động định kỳ\"]";

    private final String ios_continueCreatingDisbursementRequestBtn = "//XCUIElementTypeButton[@name=\"Tiếp tục\"]";
    private final String android_continueCreatingDisbursementRequestBtn = "//android.widget.Button[@resource-id=\"com.vietinbank.ipay:id/btnNext\"]";


    public CreateDisbursementRequest(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickDisbursementPurposes(String purposes) {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_disbursementPurposesDrp);
            String android_productionAndBusinessCostsChoose = "//android.widget.TextView[@text=\"" + purposes + "\"]";
            click(android_productionAndBusinessCostsChoose);
        } else {
            click(ios_disbursementPurposesDrp);
            String ios_productionAndBusinessCostsChoose = "//XCUIElementTypeStaticText[@name=\"" + purposes + "\"]/../../XCUIElementTypeButton";
            click(ios_productionAndBusinessCostsChoose);
        }
    }

    public void clickSelectPrincipalAndInterestDebtAccount() {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_selectPrincipalAndInterestDebtAccountDrp);
            click(android_principalAndInterestDebtAccountChoose);
        } else {
            click(ios_selectPrincipalAndInterestDebtAccountDrp);
            click(ios_principalAndInterestDebtAccountChoose);
        }
    }

    public void clickPrincipalRepaymentPeriod(String principalepaymentPeriod) {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_principalRepaymentPeriodDrp);
            String android_principalRepaymentPeriodChoose = "//android.widget.TextView[@text=\"" + principalepaymentPeriod + "\"]";
            click(android_principalRepaymentPeriodChoose);
        } else {
            click(ios_principalRepaymentPeriodDrp);
            String ios_principalRepaymentPeriodChoose = "//XCUIElementTypeStaticText[@name=\"" + principalepaymentPeriod + "\"]/../../XCUIElementTypeButton";
            click(ios_principalRepaymentPeriodChoose);
        }
    }

    public void clickRegularAutomaticRepaymentDate(String regularAutomaticRepaymentDate) {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_regularAutomaticRepaymentDateDrp);
            String android_regularAutomaticRepaymentDateChoose = "//android.widget.TextView[@text=\"" + regularAutomaticRepaymentDate + "\"]";
            click(android_regularAutomaticRepaymentDateChoose);
        } else {
            click(ios_regularAutomaticRepaymentDateDrp);
            String ios_regularAutomaticRepaymentDateChoose = "//XCUIElementTypeButton[@name=\"" + regularAutomaticRepaymentDate + "\"]";
            click(ios_regularAutomaticRepaymentDateChoose);
            String ios_RepaymentDateChoose = "//XCUIElementTypeButton[@name=\"Chọn trả nợ ngày " + regularAutomaticRepaymentDate + "\"]";
            click(ios_RepaymentDateChoose);
        }
    }

    public CreateDisbursementRequest_Step1 clickContinueCreatingDisbursementRequest() {
        if(appiumDriver instanceof AndroidDriver) {
            click(android_continueCreatingDisbursementRequestBtn);
        } else {
            click(ios_continueCreatingDisbursementRequestBtn);
        }
        return new CreateDisbursementRequest_Step1(this.appiumDriver);
    }


}
