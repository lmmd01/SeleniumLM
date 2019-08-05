package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {
	WebDriver driver;
	WebDriverWait wait;
	boolean encontrado = false;

	// Constructor
	public Generic(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}


	// Method search element
	public void buscarElemento(By element) {
		try {
			if (driver.findElement(element).isEnabled() && driver.findElement(element).isDisplayed()) {
				encontrado = true;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// Method create web element
	public WebElement createWebElement(By element) {
		WebElement webElement = null;
		try {
			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return webElement;
	}

}
