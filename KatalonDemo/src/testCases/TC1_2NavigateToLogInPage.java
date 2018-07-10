package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.relevantcodes.extentreports.LogStatus;
import pageObject.AppointmentPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.InitialConfiguration;
import utilities.ScreenShot;

public class TC1_2NavigateToLogInPage extends InitialConfiguration{
	
	//Create Object for all pages
	LoginPage login=new LoginPage(driver);
	HomePage home=new HomePage(driver);
	AppointmentPage appPage=new AppointmentPage(driver);
	
	
	//Test Cases
	@Test(priority=0)
	public void verifyPageLabel() {
	
		extent.startTest("TC01.2  Navigate to Login Page", "Login  Page");
		        driver.findElement(home.getBurgerMenuLocator()).click();
		        driver.findElement(home.getloginLocator()).click();
				String pageLabel=driver.findElement(login.getPageLabelLocator()).getText();
	            String expectedLabel=login.actualPageLabel();
	
		try {
			Assert.assertEquals(pageLabel,expectedLabel );
		    System.out.println("pass");
	
		    extent.log(LogStatus.PASS, "Navigate to Login Page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Login Page "+timeStamp));
		}catch(Exception e) {
			System.out.println("Fail");
			System.out.println(e);
			extent.log(LogStatus.FAIL, "Fail to Navigate Login Page",
					"View details below:",
					ScreenShot.captureScreen(driver, "Login Page "+timeStamp));
	
		}
		extent.endTest();
		
	}
	
	@Test(priority=1)
	public void verifyvalidLogInToApplicationPositive() {
	
		extent.startTest("TC01.3  verify valid LogIn T oApplication (Positive)", "Login With Valid credential");
		driver.findElement(login.userWebTextLocator()).sendKeys(login.getUserId());
		driver.findElement(login.passwordWebTextLocator()).sendKeys(login.getPassword());
		driver.findElement(login.loginButtonLocator()).click();		
		String pageLabel=driver.findElement(appPage.appointmentPageLabelLocator()).getText();
        String expectedLabel=appPage.actualAppointPageLabel();

		
		try {
			Assert.assertEquals(pageLabel,expectedLabel);
		    System.out.println("pass");
	
		    extent.log(LogStatus.PASS, "verify valid LogIn into Application (Positive)\"",
					"View details below:",
					ScreenShot.captureScreen(driver, "valid login "+timeStamp));
		}catch(Exception e) {
			System.out.println("Fail");
			System.out.println(e);
			extent.log(LogStatus.FAIL, "Fail to login",
					"View details below:",
					ScreenShot.captureScreen(driver, "Login Page "+timeStamp));
	
		}
		extent.endTest();
		
		//For Logout
		driver.findElement(home.getBurgerMenuLocator()).click();
		driver.findElement(appPage.logoffLocator()).click();
		
	}
	
	
	@Test(priority=2)
	public void verifyInvalidLogInToApplicationNegetive() {
	
		extent.startTest("TC01.3  verify valid LogIn T oApplication (Negetive)", "Login With InValid credential");
	    driver.findElement(home.getBurgerMenuLocator()).click();
	    driver.findElement(home.getloginLocator()).click();
		driver.findElement(login.userWebTextLocator()).sendKeys(login.getUserId());
		driver.findElement(login.passwordWebTextLocator()).sendKeys("");
		driver.findElement(login.loginButtonLocator()).click();		
		String errorMsg=driver.findElement(login.errorMsgLocator()).getText();
        

		
		try {
			
			if(errorMsg.isEmpty()==false) {
				 extent.log(LogStatus.PASS, "verify valid LogIn into Application (Positive)\"",
							"View details below:",
							ScreenShot.captureScreen(driver, "valid login "+timeStamp));
				
			}
	
		   
		}catch(Exception e) {
			
			extent.log(LogStatus.FAIL, "Login with Invalid Credential",
					"View details below:",
					ScreenShot.captureScreen(driver, "Login Page "+timeStamp));
	
		}
		extent.endTest();
		
		
		
	}


}
