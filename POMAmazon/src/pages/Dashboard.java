package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.Generic;

public class Dashboard {

	WebDriver driver;
	Generic util;

	By articulo = By.xpath("//IMG[@data-image-index='3']");
	By agregarCarrito = By.xpath("//INPUT[@id='add-to-cart-button']");
	By botonCarrito = By.id("a-autoid-0-announce");
	By botonCheckout = By.xpath("//INPUT[@name='proceedToCheckout']");
	By botonDireccion = By.xpath("//SPAN[@class='a-button-inner']/child::a[contains(text(),'Entregar a esta dire')]");
	By botonContinuarEnvio = By.xpath("//INPUT[@value='Continuar']");

	// Constructor
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
	}

	// Method agregarCarrito
	public void agregarCarrito() {

		// Click articulo 0
		util.clickElement(this.articulo);

		// Click agregar al carrito
		util.clickElement(this.agregarCarrito);

		// Click boton del carrito
		util.clickElement(this.botonCarrito);

	}

	// Method checkout
	public void checkout() {

		// Click boton checkout
		util.clickElement(this.botonCheckout);

		// Click boton de direccion
		util.clickElement(botonDireccion);

		// Click continuar envio
		util.clickElement(botonContinuarEnvio);

	}


}
