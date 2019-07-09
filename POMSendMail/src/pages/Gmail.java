package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Gmail {

	WebDriver driver;
	
	String msgMail;

	By userGmail = By.xpath("//INPUT[@id='identifierId']");

	By passwordGmail = By.xpath("//INPUT[@type='password']");

	By loginNext = By.xpath("//SPAN[@class='RveJvd snByac'][text()='Siguiente']");
	
	By dashboard = By.xpath("//SPAN[@class='gb_xa gbii']");

	By signOut = By.xpath("//A[@id='gb_71']");
	
	//By subjectMensaje = By.xpath("//SPAN[@class='bog']/child::span[text()='" + msgMail + "']");
	
	By subjectMensaje = By.xpath("//SPAN[@class='bog']/child::span[text()='Hola']");


	public Gmail(WebDriver driver) {

		this.driver = driver;

	}

	// Set user name in textbox

	public void setUserName(String strUser) {

		driver.findElement(userGmail).sendKeys(strUser);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(passwordGmail).sendKeys(strPassword);

	}

	// Click on element

	public void clickElement(By element) {

		driver.findElement(element).click();

	}

	// Thread sleep

	public void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Error en thread sleep");
		}
	}


	public void loginToGmail(String strUserName, String strPasword) {

		// Open the webpage
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		// Fill user name

		this.setUserName(strUserName);

		// Click next button

		this.clickElement(loginNext);

		// Click wait time

		this.waitTime(2000);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickElement(loginNext);
		
		// Click wait time

		this.waitTime(2000);
		
	}
	
	public void buscarMensaje(String subject) {

		msgMail = subject;
		
		// Click dashboard
		this.clickElement(subjectMensaje); 


	}
	
	public void logout() {
		
		// Click wait time

		this.waitTime(2000);

		// Click dashboard
		this.clickElement(dashboard); 

		// Click sign out
		this.clickElement(signOut);

	}

}
