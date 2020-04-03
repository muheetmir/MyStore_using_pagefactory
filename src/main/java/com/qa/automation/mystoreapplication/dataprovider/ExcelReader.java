package com.qa.automation.mystoreapplication.dataprovider;

import java.io.IOException;
import com.atmecs.falcon.automation.util.parser.XlsReader;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;


/**
 * this class contains method which reads the excel file
 * @author mir.ali
 *
 */
public class ExcelReader {
	private ReportLogService report = new ReportLogServiceImpl(ExcelReader.class); 
	XlsReader xlsReader = new XlsReader();
	
	
	/**
	 * this method reads the data of excel file by using file path and sheet name
	 * @param testDataFilePath path of the file where it is located
	 * @param testDataSheetName Name of the sheet in the excel file
	 * @return the data of the excel file
	 */
	public Object[][] Registrationdata(String testDataFilePath,String testDataSheetName){
		   
	    try {
	    xlsReader.setPath(testDataFilePath);
	    } catch (IOException ioException) {
	    report.error("IOExeption occured as " + ioException.getMessage());
	    }
	    int rowCount = xlsReader.getRowCount(testDataSheetName);
	    int colcount=xlsReader.getColumnCount(testDataSheetName);
	    Object[][] data=new Object[rowCount][xlsReader.getColumnCount(testDataSheetName)];

	    for(int i=0;i<rowCount;i++) {
	    for(int j=0;j<colcount;j++) {
	    data[i][j]= xlsReader.getCellDataByColumnIndex(testDataSheetName, j, (i+1));
	}
	}

	return data;
	}

}
