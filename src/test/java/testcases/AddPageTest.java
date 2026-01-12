package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import projectobjects.AddUserPage;
import projectobjects.Admin;
import projectobjects.Login_page;
import projectobjects.UserManagementPage;

public class AddPageTest extends BaseTest {

    private UserManagementPage navigateToUserManagement() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        Admin admin = new Admin(driver);
        admin.openAdminPage();

        return admin.goToUserManagement();
    }

    @Test(priority = 1)
    public void verifyAddUserWithValidData() {

        UserManagementPage userMgmt = navigateToUserManagement();
        AddUserPage addUserPage = userMgmt.clickAddUser();

        Assert.assertTrue(addUserPage.isAddUserPageDisplayed(),
                "Add User page not displayed");

        addUserPage.selectUserRole("ESS");
        addUserPage.selectStatus("Enabled");
        addUserPage.enterEmployeeName("Pallavi Shivaji Bhure");
        addUserPage.enterUsername("AutoUser" + System.currentTimeMillis());
        addUserPage.enterPassword("Admin@123");
        addUserPage.clickSave();
    }

    @Test(priority = 2)
    public void verifyCancelButton() {

        UserManagementPage userMgmt = navigateToUserManagement();
        AddUserPage addUser = userMgmt.clickAddUser();

        addUser.clickCancel();

        Assert.assertTrue(userMgmt.isUserManagementPageDisplayed(),
                "User Management page not displayed after cancel");
    }
}
