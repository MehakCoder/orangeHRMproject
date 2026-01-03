package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quicklaunch extends Dashboard {
	WebDriverWait wait;
	
	public QuickLaunch(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

}
