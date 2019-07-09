package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Login;



public class TestCompraAmazon {

	WebDriver driver;
	Login login;
	Dashboard dash;


	@BeforeTest
	public void setup() {

		// Open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PCDUARTE01\\Desktop\\TATA\\ECLIPSE\\ZIP\\chromedriver.exe");

		driver = new ChromeDriver();

		// Open the webpage
		driver.get(
				"https://www.amazon.com.mx/");
	}


	@Test
	public void testMail() {

		// Create Login/Dashboard Page object
		login = new Login(driver);
		dash = new Dashboard(driver);

		// Login to Amazon
		login.loginToAmazon("mike26pogo@gmail.com","futbol01");
		
		// Buscar articulo
		login.buscarArticulo("teclado logitech k780");
		
		// Agregar articulo al carrito
		dash.agregarCarrito();
		
		// Hacer checkout
		dash.checkout();




	}

}
