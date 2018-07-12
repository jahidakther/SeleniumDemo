package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelpingMethod {
	WebDriver driver;
	//For Selecting value from combo box
	public void selectValueFromComboBox(String value) {
		
		Select selectBox = new Select(driver.findElement(By.id("combo_facility")));
	    selectBox.selectByVisibleText(value);
	    
	}

}
