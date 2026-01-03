package projectobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TimesheetPage {

    WebDriver driver;

    public TimesheetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTimesheetPageOpened() {
        return driver.getCurrentUrl().contains("time");
    }
}
