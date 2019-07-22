package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class Login {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;
	
	By btnMyAccount = By.xpath("//nav[@class = 'navbar navbar-default']//following::li[@id = 'li_myaccount']");
	By btnLogin = By.xpath("//nav[@class = 'navbar navbar-default']//following::a[text()=' Login']");
	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLoginSubmit = By.xpath("//button[text() = 'Login']");

	// Constructor
	public Login(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
	}
	
	
	public void ingresar(String strMail, String strPass) {
		//System.out.println("Displayed: " + driver.findElement(btnMyAccount).isDisplayed());
		//System.out.println("Enabled: " + driver.findElement(btnMyAccount).isDisplayed());
		util.clickElement(btnMyAccount);
		util.clickElement(btnLogin);
		
		WebElement weMyAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnMyAccount));
		weMyAccount.click();
		WebElement weLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnLogin));
		weLogin.click();
		WebElement weUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtUsername));
		weUsername.clear();
		weUsername.sendKeys(strMail);
		WebElement wePass = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtPassword));
		wePass.clear();
		wePass.sendKeys(strPass);
		WebElement weLoginSub = wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnLoginSubmit));
		weLoginSub.click();
		
		
		
	}

}
