package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.Generic;

public class Login {

	WebDriver driver;
	Generic util;

	By signIn = By.xpath("//A[@id='nav-link-accountList']//child::span[text()='Hola, Identifícate']");
	By userMail = By.id("ap_email");
	By passwordMail = By.id("ap_password");
	By submit = By.id("signInSubmit");
	By barraBusqueda = By.id("twotabsearchtextbox");
	By botonBuscar = By.xpath("(//INPUT[@type='submit'])[1]");
	
	boolean good,sesion,encontrado = false;
	

	// Constructor
	public Login(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
	}
	
	// Set user name 
	public void setUserName(String strUser) {
		driver.findElement(userMail).sendKeys(strUser);
	}

	// Set password 
	public void setPassword(String strPassword) {
		driver.findElement(passwordMail).sendKeys(strPassword);
	}

	// Set articulo a buscar
	public void setBusqueda(String strBusqueda) {
		driver.findElement(barraBusqueda).sendKeys(strBusqueda);
	}

	// Method login
	public boolean loginToAmazon(String mail, String password) {
		
		// Click Ingresar
		//this.clickElement(signIn);
		util.clickElement(signIn);
		
		// Fill user name
		this.setUserName(mail);

		// Fill password
		this.setPassword(password);

		// Click Login button
		util.clickElement(submit);
		
		return sesion = util.buscarElemento("//A[@id='nav-item-signout']");
	}
	

	// Method buscarArticulo
	public void buscarArticulo(String item) {
		
		// Fill busqueda
		this.setBusqueda(item);

		// Click Login button
		util.clickElement(botonBuscar);

	}




}
