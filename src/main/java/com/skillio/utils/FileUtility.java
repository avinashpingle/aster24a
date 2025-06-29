package com.skillio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * Tum mujhe key do mai to locator dunga, locator.properties file ke andar se
	 */
	public static String getLocator(String locatorKey) {
		String baseDir = System.getProperty("user.dir");
		
		return getProperty(baseDir+"/src/test/resources/locators.properties", locatorKey);
	}
	
	public static String getProperty(String filePath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		System.out.println("Value: "+value);
		return value;
	}

	public static void main(String[] args) throws IOException {
		
	}
}
