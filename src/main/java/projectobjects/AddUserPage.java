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

	public AddUserPage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// User Role dropdown
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

	// -------------- Actions -------------------//

	public void selectUserRole(String role) {
		wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();

		WebElement option = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + role + "']")));
		option.click();
	}

	public void selectStatus(String status) {
		wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();

		WebElement option = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + status + "']")));
		option.click();
	}

	public void enterEmployeeName(String name) {
		employeeName.sendKeys("admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + name + "')]")))
				.click();
	}

	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
	}

	public void clickSave() {
		saveButton.click();
	}

	public void clickCancel() {
		cancelButton.click();
	}
}
