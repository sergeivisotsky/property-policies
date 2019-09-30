package org.sergei.policies.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Sergei Visotsky
 */
public class PropertyProvider {

    /**
     * So that it was impossible to create class instance
     */
    private PropertyProvider() {
    }

    /**
     * Read property file
     *
     * @return {@link Properties}
     */
    public static Properties getPropertyFile() {
        Properties props = new Properties();
        ClassLoader classLoader = PropertyProvider.class.getClassLoader();
        try {
            props.load(classLoader.getResourceAsStream("app.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

}
