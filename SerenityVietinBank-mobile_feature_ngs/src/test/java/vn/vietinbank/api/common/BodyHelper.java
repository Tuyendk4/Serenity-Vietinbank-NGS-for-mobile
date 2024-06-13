package vn.vietinbank.api.common;

import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static vn.vietinbank.api.utils.ExcelActions.excelToJsonConverter;

public class BodyHelper {

    private static final Logger logger = LogManager.getLogger(BodyHelper.class);

    public static Map<String, String> createBody(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        logger.info(dataList.get(0).toString());
        return dataList.get(0);
    }

    public static JSONObject getExcelToJson(DataTable dataTable) {
        try {
            List<List<String>> data = dataTable.asLists();
            return new JSONObject(excelToJsonConverter(data.get(1).get(0), data.get(1).get(1), data.get(1).get(2)));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}