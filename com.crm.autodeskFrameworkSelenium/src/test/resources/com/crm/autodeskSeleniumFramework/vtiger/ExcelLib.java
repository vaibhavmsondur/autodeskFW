package com.crm.autodeskSeleniumFramework.vtiger;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	public String getLibData(String sheetName, int rownum, int cellnum) throws Exception{
		FileInputStream fin= new FileInputStream("D:\\Selenium Videos\\New folder\\vtigerdata.xlsx");
		Workbook workbook= WorkbookFactory.create(fin);
		
		 Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rownum);
		 Cell cell = row.getCell(cellnum);
		 String data= cell.getStringCellValue();
		 return data;
	}
	
}
