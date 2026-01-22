package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_page {

    private WebDriver driver;
    private WebDriverWait wait;

    // ================= WebElements ================= //

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[contains(@class,'oxd-alert-content')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[text()='Required']")
    private WebElement requiredError;

    // ================= Constructor ================= //

    public Login_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ================= Actions ================= //

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void login(String username, String password) {
        // Wait for visibility to ensure page is loaded
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public boolean isRequiredErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(requiredError));
        return requiredError.isDisplayed();
    }
}
