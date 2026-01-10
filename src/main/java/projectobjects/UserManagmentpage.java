package projectobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagmentpage {

	private WebDriver driver;
	private WebDriverWait wait;

	// ---------------- Constructor ---------------- //
	public UserManagmentpage() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// ------------WebElement----------------------//
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameInput;

	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
	private WebElement userRoleDropdown;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeNameInput;

	@FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[2]")
	private WebElement statusDropdown;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//button[normalize-space()='Reset']")
	private WebElement resetBtn;

	// ---------- Add User ----------
	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addButton;

	 // ---------- Table ----------
    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row']")
    private List<WebElement> tableRows;

//	--------------Action-------------------//
	public AddUserPage clickAddUser() {
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
		return new AddUserPage();
	}
	public  void searchByusername(String username) {
		usernameInput.sendKeys("admin");
		searchBtn.click();
	}
	public void selectUserRole(String role) {
        userRoleDropdown.click();
        driver.findElement(By.xpath("//span[text()='" + role + "']")).click();
    }

    public void selectStatus(String status) {
        statusDropdown.click();
        driver.findElement(By.xpath("//span[text()='" + status + "']")).click();
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public void clickReset() {
        resetBtn.click();
    }

    public int getResultCount() {
        return tableRows.size();
    }

    public boolean isUserPresent(String username) {
        return tableRows.stream().anyMatch(row -> row.getText().contains(username));
    }

}
