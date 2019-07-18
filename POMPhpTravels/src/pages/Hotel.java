package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class Hotel {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;
	JavascriptExecutor js;

	By availableSection = By.xpath("//div[@class = 'panel-heading go-text-right panel-default ttu'][text()='Available Rooms']");
	By hotelNotAvailable = By.xpath("//h4[@class = 'alert alert-info'][text()='No Results Found']");

	By amenities = By.xpath("//p[@class = 'main-title go-right'][text()='Privacy Policy']");
	By checkInformation = By.xpath("//p[@class = 'main-title  go-right'][text()='Check in']");

	By checkBox = By.xpath("//h4[@class = 'RTL go-text-right mt0 list_title ttu']//child::a//child::b[text()='Junior Suites']//following::input//following::div[@class='control__indicator']");
	By bookButton = By.xpath("//button[@type = 'submit'][contains(text(),'Book Now')]");
	By coupon = By.xpath("//input[@placeholder = 'Coupon Code']");
	By buttonCupon = By.xpath("//span[text() = 'Apply Coupon']");
	By exitoCupon = By.xpath("//div[@class = 'alert alert-success']");
	By panelPersonalInfo = By.xpath("//div[@class = 'panel-heading'][text() = 'Personal Details']");
	By nameR = By.name("firstname");
	By lastname = By.name("lastname");
	By email = By.name("email");
	By emailConfirm = By.name("confirmemail");
	By buttonConfirmBooking = By.xpath("//button[@type = 'submit'][contains(text(),'CONFIRM THIS BOOKING')]");
	
	

	// Constructor
	public Hotel(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
	}

	// Set coupon
	public void setCoupon(String strCupon) {
		driver.findElement(coupon).clear();
		driver.findElement(coupon).sendKeys(strCupon);
		driver.findElement(buttonCupon).click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(exitoCupon));
			if(driver.findElement(exitoCupon).isDisplayed()) {
				System.out.println("Se ha aplicado el cupon");
			}
		} catch (NoSuchElementException ex) {
			System.out.println("No se ha aplicado el cupon");
		}

	}
	
	// Set name
		public void setNameR(String strNameR) {
			util.clickElement(this.nameR);
			driver.findElement(nameR).sendKeys(strNameR);
		}

		// Set lastname
		public void setLastname(String strLastname) {
			driver.findElement(lastname).sendKeys(strLastname);
		}

		// Set email
		public void setEmail(String strEmail) {
			driver.findElement(email).sendKeys(strEmail);
			driver.findElement(emailConfirm).sendKeys(strEmail);
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
			isAvailable = true;
		} finally {
			System.out.println("Hotel disponible ?: " + isAvailable);
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

	// Verificar Checking
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
	public void reservarHotel(String url, String coupon, String name, String lastname, String email) {
		

		driver.get(url);

		// This will scroll down the page by 1000 pixel vertical
		js.executeScript("window.scrollBy(0,1000)");

		util.clickElement(checkBox);

		js.executeScript("window.scrollBy(0,1000)");
		
		util.clickElement(bookButton);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(panelPersonalInfo));

		this.setNameR(name);
		
		this.setLastname(lastname);
		
		this.setEmail(email);
		
		
		js.executeScript("window.scrollBy(0,1000)");
		
		if(coupon != "") {
			this.setCoupon(coupon);
		}

		util.clickElement(buttonConfirmBooking);

	}

}
