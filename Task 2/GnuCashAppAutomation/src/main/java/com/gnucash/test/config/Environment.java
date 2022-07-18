package com.gnucash.test.config;

import java.util.Date;

import com.gnucash.test.base.Base;


/*
 * This class is responsible for containing environment variable.
 */
public class Environment extends Base {
	
	//Global environment variables.
	public static String EXTENT_REPORT_NAME = (new Date()).toString().replace(":", "_").replace(" ", "_") + ".html";
	public static String REPORTS_FOLDER_PATH = System.getProperty("user.dir") + "/target/Reports/";
	public static String GLOBAL_PROPERTY_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/global.properties";
	public static String Test_DATA_PROPERTY_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/testData.properties";
	
	public static String fetchPlatform() {
		if(!System.getProperty("platform").equals("")) {
			return System.getProperty("platform");
		}
		return "android";
	}
}
