package vn.vietinbank.utils.converter;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Converter {

    Logger logger = LogManager.getLogger(Converter.class);

    /**
     * string to list string
     *
     * @param str   là string cần chuyển về dạng list
     * @param regex là ký hiệu ngăn cách các phần tử trong string: , - ;
     * @return List<String>
     */
    public List<String> stringToList(String str, String regex) {
        String[] arr = str.split(regex);
        return Arrays.asList(arr);
    }

    /**
     * lấy string phía trước dấu .
     *
     * @param input là string cần lấy giá trị trước dấu .
     * @return string trước dấu .
     */
    public String getStringBeforeFirstDot(String input) {
        int index = input.indexOf(".");
        if (index == -1) {
            return input;
        }
        return input.substring(0, index);
    }

    /**
     * response to JSONObject
     *
     * @param response là response của API
     * @return JSONObject
     */
    public JSONObject responseToJSONObject(Response response) {
        try {
            return new JSONObject(response.asString());
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    /**
     * string base 64 to list string
     *
     * @param base64Decoded là string của base64Decoded
     * @return List<String> là list các ký tự của base64Decoded
     */
    public List<String> base64DecodedToList(String base64Decoded) {
        String[] stringArray = base64Decoded.split("");
        return new ArrayList<>(Arrays.asList(stringArray));
    }

    /**
     * kiểm tra xem có phải IN HOA không
     *
     * @param str là string cần kiểm tra
     * @return boolean
     */
    public boolean isAllUpperCase(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * kiểm tra có phải ký tự đặc biệt không
     *
     * @param text là string cần kiểm tra
     * @return boolean
     */
    public boolean isStringInListSpecialSymbols(String text) {
        List<String> specialCharacters = Arrays.asList(
                "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=",
                "{", "}", "[", "]", "|", "\\", ":", ";", "\"", "'", "<", ">", ",", ".", "?", "/"
        );
        return specialCharacters.contains(text);
    }

    /**
     * kiểm tra có phải số không
     *
     * @param text là string cần kiểm tra
     * @return boolean
     */
    public boolean isStringInListNumbers(String text) {
        List<String> numberCharacters = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
        return numberCharacters.contains(text);
    }

    /**
     * giải mã base 64
     *
     * @param base64String là string cần kiểm tra
     * @return giá trị đã giải mã base64
     */
    public String decodeBase64String(String base64String) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        String value = new String(decodedBytes);
        logger.info(value);
        return value;
    }

    /**
     * thêm dấu , vào trong số tiền
     *
     * @param number là string số cần thêm dấu ,
     * @return giá trị đã của số đã thêm dấu ,
     */
    public String format(String number, String regex) {
        StringBuilder formattedNumber = new StringBuilder();
        int length = number.length();
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            formattedNumber.insert(0, number.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0) {
                formattedNumber.insert(0, regex);
            }
        }
        return formattedNumber.toString();
    }

    /**
     * string to JSONObject
     *
     * @param jsonString là string cần chuyển đổi sang JSONObject
     * @return JSONObject
     */
    public JSONObject stringToJSONObject(String jsonString) {
        if (jsonString == null || jsonString.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }

    /**
     * Convert 1 ngày từ format này sang format khác.
     */
    public String convertDateTime(String dateTime, String oldFormat, String newFormat) {
        if (dateTime != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(oldFormat);
            Date date = null;
            try {
                date = formatter.parse(dateTime);
            } catch (ParseException e) {
                logger.error(e.getMessage());
            }
            SimpleDateFormat formatDate = new SimpleDateFormat(newFormat);
            return formatDate.format(date);
        }
        return null;
    }

    /**
     * Convert Date sang một định dạng mới. Ví dụ từ định dạng yyyy-MM-dd chuyển sang yyyy MMM  dd
     * Dữ liệu tạo ra có kiểu String
     */
    public String convertDateTime(Date date, String newFormat) {
        if (date != null) {
            SimpleDateFormat formatDate = new SimpleDateFormat(newFormat);
            return formatDate.format(date);
        }
        return null;
    }

    public LocalDate dateTimeToLocalDate(Date date) {
        LocalDate result = null;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            result = LocalDate.of(calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
