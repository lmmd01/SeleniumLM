package pages;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String field;

	public String getData(int numCell) throws IOException {

		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		// To write data in the excel
		// FileOutputStream fos = new FileOutputStream(src);
		// Message to be written in the excel sheet
		// String message = ""; //

		/*
		// sheet.getLastRowNum()
		for (int i = 1; i <= 1; i++) {

			// Import data for field
			cell = sheet.getRow(i).getCell(numCell);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			field = cell.getStringCellValue();

			// Create cell where data needs to be written.
			// sheet.getRow(i).createCell(8).setCellValue(message);
			// Finally write content
			// workbook.write(fos);
		}
	
		 */
		
		
		cell = sheet.getRow(1).getCell(3);
		System.out.println(cell.getStringCellValue());
		// Close the file
		// fos.close();

		return field;

	}

}
