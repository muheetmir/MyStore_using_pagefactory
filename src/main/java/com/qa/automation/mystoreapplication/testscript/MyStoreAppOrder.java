package com.qa.automation.mystoreapplication.testscript;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.pages.AddToCartPage;
import com.qa.automation.mystoreapplication.pages.CheckoutPage;
import com.qa.automation.mystoreapplication.pages.HomePage;
import com.qa.automation.mystoreapplication.pages.LoginPage;
import com.qa.automation.mystoreapplication.pages.PaymentPage;
import com.qa.automation.mystoreapplication.testsuite.TestSuiteBase;

/*
 * this class perform the actions for placing the order from signing into the application with the known user details 
 * and adding then selecting the product from home page and adding it into the cart and placing the order.
 */
public class MyStoreAppOrder extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(MyStoreAppOrder.class);
	//LoginPage lp;				//declaring the ref for LoginPage class and instantiating in respective methods below
	HomePage hp;  				//declaring the ref for HomePage class and instantiating in respective methods below
	AddToCartPage addcartpg;	//declaring the ref for AddToCartPage class and instantiating in respective methods below
	CheckoutPage chkoutpg;		//declaring the ref for CheckoutPage class and instantiating in respective methods below
	PaymentPage paypage;		//declaring the ref for PaymentPage class and instantiating in respective methods below
	LoginPage lp;
	
	
// Launching the website and performing sign in with known credentials
	@Test(priority=1)
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void signIntoMyStore(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		browser.openURL("http://automationpractice.com/index.php", os, osVersion, br, browserVersion);
		browser.getWait().HardPause(2000);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		lp=new LoginPage(browser);
		String mystoretitle=browser.getCurrentPageTitle();
		Verify.verifyString(mystoretitle,"My Store", "Verifying the login page title");
		lp.clickSignInLink();
		lp.logIntoApplication();
		
}
	
// Selecting the product item		
	@Test(priority=2)
	public void clickOnProduct()
	{
		hp=new HomePage(browser);
		hp.selectItem();
	}
	
	
//	 adding the item into cart
	@Test(priority=3)
	public void placeOrder()
	{
		hp=new HomePage(browser);
		browser.getWait().HardPause(3000);
		addcartpg=new AddToCartPage(browser);
		
		report.info("Adding item into cart");
		addcartpg.clickAddToCart();
		
		chkoutpg=new CheckoutPage(browser);
		chkoutpg.performCheckout();
		
		paypage=new PaymentPage(browser);
		paypage.confirmOrder();
	}
}

