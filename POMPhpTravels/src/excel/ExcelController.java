package excel;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.Hotel;
import pages.Login;
import pdf.PdfCreation;


public class ExcelController {


	XSSFWorkbook workbook;
	XSSFSheet sheet, mainSheet, loginSheet,hotelSheet,urlSheet,couponSheet;
	XSSFCell cell;
	XSSFRow row, mainRow;
	String field;
	ArrayList<String> fields = new ArrayList<String>(); 
	WebDriver driver;
	HomePage home;
	Hotel hotel;
	Login login;
	PdfCreation testPDF;

	// Constructor
	public ExcelController(WebDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
		hotel = new Hotel(driver);
		login = new Login(driver);
		testPDF = new PdfCreation();
	}

	public ArrayList<String> getValues(int numberSheet) throws Exception {

		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(numberSheet);
		// Load the number of cells
		int cellNumber =  sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < cellNumber;  i++) {

			cell = sheet.getRow(1).getCell(i);

			// Get the value and format it 
			switch (cell.getCellType()) {

			case HSSFCell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					field = dateFormat.format(cell.getDateCellValue());
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					field = cell.getStringCellValue();
				}
				fields.add(field);
				break;

			case HSSFCell.CELL_TYPE_STRING:
				field = cell.getStringCellValue();
				fields.add(field);
				break;
			}
		}

		System.out.println(fields);
		return fields;
	}

	public void getDataTest(String testID) throws Exception {

		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the main sheet
		mainSheet = workbook.getSheetAt(0);
		// Save the row number when it is found
		int rowNumber = -1;
		// Result fot the test
		Boolean result = false;

		for (Row row : mainSheet) {
			for (Cell cell : row) {
				if(cell.getStringCellValue().trim().equals(testID.trim()))
					rowNumber = cell.getRowIndex();
			}
		}

		if(rowNumber != -1) {
			// Load the found row
			row = mainSheet.getRow(rowNumber);
			ArrayList<String> values = null; 

			// Login Column
			if(row.getCell(4).getStringCellValue().trim().equals("YES")) {
				//Load the hotel sheet values
				values = getValues(1);
			}
			// Hotel Column
			if(row.getCell(5).getStringCellValue().trim().equals("YES")) {
				//Load the hotel sheet values
				values = getValues(2);
				// Call method 
				result = home.buscarHotel(values.get(0),values.get(1),values.get(2),values.get(3),values.get(4));
			}
			// URL Column
			if(row.getCell(6).getStringCellValue().trim().equals("YES")) {
				//Load the hotel sheet values
				values = getValues(3);
			}
			// Coupon Column
			if(row.getCell(7).getStringCellValue().trim().equals("YES")) {
				//Load the hotel sheet values
				values = getValues(4);
			}
		}
		
		testPDF.createPDF(testID, result);
	}
}
