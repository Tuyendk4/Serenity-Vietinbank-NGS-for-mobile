package vn.vietinbank.api.configs;

public class DataCommonAppRestService {
    public static final String BASE_URL_SHOP = PropertiesManager.getEnvironmentSpecFromProperty("urlShop");
    public static final String BASE_URL_MA = PropertiesManager.getEnvironmentSpecFromProperty("urlMa");
    public static final String BASE_URL_DEVELOPMENT = PropertiesManager.getEnvironmentSpecFromProperty("urlDevelopment");

    private DataCommonAppRestService() {
        throw new IllegalStateException("DataCommonAppRestService");
    }
}
