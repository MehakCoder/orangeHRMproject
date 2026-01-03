package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import projectobjects.Login_page;

public class Login_test extends BaseTest {

    @BeforeMethod
    public void openLoginPage() {
        driver.get(prop.getProperty("url"));
    }

    // ================= Test 1 ================= //
    // Valid Login
    @Test(priority = 1)
    public void validLoginTest() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='Dashboard']")
                )
        );

        Assert.assertTrue(dashboardMenu.isDisplayed(), "Valid login failed!");
    }

    // ================= Test 2 ================= //
    // Invalid Login
    @Test(priority = 2)
    public void invalidLoginTest() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin");

        String errorMsg = login.getErrorMessage();

        Assert.assertTrue(
                errorMsg.contains("Invalid credentials"),
                "Invalid credentials error not displayed!"
        );
    }

    // ================= Test 3 ================= //
    // Empty Username & Password
    @Test(priority = 3)
    public void emptyFieldsTest() {

        Login_page login = new Login_page(driver);
        login.clickLogin();

        Assert.assertTrue(
                login.isRequiredErrorDisplayed(),
                "Required field validation not shown!"
        );
    }

    // ================= Test 4 ================= //
    // Forgot Password Navigation
    @Test(priority = 4)
    public void forgotPasswordTest() {

        Login_page login = new Login_page(driver);
        login.clickForgotPassword();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("requestPasswordResetCode"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("requestPasswordResetCode"),
                "Forgot Password page not opened!"
        );
    }

    // ================= Test 5 ================= //
    // Verify Dashboard Load After Login
    @Test(priority = 5)
    public void verifyDashboardAfterLogin() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h6[text()='Dashboard']")
                )
        );

        Assert.assertTrue(
                dashboardHeader.isDisplayed(),
                "Dashboard page did not load after login"
        );
    }
}
