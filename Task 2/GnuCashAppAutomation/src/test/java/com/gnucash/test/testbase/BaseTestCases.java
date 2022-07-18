package com.gnucash.test.testbase;

import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.gnucash.test.base.Base;
import com.gnucash.test.config.Environment;
import com.gnucash.test.pages.AccountPage;
import com.gnucash.test.pages.IncomeAndExpensePage;
import com.gnucash.test.pages.ReportsPage;
import com.gnucash.test.pages.SettingsPage;
import com.gnucash.test.pages.UsabilityPage;
import com.gnucash.test.utility.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Class contains all the basic login for test cases and driver management.
 */
public class BaseTestCases extends Base {
	
	public AccountPage accountPage;
	public IncomeAndExpensePage incomeAndExpensePage;
	public UsabilityPage usabilityPage;
	public ReportsPage reportsPage;
	public SettingsPage settingsPage;
	
	
	/**
	 * Initialization for mobile driver.
	 * 
	 * @return Account page object which is going to be the root
	 * 		   for all activities.
	 * @throws Exception Generic Exception
	 */
	public AccountPage initializeDriver() throws Exception {
			
			log.infoMSG("Intitializing common capabilities.");
			
			System.out.println(Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "deviceName"));
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, 
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "deviceName"));
			
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, 
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "platformVersion"));
			
			cap.setCapability(MobileCapabilityType.APP, 
					System.getProperty("user.dir") +
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "app"));
			
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "automationName"));
			
			cap.setCapability(MobileCapabilityType.NO_RESET, true);

			//Initializing browser based on the given platform
			switch(Environment.fetchPlatform()) {
			
			case "android":
				log.infoMSG("Platform is android, Intitializing android specific capabilities.");
				
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Environment.fetchPlatform());
				
				cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
						Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "androidAppPackage"));
		        
				cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
						Utils.getPropertiesFromFile(Environment.GLOBAL_PROPERTY_FILE_PATH, "androidAppActivity"));
		        
				
				url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AndroidDriver<MobileElement>(url, cap);
				break;
			
			case "iOS":
				//We can place the IOS related initialization here.
				break;

			default:
				throw new Exception("Invalid platform! - " + Environment.fetchPlatform());
				
			}
			log.infoMSG("Driver initialized, Application launch successful.");

		return new AccountPage(driver, log);
	}
	
	
	/**
	 * Responsible for closing the app.
	 */
	public void closeApp() {

		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	
	/**
	 * Responsible for navigating back in the app.
	 */
	public void navigateBack() {
		
		driver.navigate().back();
	}
	
	
	/**
	 * Responsible for re-launch of app.
	 */
	public void navigateToMainActivity() {
		
		driver.launchApp();
	}
	
	
	/**
	 * Responsible for installing app and setting up.
	 * 
	 * @throws Exception
	 */
	@BeforeSuite
	public void suiteSetUp() throws Exception {
		
		accountPage = initializeDriver();
		accountPage.setUpAccount();
		Assert.assertEquals("Accounts", accountPage.getHomeTitle());

	}
	
	/**
	 * Initialization of driver for each test class
	 * 
	 * @throws Exception
	 */
	@BeforeClass(alwaysRun = true)
	public void classSetUp() throws Exception {

		closeApp();
		accountPage = initializeDriver();
	}
	
	
	/**
	 * Responsible for closing class after each test class.
	 */
	@AfterClass
	public void classTearDown() {
		
		closeApp();
	}
	
	
	/**
	 * Responsible for ending the test case.
	 * 
	 * @param result
	 * @throws IOException
	 */
	@AfterMethod(alwaysRun = true)
	public void methodTearDown(ITestResult result) throws IOException {
		log.endTestHTML();
	}
	
	/**
	 * Responsible for uninstalling the app.
	 * 
	 * @throws Exception
	 */
	@AfterSuite
	public void commonSuiteTearDown() throws Exception {
		
		initializeDriver();
		driver.removeApp("org.gnucash.android");
	}
	
}
