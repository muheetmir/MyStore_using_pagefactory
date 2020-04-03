package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.config.MyStoreApplicationConstants;
import com.qa.automation.mystoreapplication.utilities.CommonFunctionsUtility;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;

/**
 * this class contains the elements of checkout page and methods to perform checkout for placing the order
 * and it extends the MyStoreUtility class
 * @author mir.ali
 *
 */
public class CheckoutPage extends MyStoreUtility{
	Browser browser;
	JavascriptExecutor executor;
	CommonFunctionsUtility utilref;
	private ReportLogService report=new ReportLogServiceImpl(CheckoutPage.class);

	static Properties checkoutprop=loadProperties(MyStoreApplicationConstants.PROPERTIES_FILE);
	
	
	public CheckoutPage(Browser browser)
	{
		this.browser=browser;
		PageFactory.initElements(browser.getDriver(), this);
		utilref=new CommonFunctionsUtility();
	}
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement btnproceedchkout;
	
	@FindBy(xpath="//a[@title='Proceed to checkout' and contains(@class,'standard')]")
	WebElement btnsummarychkout;
	
	@FindBy(name="processAddress")
	WebElement btnaddresschkout;
	
	@FindBy(xpath="//label[@for='cgv' and contains(text(),'I agree')]")
	WebElement chkboxTerms;
	
	@FindBy(name="processCarrier")
	WebElement btnshhippingchkout;
	
	
	public void performCheckout()
	{	
		utilref.waitForElement(btnproceedchkout, browser);
		report.info("click on proceed to checkout button");
		utilref.clickUsingJavaScriptExecutor(btnproceedchkout, browser);
		
		utilref.waitForElement(btnsummarychkout, browser);
		report.info("check out on summary page");
		utilref.click(btnsummarychkout);
		
		utilref.waitForElement(btnaddresschkout, browser);
		report.info("checkout on address page");
		utilref.click(btnaddresschkout);
		
		utilref.waitForElement(chkboxTerms, browser);
		report.info("accept term and conditons");
		utilref.click(chkboxTerms);
		
		utilref.waitForElement(btnshhippingchkout, browser);
		report.info("checkout on shipping page");
		utilref.click(btnshhippingchkout);
	}	
	
}
