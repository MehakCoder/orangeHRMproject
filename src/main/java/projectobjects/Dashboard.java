package projectobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

    protected WebDriver driver;
    private WebDriverWait wait;

    // ================= WebElements =================

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    private WebElement dashboardHeading;

    @FindBy(xpath = "//p[normalize-space()='Time at Work']")
    private WebElement timeAtWork;

    @FindBy(xpath = "//p[normalize-space()='My Actions']")
    private WebElement myActions;
    
    @FindBy(xpath = "//p[normalize-space()='Buzz Latest Posts']")
    private WebElement latestPosts ;

    
    @FindBy(xpath = "//p[normalize-space()='Quick Launch']")
    private WebElement quickLaunch;

    @FindBy(xpath = "//p[normalize-space()='Employees on Leave Today']")
    private WebElement employeesOnLeaveToday;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Sub Unit']")
    private WebElement empDistSubUnit;

    @FindBy(xpath = "//p[normalize-space()='Employee Distribution by Location']")
    private WebElement empDistLocation;

 // ========= QUICK LAUNCH =========
    @FindBy(xpath = "//p[text()='Assign Leave']")
    protected WebElement assignLeave;

    @FindBy(xpath = "//p[text()='Leave List']")
    protected WebElement leaveList;

    @FindBy(xpath = "//p[text()='Timesheets']")
    protected WebElement timesheets;

    @FindBy(xpath = "//p[text()='Apply Leave']")
    protected WebElement applyLeave;

    @FindBy(xpath = "//p[text()='My Leave']")
    protected WebElement myLeave;

    @FindBy(xpath = "//p[text()='My Timesheet']")
    protected WebElement myTimesheet;
   
    

    // ================= Constructor =================

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ================= Core Wait =================

    public void waitForDashboardLoad() {

        // 1️⃣ URL must contain dashboard
        wait.until(ExpectedConditions.urlContains("dashboard"));

        // 2️⃣ Loader must disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".oxd-loading-spinner")));

        // 3️⃣ Dashboard heading visible
        wait.until(ExpectedConditions.visibilityOf(dashboardHeading));
    }

    // ================= Validations =================

    public boolean isDashboardDisplayed() {
        return dashboardHeading.isDisplayed();
    }

    public boolean isTimeAtWorkDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(timeAtWork));
        return timeAtWork.isDisplayed();
    }

    public boolean isMyActionsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(myActions));
        return myActions.isDisplayed();
    }

    public boolean isQuickLaunchDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(quickLaunch));
        return quickLaunch.isDisplayed();
    }

    public boolean isLatestPostsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(latestPosts));
        return latestPosts.isDisplayed();
    }

    public boolean isEmployeesOnLeaveTodayDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(employeesOnLeaveToday));
        return employeesOnLeaveToday.isDisplayed();
    }

    public boolean isEmpDistBySubUnitDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(empDistSubUnit));
        return empDistSubUnit.isDisplayed();
    }

    public boolean isEmpDistByLocationDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(empDistLocation));
        return empDistLocation.isDisplayed();
    }

    
    
}
