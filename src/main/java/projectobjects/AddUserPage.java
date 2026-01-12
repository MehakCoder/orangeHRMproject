package projectobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// -------- Constructor --------
	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// -------- Page Validation --------
	@FindBy(xpath = "//h6[text()='Add User']")
	private WebElement addUserHeading;

	// -------- WebElements --------
	@FindBy(xpath = "//label[text()='User Role']/../following-sibling::div")
	private WebElement userRoleDropdown;

	@FindBy(xpath = "//label[text()='Status']/../following-sibling::div")
	private WebElement statusDropdown;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeName;

	@FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
	private WebElement username;

	@FindBy(xpath = "//label[text()='Password']/../following-sibling::div/input")
	private WebElement password;

	@FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div/input")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelButton;

	// -------- Actions --------
	public boolean isAddUserPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(addUserHeading)).isDisplayed();
	}

	public void selectUserRole(String role) {
		wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + role + "']"))).click();
	}

	public void selectStatus(String status) {
		wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + status + "']"))).click();
	}

	public void enterEmployeeName(String name) {
		wait.until(ExpectedConditions.visibilityOf(employeeName)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + name + "')]")))
				.click();
	}

	public void enterUsername(String uname) {
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
	}

	public void clickSave() {
		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}

	public void clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
	}
}
