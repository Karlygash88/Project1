package com.cybertek.library.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("config.properties");

            properties.load(file);

            file.close();

        } catch (IOException e) {
            System.out.println("Cannot read the config.properties file "+e.getMessage());
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
