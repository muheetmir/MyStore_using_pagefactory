package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.qa.automation.mystoreapplication.config.MyStoreApplicationConstants;
import com.qa.automation.mystoreapplication.utilities.CommonFunctionsUtility;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;
/**
 * it contains methods which are used to perform actions on home page elements.
 * @author mir.ali
 *
 */
public class HomePage extends MyStoreUtility{
	Browser browser;
	JavascriptExecutor js;
	CommonFunctionsUtility utilref;
	
	//static Properties homepageprop=loadProperties(MyStoreApplicationConstants.PROPERTIES_FILE);
	private ReportLogService report=new ReportLogServiceImpl(PaymentPage.class);
	
	public HomePage(Browser browser)
	{
		
		this.browser=browser;
		PageFactory.initElements(browser.getDriver(), this);
		utilref=new CommonFunctionsUtility();
	}
	
	@FindBy(xpath="//a[@class='home']")
	WebElement homeicon;
	
	@FindBy(xpath="//li[contains(@id,'category-thumbnail')]//following::li//child::a[text()='T-shirts']")
	WebElement tshirtlink;
	
	@FindBy(xpath="//div[@class='product-container']")
	WebElement itemimage;
	
	@FindBy(xpath="//a[@title='View' and contains(@class,'lnk_view')]")
	WebElement btnmore;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement btnsignout;
	
	
	//Selecting the product for placing order
	public void selectItem()
	{	
		report.info("Click on home icon");
		utilref.click(homeicon);
		
		report.info("click on t-shirts link");
		utilref.click(tshirtlink);
		
		utilref.waitForElement(itemimage, browser);
		utilref.scrollDownPage(itemimage, browser);
		
		report.info("click on more button");
		browser.getMouse().mouseHover(itemimage);
		utilref.click(btnmore);
	}
	
	//click on sign out
	public void clickSignOut()
	{	
		utilref.click(btnsignout);
	}
}
