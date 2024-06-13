package vn.vietinbank.api.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static vn.vietinbank.api.configs.APIConstants.*;

public class HeaderHelper {

    private static final Logger logger = LogManager.getLogger(HeaderHelper.class);

    public static Map<String, String> headersDefault() {
        Map<String, String> map = new HashMap<>();
        map.put(CONTENT_TYPE, APPLICATION_JSON);
        map.put(ACCEPT, ALL_TYPE);
        logger.info(map.toString());
        return map;
    }

    public static Map<String, String> headersChangeAcceptValue(String acceptValue) {
        Map<String, String> map = new HashMap<>();
        map.put(CONTENT_TYPE, APPLICATION_JSON);
        map.put(ACCEPT, acceptValue);
        logger.info(map.toString());
        return map;
    }

    public static Map<String, String> headersDefaultXML() {
        Map<String, String> map = new HashMap<>();
        map.put(CONTENT_TYPE, APPLICATION_XML);
        map.put(ACCEPT, ALL_TYPE);
        logger.info(map.toString());
        return map;
    }

    public static Map<String, String> headersWithAuthorization(String typeAuthorization, String authorization) {
        Map<String, String> map = headersDefault();
        String auth = "";
        switch (typeAuthorization) {
            case BEARER:
                auth = BEARER + " " + authorization;
                break;
            case BASIC_AUTH:
                auth = authorization;
                break;
            default:
                break;
        }
        map.put(AUTHORIZATION, auth);
        logger.info(map.toString());
        return map;
    }

}
