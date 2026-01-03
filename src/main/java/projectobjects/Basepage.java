package projectobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	 private WebDriver driver;

	public Basepage(WebDriver driver) {
		   this.driver = driver;
	       PageFactory.initElements(driver, this);
	   }

}
