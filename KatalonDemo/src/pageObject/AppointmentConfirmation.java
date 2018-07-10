package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmation {
	
	public static WebDriver driver;
	private String actualConfirmationPageLabel="Appointment Confirmation";
	private String actualFacility="Tokyo CURA Healthcare Center";
	private By expectedFAcilityLocator = By.id("facility");
	private By expectedVisitdateLocator = By.id("visit_date");
	
	
	
	// This is A Constructor
    public AppointmentConfirmation(WebDriver driver) {
	this.driver = driver;
      }

 // For access Actual Page Label
 	public String actualConfirmationPageLabel() {
 		return actualConfirmationPageLabel;
 	}
    
 // For access Actual Facility name
  	public String actualFacility() {
  		return actualFacility;
  	}
  	
  //For access Expected Facility Locator
  	public By expectedFAcilityLocator() {
  		return expectedFAcilityLocator;
  	}
  	
  //For access Expected Facility Locator
  	public By expectedVisitDateLocator() {
  		return expectedVisitdateLocator;
  	}
    
}
