package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class LoginPage {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;

	// Locators 
	By lblEmail = By.id("email");
	By lblPass = By.id("passwd");
	By btnSubmit = By.id("SubmitLogin");


	// WebElements from shopping
	WebElement weEmail;
	WebElement wePass; 
	WebElement weSubmit;


	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
	}

	// Method to login to account
	public void ingresar(String mail,String pass) {
		weEmail = util.createWebElement(this.lblEmail);
		weEmail.sendKeys(mail);
		wePass = util.createWebElement(this.lblPass);
		wePass.sendKeys(pass);
		weSubmit = util.createWebElement(this.btnSubmit);
		weSubmit.click();
	}
	
	// Method to log out from account
	public void salir(String mail,String pass) {
	 // in progress.....
	}

}