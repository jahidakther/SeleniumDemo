package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentPage {

public static WebDriver driver;
	
	private String actualAppointmentPageLabel="Make Appointment";
	private String validDate="29/10/2018";
	private String invalidDate="01/01/1951";
	private By comboBoxLocator = By.id("combo_facility");
	private By dateLocator = By.xpath(".//*[@id='txt_visit_date']");
	private By logoffLocator = By.xpath(".//*[@id='sidebar-wrapper']/ul/li[5]/a");
	private By bookAppointButton = By.id("btn-book-appointment");
	private By appointmentPageLabelLocator = By.xpath(".//*[@id='login']/div/div/div[1]/h2");
	
		// This is A Constructor
	public AppointmentPage(WebDriver driver) {
		this.driver = driver;
	}

			
	// For access Actual Page Label
	public String actualAppointPageLabel() {
		return actualAppointmentPageLabel;
	}
	
	// For access Valid date
	public String getvalidDate() {
		return validDate;
	}
	
	// For access Invalid date
	public String getinvalidDate() {
		return invalidDate;
	}
		
	//For access Combo box  Locator
	public By facilityComboLocator() {
		return comboBoxLocator;
	}
		
	//For access Visit Date  Locator
	public By VisitDateLocator() {
		return dateLocator;
	}
	
	
	//For access logoff  Locator
		public By logoffLocator() {
			return logoffLocator;
		}
	
	
	//For access Book Appointment Button  Locator
	public By bookAppointButtonLocator() {
		return bookAppointButton;
	}

	//For  appointmentPageLabelLocator Locator
	public By appointmentPageLabelLocator() {
		return appointmentPageLabelLocator;
	}
	
}
