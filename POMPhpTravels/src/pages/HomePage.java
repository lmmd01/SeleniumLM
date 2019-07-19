package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;

public class HomePage {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;

	By tabHotels = By.xpath("//span[@class='hidden-xs'][contains(text(),'Hotels')]");
	By txtNameClick = By.xpath("//div[@id='s2id_autogen3']//child::a//child::span");
	By txtNameWrite = By.name("hotel_s2_text");
	By txtNameResult = By.xpath("//ul[@class='select2-result-sub']//child::li[1]//div[@class='select2-result-label']");
	By txtCheckIn = By.xpath("//input[@name='checkin']");
	By txtCheckOut = By.xpath("//input[@name='checkout']");
	By txtPeople = By.xpath("//input[@id='travellersInput']");
	By txtAdults = By.xpath("//input[@id='adultInput']");
	By txtChilds = By.xpath("//input[@id='childInput']");
	By btnBuscar = By.xpath("//button[@type = 'submit'][@class = 'btn btn-lg btn-block btn-primary pfb0 loader']");
	// By botonBuscar = By.name("fCustomHotelSearch");
	By btnLogin = By.xpath("//li[@id='li_myaccount']//child::ul//child::li[1]//child::a");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
	}

	// Set hotel name
	public void setHotelName(String strHotel) {
		WebElement weHotelClick = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtNameClick));
		WebElement weHotelWrite = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtNameWrite));
		weHotelClick.click();
		weHotelWrite.sendKeys(strHotel);
	}

	// Set check in
	public void setCheckIn(String strCin) {
		WebElement weCheckIn = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtCheckIn));
		weCheckIn.sendKeys(strCin);
	}

	// Set check out
	public void setCheckOut(String strCou) {
		WebElement weCheckOut = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtCheckOut));
		weCheckOut.sendKeys(strCou);
	}

	// Set people
	public void setPeople(String nAdul, String nChild) {
		WebElement wePeople = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtPeople));
		wePeople.click();
		WebElement weAdults = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtAdults));
		WebElement weChilds = wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtChilds));
		weAdults.clear();
		weAdults.sendKeys(nAdul);
		weChilds.clear();
		weChilds.sendKeys(nChild);
	}

	// Buscar Hotel
	public String buscarHotel(String hotel, String in, String out, String numAdults, String numChild) {
		// Fill hotel name
		this.setHotelName(hotel);
		// Click 1st result
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtNameResult));
		util.clickElement(this.txtNameResult);
		// Fill check in
		this.setCheckIn(in);
		// Fill check out
		this.setCheckOut(out);
		// Fill person
		wait.until(ExpectedConditions.visibilityOfElementLocated(this.txtPeople));
		this.setPeople(numAdults, numChild);
		// Submmit button
		util.clickElement(btnBuscar);

		// return url
		System.out.println("La URL es: " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}

}
