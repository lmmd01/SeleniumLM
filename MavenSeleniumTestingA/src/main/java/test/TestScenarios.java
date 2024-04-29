package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pom.GooglePage;
import pom.SauceLabsPage;
import utilities.HelperClass;

public class TestScenarios extends HelperClass {

	GooglePage googlePage;
	SauceLabsPage sauceLabsPage;

	public TestScenarios() {

	}

	@BeforeClass
	public void initPoms() {
		googlePage = PageFactory.initElements(driver, GooglePage.class);
		sauceLabsPage = PageFactory.initElements(driver, SauceLabsPage.class);
	}

	@Test(priority = 1, enabled = false)
	public void navigateToGoogle() {
		test = extent.createTest("Testing Google page", "Author: LMMD");
		test.log(Status.INFO, "Validate title of the page");
		driver.get("https://www.google.com/");
		Assert.assertEquals(googlePage.getPageTitle(), "Google");
	}

	@Test(priority = 2, enabled = true)
	public void testingSauceLabs() {
		test = extent.createTest("Testing Sauce Labs page", "");
		driver.get("https://www.saucedemo.com/");
		test.log(Status.INFO, "Login with standar user");
		sauceLabsPage.enterUsername(configFileReader.getStandarUser());
		sauceLabsPage.enterPassword(configFileReader.getStandarPassword());
		sauceLabsPage.clickLogin();
		test.log(Status.INFO, "Verifiyng there are some products");
		if(sauceLabsPage.getItems() > 0) {
			test.log(Status.INFO, "Adding a product to the cart");
			sauceLabsPage.addProductName("Sauce Labs Bike Light");	
			test.log(Status.INFO, "Cart Checkout");
			String result = sauceLabsPage.makeCheckout();
			Assert.assertEquals(result, "Thank you for your order!");
		} else {
			test.log(Status.INFO, "There are not products");
		}
		
	}

}