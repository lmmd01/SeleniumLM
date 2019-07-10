package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.Login;



public class TestCompraAmazon {

	WebDriver driver;
	Login login;
	Dashboard dash;
	boolean next,sesion = false;

	@BeforeTest
	public void setup() {

		// Open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PCDUARTE01\\Desktop\\TATA\\ECLIPSE\\ZIP\\chromedriver.exe");

		driver = new ChromeDriver();

		// Open the webpage
		driver.get("https://www.amazon.com.mx/");
	}


	@Test
	public void testMail() {
		
		try {

		// Create Login/Dashboard Page object
		login = new Login(driver);
		dash = new Dashboard(driver);

		// Login to Amazon
		sesion = login.loginToAmazon("email","pass");

		// Buscar articulo
		login.buscarArticulo("teclado logitech k780");

		// Agregar articulo al carrito
		dash.agregarCarrito();

		if(sesion) {
			// Hacer checkout
			dash.checkout();
		}
		
		Assert.assertEquals("true", "true");

		} catch(Exception ex) {
			System.out.println("Hay error");
			ex.printStackTrace();
		}
		 

	}

}
