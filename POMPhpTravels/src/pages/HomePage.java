package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilidades.Generic;

public class HomePage {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;

	// Locators
	By tabHotels = By.xpath("//span[@class='hidden-xs'][contains(text(),'Hotels')]");
	By txtNameClick = By.xpath("//div[@id='s2id_location']//child::a//child::span");
	//By txtNameWrite = By.xpath("//div[@id='select2-drop']//following::input[@class='select2-input']");
	By txtNameWrite = By.xpath("//div[@id='select2-drop']//div//input");
	By txtNameResult = By.xpath("//ul[@class='select2-result-sub']//child::li[1]//div[@class='select2-result-label']");
	By txtCheckIn = By.xpath("//input[@name='checkin']");
	By txtCheckOut = By.xpath("//input[@name='checkout']");
	By txtPeople = By.xpath("//input[@id='htravellersInput']");
	By txtAdults = By.xpath("//input[@id='hadultInput']");
	By txtChilds = By.xpath("//input[@id='hchildInput']");
	By btnBuscar = By.xpath("//button[@type = 'submit'][@class = 'btn btn-lg btn-block btn-primary pfb0 loader']");
	By btnLogin = By.xpath("//li[@id='li_myaccount']//child::ul//child::li[1]//child::a");
	By lblAvailableSection = By.xpath("//div[@class = 'panel-heading go-text-right panel-default ttu'][text()='Available Rooms']");

	//WebElements
	WebElement weHotelClick;
	WebElement weHotelWrite;
	WebElement weCheckIn;
	WebElement weCheckOut;
	WebElement wePeople;
	WebElement weAdults;
	WebElement weChilds;
	WebElement weAvailableSection;
	
	
	
	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 20);
	}

	// Set hotel name
	public void setHotelName(String strHotel) {
		weHotelClick = util.createWebElement(this.txtNameClick);
		weHotelClick.click();
		weHotelWrite = util.createWebElement(this.txtNameWrite);
		weHotelWrite.sendKeys(strHotel);
	}

	// Set check in
	public void setCheckIn(String strCin) {
		weCheckIn = util.createWebElement(this.txtCheckIn);
		weCheckIn.sendKeys(strCin);
	}

	// Set check out
	public void setCheckOut(String strCou) {
		weCheckOut = util.createWebElement(this.txtCheckOut);
		weCheckOut.sendKeys(strCou);
	}

	// Set people
	public void setPeople(String nAdul, String nChild) {
		wePeople = util.createWebElement(this.txtPeople);
		wePeople.click();
		weAdults = util.createWebElement(this.txtAdults);
		weChilds = util.createWebElement(this.txtChilds);
		weAdults.clear();
		weAdults.sendKeys(nAdul);
		weChilds.clear();
		weChilds.sendKeys(nChild);
	}

	// Buscar Hotel
	public boolean buscarHotel(String hotel, String in, String out, String numAdults, String numChild) {
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

		// ----- Escribir URL en excel 
		System.out.println("La URL es: " + driver.getCurrentUrl());
		
		weAvailableSection = util.createWebElement(lblAvailableSection);
		
		// Actual - Expected
		 Assert.assertEquals(weAvailableSection.isDisplayed(), true);
		 
		return weAvailableSection.isDisplayed();
	}

}
