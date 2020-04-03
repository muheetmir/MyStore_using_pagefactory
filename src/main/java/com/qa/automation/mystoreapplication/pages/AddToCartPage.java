package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.config.MyStoreApplicationConstants;
import com.qa.automation.mystoreapplication.utilities.CommonFunctionsUtility;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;

/**
 * It contains methods which are use to add the item into cart and it extends MyStoreUtility class.
 * @author mir.ali
 *
 */
public class AddToCartPage {
	Browser browser;
	CommonFunctionsUtility utilref;
	
	JavascriptExecutor executor;
	private ReportLogService report=new ReportLogServiceImpl(AddToCartPage.class);

	static Properties addtocartprop=MyStoreUtility.loadProperties(MyStoreApplicationConstants.PROPERTIES_FILE);
	
	public AddToCartPage(Browser browser)
	{
		this.browser=browser;
		PageFactory.initElements(browser.getDriver(), this);
		utilref=new CommonFunctionsUtility();
	}
	
	@FindBy(name="Submit")
	WebElement btnaddtocart;
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement updateqty;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement updatesize;
	
	
	
	// clicking on the add to cart button
	public void clickAddToCart()
	{	report.info("click on add to cart button");
		utilref.click(btnaddtocart);
		browser.getWait().HardPause(3000);
	}
		
}
