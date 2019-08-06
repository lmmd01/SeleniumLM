package img;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	WebDriver driver;

	// Constructor
	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public void takeSnapShot(String name) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot)driver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File("C:/Users/PCDUARTE01/Desktop/tests/" + name + ".png ");

		//Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
}
