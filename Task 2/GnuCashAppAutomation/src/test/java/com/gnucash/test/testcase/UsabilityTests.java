package com.gnucash.test.testcase;


import org.junit.Assert;
import org.testng.annotations.Test;

import com.gnucash.test.testbase.BaseTestCases;

public class UsabilityTests extends BaseTestCases {
	
	@Test
	public void Test1AsAUserIWantToAddAccountInFavourites() {
		
		//when
		accountPage.addToFavourites();
		usabilityPage = accountPage.navigateToFavouriteTab();
		
		
		//then
		Assert.assertNotEquals(0, usabilityPage.getListItems());
	}
	
	@Test
	public void Test2AsAUserIWantToCheckRecentActivity() {
		
		//given
		accountPage.navigateToAllTab();
		incomeAndExpensePage = accountPage.navigateToIncomePage();
		incomeAndExpensePage.addIncome();
		navigateBack();
		
		//when
		usabilityPage = accountPage.moveToRecentTab();
		
		//then
		Assert.assertNotEquals(0, usabilityPage.getListItems());
	}
	
	@Test
	public void Test3AsAUserIWantToVlidateSearch() {
		
		//given
		accountPage.navigateToAllTab();

		//when
		usabilityPage = accountPage.searchItem();
		
		//then
		Assert.assertEquals(1, usabilityPage.getListItems());
	}
	
}
