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

    WebDriver driver;
    WebDriverWait wait;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Add User']")
    private WebElement addUserHeader;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text')])[2]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeName;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement username;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement password;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    public boolean isAddUserPageDisplayed() {
        return addUserHeader.isDisplayed();
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

    public void enterEmployeeName(String name) {
        employeeName.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'" + name + "')]"))).click();
    }

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
    }

    public void clickSave() {
        saveBtn.click();
    }
}
