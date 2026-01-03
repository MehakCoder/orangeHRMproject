package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quicklaunch extends Dashboard {
	private WebDriverWait wait;
	
	//-----------Quick Launch Elements -----------
	@FindBy(xpath="//p[normalize-space()='Assign Leave']")
	private WebElement assignLeave;
	
	@FindBy(xpath="//p[normalize-space()='Leave List']")
	private WebElement LeaveList;
	
	@FindBy(xpath="//p[text()='Apply Leave']")
	private WebElement ApplyLeave;
	
	@FindBy(xpath = "//p[text()='My Leave']")
    private WebElement myLeave;

    @FindBy(xpath = "//p[text()='Timesheets']")
    private WebElement timesheets;

    @FindBy(xpath = "//p[text()='My Timesheet']")
    private WebElement myTimesheet;
	
	
	
	//---------Constructor----------------
	public Quicklaunch(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//------------Action------------------
	public LeavePage clickApplyLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(ApplyLeave));
        ApplyLeave.click();
        return new LeavePage(driver);
    }

    public LeavePage clickMyLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(myLeave));
        myLeave.click();
        return new LeavePage(driver);
    }

    public TimesheetPage clickMyTimesheet() {
        wait.until(ExpectedConditions.elementToBeClickable(myTimesheet));
        myTimesheet.click();
        return new TimesheetPage(driver);
    }

}
