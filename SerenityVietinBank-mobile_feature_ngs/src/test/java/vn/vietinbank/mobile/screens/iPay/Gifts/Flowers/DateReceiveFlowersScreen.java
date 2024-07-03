package vn.vietinbank.mobile.screens.iPay.Gifts.Flowers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import vn.vietinbank.mobile.common.BaseScreen;

public class DateReceiveFlowersScreen extends BaseScreen {

    public DateReceiveFlowersScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void tapRandomDate() {
        Point point = new Point(215, 688);
        tapAtPoint(point);
        delay(1000);
        tapAtPoint(point);
    }
}
