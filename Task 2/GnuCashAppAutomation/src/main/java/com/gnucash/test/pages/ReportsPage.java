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
 * This class contains the method relates to reports validation.
 */
public class ReportsPage extends Base {
	
	//OR for reports activity.
	@AndroidFindBy(id = "btn_pie_chart")
	private MobileElement btnPieChart;
	
	@AndroidFindBys(
	@AndroidBy(id = "pie_chart"))
	private List<MobileElement> pieChart;
	
	@AndroidFindBy(id = "btn_bar_chart")
	private MobileElement btnBarChart;
	
	@AndroidFindBys(
	@AndroidBy(id = "bar_chart"))
	private List<MobileElement> barChart;
	
	@AndroidFindBy(id = "btn_line_chart")
	private MobileElement btnLineChart;
	
	@AndroidFindBys(
	@AndroidBy(id = "line_chart"))
	private List<MobileElement> lineChart;
	
	
	/**
	 * Constructor for updating driver and log objects same across tests
	 * 
	 * @param driver Driver on which cases are running
	 * @param log 	 Common object for logging across framework.
	 */
	public ReportsPage(AppiumDriver<MobileElement> driver, LoggerUtility log) {
		super(driver, log);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	MobileHelper mobHelper = new MobileHelper(driver, log);
	
	
	/**
	 * Responsible for selecting pie chart.
	 */
	public void selectPieChart() {
		mobHelper.waitAndClickElement(btnPieChart);
	}
	
	/**
	 * Responsible for selecting bar chart.
	 */
	public void selectBarChart() {
		mobHelper.waitAndClickElement(btnBarChart);
	}
	
	/**
	 * Responsible for selecting line chart.
	 */
	public void selectLineChart() {
		mobHelper.waitAndClickElement(btnLineChart);
	}
	
	/**
	 * Responsible for verifying pie chart.
	 */
	public int fetchPieChart() {
		
		return pieChart.size();
	}
	
	/**
	 * Responsible for verifying bar chart.
	 */
	public int fetchBarChart() {
		
		return barChart.size();
	}
	
	/**
	 * Responsible for verifying line chart.
	 */
	public int fetchLineChart() {
		
		return lineChart.size();
	}
	
}
