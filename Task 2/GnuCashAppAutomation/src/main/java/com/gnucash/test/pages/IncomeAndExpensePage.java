package com.gnucash.test.pages;


import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.gnucash.test.base.Base;
import com.gnucash.test.config.Environment;
import com.gnucash.test.utility.LoggerUtility;
import com.gnucash.test.utility.MobileHelper;
import com.gnucash.test.utility.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/*
 * This class contains the method relates to income and expenses.
 */
public class IncomeAndExpensePage extends Base {
	
	//OR for income & expense activity.
	@AndroidFindBy(id = "menu_save")
	private MobileElement menuSave;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[4]//*[@resource-id='org.gnucash.android:id/create_transaction']")
	private MobileElement booksExpense;
	
	@AndroidFindBy(id = "input_transaction_name")
	private MobileElement transactionName;
	
	@AndroidFindBy(id = "input_transaction_amount")
	private MobileElement transactionAmount;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[4]//*[@resource-id='org.gnucash.android:id/account_balance']")
	private MobileElement incomeAmount;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[3]//*[@resource-id='org.gnucash.android:id/account_balance']")
	private MobileElement expenseAmount;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[5]//*[@resource-id='org.gnucash.android:id/create_transaction']")
	private MobileElement salaryIncome;
	
	@AndroidFindBy(id = "input_transaction_type")
	private MobileElement transactionType;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[1]//*[@resource-id='org.gnucash.android:id/account_balance']")
	private MobileElement assetsAmount;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[5]//*[@resource-id='org.gnucash.android:id/create_transaction']")
	private MobileElement cableExpense;
	
	@AndroidFindBy(accessibility = "Navigation drawer opened")
	private MobileElement globalMenu;
	
	@AndroidFindBy(xpath = "//*[@text='Scheduled Actions']")
	private MobileElement schedules;
	
	@AndroidFindBy(id = "input_recurrence")
	private MobileElement recurrencePayment;
	
	@AndroidFindBy(id = "repeat_switch")
	private MobileElement recurrenceSwitch;
	
	@AndroidFindBy(id = "freqSpinner")
	private MobileElement frequencySelector;
	
	@AndroidFindBys(
	@AndroidBy(id = "spinner_item"))
	private List<MobileElement> frequencyItems;
	
	@AndroidFindBy(id = "done_button")
	private MobileElement submitSchedule;
	
	/**
	 * Constructor for updating driver and log objects same across tests
	 * 
	 * @param driver Driver on which cases are running
	 * @param log 	 Common object for logging across framework.
	 */
	public IncomeAndExpensePage(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	MobileHelper mobHelper = new MobileHelper(driver, log);
	
	
	/**
	 * Responsible for adding income.
	 */
	public void addIncome() {
		
		mobHelper.waitAndClickElement(salaryIncome);
		mobHelper.waitAndSendTextToElement(transactionName, Utils.getPropertiesFromFile(Environment.Test_DATA_PROPERTY_FILE_PATH, "testTransaction"));
		mobHelper.waitAndSendTextToElement(transactionAmount, Utils.getPropertiesFromFile(Environment.Test_DATA_PROPERTY_FILE_PATH, "income"));
		mobHelper.waitAndClickElement(transactionType);
		mobHelper.waitAndClickElement(menuSave);
			
	}
	
	
	/**
	 * Responsible for adding expenses.
	 */
	public void addExpense() {
		
		mobHelper.waitAndClickElement(booksExpense);
		mobHelper.waitAndSendTextToElement(transactionName, Utils.getPropertiesFromFile(Environment.Test_DATA_PROPERTY_FILE_PATH, "testTransaction"));
		mobHelper.waitAndSendTextToElement(transactionAmount, Utils.getPropertiesFromFile(Environment.Test_DATA_PROPERTY_FILE_PATH, "expense"));
		mobHelper.waitAndClickElement(menuSave);
		
	}
	
	
	/**
	 * Responsible for verifying assets.
	 * 
	 * @return Amount of assets.
	 */
	public String getAssetValue() {
		
		return mobHelper.getTextFromElement(assetsAmount);
	}
	
	
	/**
	 * Responsible for validating income.
	 * 
	 * @return Return Income Amount.
	 */ 
	public String getIncomeAmount() {
		
		return mobHelper.getTextFromElement(incomeAmount);
	}
	
	
	/**
	 * Responsible for validating expenses.
	 * 
	 * @return Return Expense Amount
	 */
	public String getExpenseAmount() {
		
		return mobHelper.getTextFromElement(expenseAmount);
	}
	
	/**
	 * Responsible for scheduling transaction.
	 */
	public void addExpenseWithSchedule() {
		
		mobHelper.waitAndClickElement(cableExpense);
		mobHelper.waitAndSendTextToElement(transactionName, Utils.getPropertiesFromFile(Environment.Test_DATA_PROPERTY_FILE_PATH, "testTransaction"));
		mobHelper.waitAndSendTextToElement(transactionAmount, Utils.getPropertiesFromFile(Environment.Test_DATA_PROPERTY_FILE_PATH, "schedule"));
		mobHelper.waitAndClickElement(recurrencePayment);
		mobHelper.waitAndClickElement(recurrenceSwitch);
		mobHelper.waitAndClickElement(frequencySelector);
		mobHelper.waitAndClickElement(frequencyItems.get(3));
		mobHelper.waitAndClickElement(submitSchedule);
		mobHelper.waitAndClickElement(menuSave);
	}
	
	/**
	 * Navigation to schedule tab in settings.
	 * 
	 * @return An object of settings page.
	 */
	public SettingsPage navigateToSchedule() {

		mobHelper.waitAndClickElement(globalMenu);
		mobHelper.waitAndClickElement(schedules);
		
		return new SettingsPage(driver, log);
	}
}
