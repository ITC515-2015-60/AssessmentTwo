package datamanagement;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class instantiates the properties for the App
 *
 * @author Pat Barilla
 * @since 2015-08-05
 */

public class AppProperties {

    private static AppProperties self = null;

    private Properties properties_;

    /**
     * Gets an instance of the Class
     *
     * @return AppProperties
     */
    public static AppProperties getInstance() {
        if (self == null ) {
            self = new AppProperties();
        }
        return self;
    }

    /**
     * Loads properties based on a file.
     *
     * @throws RuntimeException if properties cannot be read
     */
    private AppProperties() {
        properties_ = new Properties();
        try {
            properties_.load(new FileInputStream("Properties.prop"));
        }
        catch (IOException e) {
            throw new RuntimeException("Could not read property file");
        }
    }

    /**
     * Returns the private Properties object
     *
     * @return Properties properties_
     */
    public Properties getProperties() {
        return properties_;
    }

}