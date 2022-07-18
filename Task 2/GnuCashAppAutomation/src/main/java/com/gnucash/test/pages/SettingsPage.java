package com.gnucash.test.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.gnucash.test.base.Base;
import com.gnucash.test.utility.LoggerUtility;
import com.gnucash.test.utility.MobileHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/*
 * This class contains the method relates to settings validation.
 */
public class SettingsPage extends Base {
	
	//OR related to settings activity.
	@AndroidFindBys(
	@AndroidBy(xpath = "//*[@resource-id='android:id/list']/android.widget.LinearLayout"))
	private List<MobileElement> scheduleList;
	
	/**
	 * Constructor for updating driver and log objects same across tests
	 * 
	 * @param driver Driver on which cases are running
	 * @param log 	 Common object for logging across framework.
	 */
	public SettingsPage(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	MobileHelper mobHelper = new MobileHelper(driver, log);
	
	
	/**
	 * Responsible for verifying scheduled transaction.
	 * 
	 * @return Count of total scheduled transaction.
	 */
	public int countScheduleList() {
		
		return scheduleList.size();
	}

}
