package com.gnucash.test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gnucash.test.utility.LoggerUtility;


/**
 * 
 * @author Shivam Bansal
 *
 * This class contains listener for all testNG events and methods are the implemented as
 * ITestListener is an interface.
 * 
 */
public class EventListener implements ITestListener {

	LoggerUtility log = new LoggerUtility();
	
	@Override  
	public void onTestStart(ITestResult result) {
		log.initiateTestHTML(result.getName());
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	 
		log.reportInfoMsgInHtml("Success of test cases and its details are : "+result.getName());
		log.endTestHTML();
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	
		log.reportFailureInHtml("Failure of test cases and its details are : "+result.getName());  
		log.endTestHTML();
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	
		log.infoMSG("Skip of test cases and its details are : "+result.getName());
		log.endTestHTML();
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	
		log.infoMSG("Failure of test cases and its details are : "+result.getName());  
		log.endTestHTML();
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
		
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	
	}
}
