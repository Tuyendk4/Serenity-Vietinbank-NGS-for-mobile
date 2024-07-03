package vn.vietinbank.api.common;

import java.util.HashMap;
import java.util.Map;

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.htmlunit.util.MimeType.APPLICATION_JSON;
import static org.htmlunit.util.MimeType.APPLICATION_XML;
import static vn.vietinbank.utils.Constants.ALL_TYPE;

public class APIHelper {

    public Map<String, String> headers;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void createHeadersDefault(String type) {
        headers = new HashMap<>();
        switch (type) {
            case "json":
                headers.put(CONTENT_TYPE, APPLICATION_JSON);
                break;
            case "xml":
                headers.put(CONTENT_TYPE, APPLICATION_XML);
        }
        headers.put(ACCEPT, ALL_TYPE);
    }

    public void updateHeadersWithValue(String key, String value) {
        headers.put(key, value);
    }
}