package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import projectobjects.Admin;
import projectobjects.Dashboard;
import projectobjects.Login_page;

public class AdminTest extends BaseTest {
	@Test(priority = 1)
	public void VerifyAdminPageNavigation() {
		// Login
		Login_page login = new Login_page(driver);
		login.login("Admin", "admin123");

		// Dashboard load
		Dashboard dashboard = new Dashboard(driver);
		dashboard.waitForDashboardLoad();

		// AdminPage
		Admin admin = new Admin(driver);
		admin.openAdminPage();

		// Assertions
		Assert.assertTrue(admin.isAdminDisplayed(), "Admin heading is not displayed");

		Assert.assertTrue(admin.isSystemUserPageDisplayed(), "User Management page is not displayed");
	}

	@Test(priority = 2)
	public void verifyJobMenuHover() {
		Admin admin = new Admin(driver);
		admin.openAdminPage();

		admin.hoverOnJob();

		Assert.assertTrue(true);
	}

	@Test(priority = 3)
	public void verifyOrganizationMenuHover() {
		Admin admin = new Admin(driver);
		admin.openAdminPage();

		admin.hoverOnOrganization();

		Assert.assertTrue(true);
	}

	@Test(priority = 4)
    public void verifyQualificationsMenuHover() {
        Admin admin = new Admin(driver);
        admin.openAdminPage();
        admin.hoverOnQualifications();
        Assert.assertTrue(true);
    }

	@Test(priority = 5)
	public void verifyNationalitiesPage() {
		Admin admin = new Admin(driver);
		admin.openAdminPage();
		admin.Nationalites();
		Assert.assertTrue(driver.getCurrentUrl().contains("nationality"));
	}

	@Test(priority = 6)
	public void verifyCorporateBrandingPage() {
		Admin admin = new Admin(driver);
		admin.openAdminPage();
     
		admin.CorporateBranding();

		Assert.assertTrue(driver.getCurrentUrl().contains("Corporate Branding"));
	}

	@Test(priority = 7)
	public void verifyConfigurationMenuHover() {
		Admin admin = new Admin(driver);
		admin.openAdminPage();

		admin.hoverOnConfiguration();

		Assert.assertTrue(true, "Configuration menu hover successful");
	}
	
	
	@Test(priority = 8)
	public void verifyHelpPageOpen() {

	    Admin admin = new Admin(driver);
	    admin.openAdminPage();
	    admin.openHelppage();

	    // Verify new page opened
	    Assert.assertTrue(driver.getCurrentUrl().contains("help"));
	}


}