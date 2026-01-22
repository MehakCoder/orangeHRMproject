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
    private WebDriverWait wait;

    public MyInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    /* ---------- SIDE MENU ---------- */

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoSideMenu;

    /* ---------- PAGE HEADERS ---------- */

    @FindBy(xpath = "//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]")
    private WebElement mainHeader;

    @FindBy(xpath = "//h6[contains(@class,'orangehrm-main-title')]")
    private WebElement sectionHeader;

    /* ---------- MY INFO TABS ---------- */

    @FindBy(xpath = "//a[text()='Personal Details']")
    private WebElement personalDetailsTab;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsTab;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    private WebElement emergencyContactsTab;

    @FindBy(xpath = "//a[text()='Dependents']")
    private WebElement dependentsTab;

    @FindBy(xpath = "//a[text()='Immigration']")
    private WebElement immigrationTab;

    @FindBy(xpath = "//a[text()='Job']")
    private WebElement jobTab;

    @FindBy(xpath = "//a[text()='Salary']")
    private WebElement salaryTab;

    @FindBy(xpath = "//a[text()='Report-to']")
    private WebElement reportTab;

    @FindBy(xpath = "//a[text()='Qualifications']")
    private WebElement qualificationsTab;

    @FindBy(xpath = "//a[text()='Memberships']")
    private WebElement membershipsTab;

    /* ---------- ACTION METHODS ---------- */

    public void openMyInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoSideMenu)).click();
        wait.until(ExpectedConditions.visibilityOf(personalDetailsTab));
    }

    public void openPersonalDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(personalDetailsTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Personal Details"));
    }

    public void openContactDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Contact Details"));
    }

    public void openEmergencyContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(emergencyContactsTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Emergency Contacts"));
    }

    public void openDependents() {
        wait.until(ExpectedConditions.elementToBeClickable(dependentsTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Dependents"));
    }

    public void openImmigration() {
        wait.until(ExpectedConditions.elementToBeClickable(immigrationTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Immigration"));
    }

    public void openJob() {
        wait.until(ExpectedConditions.elementToBeClickable(jobTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Job"));
    }

    public void openSalary() {
        wait.until(ExpectedConditions.elementToBeClickable(salaryTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Salary"));
    }

    public void openReportTo() {
        wait.until(ExpectedConditions.elementToBeClickable(reportTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Report-to"));
    }

    public void openQualifications() {
        wait.until(ExpectedConditions.elementToBeClickable(qualificationsTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Qualifications"));
    }

    public void openMemberships() {
        wait.until(ExpectedConditions.elementToBeClickable(membershipsTab)).click();
        wait.until(ExpectedConditions.textToBePresentInElement(sectionHeader, "Memberships"));
    }

    /* ---------- VERIFICATION ---------- */

    public String getSectionHeaderText() {
        return sectionHeader.getText();
    }

	}
