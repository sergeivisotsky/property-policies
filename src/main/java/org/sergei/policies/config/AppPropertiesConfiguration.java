package org.sergei.policies.config;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Sergei Visotsky
 */
public final class AppPropertiesConfiguration {

    private static AppPropertiesConfiguration instance = null;

    private static Properties props = null;

    /**
     * So that it was impossible to create class instance
     */
    private AppPropertiesConfiguration() {
        props = new Properties();
        ClassLoader classLoader = AppPropertiesConfiguration.class.getClassLoader();
        try {
            props.load(classLoader.getResourceAsStream("app.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get value form the property file by key
     *
     * @param key by which properties' value should be taken
     * @return value from the property file
     */
    public String getValue(String key) {
        return props.getProperty(key);
    }

    /**
     * Get property from the file by key and value
     *
     * @param key   by which property should be taken from the file
     * @param value by which property should be taken
     * @return value from the property file
     */
    public String getValue(String key, String value) {
        return props.getProperty(key, value);
    }

    /**
     * Singleton instance
     *
     * @return property provider instance
     */
    public static AppPropertiesConfiguration getInstance() {
        if (instance == null) {
            instance = new AppPropertiesConfiguration();
        }
        return instance;
    }

}
