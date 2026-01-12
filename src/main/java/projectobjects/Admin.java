package projectobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    // ===== WebElements =====
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']")
    private WebElement adminHeading;

    @FindBy(xpath = "//span[normalize-space()='User Management']")
    private WebElement userManagementMenu;

    @FindBy(xpath = "//span[normalize-space()='Job']")
    private WebElement job;

    @FindBy(xpath = "//span[normalize-space()='Organization']")
    private WebElement organization;

    @FindBy(xpath = "//span[normalize-space()='Qualifications']")
    private WebElement qualifications;

    @FindBy(xpath = "//a[normalize-space()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//a[normalize-space()='Corporate Branding']")
    private WebElement corporateBranding;

    @FindBy(xpath = "//span[normalize-space()='Configuration']")
    private WebElement configuration;

    @FindBy(xpath = "//button[@title='Help']")
    private WebElement helpBtn;

    // ===== Actions =====
    public void openAdminPage() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }

    public boolean isAdminDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(adminHeading)).isDisplayed();
    }

    public void hoverOnJob() {
        new Actions(driver).moveToElement(job).perform();
    }

    public void hoverOnOrganization() {
        new Actions(driver).moveToElement(organization).perform();
    }

    public void hoverOnQualifications() {
        new Actions(driver).moveToElement(qualifications).perform();
    }

    public void clickNationalities() {
        wait.until(ExpectedConditions.elementToBeClickable(nationalities)).click();
    }

    public void clickCorporateBranding() {
        wait.until(ExpectedConditions.elementToBeClickable(corporateBranding)).click();
    }

    public void hoverOnConfiguration() {
        new Actions(driver).moveToElement(configuration).perform();
    }

    public void openHelpPage() {
        String parentWindow = driver.getWindowHandle();
        helpBtn.click();

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public UserManagementPage goToUserManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(userManagementMenu)).click();
        return new UserManagementPage(driver);
    }
    public UserManagementPage openUserManagementProperly() {

        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();

        WebElement userManagementTab = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='User Management']")
            )
        );

        userManagementTab.click();
        return new UserManagementPage(driver);
    }


}
