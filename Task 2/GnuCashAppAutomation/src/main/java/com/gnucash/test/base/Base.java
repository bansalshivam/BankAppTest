package com.gnucash.test.base;

import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.gnucash.test.utility.LoggerUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 
 * @author Shivam Bansal
 *
 * This class contains all the basic variables and methods required by all sub classes.
 */

public class Base {

	public LoggerUtility log = new LoggerUtility();
	public AppiumDriver<MobileElement> driver;
	public URL url;
	
	/*
	 * Default Constructor for Base Test Class
	 * 
	 */
	
	public Base() {}

	/*
	 * Constructor used to set driver and logger which will be available for all classes.
	 * 
	 * @param		driver		Appium driver which will be used by all classes.		
	 * 
	 */
	public Base(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		this.driver = driver;
		this.log = log;
	}
	
	
	/*
	 * Capturing screenshot in base64 format as it can be sent anywhere in HTML
	 * without specifying path.
	 * 
	 * @param		None		None
	 * @return		String		Base64 String of captured screen
	 * 
	 */
	public String captureScreenShotInBase64String() {
		return "data:image/jpeg;base64," + ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
