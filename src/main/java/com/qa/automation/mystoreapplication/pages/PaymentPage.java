package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;

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
 * this class contains the methods which are used to perform actions on payment page of My store application
 * @author mir.ali
 *
 */
public class PaymentPage extends MyStoreUtility{
	Browser browser;
	CommonFunctionsUtility utilref;
	private ReportLogService report=new ReportLogServiceImpl(PaymentPage.class);

	static Properties paymentprop=loadProperties(MyStoreApplicationConstants.PROPERTIES_FILE);
	
	public PaymentPage(Browser browser)
	{
		this.browser=browser;
		PageFactory.initElements(browser.getDriver(), this);
		utilref=new CommonFunctionsUtility();
	}
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement lnkPayByChk;
	
	@FindBy(xpath="//label[@for='cgv' and contains(text(),'I agree')]")
	WebElement chkboxTerms;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement btnConfirmorder;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement txtorderconfirmation;
	
	//clicking on the pay by check link
	public void confirmOrder()
	{
		utilref.waitForElement(lnkPayByChk, browser);
		report.info("click on pay by check link");
		utilref.click(lnkPayByChk);
		
		utilref.waitForElement(btnConfirmorder, browser);
		report.info("click on confirm order button");
		utilref.click(btnConfirmorder);
		
		utilref.waitForElement(txtorderconfirmation, browser);
		report.info("Verifying order placed confirmation message");
		String exptext="Your order on My Store is complete.";
		utilref.validateText(browser, txtorderconfirmation, exptext);
	}
	
	
}
