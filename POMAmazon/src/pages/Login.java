package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;

	By signIn = By.xpath("//SPAN[@class='nav-line-1'][text()='Hola, Identifícate']");
	By userMail = By.id("ap_email");
	By passwordMail = By.id("ap_password");
	By submit = By.id("signInSubmit");
	By barraBusqueda = By.id("twotabsearchtextbox");
	By botonBuscar = By.xpath("(//INPUT[@type='submit'])[1]");

	// Constructor
	public Login(WebDriver driver) {
		this.driver = driver;
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


	// Method login
	public void loginToAmazon(String mail, String password) {
		// Click Ingresar
		this.clickElement(signIn);

		// Fill user name
		this.setUserName(mail);

		// Fill password
		this.setPassword(password);

		// Click Login button
		this.clickElement(submit);
	}

	// Method buscarArticulo
	public void buscarArticulo(String item) {

		// Fill busqueda
		this.setBusqueda(item);

		// Click Login button
		this.clickElement(botonBuscar);

		// Wait time
		//this.waitTime(2000);

	}




}
