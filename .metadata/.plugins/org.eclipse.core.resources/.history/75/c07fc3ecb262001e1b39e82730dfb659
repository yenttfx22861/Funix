package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
    // Đường dẫn đến tập tin properties trong thư mục configuration
    private static String CONFIG_PATH = "./configuration/configs.properties"; // Đường dẫn đúng tới tập tin properties

    // Lấy ra giá trị property bất kỳ theo key.
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(CONFIG_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
