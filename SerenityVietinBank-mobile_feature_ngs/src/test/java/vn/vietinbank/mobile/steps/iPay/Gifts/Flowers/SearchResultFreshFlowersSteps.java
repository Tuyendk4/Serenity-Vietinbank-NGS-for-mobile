package vn.vietinbank.mobile.steps.iPay.Gifts.Flowers;

import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import vn.vietinbank.mobile.screens.iPay.Gifts.Flowers.SearchResultFreshFlowersScreen;

public class SearchResultFreshFlowersSteps {

    SearchResultFreshFlowersScreen searchResultFreshFlowersScreen = new SearchResultFreshFlowersScreen(Serenity.sessionVariableCalled("appiumDriver"));

    @And("chọn bó hoa thứ {string}")
    public void chon_bo_hoa_thu(String index) {
        searchResultFreshFlowersScreen.clickFlowerByIndex(index);
    }
}
