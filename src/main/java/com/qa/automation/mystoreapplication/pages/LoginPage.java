package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;

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
 * this class contains the methods to perform the acitons on Sign in page of MyStore application
 * @author mir.ali
 *
 */
public class LoginPage extends MyStoreUtility {
		
	 Browser browser;
	CommonFunctionsUtility utilref;
		
private ReportLogService report=new ReportLogServiceImpl(LoginPage.class);

static Properties page=loadProperties(MyStoreApplicationConstants.PROPERTIES_FILE);

	public LoginPage(Browser browser)
	{
			this.browser=browser;
			PageFactory.initElements(browser.getDriver(), this);
			utilref=new CommonFunctionsUtility();
			
	}
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signinlink;
	
	@FindBy(id="email")
	WebElement txtusername;
	
	@FindBy(id="passwd")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnsignin;
	
	@FindBy(xpath="//span[text()='aaa zzz']")
	WebElement User_fn_ln;
	
	
	public void clickSignInLink()
	{	
		report.info("clicking on sign in link");	
		utilref.click(signinlink);
		utilref.waitForElement(txtusername, browser);
	}
	
	public void logIntoApplication()
	{
		report.info("enter the user name");
		txtusername.sendKeys("testapple063@gmail.com");
		
		report.info("Enter password");
		txtpassword.sendKeys("product3109!");
		
		report.info("click on sign in");
		utilref.click(btnsignin);
		
		browser.getWait().HardPause(3000);
		report.info("verifying the user first and last name");
		utilref.validateText(browser, User_fn_ln, "aaa zzz");
	}
	
}
