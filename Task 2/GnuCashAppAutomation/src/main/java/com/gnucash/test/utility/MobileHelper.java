package com.gnucash.test.utility;

import com.gnucash.test.base.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/*
 * This class contains all mobile operation helper methods.
 */
public class MobileHelper extends Base {


	/**
	 * Constructor for updating driver and log objects same across tests
	 * 
	 * @param driver Driver on which cases are running
	 * @param log 	 Common object for logging across framework.
	 */
	public MobileHelper(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
	}
	
	//Initializing the object of waitHelper class
	DriverWaitHelper waitHelper = new DriverWaitHelper(driver, log);
	
	
	/**
	 * Wait for element and click
	 * 
	 * @param element to be clicked.
	 */
	public void waitAndClickElement(MobileElement element) {
		waitHelper.waitAndReturnElementClickable(element).click();
	}
	
	
	/**
	 * Wait for element and send text.
	 * 
	 * @param element Element on which text to be send.
	 * @param textToSend Text which needs to be send.
	 */
	public void waitAndSendTextToElement(MobileElement element, String textToSend) {
		waitHelper.waitAndReturnElementAvailable(element).clear();;
		waitHelper.waitAndReturnElementAvailable(element).sendKeys(textToSend);
	}
	
	
	/**
	 * Wait and get text from element
	 * 
	 * @param element From which text to be fetched.
	 * @return Fetched text.
	 */
	public String getTextFromElement(MobileElement element) {
		return waitHelper.waitAndReturnElementAvailable(element).getText();
	}
	
}
