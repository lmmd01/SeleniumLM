package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class HomePage {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;

	By pestana = By.xpath("//span[@class='hidden-xs'][text()='Hotels    ']");
	By hotelNameClick = By.xpath("//div[@id='s2id_autogen3']//child::a//child::span");
	By hotelNameWrite = By.name("hotel_s2_text");
	By hotelResult = By.xpath("//ul[@class='select2-result-sub']//child::li[1]//div[@class='select2-result-label']");
	By checkIn = By.xpath("//input[@name='checkin']");
	By checkOut = By.xpath("//input[@name='checkout']");
	By people = By.xpath("//input[@id='travellersInput']");
	By adultos = By.xpath("//input[@id='adultInput']");
	By ninos = By.xpath("//input[@id='adultInput']");
	By botonBuscar = By.xpath("//button[@type = 'submit'][@class = 'btn btn-lg btn-block btn-primary pfb0 loader']");
	//By botonBuscar = By.xpath("//form[@action='https://www.phptravels.net/hotels/search']");
	//By botonBuscar = By.name("fCustomHotelSearch");
	By loginButton = By.xpath("//li[@id='li_myaccount']//child::ul//child::li[1]//child::a");



	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
	}

	// Set hotel name 
	public void setHotelName(String strHotel) {
		driver.findElement(hotelNameWrite).sendKeys(strHotel);
	}

	// Set check in
	public void setCheckIn(String strCin) {
		driver.findElement(checkIn).sendKeys(strCin);
	}

	// Set check out
	public void setCheckOut(String strCou) {
		driver.findElement(checkOut).sendKeys(strCou);
	}

	// Set check out
	public void setPeople(String nAdul, String nChild) {
		util.clickElement(this.people);
		//driver.findElement(adultos).sendKeys("value", nAdul);
		//driver.findElement(ninos).sendKeys(nChild);
	}

	public void submitSearch() {

		driver.findElement(botonBuscar).submit();
	}




	// Method agregarCarrito
	public void buscarHotel(String hotel, String in, String out, String numAdults, String numChild) {
		// Click hotel name
		util.clickElement(this.hotelNameClick);
		// Fill hotel name
		this.setHotelName(hotel);
		// Click 1st result
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.hotelResult));
		util.clickElement(this.hotelResult);
		// Fill check in
		this.setCheckIn(in);
		// Fill check out
		this.setCheckOut(out);
		// Fill person
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.people));
		this.setPeople(numAdults,numChild);
		// Submmit button
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Error en thread sleep");
		}
		
		//util.clickElement(botonBuscar);
		boolean status = driver.findElement(botonBuscar).isDisplayed();
		System.out.println("El valor de isDisplayed is: " + status);
		status = driver.findElement(botonBuscar).isEnabled();
		System.out.println("El valor de isEnabled is: " + status);
		driver.findElement(botonBuscar).click();

	}


}
