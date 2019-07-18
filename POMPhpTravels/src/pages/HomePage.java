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

	By pestana = By.xpath("//span[@class='hidden-xs'][contains(text(),'Hotels')]");
	By nameClick = By.xpath("//div[@id='s2id_autogen3']//child::a//child::span");
	By nameWrite = By.name("hotel_s2_text");
	By nameResult = By.xpath("//ul[@class='select2-result-sub']//child::li[1]//div[@class='select2-result-label']");
	By checkIn = By.xpath("//input[@name='checkin']");
	By checkOut = By.xpath("//input[@name='checkout']");
	By people = By.xpath("//input[@id='travellersInput']");
	By adultos = By.xpath("//input[@id='adultInput']");
	By ninos = By.xpath("//input[@id='childInput']");
	By botonBuscar = By.xpath("//button[@type = 'submit'][@class = 'btn btn-lg btn-block btn-primary pfb0 loader']");
	// By botonBuscar = By.name("fCustomHotelSearch");
	By botonLogin = By.xpath("//li[@id='li_myaccount']//child::ul//child::li[1]//child::a");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
	}

	// Set hotel name
	public void setHotelName(String strHotel) {
		util.clickElement(this.nameClick);
		driver.findElement(nameWrite).sendKeys(strHotel);
	}

	// Set check in
	public void setCheckIn(String strCin) {
		driver.findElement(checkIn).sendKeys(strCin);
	}

	// Set check out
	public void setCheckOut(String strCou) {
		driver.findElement(checkOut).sendKeys(strCou);
	}

	// Set people
	public void setPeople(String nAdul, String nChild) {
		util.clickElement(this.people);
		driver.findElement(adultos).clear();
		driver.findElement(adultos).sendKeys(nAdul);
		driver.findElement(ninos).clear();
		driver.findElement(ninos).sendKeys(nChild);
	}

	// Submit buttn busqueda
	public void submitSearch() {
		driver.findElement(botonBuscar).submit();
	}

	// Buscar Hotel
	public String buscarHotel(String hotel, String in, String out, String numAdults, String numChild) {
		// Fill hotel name
		this.setHotelName(hotel);
		// Click 1st result
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.nameResult));
		util.clickElement(this.nameResult);
		// Fill check in
		this.setCheckIn(in);
		// Fill check out
		this.setCheckOut(out);
		// Fill person
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.people));
		this.setPeople(numAdults, numChild);
		// Submmit button
		util.clickElement(botonBuscar);

		// return url
		System.out.println("La URL es: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

}
