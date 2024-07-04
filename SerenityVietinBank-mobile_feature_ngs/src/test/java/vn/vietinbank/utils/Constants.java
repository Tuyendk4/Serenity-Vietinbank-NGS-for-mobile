package vn.vietinbank.utils;

import vn.vietinbank.utils.data.GetData;

import java.io.File;

public class Constants {

    //json path
    public static final String JSONPATH_BEGIN = "$.";
    //path configs/data
    public static final String pathMobileConfigs = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
            + File.separator + "resources" + File.separator + "configs" + File.separator + "mobile" + File.separator;
    public static final String RESPONSE = "RESPONSE";
    public static final String MONTH = "MONTH";
    public static final String NAME_SHOP_ACTIVE = "NAME_SHOP_ACTIVE";
    //generate data
    public static final String TIMESTAMP_LOCAL_NOW = "TIMESTAMP_LOCAL_NOW";
    public static final String LOCAL_TIME_1 = "LOCAL_TIME_1";
    public static final String LOCAL_DATE_1 = "LOCAL_DATE_1";
    public static final String LOCAL_DATE_2 = "LOCAL_DATE_2";
    public static final String LOCAL_DATE_3 = "LOCAL_DATE_3";
    public static final String NULL = "NULL";
    public static final String EMPTY = "EMPTY";
    public static final String BLANK = "BLANK";
    public static final String REMOVE = "REMOVE";
    public static final String RANDOM_NUMBER = "RANDOM_NUMBER";
    public static final String RANDOM_STRING = "RANDOM_STRING";
    public static final String SESSION_ID = "sessionId";
    public static final String ERROR_CODE = "errorCode";
    //plus/minus
    public static final String PLUS = "Thêm";
    public static final String MINUS = "Xoá bớt";
    //answer
    public static final String YES = "Có";
    public static final String NO = "Không";
    //account
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    //headers
    public static final String BEARER = "Bearer";
    public static final String BASIC_AUTH = "Basic Auth";
    public static final String ALL_TYPE = "*/*";
    //method
    public static final String METHOD_GET = "GET";
    public static final String METHOD_GET_PARAMS = "GET_PARAMS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_PATCH = "PATCH";
    public static final String METHOD_DELETE = "DELETE";
    //results
    public static final String RESULT_PASS = "PASS";
    public static final String RESULT_FAIL = "FAIL";
    public static final String TRUE = "TRUE";
    public static final String FALSE = "FALSE";
    //other
    public static final String RUN_FULL_FILE = "Run Full File";
    //serenity session variable
    public static final String HEADERS = "headers";
    public static final String PARAMS = "params";
    public static final String BODY_REQUEST = "BODY_REQUEST";
    public static final String STATUS_CODE_EXPECTED = "STATUS_CODE_EXPECTED";
    public static final String RESPONSE_STATUS = "responseStatus";
    public static final String RESPONSE_EXPECTED = "RESPONSE_EXPECTED";
    public static final String ERROR_MESSAGE = "errorMessage";
    //command
    public static final String FROM_COMMAND_LINE = "FROM_COMMAND_LINE";
    public static final String FROM_CONF_FILE = "FROM_CONF_FILE";
    public static final String FROM_ACCOUNTS_FILE = "FROM_ACCOUNTS_FILE";
    // JSON
    public static final String USER_NAME = "userName";
    //platform
    public static final String ENV = new GetData().getValueOf("env");
    //platform
    public static final String PLATFORM = new GetData().getValueOf("platformName");
    //otp
    public static final String OTP = new GetData().getValueOf("otp");
    //appium
    public static final String NODE_PATH = new GetData().getValueFromJson(pathMobileConfigs + "AppiumConfigs.json", String.format(JSONPATH_BEGIN + "%s.nodePath", new GetData().getValueOf("pcName")));
    public static final String APPIUM_PATH = new GetData().getValueFromJson(pathMobileConfigs + "AppiumConfigs.json", String.format(JSONPATH_BEGIN + "%s.appiumPath", new GetData().getValueOf("pcName")));
    //udid
    public static final String udid = new GetData().getValueOf("udid");
}
