package test;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ExcelData;
import pages.HomePage;
import pages.Hotel;
import pages.Login;

public class TestPhpTravels {
	
	// Logger
	private final static Logger LOGGER = Logger.getLogger("TestPhpTravels");

	WebDriver driver;
	HomePage home;
	Hotel hotel;
	Login login;
	ExcelData excel;

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

		// Create HomePage object
		home = new HomePage(driver);
		hotel = new Hotel(driver);
		login = new Login(driver);
		excel = new ExcelData();


		try {
			String[] keys = new String[] {"USERNAME","PASSWORD","HOTEL","CHECKIN","CHECKOUT","NUM_ADULTS","NUM_CHILDS","COUPON","NAME_H","LAST_H","EMAIL_H"};
			ArrayList<String> values  = excel.getDatas(keys);
			//String values = excel.getData("USERNAME");
			System.out.println(values);
			LOGGER.info("Test logger");
			
			/*
			// Login
			login.ingresar(values.get(0),values.get(1));
			
			// Buscar hotel
			String url = home.buscarHotel(values.get(2),values.get(3),values.get(4),values.get(5),values.get(6));

			// Verificar disponibilidad, amenities y checking
			if(hotel.verificarDisponibilidadHotel(url) && hotel.verificarAmenities(url) && hotel.verificarChecking(url)) {
				hotel.reservarHotel(url,values.get(7),values.get(8),values.get(9),values.get(10));
			}
			*/
			
			/*
			// Login
			//login.ingresar("lmmd@lmmd.com","lmmd");
			// Buscar hotel
			String url = home.buscarHotel("Singapore","01/08/2019","15/08/2019","3","1");
			// Verificar disponibilidad, amenities y checking
			//url = https://www.phptravels.net/hotels/detail/singapore/rendezvous-hotels/01-08-2019/15-08-2019/3/1;
			if(hotel.verificarDisponibilidadHotel(url) && hotel.verificarAmenities(url) && hotel.verificarChecking(url)) {
				hotel.reservarHotel(url,"ElRw","Axel","Trl", "axeltrl@gmail.com");
			}
			*/
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}


		

		


	}
}
