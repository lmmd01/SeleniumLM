package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SauceLabsPage extends UtilityPom {

	public SauceLabsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "user-name")
	WebElement txtUsername;

	@FindBy(how = How.ID, using = "password")
	WebElement txtPassword;

	@FindBy(how = How.ID, using = "login-button")
	WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
	WebElement shoppingCart;

	@FindBy(how = How.ID, using = "checkout")
	WebElement btnCheckout;

	@FindBy(how = How.ID, using = "first-name")
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "last-name")
	WebElement txtLastName;

	@FindBy(how = How.ID, using = "postal-code")
	WebElement txtZipCode;

	@FindBy(how = How.ID, using = "continue")
	WebElement btnContinue;

	@FindBy(how = How.ID, using = "finish")
	WebElement btnFinish;

	@FindBy(how = How.XPATH, using = "//*[text()='Thank you for your order!']")
	WebElement msgConfirmation;

	List<WebElement> productsNumber;

	public void enterUsername(String user) {
		enterText(txtUsername, user);
	}

	public void enterPassword(String pass) {
		enterText(txtPassword, pass);
	}

	public void clickLogin() {
		clickElement(btnLogin);
	}

	public int getItems() {
		productsNumber = driver.findElements(By.xpath("//div[@data-test ='inventory-item-name']"));
		return productsNumber.size();
	}

	public void addProductName(String name) {

		for (WebElement element : productsNumber) {
			String tempStr = "";
			tempStr = element.getText();

			if (tempStr.equalsIgnoreCase(name)) {
				WebElement addProduct = driver.findElement(By.xpath(
						"(//div[@data-test ='inventory-item-name'][text()='" + tempStr + "']//following::button)[1]"));
				clickElement(addProduct);
			}
		}
	}

	public String makeCheckout() {
		String result = "";

		clickElement(shoppingCart);
		clickElement(btnCheckout);
		enterText(txtFirstName, "Test First");
		enterText(txtLastName, "Test Last");
		enterText(txtZipCode, "12345");
		clickElement(btnContinue);
		clickElement(btnFinish);

		result = getText(msgConfirmation);

		return result;

	}
}
