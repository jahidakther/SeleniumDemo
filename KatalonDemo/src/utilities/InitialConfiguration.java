package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;

import pageObject.HomePage;



public class InitialConfiguration {
	public static  WebDriver driver = null;
	public static final ExtentReports extent = ExtentReports.get(InitialConfiguration.class);
	public static String timeStamp=new SimpleDateFormat("mmddyyyy").format(Calendar.getInstance().getTime());
	public static final String reportLocation = "C:\\Users\\tuba\\Desktop\\DemoJavaSelenium\\KatalonDemo\\report\\";
	public static String imageLocation = "images/";
	HomePage home=new HomePage(driver);
	
	
	public void startReport(){
		extent.init(reportLocation + "ExtentReport.html", true,
				DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);
		extent.config().documentTitle("Test report in Browser");
		extent.config()
				.reportTitle(
						"<h1><font color='#000099'>Automation Test Result in browser</font></h1> <h4>1.Verify LogIn Screen(Positive,Negetive)</h4><h4>\n2.Member Account(Positive,Negetive).</h4><h4>\n2.Individual Provider Account(Positive,Negetive).</h4>");
		extent.config()
				.reportHeadline(
						"<b>Selenium Automation Test Report.Develop By:JAHED AKTHER</b>");
	}
	
	
  
    @Parameters(value="browser")
	@BeforeTest
	public void openBrowser(String browserName )  {
	    
	   
	   if(browserName.equalsIgnoreCase("firefox")){
		   System.setProperty("webdriver.gecko.driver", "C:\\Users\\tuba\\Desktop\\DemoJavaSelenium\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\tuba\\Desktop\\DemoJavaSelenium\\IEDriver\\IEDriverServer.exe");
			// DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
		      //  ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		        driver = new InternetExplorerDriver();
			
		}else if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tuba\\Desktop\\DemoJavaSelenium\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	 			
		//driver=new FirefoxDriver();
	   extent.init(reportLocation + "Selenium.html", true,
				DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);
		extent.config().documentTitle("Test report in "+browserName+" Browser");
		extent.config()
				.reportTitle(
						"<h1><font color='#000099'>Automation Test Result in  browser</font></h1> <h4>1.Verify LogIn Screen(Positive,Negetive)</h4><h4>\n2.Member Account(Positive,Negetive).</h4><h4>\n2.Individual Provider Account(Positive,Negetive).</h4>");
		extent.config()
				.reportHeadline(
						"<b>Selenium Automation Test Report.Develop By:JAHED AKTHER</b>");
	//	extent.startTest("TC01.1", "Open The "+ browserName+" Browser");
		
		extent.startTest("TC01.1", "Open The Browser");
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to(home.getURL());
		driver.manage().window().maximize();
		extent.log(LogStatus.PASS, "Opening  Application",
				"View details below:",
				ScreenShot.captureScreen(driver, "Open Aplication "+timeStamp));
		extent.endTest();
		
	}

    
    
    
	@AfterSuite
	public void tearDown() {
		WebDriver driver1=new FirefoxDriver();
		driver1.get("C:\\Users\\tuba\\Desktop\\DemoJavaSelenium\\KatalonDemo\\report\\selenium.html");
		driver1.manage().window().maximize();
		//driver.quit();
	}


		
		
		
		 

}
