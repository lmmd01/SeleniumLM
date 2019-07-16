package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Generic {

	WebDriver driver;
	boolean encontrado = false;

	// Constructor
	public Generic(WebDriver driver) {
		this.driver = driver;
	}


	// Method click on element
	public void clickElement(By element) {
		driver.findElement(element).click();
	}


	// Method buscar un elemento para activar flags
	public boolean buscarElemento(String xpath) {
	
		try {
			if(driver.findElement(By.xpath(xpath)).isEnabled()) {
				encontrado = true;
			}
		} catch (NoSuchElementException ex) {
			System.out.println("No se encuentra un elemento");
		}

		return encontrado;
	}
}
