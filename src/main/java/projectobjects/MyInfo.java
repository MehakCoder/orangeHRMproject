package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfo {

    private WebDriver driver;
    private static WebDriverWait wait;

    // ✅ CONSTRUCTOR
    public MyInfo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /* ---------- MENU ---------- */
    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//h6[text()='PIM']")
    private WebElement myInfoHeading;

    /* ---------- SUB MENU ---------- */
    @FindBy(xpath = "//a[text()='Personal Details']")
    private WebElement personalDetails;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetails;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    private static WebElement emergencyContacts;

    @FindBy(xpath = "//a[text()='Dependents']")
    private static WebElement dependents;

    @FindBy(xpath = "//a[text()='Immigration']")
    private static WebElement immigration;

    @FindBy(xpath = "//a[text()='Job']")
    private WebElement job;

    @FindBy(xpath = "//a[text()='Salary']")
    private WebElement salary;

    @FindBy(xpath = "//a[text()='Report-to']")
    private WebElement reportTo;

    @FindBy(xpath = "//a[text()='Qualifications']")
    private WebElement qualifications;

    @FindBy(xpath = "//a[text()='Memberships']")
    private WebElement memberships;

    /* ---------- ACTION METHODS ---------- */

    public void openMyInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click();
    }
   

    public String getMyInfoHeading() {
        return wait.until(ExpectedConditions.visibilityOf(myInfoHeading)).getText();
    }

    public void goToPersonalDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(personalDetails)).click();
    }

    public void goToContactDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetails)).click();
    }

    public static void goToEmergencyContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(emergencyContacts)).click();
    }

    public static void goToDependents() {
        wait.until(ExpectedConditions.elementToBeClickable(dependents)).click();
    }

    public static void goToImmigration() {
        wait.until(ExpectedConditions.elementToBeClickable(immigration)).click();
    }

    public void goToJob() {
        wait.until(ExpectedConditions.elementToBeClickable(job)).click();
    }

    public void goToSalary() {
        wait.until(ExpectedConditions.elementToBeClickable(salary)).click();
    }

    public void goToReportTo() {
        wait.until(ExpectedConditions.elementToBeClickable(reportTo)).click();
    }

    public void goToQualifications() {
        wait.until(ExpectedConditions.elementToBeClickable(qualifications)).click();
    }

    public void goToMemberships() {
        wait.until(ExpectedConditions.elementToBeClickable(memberships)).click();
    }

	

	
}
