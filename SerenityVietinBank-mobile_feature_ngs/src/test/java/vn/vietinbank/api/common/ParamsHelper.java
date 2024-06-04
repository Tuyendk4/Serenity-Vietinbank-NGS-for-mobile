package vn.vietinbank.api.common;

import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParamsHelper {

    private static final Logger logger = LogManager.getLogger(ParamsHelper.class);

    public static Map<String, String> createParams(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        logger.info(dataList.get(0).toString());
        return dataList.get(0);
    }
}