package projectobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemUsersPage {

    WebDriver driver;

    public SystemUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[text()='User Management']")
    private WebElement userManagementMenu;

    @FindBy(xpath = "//a[text()='Users']")
    private WebElement usersOption;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addButton;

    public void navigateToSystemUsers() {
        adminMenu.click();
    }

    public void clickAdd() {
        addButton.click();
    }

    public boolean isSystemUsersPageDisplayed() {
        return driver.getCurrentUrl().contains("viewSystemUsers");
    }
}
