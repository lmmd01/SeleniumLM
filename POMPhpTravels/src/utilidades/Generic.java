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

		try {
			driver.findElement(element).click();
		} catch (NoSuchElementException ex) {
			System.out.println("No se encuentra el elemento de :" + element);
		}
	}

	// Method buscar un elemento
	public void buscarElemento(By element) {

		try {
			if (driver.findElement(element).isEnabled() && driver.findElement(element).isDisplayed()) {
				encontrado = true;
			}
		} catch (NoSuchElementException ex) {
			System.out.println("No se encuentra el elemento de :" + element);
		}
	}
}
