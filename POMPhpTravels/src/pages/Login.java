package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class Login {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;
	
	// Locators
	By btnMyAccount = By.xpath("//nav[@class = 'navbar navbar-default']//following::li[@id = 'li_myaccount']");
	By btnLogin = By.xpath("//nav[@class = 'navbar navbar-default']//following::a[text()=' Login']");
	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLoginSubmit = By.xpath("//button[text() = 'Login']");
	
	// WebElements
	WebElement weMyAccount;
	WebElement weLogin;
	WebElement weUsername;
	WebElement wePass;
	WebElement weLoginSub;
	

	// Constructor
	public Login(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
	}
	
	
	public void ingresar(String strMail, String strPass) {
		util.clickElement(btnMyAccount);
		util.clickElement(btnLogin);
		
		weMyAccount = util.createWebElement(this.btnMyAccount);
		weMyAccount.click();
		weLogin = util.createWebElement(this.btnLogin);
		weLogin.click();
		weUsername = util.createWebElement(this.txtUsername);
		weUsername.clear();
		weUsername.sendKeys(strMail);
		wePass = util.createWebElement(this.txtPassword);
		wePass.clear();
		wePass.sendKeys(strPass);
		weLoginSub = util.createWebElement(this.btnLoginSubmit);
		weLoginSub.click();
		
		
		
	}

}
