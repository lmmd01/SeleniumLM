package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityPom {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	JavascriptExecutor js;

	public UtilityPom(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	public void enterText(WebElement element, String text) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).perform();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}

	}

	public void clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).perform();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	public String getText(WebElement element) {
		String text = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).perform();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			text = element.getText();
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return text;

	}

	public boolean isDisplayed(WebElement element) {
		boolean result = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).perform();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			result = element.isDisplayed();
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return result;

	}

	public void selectValueFromDropByText(WebElement element, String text) {
		Select dropDown = null;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).perform();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			dropDown = new Select(element);
			dropDown.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}

	}

	public String getPageTitle() {
		String text = "";
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			text = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;

	}

}
