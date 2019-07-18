package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class Save {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;
	JavascriptExecutor js;

	final String HOTEL_NO_DISPONIBLES = "";

	By pestana = By.xpath("//span[@class='hidden-xs'][text()='Hotels    ']");
	By hotelNameClick = By.xpath("//div[@id='s2id_autogen3']//child::a//child::span");
	By hotelNameWrite = By.name("hotel_s2_text");
	By hotelResult = By.xpath("//ul[@class='select2-result-sub']//child::li[1]//div[@class='select2-result-label']");
	By checkIn = By.xpath("//input[@name='checkin']");
	By checkOut = By.xpath("//input[@name='checkout']");
	By people = By.xpath("//input[@id='travellersInput']");
	By adultos = By.xpath("//input[@id='adultInput']");
	By ninos = By.xpath("//input[@id='childInput']");
	By botonBuscar = By.xpath("//button[@type = 'submit'][@class = 'btn btn-lg btn-block btn-primary pfb0 loader']");
	// By botonBuscar = By.name("fCustomHotelSearch");
	By loginButton = By.xpath("//li[@id='li_myaccount']//child::ul//child::li[1]//child::a");

	By availableSection = By.xpath("//div[@class = 'panel-heading go-text-right panel-default ttu'][text()='Available Rooms']");
	By hotelNotAvailable = By.xpath("//h4[@class = 'alert alert-info'][text()='No Results Found']");

	By amenities = By.xpath("//p[@class = 'main-title go-right'][text()='Privacy Policy']");
	By checkInformation = By.xpath("//p[@class = 'main-title  go-right'][text()='Check in']");

	By checkBox = By.xpath("//h4[@class = 'RTL go-text-right mt0 list_title ttu']//child::a//child::b[text()='Junior Suites']//following::input//following::div[@class='control__indicator']");
	By bookButton = By.xpath("//button[@type = 'submit'][contains(text(),'Book Now')]");
	By coupon = By.xpath("//input[@placeholder = 'Coupon Code']");
	By buttonCupon = By.xpath("//span[text() = 'Apply Coupon']");
	By exitoCupon = By.xpath("//div[@class = 'alert alert-success']");

	// Constructor
	public Save(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
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

	// Set coupon
	public boolean setCoupon(String strCupon) {

		boolean couponApplied = false;

		driver.findElement(coupon).clear();
		driver.findElement(coupon).sendKeys(strCupon);
		driver.findElement(buttonCupon).click();



		try {
			if(driver.findElement(exitoCupon).isDisplayed()) {
				couponApplied = true;
				System.out.println("Se ha aplicado el cupon");
			}

		} catch (NoSuchElementException ex) {
			System.out.println("No se encuentra un elemento");
		}

		return couponApplied;
	}

	// Set people
	public void setPeople(String nAdul, String nChild) {
		util.clickElement(this.people);
		driver.findElement(adultos).clear();
		driver.findElement(adultos).sendKeys(nAdul);
		driver.findElement(ninos).clear();
		driver.findElement(ninos).sendKeys(nChild);
	}

	public void submitSearch() {

		driver.findElement(botonBuscar).submit();
	}

	// Buscar Hotel
	public String buscarHotel(String hotel, String in, String out, String numAdults, String numChild) {
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
		this.setPeople(numAdults, numChild);
		// Submmit button
		driver.findElement(botonBuscar).click();
		// this.submitSearch();

		// return url
		System.out.println("La URL es: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();

	}

	// Verificar Disponibilidad
	public boolean verificarDisponibilidadHotel(String url) {

		boolean isAvailable = false;

		driver.get(url);

		try {
			// This will scroll down the page by 1000 pixel vertical
			js.executeScript("window.scrollBy(0,1000)");

			wait.until(ExpectedConditions.visibilityOfElementLocated(availableSection));

			driver.findElement(hotelNotAvailable).isDisplayed();

		} catch (NoSuchElementException ex) {
			System.out.println("No se encuentra un elemento");
			isAvailable = true;
		} finally {
			System.out.println("El valor de available is: " + isAvailable);
		}

		return isAvailable;

	}

	// Verificar Amenities
	public boolean verificarAmenities(String url) {

		boolean isAmenities = false;

		driver.get(url);

		try {

			if (driver.findElement(amenities).isDisplayed()) {
				isAmenities = true;
			}

		} catch (NoSuchElementException ex) {
			System.out.println("No hay amenities information");
		}

		return isAmenities;

	}

	// Verificar Amenities
	public boolean verificarChecking(String url) {

		boolean isChecking = false;

		driver.get(url);

		try {

			if (driver.findElement(checkInformation).isDisplayed()) {
				isChecking = true;
			}

		} catch (NoSuchElementException ex) {
			System.out.println("No hay checking information");
		}

		return isChecking;

	}

	// Reservar Hotel
	public void reservarHotel(String url, String roomType, String coupon) {

		driver.get(url);

		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(checkBox).click();

		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(bookButton).click();

		js.executeScript("window.scrollBy(0,1000)");

		Boolean cuponValido = this.setCoupon(coupon);
		
		if(!cuponValido) {
			System.out.println("El cupon no es valido");
		}




	}

}
