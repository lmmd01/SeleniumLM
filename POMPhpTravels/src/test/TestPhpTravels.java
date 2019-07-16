package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestPhpTravels {

	WebDriver driver;
	HomePage home;

	@BeforeTest
	public void setup() {

		// Open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PCDUARTE01\\Desktop\\TATA\\ECLIPSE\\ZIP\\chromedriver.exe");

		driver = new ChromeDriver();

		// Open the webpage
		driver.get("https://www.phptravels.net/");
	}

	@Test
	public void testMail() {

		// Create HomePage object
		home = new HomePage(driver);

		// Buscar articulo
		home.buscarHotel("Singapore","01/08/2019","15/08/2019","3","0");

	}
}
