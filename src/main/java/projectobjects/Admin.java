package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {

	protected WebDriver driver;
	private WebDriverWait wait;

	public Admin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// ================= WebElements =================
	// Admin menu (left side)
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminMenu;
	// heading
	@FindBy(xpath = "//span[@class=\"oxd-topbar-header-breadcrumb\"]")
	private WebElement AdminHeading;
	// UserMangment page
	@FindBy(xpath = "//span[normalize-space()='User Management']")
	private WebElement UserManagment;

	// job
	@FindBy(xpath = "//span[normalize-space()='Job']")
	private WebElement job;

	// organization
	@FindBy(xpath = "//span[normalize-space()='Organization']")
	private WebElement Organization;
	// Qualification
	@FindBy(xpath = "//span[normalize-space()='Qualifications ']")
	private WebElement Qualifications;

	// Nationalities
	@FindBy(xpath = "//a[normalize-space()='Nationalities']")
	private WebElement Nationalites;

	// Corporate Branding
	@FindBy(xpath = "//a[normalize-space()='Corporate Branding']")
	private WebElement CorporateBranding;

	// configuration
	@FindBy(xpath = "//span[normalize-space()='Configuration']")
	private WebElement Configuration;

	// Help
	@FindBy(xpath = "//button[@title='Help']")
	private WebElement Helpbtn;

	/* ================= ACTION METHODS ================= */
	public void openAdminPage() {
		wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
	}

	public boolean isAdminDisplayed() {
		return AdminHeading.isDisplayed();
	}

	public boolean isSystemUserPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(UserManagment)).isDisplayed();
	}

	public void hoverOnJob() {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(job));
		actions.moveToElement(job).perform();
	}

	public void hoverOnOrganization() {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(Organization));
		actions.moveToElement(Organization).perform();
	}

	public void hoverOnQualifications() {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(Qualifications));
		actions.moveToElement(Qualifications).perform();
	}

	public void Nationalites() {
		wait.until(ExpectedConditions.elementToBeClickable(Nationalites)).click();
	}

	public void CorporateBranding() {
		wait.until(ExpectedConditions.elementToBeClickable(CorporateBranding)).click();
	}

	public void hoverOnConfiguration() {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(Configuration));
		actions.moveToElement(Configuration).perform();
	}

	public void openHelppage() {
		// Store parent window
		String parentWindow = driver.getWindowHandle();

		// Click Help
		wait.until(ExpectedConditions.elementToBeClickable(Helpbtn)).click();

		// Switch to new window
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public void waitForAdminPageLoad() {
		wait.until(ExpectedConditions.visibilityOf(AdminHeading));

	}

}
