package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Gmail;
import pages.Hotmail;

public class TestSendMail {

	WebDriver driver;

	Gmail gmail;

	Hotmail hotmail;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PCDUARTE01\\Desktop\\TATA\\ECLIPSE\\ZIP\\chromedriver.exe");

		driver = new ChromeDriver();
	}


	@Test
	public void testMail() {

		// Create Hotmail Page object

		hotmail = new Hotmail(driver);

		// Login to Hotmail

		hotmail.loginToHotmail("black_panther_xaa@hotmail.com", "fenixlmmd");
		
		// Send a mail to another account
		
		hotmail.sendMail("mike26pogo@gmail.com", "Ciao", "Come stai?");
		
		// Logout from Hotmail
		
		hotmail.logout();

		// Create Gmail Page object

		gmail = new Gmail(driver);

		// Login to Gmail

		gmail.loginToGmail("mike26pogo", "futbol01");
		
		// Buscar mensaje 

		gmail.buscarMensaje("Ciao");
		
		// Logout from Hotmail
		
		gmail.logout();



	}

}
