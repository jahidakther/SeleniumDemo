package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.HomePage;
import utilities.InitialConfiguration;
import utilities.ScreenShot;

public class TC1_1VerifyHomePage extends InitialConfiguration{
	HomePage home=new HomePage(driver);
	@Test(priority=0)
	public void verifyTitle() {
		
		extent.startTest("TC01.1.1 Successfully Landed Home Page", "Home Page");
				String title=driver.getTitle();
	            String expectedTitle=home.getTitle();
	
		try {
			Assert.assertEquals(title,expectedTitle );
		    extent.log(LogStatus.PASS, "Home Page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Home Page "+timeStamp));
		}catch(Exception e) {
			extent.log(LogStatus.FAIL, "Home Page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Home Page "+timeStamp));
	
		}
		extent.endTest();
		
	}
	

}
