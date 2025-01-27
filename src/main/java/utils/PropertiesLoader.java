package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {

    private String propertyFile;

    public PropertiesLoader(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public Properties load() {
        InputStream propertyStream = null;
        try {
            propertyStream = new FileInputStream(propertyFile);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        try {
            properties.load(propertyStream);
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }

        return properties;
    }


}