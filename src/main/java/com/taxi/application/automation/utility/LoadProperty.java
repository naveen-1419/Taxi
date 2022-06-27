package com.taxi.application.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty {
	public static Properties properties;

	public static String readLocatorString(String pathFile, String keyValue) {
		properties = new Properties();
		String locatorKeyValue;
		try {
			properties.load(new FileInputStream(pathFile));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		locatorKeyValue = properties.getProperty(keyValue, "");
		return locatorKeyValue;
	}
	
	
}
