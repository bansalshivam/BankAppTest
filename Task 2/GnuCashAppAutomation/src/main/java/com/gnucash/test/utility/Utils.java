package com.gnucash.test.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * Generic class can have all utility methods.
 */
public class Utils {

	
	/**
	 * Responsible for parsing properties file.
	 * 
	 * @param fileName Property file name.
	 * @param key unique key which needs to be fetched.
	 * @return Text for the particular key.
	 */
	public static String getPropertiesFromFile(String fileName, String key) {
        Properties prop = null;
        
        try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(fileName);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return prop.getProperty(key);
    }
}
