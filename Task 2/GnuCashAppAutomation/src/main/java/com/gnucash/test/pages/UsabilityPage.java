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
 * This class contains the method relates to usability validation.
 */
public class UsabilityPage extends Base {

	//OR for usability tabs.
	@AndroidFindBys(
	@AndroidBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout"))
	private List<MobileElement> frameList;
	
	/**
	 * Constructor for updating driver and log objects same across tests
	 * 
	 * @param driver Driver on which cases are running
	 * @param log 	 Common object for logging across framework.
	 */
	public UsabilityPage(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	MobileHelper mobHelper = new MobileHelper(driver, log);
	
	
	/**
	 * Responsible for verifying list items.
	 * 
	 * @return Count of list attributes.
	 */
	public int getListItems() {
		
		return frameList.size();
	}
}
