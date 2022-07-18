package com.gnucash.test.testcase;


import org.junit.Assert;

import org.testng.annotations.Test;

import com.gnucash.test.testbase.BaseTestCases;

public class SetupAndAccountTests extends BaseTestCases {
	
	@Test
	public void Test1AsAUserIWantToCreateAccount() {
		
		//when
		accountPage.createAccount();
		
		//then
		Assert.assertNotEquals(0, accountPage.getCreatedAccountCount());
	}
	
	@Test
	public void Test2AsAUserIWantToEditAccount() {
		
		//when
		accountPage.editAccount();
		
		//then
		Assert.assertNotEquals(0, accountPage.getUpdatedAccountCount());
	}
	
	@Test
	public void Test3AsAUserIWantToDeleteAccount() {
		
		//when
		accountPage.deleteAccount();
		
		//then
		Assert.assertEquals(0, accountPage.getUpdatedAccountCount());
	}
	
	
}
