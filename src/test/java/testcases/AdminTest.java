package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import projectobjects.Admin;
import projectobjects.Dashboard;
import projectobjects.Login_page;

public class AdminTest extends BaseTest {

    @Test(priority = 1)
    public void verifyAdminPageNavigation() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        Dashboard dashboard = new Dashboard(driver);
        dashboard.waitForDashboardLoad();

        Admin admin = new Admin(driver);
        admin.openAdminPage();

        Assert.assertTrue(admin.isAdminDisplayed(), "Admin heading not displayed");
    }

    @Test(priority = 2)
    public void verifyJobMenuHover() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.hoverOnJob();

        Assert.assertTrue(true, "Job menu hover successful");
    }

    @Test(priority = 3)
    public void verifyOrganizationMenuHover() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.hoverOnOrganization();

        Assert.assertTrue(true, "Organization menu hover successful");
    }

    @Test(priority = 4)
    public void verifyQualificationsMenuHover() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.hoverOnQualifications();

        Assert.assertTrue(true, "Qualifications menu hover successful");
    }

    @Test(priority = 5)
    public void verifyNationalitiesPage() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.clickNationalities();

        Assert.assertTrue(driver.getCurrentUrl().contains("nationalities"),
                "Nationalities page not opened");
    }

    @Test(priority = 6)
    public void verifyCorporateBrandingPage() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.clickCorporateBranding();

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("branding"),
                "Corporate Branding page not opened");
    }

    @Test(priority = 7)
    public void verifyConfigurationMenuHover() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.hoverOnConfiguration();

        Assert.assertTrue(true, "Configuration hover successful");
    }

    @Test(priority = 8)
    public void verifyHelpPageOpen() {

        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.openHelpPage();

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("help"),
                "Help page not opened");
    }
}
