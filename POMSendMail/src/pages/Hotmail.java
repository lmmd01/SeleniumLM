package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hotmail {

	WebDriver driver;

	By userHotmail = By.id("i0116");

	By passwordHotmail = By.id("i0118");

	By signIn = By.xpath("//a[@class='linkButtonSigninHeader']");

	By loginNext = By.id("idSIButton9");

	By dashboard = By.xpath("//div[@class='ms-Persona-initials initials-100']");

	By signOut = By.xpath("//DIV[@class='ms-Button-label label-46'][text()='Sign out']");

	By newMessage = By.id("id__5");

	By destinatario = By.xpath("//input[@class='ms-BasePicker-input pickerInput_55459320']");

	By subject = By.id("subjectLine0");

	By message = By.xpath("//div[@class='_4utP_vaqQ3UQZH0GEBVQe B1QSRkzQCtvCtutReyNZ _17ghdPL1NLKYjRvmoJgpoK _2s9KmFMlfdGElivl0o-GZb']");

	By send = By.id("id__972");



	// Constructor

	public Hotmail(WebDriver driver) {

		this.driver = driver;

	}

	// Set user name in textbox

	public void setUserName(String strUser) {

		driver.findElement(userHotmail).sendKeys(strUser);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(passwordHotmail).sendKeys(strPassword);

	}

	// Set destinatario in textbox

	public void setDestinatario(String strDest) {

		driver.findElement(destinatario).sendKeys(strDest);

	}

	// Set subject in textbox

	public void setSubject(String strSubj) {

		driver.findElement(subject).sendKeys(strSubj);

	}

	// Set body message in textbox

	public void setMessage(String strMessage) {

		driver.findElement(message).sendKeys(strMessage);

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


	public void loginToHotmail(String strUserName, String strPasword) {

		// Open the webpage
		driver.get("https://outlook.live.com/owa/");

		// Click Sign in button

		this.clickElement(signIn);

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

	}

	public void sendMail (String strDest, String strSubj, String strMessage) {

		// Click new message
		this.clickElement(newMessage); 

		// Click wait time

		this.waitTime(3000);

		// Fill destinatario
		this.setDestinatario(strDest);

		// Fill subject
		this.setSubject(strSubj);

		// Fill message body
		this.setMessage(strMessage);

		// Click send
		this.clickElement(send);

	}

	public void logout() {

		// Click dashboard
		this.clickElement(dashboard); 

		// Click wait time

		this.waitTime(2000);

		// Click sign out
		this.clickElement(signOut);

	}


}
