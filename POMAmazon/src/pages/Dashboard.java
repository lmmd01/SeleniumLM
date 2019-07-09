package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

	WebDriver driver;

	//By articulo = By.xpath("//DIV[@data-index='0']");
	By articulo = By.xpath("//IMG[@data-image-index='3']");
	By agregarCarrito = By.xpath("//INPUT[@id='add-to-cart-button']");
	By botonCarrito = By.id("a-autoid-0-announce");
	By botonCheckout = By.xpath("//INPUT[@name='proceedToCheckout']");
	By botonDireccion = By.xpath("//SPAN[@class='a-button-inner']/child::a[contains(text(),'Entregar a esta dire')]");
	By botonContinuarEnvio = By.xpath("//INPUT[@value='Continuar']");

	// Constructor
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

	// Method agregarCarrito
	public void agregarCarrito() {

		// Click articulo 0
		this.clickElement(this.articulo);

		// Click agregar al carrito
		this.clickElement(this.agregarCarrito);

		// Click boton del carrito
		this.clickElement(this.botonCarrito);

	}

	// Method checkout
	public void checkout() {

		// Click boton checkout
		this.clickElement(this.botonCheckout);

		// Click boton de direccion
		this.clickElement(botonDireccion);

		// Click continuar envio
		this.clickElement(botonContinuarEnvio);

	}
	// Method click on element
	public void clickElement(By element) {
		driver.findElement(element).click();
	}

	// Thread sleep
	public void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Error en thread sleep");
		}
	}
}
