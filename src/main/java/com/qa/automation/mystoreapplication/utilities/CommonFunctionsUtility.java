package com.qa.automation.mystoreapplication.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class CommonFunctionsUtility {
	
	
	public void click(WebElement element)
	{
		element.click();
	}
	
	public void clickUsingJavaScriptExecutor(WebElement element,Browser browser)
	{
		JavascriptExecutor jsobj=(JavascriptExecutor)browser.getDriver();
		jsobj.executeScript("arguments[0].click();", element);
	}
	
	public WebElement waitForElement(WebElement elementtobeloaded,Browser browser)
	{
		WebDriverWait wait=new WebDriverWait(browser.getDriver(), 20);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementtobeloaded));
		return element;
	}
	
	public void scrollDownPage(WebElement element,Browser browser)
	{
		JavascriptExecutor js=(JavascriptExecutor)browser.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public boolean validateText(Browser browser,WebElement element,String expectedText)
	{
		String actualText=element.getText();
		if(actualText.equalsIgnoreCase(expectedText)){
			return true;
		}
		else
			return false;
	}
	
}
