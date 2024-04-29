package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class HelperClass {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ConfigFileReader configFileReader;

	public HelperClass() {
	}

	@BeforeClass
	public void beforeClass() {
		//Driver
		driver = BrowserFactory.getDriver();
		//ExtentReport
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Simple Automation Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		//Config file
		configFileReader= new ConfigFileReader();
		//DBConnection
		//JDBConexion.dbConnection();
		
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL, test.addScreenCaptureFromPath(getScreenShot(driver, result.getName())) + "");
				test.log(Status.FAIL, result.getThrowable());
			} catch (IOException e) {
				System.out.println("\n" + e.getMessage());
			}

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST PASSED");
		} else {
			test.log(Status.SKIP, "TEST SKIPPED");
		}
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.quit();
	}

	public static String getScreenShot(WebDriver driver, String test) {
		String filepath = "";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			filepath = System.getProperty("user.dir") + "\\screenshots\\" + test + "-" + getDateTimeStamp() + ".png";
			FileUtils.copyFile(source, new File(filepath));
		} catch (WebDriverException e) {
			System.out.println("\nError from HelperClass");
			System.out.println("\n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("\nError from HelperClass");
			System.out.println("\n" + e.getMessage());
		}
		return filepath;
	}

	public static String getDateTimeStamp() {
		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		oDate = new Date();
		sDatePart = oDate.toString().split(" ");
		sDateStamp = sDatePart[2] + sDatePart[1] + sDatePart[5] + "-" + sDatePart[3];
		sDateStamp = sDateStamp.replace(":", "_");
		return sDateStamp;
	}

}
