package com.crm.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 
 * @author adran
 *
 */
public class ExcelfileUtility {
	/**
	 * @throws Throwable
	 * @throws EncryptedDocumentException 
	 * @throws throwable
	 * 
	 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstant.EXCELEPATH);
		  
	
		//Workbook book=WorkbookFactory.create(fis);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetName);
		DataFormatter format=new DataFormatter();
		Row row=sh.getRow(rownum);
	//	Cell cell=row.getCell(cellnum);
		//String value=cell.getStringCellValue();
		book.close();
		return format.formatCellValue(row.getCell(cellnum));
		
		
	}
	/**
	 * this mwthod  used to get last used row number on specified sheet
	 * @throws Throwable 
	 */
	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.EXCELEPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		wb.close();
		return sh.getLastRowNum();

		}
	   public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
		FileInputStream fis  = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}


}
