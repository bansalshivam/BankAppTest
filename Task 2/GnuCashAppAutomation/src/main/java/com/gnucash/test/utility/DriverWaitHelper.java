package com.gnucash.test.utility;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gnucash.test.base.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * 
 * @author Shivam Bansal
 *
 * This class contains the common wait methods used by all classes.
 */
public class DriverWaitHelper extends Base {
	
	/*
	 * Constructor used to set driver and logger to base class.
	 * 
	 * @param		driver		Appium driver which will be used by all classes.		
	 * 				log			Common logger object going to be used by all classes.
	 * 
	 */
	public DriverWaitHelper(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
	}
	
	//Generic wait object for all methods.
	final WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	/*
	 * Wait for element to be available and return with specified wait time.
	 * Using explicit wait.
	 * 
	 * @param		None			None
	 * @return		MobileElement	element after available
	 * 
	 */
	public MobileElement waitAndReturnElementAvailable(MobileElement elementToWait) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(elementToWait));
	}
	
	
	/*
	 * Wait for element to be clickable and return with specified wait time.
	 * Using explicit wait.
	 * 
	 * @param		None			None
	 * @return		MobileElement	element after clickable
	 * 
	 */
	public MobileElement waitAndReturnElementClickable(MobileElement elementToWait) {
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
	}
}
