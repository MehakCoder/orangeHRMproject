package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectobjects.AddUserPage;
import projectobjects.Login_page;
import projectobjects.SystemUsersPage;

public class UserManagementTest extends BaseTest {

    @Test
    public void addUserSuccessfully() {

        Login_page loginPage = new Login_page(driver);
        loginPage.login("Admin", "admin123");

        SystemUsersPage systemUsersPage = new SystemUsersPage(driver);
        systemUsersPage.navigateToSystemUsers();

        Assert.assertTrue(systemUsersPage.isSystemUsersPageDisplayed());

        systemUsersPage.clickAdd();

        AddUserPage addUserPage = new AddUserPage(driver);
        Assert.assertTrue(addUserPage.isAddUserPageDisplayed());

        addUserPage.selectUserRole("ESS");
        addUserPage.enterEmployeeName("Paul Collings");
        addUserPage.selectStatus("Enabled");

        String uniqueUser = "user" + System.currentTimeMillis();
        addUserPage.enterUsername(uniqueUser);
        addUserPage.enterPassword("Test@123");

        addUserPage.clickSave();

        
        wait.until(ExpectedConditions.urlContains("viewSystemUsers"));
        Assert.assertTrue(systemUsersPage.isSystemUsersPageDisplayed());


    }
}
