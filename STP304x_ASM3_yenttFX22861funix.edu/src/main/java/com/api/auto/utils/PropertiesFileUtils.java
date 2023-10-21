package com.api.auto.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
	private static String CONFIG_PATH = "./configuration/configs.properties";
	private static String TOKEN_PATH = "./configuration/token.properties";


    // Đọc giá trị thuộc tính từ tệp cấu hình chứa các cài đặt
	public static String getProperty(String key) throws IOException {
		Properties properties = new Properties();
		String value = "";
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(CONFIG_PATH);
			properties.load(fileInputStream);
			value = properties.getProperty(key);
			return value;
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	   // Đọc giá trị token từ tệp cấu hình chứa token
	public static String getToken(String key) throws IOException {
		Properties properties = new Properties();
		String value = "";
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(TOKEN_PATH);
			properties.load(fileInputStream);
			value = properties.getProperty(key);
			return value;
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	

    // Lưu giá trị token mới vào tệp cấu hình
	public static void saveToken(String key, String value) {
		Properties properties = new Properties();
		FileOutputStream fileOutputStream = null;
		try {
			
			fileOutputStream = new FileOutputStream(TOKEN_PATH);
			properties.setProperty(key, value);
			properties.store(fileOutputStream, "Set new value in properties");
			System.out.println("Set new value in file properties success.");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
		
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}


}