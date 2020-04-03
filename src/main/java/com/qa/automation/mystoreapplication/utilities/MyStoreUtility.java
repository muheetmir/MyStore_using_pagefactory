package com.qa.automation.mystoreapplication.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;


/**
 * This class acts as utility for reading the data from properties file
 * @author mir ali
 *
 */
public class MyStoreUtility {
	Browser browser;
	Properties prop = new Properties();
/**
 * This method reads the properties file
 * @param propertyFilePath path of the file where it is located
 * @return object of properties class
 */
	 public static Properties loadProperties(String propertyFilePath ) { 
		 File file=new File(propertyFilePath);
		 FileInputStream fileInput=null; 
		 try {
			 fileInput=new FileInputStream(file);
		 }catch(FileNotFoundException e) { 
		e.printStackTrace(); } 
		Properties prop=new 
		Properties(); 
		try { 
			prop.load(fileInput); 
		}catch(IOException e) {
			e.printStackTrace();
			}
		return prop; 
	  }
	 
}
