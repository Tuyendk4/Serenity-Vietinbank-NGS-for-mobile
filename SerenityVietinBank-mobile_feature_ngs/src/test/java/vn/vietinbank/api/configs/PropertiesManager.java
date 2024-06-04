package vn.vietinbank.api.configs;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class PropertiesManager {
    public static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    PropertiesManager() {
        throw new IllegalStateException("Properties Manager class");
    }

    public static String getEnvironmentSpecFromProperty(String propertyName) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(propertyName);
    }

    public static String getValueOf(String key) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(key);
    }

    public static boolean getValueOfAsBoolean(String key) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getPropertyAsBoolean(key, true);
    }
}
