package com.gnucash.test.testcase;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gnucash.test.testbase.BaseTestCases;

public class SettingsTests extends BaseTestCases {
	
	@Test
	public void Test1AsAUserIwantToScheduleTransactions() {
		
		//given
		incomeAndExpensePage = accountPage.navigateToExpensePage();
		
		//when
		incomeAndExpensePage.addExpenseWithSchedule();
		navigateToMainActivity();
		settingsPage = incomeAndExpensePage.navigateToSchedule();
		
		//then
		Assert.assertNotEquals(0, settingsPage.countScheduleList());
	}
	
}
