package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	
	public static WebDriver driver;
	
	private String url="http://demoaut.katalon.com/";
	private String actualTitle="CURA Healthcare Service";
	private By burgerMenu = By.xpath(".//*[@id='menu-toggle']/i");
	private By logInLink = By.xpath(".//*[@id='sidebar-wrapper']/ul/li[3]/a");
	private By homeLink = By.xpath(".//*[@id='sidebar-wrapper']/ul/li[2]/a");
	
		// This is A Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

		// For access Private URL string
	public String getURL() {
		return url;
	}

	// For access Actual Title
	public String getTitle() {
		return actualTitle;
	}
	
	// For access login Locator
		public By getBurgerMenuLocator() {
			return burgerMenu;
		}
		
	// For access login Locator
	public By getloginLocator() {
		return logInLink;
				}
	
	// For access login Locator
		public By getHomeLocator() {
			return homeLink;
					}
	

	
	
	
}
