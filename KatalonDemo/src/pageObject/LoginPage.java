package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static WebDriver driver;
	
	private String userId="John Doe";
	private String password="ThisIsNotAPassword";
	private String actualLogInLabel="Login";
	private By userWebTextLocator = By.id("txt-username");
	private By passwordWebTextLocator = By.id("txt-password");
	private By logInButtonLocator = By.id("btn-login");
	private By pageLabel = By.xpath(".//*[@id='login']/div/div/div[1]/h2");
	private By errorMsgLocator = By.xpath(".//*[@id='login']/div/div/div[1]/p[2]");
	
		// This is A Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

		// For access User ID
	public String getUserId() {
		return userId;
	}

	// For access Actual Page Label
	public String actualPageLabel() {
		return actualLogInLabel;
	}
	
	// For access User Name Web Text Locator
	public String getPassword() {
		return password;
	}
	
	//For access user WebText Locator
		public By userWebTextLocator() {
			return userWebTextLocator;
		}
		
		
		
		//For access Error Message Locator
				public By errorMsgLocator() {
					return errorMsgLocator;
				}
		
		
	
	//For access password WebText Locator
	public By passwordWebTextLocator() {
		return passwordWebTextLocator;
	}
	
    //For access Login Button Locator
	public By loginButtonLocator() {
		return logInButtonLocator;
	}
			
	//For access Page Label Locator
	public By getPageLabelLocator() {
		return pageLabel;
	}
				
	
}
