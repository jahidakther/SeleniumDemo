package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.AppointmentPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.InitialConfiguration;
import utilities.ScreenShot;

public class TC1_3VerifyAppointmentPage extends InitialConfiguration{

	//Create Object for all pages
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		AppointmentPage appPage=new AppointmentPage(driver);
		
		
		//Test Cases
		@Test(priority=0)
		public void verifyPageLabel() {
			
			    driver.findElement(home.getBurgerMenuLocator()).click();
		        driver.findElement(home.getloginLocator()).click();
		        extent.startTest("TC01.3  Navigate to Appointment Page", "Appointment Page");
			       
		
			try {
				
				if(driver.findElement(appPage.appointmentPageLabelLocator()).isDisplayed()==true) {
					extent.log(LogStatus.PASS, "Navigate to Appointment Page successfully",
							"View details below:",
							ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
									}else {
										extent.log(LogStatus.FAIL, "Fail to Navigate Appointment Page",
												"View details below:",
												ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
									}
				
			   
			}catch(Exception e) {
						extent.log(LogStatus.FAIL, "Fail to Navigate Appointment Page",
						"View details below:",
						ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
		
			}
			extent.endTest();
			
		}
		
			
	
}
