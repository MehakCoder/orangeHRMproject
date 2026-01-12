package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import projectobjects.Admin;
import projectobjects.UserManagementPage;

public class UserManagementPageTest extends BaseTest {

    private UserManagementPage navigateToUserManagement() {

        Admin admin = new Admin(driver);
        return admin.openUserManagementProperly();
    }

    @Test(priority = 1)
    public void verifySearchUserByUsername() {

        UserManagementPage userMgmt = navigateToUserManagement();
        userMgmt.searchByUsername("Admin");

        Assert.assertTrue(
                userMgmt.isUserPresent("Admin"),
                "Admin user not found"
        );
    }

    @Test(priority = 2)
    public void verifyResetButton() {

        UserManagementPage userMgmt = navigateToUserManagement();
        userMgmt.searchByUsername("Admin");
        userMgmt.clickReset();

        Assert.assertTrue(
                userMgmt.isUsernameFieldCleared(),
                "Reset did not clear input"
        );
    }

    @Test(priority = 3)
    public void verifyAddUserNavigation() {

        UserManagementPage userMgmt = navigateToUserManagement();

        Assert.assertTrue(
                userMgmt.clickAddUser().isAddUserPageDisplayed(),
                "Add User page not opened"
        );
    }
}
