// java
package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIM {
    protected WebDriver driver;
    private WebDriverWait wait;
    private String parentWindowHandle;

    public PIM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= WebElements =================
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")
    private WebElement PIMMenu;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement PIMHeading;

    @FindBy(xpath = "//span[text()='Configuration']")
    private WebElement Configuration;
 // Configuration child item
    @FindBy(xpath = "//a[normalize-space()='Optional Fields']")
    private WebElement OptionalFields;


    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement EmployeeList;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement AddEmployee;

    @FindBy(xpath = "//a[text()='Reports']")
    private WebElement Reports;

    // fixed Help locator
    @FindBy(xpath = "//button[@title='Help']")
    private WebElement Help;

    // ================= Actions / Methods =================
    public void openPIMPage() {
        wait.until(ExpectedConditions.elementToBeClickable(PIMMenu)).click();
    }

    public void clickPIMMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(PIMMenu)).click();
    }

    public String getPIMHeading() {
        wait.until(ExpectedConditions.visibilityOf(PIMHeading));
        return PIMHeading.getText();
    }

    public void clickConfiguration() {
        // Ensure the PIM menu is open so the Configuration item is visible/clickable
        if (!isConfigurationDisplayed()) {
            clickPIMMenu();
        }
        wait.until(ExpectedConditions.elementToBeClickable(Configuration)).click();
    }

    public boolean isConfigurationDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(Configuration));
            return Configuration.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOptionalFieldsVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(OptionalFields)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickEmployeeList() {
        wait.until(ExpectedConditions.elementToBeClickable(EmployeeList)).click();
    }

    public void clickAddEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(AddEmployee)).click();
    }

    public void clickReports() {
        wait.until(ExpectedConditions.elementToBeClickable(Reports)).click();
    }

    // Click Help and switch to new window
    public void clickHelp() {
        parentWindowHandle = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(Help)).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindowHandle)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Close help window and switch back to parent
    public void closeHelpAndSwitchBack() {
        if (parentWindowHandle == null) {
            return;
        }
        try {
            driver.close();
        } catch (Exception e) {
            // ignore
        }
        driver.switchTo().window(parentWindowHandle);
        parentWindowHandle = null;
    }
}
