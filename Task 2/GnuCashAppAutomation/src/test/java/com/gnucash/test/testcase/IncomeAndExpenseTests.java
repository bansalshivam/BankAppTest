package com.gnucash.test.testcase;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gnucash.test.config.Environment;
import com.gnucash.test.testbase.BaseTestCases;
import com.gnucash.test.utility.Utils;

public class IncomeAndExpenseTests extends BaseTestCases {
	
	@Test
	public void Test1AsAUserIWantToAddIncome() {
		
		//given
		incomeAndExpensePage = accountPage.navigateToIncomePage();
		
		//when
		incomeAndExpensePage.addIncome();
		navigateBack();
		
		//then
		Assert.assertEquals(Utils.getPropertiesFromFile(
				Environment.Test_DATA_PROPERTY_FILE_PATH, "incomeValidation"), incomeAndExpensePage.getIncomeAmount());
	}
	
	@Test
	public void Test2AsAUserIWantToAddExpense() {
		
		//given
		incomeAndExpensePage = accountPage.navigateToExpensePage();
		
		//when
		incomeAndExpensePage.addExpense();
		navigateBack();
		
		//then
		Assert.assertEquals(Utils.getPropertiesFromFile(
				Environment.Test_DATA_PROPERTY_FILE_PATH, "expenseValidation"), incomeAndExpensePage.getExpenseAmount());
	}
	
	@Test
	public void Test3AsAUserIWantToValidateAssets() {
		
		//given
		incomeAndExpensePage = accountPage.navigateToIncomePage();
		
		//when
		incomeAndExpensePage.addIncome();
		navigateBack();

		//then
		Assert.assertEquals(Utils.getPropertiesFromFile(
				Environment.Test_DATA_PROPERTY_FILE_PATH, "assetValidation"), incomeAndExpensePage.getAssetValue());
	}
	
}
