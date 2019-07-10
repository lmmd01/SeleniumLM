package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;

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

	// Method login
	public boolean loginToAmazon(String mail, String password) {
		
		// Click Ingresar
		this.clickElement(signIn);

		// Fill user name
		this.setUserName(mail);

		// Fill password
		this.setPassword(password);

		// Click Login button
		this.clickElement(submit);
		
		return sesion = buscarElemento("//A[@id='nav-item-signout']");
	}
	

	// Method buscarArticulo
	public void buscarArticulo(String item) {
		
		// Fill busqueda
		this.setBusqueda(item);

		// Click Login button
		this.clickElement(botonBuscar);

	}




}
