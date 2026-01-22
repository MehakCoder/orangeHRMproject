package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Leave {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public Leave(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveMenu;

    @FindBy(xpath = "//h6[contains(@class,'breadcrumb-module')]")
    private WebElement leaveHeading;

    @FindBy(xpath = "//a[text()='Leave List']")
    private WebElement leaveList;

    @FindBy(xpath = "//a[text()='My Leave']")
    private WebElement myLeave;

    @FindBy(xpath = "//a[text()='Apply']")
    private WebElement applyLeave;

    @FindBy(xpath = "//span[text()='Entitlements']")
    private WebElement entitlements;

    @FindBy(xpath = "//span[text()='Reports']")
    private WebElement reports;

    @FindBy(xpath = "//span[text()='Configure']")
    private WebElement configure;

    @FindBy(xpath = "//a[contains(text(),'Add Entitlements')]")
    private WebElement addEntitlements;

    @FindBy(xpath = "//a[contains(text(),'Leave Usage')]")
    private WebElement leaveUsage;

    @FindBy(xpath = "//a[contains(text(),'Leave Period')]")
    private WebElement leavePeriod;

    private void hoverLeave() {
        wait.until(ExpectedConditions.visibilityOf(leaveMenu));
        actions.moveToElement(leaveMenu).perform();
    }

    public void openLeavePage() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
    }

    public String getLeaveHeading() {
        wait.until(ExpectedConditions.visibilityOf(leaveHeading));
        return leaveHeading.getText();
    }

    public void clickLeaveList() {
        hoverLeave();
        wait.until(ExpectedConditions.elementToBeClickable(leaveList)).click();
    }

    public void clickMyLeave() {
        hoverLeave();
        wait.until(ExpectedConditions.elementToBeClickable(myLeave)).click();
    }

    public void clickApplyLeave() {
        hoverLeave();
        wait.until(ExpectedConditions.elementToBeClickable(applyLeave)).click();
    }

    public void clickAddEntitlements() {
        hoverLeave();
        actions.moveToElement(entitlements).perform();
        wait.until(ExpectedConditions.elementToBeClickable(addEntitlements)).click();
    }

    public void clickLeaveUsageReport() {
        hoverLeave();
        actions.moveToElement(reports).perform();
        wait.until(ExpectedConditions.elementToBeClickable(leaveUsage)).click();
    }

    public void clickLeavePeriod() {
        hoverLeave();
        actions.moveToElement(configure).perform();
        wait.until(ExpectedConditions.elementToBeClickable(leavePeriod)).click();
    }
}
