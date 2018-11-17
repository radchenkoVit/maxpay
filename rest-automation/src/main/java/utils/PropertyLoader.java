package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public class PropertyLoader {
    private static final String PROPERTY_FILE_NAME = "application.properties";
    private static Logger LOGGER = LoggerFactory.getLogger(PropertyLoader.class);
    private static Properties prop = initProps();

    private static Properties initProps() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = PropertyLoader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
            prop.load(input);
        } catch (IOException ex) {
            LOGGER.error(format("Failed to load properties from: %s, exception: %s", PROPERTY_FILE_NAME, ex));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error(format("Failed to close input stream exception: %s", e));
                }
            }
        }

        return prop;
    }

    public static String getProperty(String name) {
        return prop.getProperty(name).trim();
    }
}
