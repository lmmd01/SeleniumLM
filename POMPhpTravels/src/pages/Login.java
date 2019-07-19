package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.Generic;

public class Login {

	WebDriver driver;
	Generic util;
	
	By btnMyAccount = By.xpath("//li[@id='li_myaccount']");
	By btnLogin = By.xpath("//li[@id='li_myaccount']//child::ul//child::li[1]//child::a");

	// Constructor
	public Login(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
	}
	
	
	public void ingresar() {
		System.out.println("Displayed: " + driver.findElement(btnMyAccount).isDisplayed());
		System.out.println("Enabled: " + driver.findElement(btnMyAccount).isDisplayed());
		//util.clickElement(botonMyAccount);
		//util.clickElement(botonLogin);
	}

}
