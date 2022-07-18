package com.gnucash.test.utility;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * 
 * @author Shivam Bansal
 *
 * This is the main and the only class to take care logging activities.
 * Two types of logging is used here one is in log4j and second is to generate html extent reports.
 */
public class LoggerUtility {

	private static Logger log = Logger.getLogger(LoggerUtility.class);
	private ExtentReports extent = ExtentReportManager.getInstance();
	private static ExtentTest test;
	
	
	/*
	 * Method to log start of test case on console and in log4j file.
	 * 
	 * @param		testCaseName	Name of the test case
	 * @return		void			None
	 * 
	 */
	public void startTestCase(final String testCaseName) {
		log.info("******************************************************************************");
		log.info("----------------- Starting Test Case  :  " + testCaseName);
		log.info("******************************************************************************");
	}
	
	
	/*
	 * Method to log end of test case on console and in log4j file.
	 * 
	 * @param		testCaseName	Name of the test case
	 * @return		void			None
	 * 
	 */
	public void endTestCase(final String testCaseName) {
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		log.info("----------------- Ending Test Case    :  " + testCaseName);
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	
	/*
	 * Method to log info level logs of console and in log4j file.
	 * 
	 * @param		message			Text to write.
	 * @return		void			None
	 * 
	 */
	public void infoMSG(final String message) {
		log.info(message);
	}
	
	
	/*
	 * Method to log warning level logs of console and in log4j file.
	 * 
	 * @param		message			Text to write.
	 * @return		void			None
	 * 
	 */
	public void warningMSG(final String message) {
		log.warn(message);
	}
	
	
	/*
	 * Method to log error level logs of console and in log4j file.
	 * 
	 * @param		message			Text to write.
	 * @return		void			None
	 * 
	 */
	public void errorMSG(final String message) {
		log.error(message);
	}
	
	
	/*
	 * Method to log fatal level logs of console and in log4j file.
	 * 
	 * @param		message			Text to write.
	 * @return		void			None
	 * 
	 */
	public void fatalMSG(final String message) {
		log.fatal(message);
	}
	
	
	/*
	 * Method to log debug level logs of console and in log4j file.
	 * 
	 * @param		message			Text to write.
	 * @return		void			None
	 * 
	 */
	public void debugMSG(final String message) {
		log.debug(message);
	}
	
	
	/*
	 * Method to log initialization of test case in extent HTML report
	 * 
	 * @param		testCaseName	Name of the test case
	 * @return		void			None
	 * 
	 */
	public void initiateTestHTML(final String testCaseName) {
		startTestCase(testCaseName);
		test = extent.createTest(testCaseName);
	}
	
	
	/*
	 * Method to log end of test case in extent HTML report
	 * 
	 * @param		testCaseName	Name of the test case
	 * @return		void			None
	 * 
	 */
	public void endTestHTML() {
		endTestCase(test.getModel().getName());
		if(extent != null) {
			extent.flush();
		}
	}
	
	
	/*
	 * Method to log info level logs of test case in extent HTML report
	 * 
	 * @param		message			Text to write in reports
	 * @return		void			None
	 * 
	 */
	public void reportInfoMsgInHtml(final String message) {
		infoMSG(message);
		test.log(Status.INFO, message);
	}
	
	
	/*
	 * Method to log warning level logs of test case in extent HTML report
	 * 
	 * @param		message			Text to write in reports
	 * @return		void			None
	 * 
	 */
	public void reportWarningMsgInHtml(final String message) {
		warningMSG(message);
		test.log(Status.WARNING, message);
	}
	
	
	/*
	 * Method to log failure level logs of test case in extent HTML report
	 * 
	 * @param		message			Text to write in reports
	 * @return		void			None
	 * 
	 */
	public void reportFailureMsgInHtml(final String message) {
		errorMSG(message);
		test.log(Status.FAIL, message);
	}
	
	
	/*
	 * Method to log skip level logs of test case in extent HTML report
	 * 
	 * @param		message			Text to write in reports
	 * @return		void			None
	 * 
	 */
	public void reportSkippedMsgInHtml(final String message) {
		warningMSG(message);
		test.log(Status.SKIP, message);
	}
	
	
	/*
	 * Method to log pass level logs of test case in extent HTML report
	 * 
	 * @param		message			Text to write in reports
	 * @return		void			None
	 * 
	 */
	public void reportPassInHtml(final String message) {
		infoMSG(message);
		test.log(Status.PASS, message);
	}
	
	
	/*
	 * Method to report failure of test case in extent HTML report
	 * and generate an failed assertion to fail testNG test.
	 * 
	 * @param		message			Text to write in reports
	 * @return		void			None
	 * 
	 */
	public void reportFailureInHtml(final String message) {
		errorMSG("****************** Test Item Failed ******************");
		test.log(Status.FAIL, message);
		Assert.fail(message);
	}
	

	/*
	 * Method to log screenshot in extent HTML report
	 * 
	 * @param		base64ImageString	base64 string of image
	 * @return		void				None
	 * 
	 */
	public void reportScreenshotInHtml(final String base64ImageString) {
		test.addScreenCaptureFromBase64String(base64ImageString);
	}
	
	
	/*
	 * Method to remove test from extent report in case of retry.
	 * 
	 * @param		testCaseName	Name of test case to remove
	 * @return		void			None
	 * 
	 */
	public void removeTestFromHtml(final String testCaseName) {
		extent.removeTest(testCaseName);
	}

}
