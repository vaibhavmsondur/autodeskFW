package com.crm.autodeskFrameworkSelenium.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed using Apache POI libraries, which used to handle Microsoft Excel Sheet
 * @author VAIBHAV
 *
 */
public class ExcelUtility {
	/**
	 * it is used to read the data from excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) {
		FileInputStream fis;
		String data=null;
		try {
			fis = new FileInputStream(IPathConstants.EXCEL_PATH);
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			data = cell.getStringCellValue();
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * used to get the Number of Rows in the excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) {
		FileInputStream fis;
		int row=0;
		try {
			fis = new FileInputStream("./data/testScriptData.xlsx");
		
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		row =sheet.getPhysicalNumberOfRows();
		wb.close();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	/**
	 * used to get the Number of Cells in the excel sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getCellCount(String sheetName) throws Throwable {
		FileInputStream fis= new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(0);
		wb.close();
		return row.getPhysicalNumberOfCells();
	}
	/**
	 * used to Write in the Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fis= new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos= new FileOutputStream("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * it is used to read the data from excel for leads based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcelLeads(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\LeadsTestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * This method is used to get Date Data in String data type
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDateDataString(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\DateTestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * This method is used to get Date data in numeric
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public int getDateDataNumeric(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\DateTestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int data =(int) cell.getNumericCellValue();
		wb.close();
		return data;
	}
}
