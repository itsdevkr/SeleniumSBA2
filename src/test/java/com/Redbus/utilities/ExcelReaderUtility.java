package com.Redbus.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReaderUtility {

	public static String getCellValue(String sheetName, int rowNum, int cellNum) throws IOException {
		String cellValue = null;
		try {
			FileInputStream stream = new FileInputStream(".\\excel\\RedbusTestData.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(stream);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(cellNum);
			cellValue = cell.getStringCellValue();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellValue;

	}
}
