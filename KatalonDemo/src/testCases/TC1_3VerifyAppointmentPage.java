package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObject.AppointmentConfirmation;
import pageObject.AppointmentPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.HelpingMethod;
import utilities.InitialConfiguration;
import utilities.ScreenShot;

public class TC1_3VerifyAppointmentPage extends InitialConfiguration{

	//Create Object for all pages
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		AppointmentPage appPage=new AppointmentPage(driver);
		AppointmentConfirmation appCon=new AppointmentConfirmation(driver);
		HelpingMethod helpingMethod =new HelpingMethod();
		
		@Test(priority=0)
		public void verifyPageLabel() {
			
		  extent.startTest("TC01.3.1 Navigate to Appointment Page", "Appointment Page");
		
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
		
		@Test(priority=1)
		public void makeAppointmentWithoutDate() {
			
		  extent.startTest("TC01.3.2  Make Appointment Without Date", "Appointment Page");
		driver.findElement(appPage.bookAppointButtonLocator()).click();
			try {
				if(driver.findElement(appCon.confirmationPageLabelLocator()).isDisplayed()==false) {
					extent.log(LogStatus.PASS, "Try to Make appointment without date ",
							"View details below:",
							ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
				}else {
					extent.log(LogStatus.FAIL, "Try to Make appointment without date",
												"View details below:",
												ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
									}
				   
			}catch(Exception e) {
						extent.log(LogStatus.FAIL, "Try to Make appointment without date",
						"View details below:",
						ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
				}
			extent.endTest();
			}
		
		@Test(priority=2)
		public void makeAppointmentWithPastDate() {
			
			  extent.startTest("TC01.3.3  Make Appointment With Past Date", "Appointment Page");
			  helpingMethod.selectValueFromComboBox("Hongkong CURA Healthcare Center");
			  driver.findElement(appPage.VisitDateLocator()).sendKeys("12/12/2017");
			  driver.findElement(appPage.bookAppointButtonLocator()).click();
				try {
					if(driver.findElement(appCon.confirmationPageLabelLocator()).isDisplayed()==false) {
						extent.log(LogStatus.PASS, "Try to Make appointment without date ",
								"View details below:",
								ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
					}else {
						extent.log(LogStatus.FAIL, "Try to Make appointment without date",
													"View details below:",
													ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
										}
					   
				}catch(Exception e) {
							extent.log(LogStatus.FAIL, "Try to Make appointment with Past date",
							"View details below:",
							ScreenShot.captureScreen(driver, "Appointment Page "+timeStamp));
					}
				extent.endTest();
				}
			
			
		
}
