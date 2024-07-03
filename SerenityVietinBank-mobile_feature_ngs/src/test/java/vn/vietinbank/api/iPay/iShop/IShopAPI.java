package vn.vietinbank.api.iPay.iShop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IShopAPI {

    public String getIdByName(JSONArray dataArray, String name) {
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject cityObj;
            try {
                cityObj = dataArray.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            String nameInData;
            try {
                nameInData = cityObj.getString("name");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            if (nameInData.equals(name)) {
                try {
                    return cityObj.getString("id");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }
}