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

public class UserManagementPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Correct Constructor
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== WebElements =====
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

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@class='oxd-table-row']")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//h6[text()='User Management']")
    private WebElement userManagementHeader;

    // ===== Actions =====
    public boolean isUserManagementPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(userManagementHeader)).isDisplayed();
    }

    public AddUserPage clickAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        return new AddUserPage(driver);
    }

    public void searchByUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).clear();
        usernameInput.sendKeys(username);
        searchBtn.click();
        waitForTableToLoad();   // ✅ CRITICAL
    }


    public void selectUserRole(String role) {
        userRoleDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='" + role + "']"))).click();
    }

    public void selectStatus(String status) {
        statusDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='" + status + "']"))).click();
    }

    public void clickReset() {
        resetBtn.click();
    }

    public int getResultCount() {
        return tableRows.size();
    }
    public void waitForTableToLoad() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.xpath("//div[@class='oxd-table-row']")
        ));
    }

    public boolean isUserPresent(String username) {
        return tableRows.stream().anyMatch(row -> row.getText().contains(username));
    }

	public boolean isUsernameFieldCleared() {
		  return usernameInput.getAttribute("value").isEmpty();
	}
}
