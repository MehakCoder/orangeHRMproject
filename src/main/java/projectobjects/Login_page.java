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

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public void login(String user, String pass) {

        if (!isLoginPageDisplayed()) {
            return; // already logged in
        }

        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }


    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }
    
    public boolean isLoginPageDisplayed() {
        return driver.getCurrentUrl().contains("login");
    }


    public boolean isRequiredErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(requiredError));
        return requiredError.isDisplayed();
    }
}
