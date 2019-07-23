package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {


	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	String field;
	ArrayList<String> fields = new ArrayList<String>(); 
	
	public String getData(String columnName) throws Exception {

		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(1);
		// Load the first row
		row = sheet.getRow(0);
		// Variable to assign column #
		int columnNum = -1;
		
		for(int i = 0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals(columnName.trim()))
            	columnNum = i;
        }
		
		cell = sheet.getRow(1).getCell(columnNum);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		field = cell.getStringCellValue();

		return field;

	}
	
	
	public ArrayList<String> getDatas(String[] columnNames) throws Exception {

		// Import excel sheet.
		File src = new File("C:\\Users\\PCDUARTE01\\Desktop\\test.xlsx");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(1);
		// Load the first row
		row = sheet.getRow(0);
		// Variable to assign column #
		int columnNum = -1;

		for(int i = 0; i < row.getLastCellNum(); i++)
		{

			for(int j = 0; j < columnNames.length; j++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(columnNames[j].trim())) {
					columnNum = i;
					cell = sheet.getRow(1).getCell(columnNum);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					field = cell.getStringCellValue();
					fields.add(field);
				}

			}
		}

		return fields;

	}
	

}
