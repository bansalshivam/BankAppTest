package com.gnucash.test.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.gnucash.test.base.Base;
import com.gnucash.test.config.Environment;


public class ExtentReportManager extends Base {

	private static ExtentReports extent;
	

	/*
	 * Method to initialize and return extend report instance.
	 * 
	 * @param		None			None
	 * @return		ExtentReports	Return extent report instance
	 * 
	 */
	public static ExtentReports getInstance() {
		if(extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter(
					Environment.REPORTS_FOLDER_PATH + Environment.EXTENT_REPORT_NAME);
			
			reporter.config().setDocumentTitle(
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "reportTitle"));
			
			reporter.config().setReportName(
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "reportName"));
			
			extent = new ExtentReports();
			
			extent.attachReporter(reporter);
			
			//Setting system info in reports. 
			extent.setSystemInfo("Device Info", Utils.getPropertiesFromFile(
					Environment.GLOBAL_PROPERTY_FILE_PATH, "deviceName"));
			
			extent.setSystemInfo("Version Info",
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "platformVersion"));
			
			extent.setSystemInfo("Platform Info", Environment.fetchPlatform());
		}
		return extent;
	}
}
