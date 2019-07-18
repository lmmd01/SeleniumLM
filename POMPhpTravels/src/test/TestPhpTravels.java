package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Hotel;

public class TestPhpTravels {

	WebDriver driver;
	HomePage home;
	Hotel hotel;

	@BeforeTest
	public void setup() {

		// Open the browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PCDUARTE01\\Desktop\\TATA\\ECLIPSE\\ZIP\\chromedriver.exe");

		driver = new ChromeDriver();

		// Open the webpage
		driver.get("https://www.phptravels.net/");

		driver.manage().window().maximize();
	}

	@Test
	public void testMail() {

		// Create HomePage object
		home = new HomePage(driver);
		hotel = new Hotel(driver);

		// Buscar articulo
		String url = home.buscarHotel("Singapore","01/08/2019","15/08/2019","3","1");
		
		
		// Verificar disponibilidad, amenities y checking
		if(hotel.verificarDisponibilidadHotel(url) && hotel.verificarAmenities(url) && hotel.verificarChecking(url)) {
			hotel.reservarHotel("https://www.phptravels.net/hotels/detail/singapore/rendezvous-hotels/01-08-2019/15-08-2019/3/1","ElRw","Axel","Trl", "axeltrl@gmail.com");
		}

		// Verificar disponibilidad
		//home.verificarDisponibilidadHotel(url);
		//home.verificarDisponibilidadHotel("https://www.phptravels.net/hotels/detail/singapore/rendezvous-hotels/01-08-2019/15-08-2019/3/1");
		//home.verificarDisponibilidadHotel("https://www.phptravels.net/hotels/detail/veracruz/hotel-san-luis");

		// Verificar amenities
		//home.verificarAmenities(url);
		//home.verificarAmenities("https://www.phptravels.net/hotels/detail/singapore/rendezvous-hotels/01-08-2019/15-08-2019/3/1");
		//home.verificarAmenities("https://www.phptravels.net/hotels/detail/veracruz/hotel-san-luis");

		// Verificar checkin
		//home.verificarChecking(url);
		//home.verificarChecking("https://www.phptravels.net/hotels/detail/singapore/rendezvous-hotels/01-08-2019/15-08-2019/3/1");
		//home.verificarChecking("https://www.phptravels.net/hotels/detail/veracruz/hotel-san-luis");


	}
}
