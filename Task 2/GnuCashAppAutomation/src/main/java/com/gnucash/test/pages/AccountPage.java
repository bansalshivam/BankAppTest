package com.gnucash.test.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.gnucash.test.base.Base;
import com.gnucash.test.utility.LoggerUtility;
import com.gnucash.test.utility.MobileHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


/*
 * This class contains the method relates to main account page.
 */
public class AccountPage extends Base {
	
	//OR for Account Page.
	@AndroidFindBy(id = "btn_save")
	private MobileElement btnNext;
	
	@AndroidFindBy(xpath = "//*[@text='EUR']")
	private MobileElement currencyTab;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[1]")
	private MobileElement defaultAccountTab;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[2]")
	private MobileElement disableCrashTab;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement alertDismiss;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/toolbar']/android.widget.TextView")
	private MobileElement homeTitle;

	@AndroidFindBy(id = "fab_create_account")
	private MobileElement accountCreate;
	
	@AndroidFindBy(id = "input_account_name")
	private MobileElement accountName;
	
	@AndroidFindBy(id = "menu_save")
	private MobileElement menuSave;
	
	@AndroidFindBys(
	@AndroidBy(xpath = "//*[@text='Account Test']"))
	private List<MobileElement> verifyAccount;
	
	@AndroidFindBys(
	@AndroidBy(xpath = "//*[@text='Account Test Updated']"))
	private List<MobileElement> verifyUpdatedAccount;
	
	@AndroidFindBys(
	@AndroidBy(id = "options_menu"))
	private List<MobileElement> optionsMenu;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[3]")
	private MobileElement expenseTab;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[1]//android.widget.TextView")
	private MobileElement editAccount;
	
	@AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[2]//android.widget.TextView")
	private MobileElement deleteAccount;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[4]")
	private MobileElement incomeTab;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/account_recycler_view']/android.widget.FrameLayout[2]//*[@ resource-id='org.gnucash.android:id/favorite_status']")
	private MobileElement equityFavourite;
	
	@AndroidFindBy(accessibility = "Navigation drawer opened")
	private MobileElement globalMenu;
	
	@AndroidFindBy(xpath = "//*[@text='Favorites']")
	private MobileElement favorites;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/tab_layout']//android.support.v7.app.ActionBar.Tab[1]")
	private MobileElement recentTab;
	
	@AndroidFindBy(xpath = "//*[@resource-id='org.gnucash.android:id/tab_layout']//android.support.v7.app.ActionBar.Tab[2]")
	private MobileElement allTab;
	
	@AndroidFindBy(accessibility = "Search")
	private MobileElement searchBox;
	
	@AndroidFindBy(id = "search_src_text")
	private MobileElement searchText;
	
	@AndroidFindBy(xpath = "//*[@text='Reports']")
	private MobileElement reports;
	
	
	/**
	 * Constructor for updating driver and log objects same across tests
	 * 
	 * @param driver Driver on which cases are running
	 * @param log 	 Common object for logging across framework.
	 */
	public AccountPage(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	MobileHelper mobHelper = new MobileHelper(driver, log);
	
	
	/**
	 * Method for setting up the initial account.
	 */
	public void setUpAccount() {
		
		mobHelper.waitAndClickElement(btnNext);
		mobHelper.waitAndClickElement(currencyTab);
		mobHelper.waitAndClickElement(btnNext);
		mobHelper.waitAndClickElement(defaultAccountTab);
		mobHelper.waitAndClickElement(btnNext);
		mobHelper.waitAndClickElement(disableCrashTab);
		mobHelper.waitAndClickElement(btnNext);
		mobHelper.waitAndClickElement(btnNext);
		mobHelper.waitAndClickElement(alertDismiss);
	}
	
	
	/**
	 * Return the title of the app
	 * 
	 * @return title
	 */
	public String getHomeTitle() {
		
		return homeTitle.getText();
	}
	
	
	/**
	 * Responsible for creating an account.
	 */
	public void createAccount() {
		
		mobHelper.waitAndClickElement(accountCreate);
		mobHelper.waitAndSendTextToElement(accountName, "Account Test");
		mobHelper.waitAndClickElement(menuSave);
	}
	
	
	/**
	 * Responsible for editing the account.
	 */
	public void editAccount() {
		
		mobHelper.waitAndClickElement(optionsMenu.get(0));
		mobHelper.waitAndClickElement(editAccount);
		mobHelper.waitAndSendTextToElement(accountName, "Account Test Updated");
		mobHelper.waitAndClickElement(menuSave);
	}
	
	
	/**
	 * Responsible for deleting the account.
	 */
	public void deleteAccount() {
		
		mobHelper.waitAndClickElement(optionsMenu.get(0));
		mobHelper.waitAndClickElement(deleteAccount);
	}
	
	
	/**
	 * Responsible for verifying the account created.
	 * 
	 * @return Count of created account.
	 */
	public int getCreatedAccountCount() {
		
		return verifyAccount.size();
	}
	
	
	/**
	 * Responsible for verifying the edited account.
	 * 
	 * @return Count of updated account.
	 */
	public int getUpdatedAccountCount() {
		
		return verifyUpdatedAccount.size();
	}
	
	
	/**
	 * Responsible for navigating to income page.
	 * 
	 * @return An object of income page.
	 */
	public IncomeAndExpensePage navigateToIncomePage() {
		
		mobHelper.waitAndClickElement(incomeTab);
		return new IncomeAndExpensePage(driver, log);
	}
	
	
	/**
	 * Responsible for navigating to expense page.
	 * 
	 * @return An object of expense page.
	 */
	public IncomeAndExpensePage navigateToExpensePage() {
		
		mobHelper.waitAndClickElement(expenseTab);
		return new IncomeAndExpensePage(driver, log);
	}
	
	
	/**
	 * Responsible for adding an account to favourites.
	 */
	public void addToFavourites() {

		mobHelper.waitAndClickElement(equityFavourite);
	}
	
	
	/**
	 * Responsible for navigating to favorite tab.
	 * 
	 * @return An object of usability class.
	 */
	public UsabilityPage navigateToFavouriteTab() {
		
		mobHelper.waitAndClickElement(globalMenu);
		mobHelper.waitAndClickElement(favorites);
		
		return new UsabilityPage(driver, log);
	}
	
	
	/**
	 * Navigating to All accounts tab.
	 */
	public void navigateToAllTab() {
		mobHelper.waitAndClickElement(allTab);
	}
	
	
	/**
	 * Responsible for navigating to recent tab.
	 * 
	 * @return An Object of Usability Class.
	 */
	public UsabilityPage moveToRecentTab() {
		
		mobHelper.waitAndClickElement(recentTab);
		return new UsabilityPage(driver, log);
	}
	
	
	/**
	 * Responsible for searching an item.
	 * 
	 * @return An Object of Usability Class.
	 */
	public UsabilityPage searchItem() {
		
		mobHelper.waitAndClickElement(searchBox);
		mobHelper.waitAndSendTextToElement(searchText, "Books");
		return new UsabilityPage(driver, log);
	}
	
	
	/**
	 * Responsible for navigating to reports activity.
	 * 
	 * @return An object of reports page.
	 */
	public ReportsPage navigateToReportsTab() {
		
		mobHelper.waitAndClickElement(globalMenu);
		mobHelper.waitAndClickElement(reports);
		return new ReportsPage(driver, log);
	}
}
