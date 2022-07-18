package com.gnucash.test.testcase;


import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gnucash.test.testbase.BaseTestCases;

public class ReportsTests extends BaseTestCases {
	
	@BeforeMethod
	public void methodSetUp() {
		//given
		navigateToMainActivity();
		incomeAndExpensePage = accountPage.navigateToIncomePage();
		incomeAndExpensePage.addIncome();
		navigateToMainActivity();
		incomeAndExpensePage = accountPage.navigateToExpensePage();
		incomeAndExpensePage.addExpense();
		navigateToMainActivity();
	}
	
	@Test
	public void Test1AsAUserIWantToViewPieChartReport() {
		
		//when
		reportsPage = accountPage.navigateToReportsTab();
		reportsPage.selectPieChart();
		
		//then
		Assert.assertNotEquals(0, reportsPage.fetchPieChart());
		
	}
	
	@Test
	public void Test2AsAUserIWantToViewBarChartReport() {
		
		//when
		reportsPage = accountPage.navigateToReportsTab();
		reportsPage.selectBarChart();
		
		//then
		Assert.assertNotEquals(0, reportsPage.fetchBarChart());
		
	}
	
	@Test
	public void Test3AsAUserIWantToViewLineChartReport() {
		
		//when
		reportsPage = accountPage.navigateToReportsTab();
		reportsPage.selectLineChart();;
		
		//then
		Assert.assertNotEquals(0, reportsPage.fetchLineChart());
		
	}
	
}
