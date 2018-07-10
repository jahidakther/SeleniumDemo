package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import pageObject.HomePage;
import utilities.InitialConfiguration;
import utilities.ScreenShot;


public class DemoTest extends InitialConfiguration{
	 	
		
	
	@Test
	public void verifyTitle() {
		HomePage home=new HomePage(driver);
		extent.startTest("TC01.1 Landed Home Page", "Home Page");
				String title=driver.getTitle();
	            String expectedTitle=home.getTitle();
	
		try {
			Assert.assertEquals(title,expectedTitle );
		    System.out.println("pass");
	
		    extent.log(LogStatus.PASS, "Home Page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Home Page "+timeStamp));
		}catch(Exception e) {
			System.out.println("Fail");
			System.out.println(e);
	
		}
		extent.endTest();
		
	}
	
	
	
	
	}

