package org.almatrasporti.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Config _instance;
    private static Properties prop;
    private static final Logger logger = LoggerFactory.getLogger(Config.class);

    private Config() {
        try {
            this.loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config getInstance() {
        if (_instance == null) {
            _instance = new Config();
        }

        return _instance;
    }

    public String get(String property) {
        System.out.println(prop.getProperty(property));
        return prop.getProperty(property);

    }

    public static final Logger logger() {
        return Config.logger;
    }

    private void loadProperties() throws IOException {
        String propFileName = System.getProperty( "properties.file" );
        System.out.println("Properties file: "  + propFileName);

        if (propFileName == null) {
            propFileName = "config.properties";
        }

        prop = new Properties();

        InputStream inputStream;

        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

    }
}
