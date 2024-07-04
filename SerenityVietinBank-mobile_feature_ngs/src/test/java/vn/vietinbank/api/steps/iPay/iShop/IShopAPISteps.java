package vn.vietinbank.api.steps.iPay.iShop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import vn.vietinbank.api.iPay.iShop.IShopAPI;
import vn.vietinbank.api.steps.CommonSteps;

public class IShopAPISteps {

    Logger logger = LogManager.getLogger(IShopAPISteps.class);
    IShopAPI iShopAPI = new IShopAPI();
    JSONObject response = CommonSteps.getResponse();

    @Then("kiểm tra trạng thái cửa hàng {string}")
    public void checkShopStatus(String status) {
        String actualStatus;
        if (response.toString().contains("sharedShopLst")) {
            try {
                actualStatus = response.getJSONArray("sharedShopLst").getJSONObject(0).get("status").toString();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                actualStatus = response.getJSONObject("data").get("status").toString();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        if (status.equalsIgnoreCase("CLOSE") || status.equalsIgnoreCase("C") || status.equalsIgnoreCase("ĐÓNG")) {
            Assert.assertEquals("C", actualStatus);
        } else {
            Assert.assertEquals("A", actualStatus);
        }
    }

    @And("lấy từ {string} và lưu {string} có tên {string} thành biến Serenity Session Variable")
    public void lay_va_luu_thanh_serenity_session_variable(String source, String serenitySessionVariable, String name) {
        JSONObject response = CommonSteps.getResponse();
        try {
            JSONArray dataArray = (JSONArray) response.get("data");
            Serenity.setSessionVariable(serenitySessionVariable).to(iShopAPI.getIdByName(dataArray, name));
            Serenity.setSessionVariable(serenitySessionVariable + "INFO").to(iShopAPI.getIdByName(dataArray, name) + "###" + name);
            logger.info("ID của {} là {} được lưu vào biến {}", name, iShopAPI.getIdByName(dataArray, name), serenitySessionVariable);
            logger.info("Info của {} là {} được lưu vào biến {}", name, iShopAPI.getIdByName(dataArray, name) + "###" + name, serenitySessionVariable + "INFO");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("response có trường errorCode {string} và errorMessage {string}")
    public void validateInputApiResponse(String errorCode, String errorMessage) {
        try {
            if (errorMessage.equals("SUCCESS")) {
                Assert.assertFalse(response.getBoolean("error"));
            } else if (errorMessage.equals("Bad Request") || errorMessage.equals("Internal Server Error")) {
                Assert.assertEquals(errorMessage, response.getString("error"));
                Assert.assertEquals(errorCode, response.getString("status"));
            } else {
                Assert.assertTrue(response.getBoolean("error"));
                if (!errorCode.isBlank() && !errorCode.isEmpty() && !errorCode.equalsIgnoreCase("undefined")) {
                    Assert.assertEquals(errorCode, response.getString("errorCode"));
                    Assert.assertTrue(response.getString("errorMessage").contains(errorMessage));
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
