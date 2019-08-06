package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilidades.Generic;



public class HomePage {

	WebDriver driver;
	Generic util;
	WebDriverWait wait;
	JavascriptExecutor js;
	String color;

	// Locators
	By txtSearchTop = By.id("search_query_top");
	By lblPopularSection = By.xpath("//a[@class='homefeatured']");
	By imgItemBlouse = By.xpath("//a[@class='product-name'][@title = 'Blouse']");
	By txtQuantity = By.id("quantity_wanted");
	By sltSize = By.id("group_1");
	By aColor;
	By btnAddCart = By.id("add_to_cart");
	By btnGoCheck = By.xpath("//a[@title = 'Proceed to checkout']");	
	By btnGoCheck2 = By.xpath("//a[@title = 'Proceed to checkout']//span[text() = 'Proceed to checkout']");

	By btnGoAddress = By.xpath("//button[@name= 'processAddress']");
	By chkTerms = By.id("uniform-cgv");
	By btnGoShipping = By.xpath("//button[@name = 'processCarrier']");
	By btnPayByBank = By.xpath("//a[@title = 'Pay by bank wire']");
	By btnConfirmOrder = By.xpath("//span[text()='I confirm my order']");
	By btnBackOrders = By.xpath("//a[@title = 'Back to orders']");

	// WebElements
	WebElement weSearchTop;
	WebElement wePopularSection;
	WebElement weBlouse;
	WebElement weQuantity;
	Select seSize;
	WebElement weColor;
	WebElement weAddCart;
	WebElement weGoCheck;
	WebElement weGoCheck2;

	WebElement weGoAddress;
	WebElement weTerms;
	WebElement weGoShipping;
	WebElement wePayByBank;
	WebElement weConfirmOrder;
	WebElement weBackOrders;


	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new Generic(driver);
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
	}


	// Method to add an article to cart
	public void agregarArticulo(String quantity,String size, String color) {
		weBlouse = util.createWebElement(this.imgItemBlouse);
		weBlouse.click();
		weQuantity = util.createWebElement(this.txtQuantity);
		weQuantity.clear();
		weQuantity.sendKeys(quantity);
		seSize = new Select(driver.findElement(sltSize));
		seSize.selectByVisibleText(size);
		aColor = By.name(color);
		weColor = util.createWebElement(aColor);
		weColor.click();
		weAddCart = util.createWebElement(this.btnAddCart);
		weAddCart.click();
		weGoCheck = util.createWebElement(this.btnGoCheck);
		weGoCheck.click();
		weGoCheck2 = util.createWebElement(this.btnGoCheck2);
		weGoCheck2.click();
	}

	// Method to login to account
	public void completeOrder() {
		weGoAddress = util.createWebElement(this.btnGoAddress);
		weGoAddress.click();
		weTerms = util.createWebElement(this.chkTerms);
		weTerms.click();
		weGoShipping = util.createWebElement(this.btnGoShipping);
		weGoShipping.click();
		wePayByBank = util.createWebElement(this.btnPayByBank);
		wePayByBank.click();
		weConfirmOrder = util.createWebElement(this.btnConfirmOrder);
		weConfirmOrder.click();
		weBackOrders = util.createWebElement(this.btnBackOrders);
		weBackOrders.click();
	}


}
