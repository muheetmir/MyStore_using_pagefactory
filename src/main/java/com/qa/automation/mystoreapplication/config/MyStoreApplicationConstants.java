package com.qa.automation.mystoreapplication.config;

import java.io.File;

public class MyStoreApplicationConstants {
	
	public static String RESOURCES="src"+File.separator+"main"+File.separator+"resources"+File.separator;
	public static String PROPERTIES_FILE=RESOURCES+File.separator+"pages"+File.separator+"locators.properties";
	public static String REGISTRATION_PROPERTIES=RESOURCES+File.separator+"pages"+File.separator+"registration.properties";
	public static final String TESTDATA_EXCELFILE_PATH = RESOURCES + "testdata" + File.separator + "MyStoreApp.xlsx";
}
