package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excel.ExcelController;
import pdf.PdfCreation;

public class TestPhpTravels {

	WebDriver driver;
	ExcelController excel;

	@BeforeTest
	public void setup() {

		// Open the browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PCDUARTE01\\Desktop\\TATA\\ECLIPSE\\ZIP\\chromedriver.exe");

		driver = new ChromeDriver();

		// Open the webpage
		driver.get("https://www.phptravels.net/");

		// Maximize browser
		//driver.manage().window().maximize();

	}

	@Test
	public void testMail() {

		excel = new ExcelController(driver);

		try {
			
			PdfCreation pdf = new PdfCreation();
			
			pdf.createPDF("Test 1", false);
			
			// Buscar hotel
			//excel.getDataTest("T2");

			/*
			// Ingresar
			excel.getDataTest("T1");

			// Buscar hotel
			excel.getDataTest("T2");

			// Verificar disponibilidad
			excel.getDataTest("T3");

			// Verificar amenities
			excel.getDataTest("T4");

			// Verificar checking
			excel.getDataTest("T5");

			// Reservar hotel
			excel.getDataTest("T6");
			*/

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
