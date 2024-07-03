package vn.vietinbank.utils.data;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import vn.vietinbank.utils.generate.GenerateDateTime;
import vn.vietinbank.utils.generate.GenerateRandom;

import java.util.List;
import java.util.Objects;

import static vn.vietinbank.utils.Constants.*;

public class DataInput {

    Logger logger = LogManager.getLogger(DataInput.class);
    GenerateDateTime generateDateTime = new GenerateDateTime();
    GenerateRandom generateRandom = new GenerateRandom();

    /**
     * cập nhật JSON với giá trị được lấy từ dataTable
     *
     * @param jsonObject là JSONObject cần update
     * @param dataTable  dữ liệu được lấy từ dataTable
     */
    public JSONObject updateJSONObject(JSONObject jsonObject, @NotNull DataTable dataTable) {
        try {
            List<List<String>> data = dataTable.asLists();
            for (int i = 0; i < data.get(0).size(); i++) {
                String key = JSONPATH_BEGIN + data.get(0).get(i);
                String value = data.get(1).get(i);
                String keyStr = key.replace(JSONPATH_BEGIN, "");
                Object[] checkData = checkData(jsonObject, value, keyStr);
                value = (String) checkData[1];
                jsonObject = (JSONObject) checkData[0];
                if (!Objects.equals(value, "REMOVE")) {
                    String check = JsonPath.parse(jsonObject.toString()).set(key, value).jsonString();
                    if (value != null && value.equals(FROM_COMMAND_LINE)) {
                        check = JsonPath.parse(jsonObject.toString()).set(key, new GetData().getValueOf(keyStr)).jsonString();
                    }
                    jsonObject = new JSONObject(check);
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        try {
            logger.info("JSON sau khi update: {}", jsonObject.toString(4));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }

    /**
     * kiểm tra dữ liệu từ dataTable, update các giá trị đấy
     *
     * @param jsonObject là JSONObject cần update
     * @param value      là giá trị được lấy từ dataTable
     * @param key        là tên cột được lấy từ dataTable
     */
    public Object[] checkData(JSONObject jsonObject, String value, String key) {
        String valueChecked;
        switch (value) {
            case TIMESTAMP_LOCAL_NOW:
                valueChecked = generateDateTime.timeStampLocalNow();
                logger.info("Giá trị của trường {} là thời gian hiện tại với định dạng yyyyMMddHHmmss = {}", key, valueChecked);
                break;
            case LOCAL_TIME_1:
                valueChecked = generateDateTime.getLocalTime1();
                logger.info("Giá trị của trường {} là thời gian hiện tại với định dạng yyyy-MM-dd'T'HH:mm:ss.SSS'Z' = {}", key, valueChecked);
                break;
            case LOCAL_DATE_1:
                valueChecked = generateDateTime.getLocalDate1();
                logger.info("Giá trị của trường {} là thời gian hiện tại với định dạng dd/MM/yyyy = {}", key, valueChecked);
                break;
            case LOCAL_DATE_2:
                valueChecked = generateDateTime.getLocalDate2();
                logger.info("Giá trị của trường {} là thời gian hiện tại với định dạng dd-MM-yyyy = {}", key, valueChecked);
                break;
            case LOCAL_DATE_3:
                valueChecked = generateDateTime.getLocalDate3();
                logger.info("Giá trị của trường {} là thời gian hiện tại với định dạng yyyy-MM-dd = {}", key, valueChecked);
                break;
            case NULL:
                valueChecked = null;
                logger.info("Giá trị của trường {} = NULL", key);
                break;
            case EMPTY:
            case BLANK:
                valueChecked = "";
                logger.info("Giá trị của trường {} là rỗng", key);
                break;
            case REMOVE:
                valueChecked = value;
                jsonObject.remove(key.replace(JSONPATH_BEGIN, ""));
                logger.info("Xoá trường {}", key);
                break;
            default:
                valueChecked = value;
                break;
        }
        if (value.contains(RANDOM_NUMBER)) {
            int[] numbers = generateRandom.extractNumbers(value);
            switch (numbers.length) {
                case 1:
                    valueChecked = generateRandom.generateRandomNumberWithLength(numbers[0]);
                    logger.info("Giá trị của trường {} là số ngẫu nhiên có độ dài {} = {}", key, numbers[0], valueChecked);
                    break;
                case 2:
                    valueChecked = generateRandom.generateRandomNumberFromTo(numbers[0], numbers[1]);
                    logger.info("Giá trị của trường {} là số ngẫu nhiên có độ dài trong khoảng {} đến {} = {}", key, numbers[0], numbers[1], valueChecked);
                    break;
                default:
                    valueChecked = value;
                    logger.info("Giá trị của trường {} là giá trị được truyền vào từ dataTable = {}", key, valueChecked);
            }
        }
        if (value.contains(RANDOM_STRING)) {
            int[] numbers = generateRandom.extractNumbers(value);
            switch (numbers.length) {
                case 1:
                    valueChecked = generateRandom.generateRandomString(numbers[0]);
                    logger.info("Giá trị của trường {} là chữ cái ngẫu nhiên có độ dài {} = {}", key, numbers[0], valueChecked);
                    break;
                case 2:
                    valueChecked = generateRandom.generateRandomStringFromTo(numbers[0], numbers[1]);
                    logger.info("Giá trị của trường {} là chữ cái ngẫu nhiên có độ dài trong khoảng {} đến {} = {}", key, numbers[0], numbers[1], valueChecked);
                    break;
                default:
                    valueChecked = value;
                    logger.info("Giá trị của trường {} là giá trị được truyền vào từ dataTable = {}", key, valueChecked);
            }
        }
        if (value.toLowerCase().contains("res") || value.toLowerCase().contains("req")) {
            valueChecked = Serenity.sessionVariableCalled(value);
            logger.info("Giá trị của trường {} là giá trị của Serenity Session Variable '{}' = {}", key, value, valueChecked);
        }
        return new Object[]{jsonObject, valueChecked};
    }
}
