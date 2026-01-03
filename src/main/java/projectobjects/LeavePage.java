package projectobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {

    WebDriver driver;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLeavePageOpened() {
        return driver.getCurrentUrl().contains("leave");
    }
}

