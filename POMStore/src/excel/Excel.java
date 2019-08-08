package excel;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import img.Screenshot;
import pages.HomePage;
import pages.LoginPage;
import pdf.PdfCreation;

public class Excel {

	private final static Logger LOGGER = Logger.getLogger("excel.Excel");

	XSSFWorkbook workbook;
	XSSFSheet sheet, mainSheet, loginSheet,itemSheet;
	XSSFCell cell;
	XSSFRow row, mainRow;
	String field;
	int rowNumber;
	ArrayList<String> fields;
	WebDriver driver;
	HomePage home;
	LoginPage login;
	PdfCreation pdf;
	Screenshot img;
	ArrayList<String> values;

	String bussinessFlow;
	String username;
	String password;
	String item;
	String quantity;
	String size;
	String color;


	// Constructor
	public Excel(WebDriver driver) {
		this.driver = driver;
		home = new HomePage(driver);
		login = new LoginPage(driver);
		pdf = new PdfCreation();
		img = new Screenshot(driver);
	}

	public void getDataTest(String testID) throws Exception {
		values = null; 
		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the main sheet
		mainSheet = workbook.getSheetAt(0);
		// Save the row number when it is found
		rowNumber = -1;
		// Result for the test
		//Boolean result = false;

		for (Row row : mainSheet) {
			for (Cell cell : row) {
				if(cell.getStringCellValue().trim().equals(testID.trim()))
					rowNumber = cell.getRowIndex();
			}
		}

		if(rowNumber != -1) {

			values = null; 
			// Load the found row
			row = mainSheet.getRow(rowNumber);

			// Business flow Column
			bussinessFlow = row.getCell(3).getStringCellValue().trim();

			// Login Column
			if(row.getCell(4) != null && row.getCell(4).getStringCellValue().trim().equals("YES")) {
				//Load the login values
				values = getValues(1);
				username = values.get(0);
				password = values.get(1);
			}

			// Item Column
			if(row.getCell(5) != null && row.getCell(5).getStringCellValue().trim().equals("YES")) {
				//Load the item values
				values = getValues(2);
				item = values.get(0);
				quantity = values.get(1);
				size = values.get(2);
				color = values.get(3);
			}

			callFlowMethod(bussinessFlow);

			//pdf.createPDF(testID, row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), true);
		}
	}


	public void callFlowMethod(String flow) {
		switch (flow) {
		case "login":
			login.ingresar(username, password);
			break;
		case "addItem":
			home.agregarArticulo(item,quantity, size, color);
			break;
		case "completeOrder":
			break;
		default:
			LOGGER.log(Level.INFO, "Comando no reconocido");
			break;
		}
	}

	public ArrayList<String> getValues(int numberSheet) throws Exception {

		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load the workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(numberSheet);
		// Load the number of cells
		int cellNumber =  sheet.getRow(0).getLastCellNum();

		fields = new ArrayList<String>(); 

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

			default:
				field = cell.getStringCellValue();
				fields.add(field);
				break;
			}
		}

		System.out.println(fields);
		return fields;
	}

}
