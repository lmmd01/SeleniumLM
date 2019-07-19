package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class Hotel {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;
	JavascriptExecutor js;

	By lblAvailableSection = By.xpath("//div[@class = 'panel-heading go-text-right panel-default ttu'][text()='Available Rooms']");
	By lblHotelNotAvailable = By.xpath("//h4[@class = 'alert alert-info'][text()='No Results Found']");

	By lblAmenities = By.xpath("//p[@class = 'main-title go-right'][text()='Privacy Policy']");
	By lblCheckingInfo = By.xpath("//p[@class = 'main-title  go-right'][text()='Check in']");

	By chkBoxReservarHotel = By.xpath("//h4[@class = 'RTL go-text-right mt0 list_title ttu']//child::a//child::b[text()='Junior Suites']//following::input//following::div[@class='control__indicator']");
	By btnBookNow = By.xpath("//button[@type = 'submit'][contains(text(),'Book Now')]");
	By txtCoupon = By.xpath("//input[@placeholder = 'Coupon Code']");
	By btnCoupon = By.xpath("//span[text() = 'Apply Coupon']");
	By lblValidCoupon = By.xpath("//div[@class = 'alert alert-success']");
	By lblPersonalInfo = By.xpath("//div[@class = 'panel-heading'][text() = 'Personal Details']");
	By txtNameBooking = By.name("firstname");
	By txtLastnameBooking = By.name("lastname");
	By txtEmailBooking = By.name("email");
	By txtEmailConfirmBooking = By.name("confirmemail");
	By btnConfirmBooking = By.xpath("//button[@type = 'submit'][contains(text(),'CONFIRM THIS BOOKING')]");
	
	

	// Constructor
	public Hotel(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
	}

	// Set coupon
	public void setCoupon(String strCupon) {
		WebElement wetCoupon = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtCoupon));
		WebElement webCoupon = wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnCoupon));

		wetCoupon.clear();
		wetCoupon.sendKeys(strCupon);
		webCoupon.click();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(lblValidCoupon));
			if(driver.findElement(lblValidCoupon).isDisplayed()) {
				System.out.println("Se ha aplicado el cupon");
			}
		} catch (NoSuchElementException ex) {
			System.out.println("No se ha aplicado el cupon");
		}

	}
	
	// Set name
		public void setNameR(String strNameR) {
			WebElement weNameBooking = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtNameBooking));
			weNameBooking.click();
			weNameBooking.sendKeys(strNameR);
		}

		// Set lastname
		public void setLastname(String strLastname) {
			WebElement weLastnameBooking = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtLastnameBooking));
			weLastnameBooking.sendKeys(strLastname);
		}

		// Set email
		public void setEmail(String strEmail) {
			WebElement weMailBooking = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtEmailBooking));
			WebElement weConfirmMailBooking = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtEmailConfirmBooking));
			weMailBooking.sendKeys(strEmail);
			weConfirmMailBooking.sendKeys(strEmail);
		}


	// Verificar Disponibilidad
	public boolean verificarDisponibilidadHotel(String url) {
		boolean isAvailable = false;

		driver.get(url);

		try {
			
			WebElement weAvailableSection = wait.until(ExpectedConditions.visibilityOfElementLocated(this.lblAvailableSection));
			
			//This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", weAvailableSection);
	        
	        WebElement weHotelNotAvailable = wait.until(ExpectedConditions.visibilityOfElementLocated(this.lblHotelNotAvailable));

	        weHotelNotAvailable.isDisplayed();

		} catch (NoSuchElementException | TimeoutException ex) {
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
			WebElement weAmenities = wait.until(ExpectedConditions.visibilityOfElementLocated(this.lblAmenities));
			
			if (weAmenities.isDisplayed()) {
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
			WebElement weCheckingInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(this.lblCheckingInfo));
			
			if (weCheckingInfo.isDisplayed()) {
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

		WebElement weReservarHotel = wait.until(ExpectedConditions.visibilityOfElementLocated(this.chkBoxReservarHotel));
		
		//This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", weReservarHotel);
        
        weReservarHotel.click();
        
        WebElement weBookNow = wait.until(ExpectedConditions.visibilityOfElementLocated(this.btnBookNow));
			
        js.executeScript("arguments[0].scrollIntoView();", weBookNow);
		
        weBookNow.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(lblPersonalInfo));

		this.setNameR(name);
		
		this.setLastname(lastname);
		
		this.setEmail(email);
		
		WebElement weCupon = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtCoupon));
		
		js.executeScript("arguments[0].scrollIntoView();", weCupon);
		
		if(coupon != "") {
			this.setCoupon(coupon);
		}

		util.clickElement(btnConfirmBooking);

	}

}
