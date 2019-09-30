package org.sergei.policies.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Sergei Visotsky
 */
public final class PropertyReader {

    /**
     * So that it was impossible to create class instance
     */
    private PropertyReader() {
    }

    /**
     * Read property file
     *
     * @return {@link Properties}
     */
    public static Properties readPropertyFile() {
        Properties props = new Properties();
        ClassLoader classLoader = PropertyReader.class.getClassLoader();
        try {
            props.load(classLoader.getResourceAsStream("app.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

}
