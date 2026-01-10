package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import projectobjects.Dashboard;
import projectobjects.Login_page;

public class DashboardTest extends BaseTest {

    private Dashboard dashboard;

    @Test(priority = 0)
    public void loginAndOpenDashboard() {

        // Step 1: Login
        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        // Step 2: Initialize Dashboard page
        dashboard = new Dashboard(driver);

        // Step 3: Wait for dashboard to load fully
        dashboard.waitForDashboardLoad();
        
        System.out.println();
    }

    // ================= TEST CASES =================

    @Test(priority = 1)
    public void verifyDashboardHeading() {
        Assert.assertTrue(
                dashboard.isDashboardDisplayed(),
                "Dashboard heading is not displayed"
        );
    }

    @Test(priority = 2)
    public void verifyTimeAtWorkCard() {
        Assert.assertTrue(
                dashboard.isTimeAtWorkDisplayed(),
                "Time at Work card is not displayed"
        );
    }

    @Test(priority = 3)
    public void verifyMyActionsCard() {
        Assert.assertTrue(
                dashboard.isMyActionsDisplayed(),
                "My Actions card is not displayed"
        );
    }

    @Test(priority = 4)
    public void verifyQuickLaunchCard() {
        Assert.assertTrue(
                dashboard.isQuickLaunchDisplayed(),
                "Quick Launch card is not displayed"
        );
    }

    @Test(priority = 3)
    public void verifyLatestPostsCard() {
        Assert.assertTrue(
                dashboard.isLatestPostsDisplayed(),
                "Latest Posts card is not displayed"
        );
    }

    @Test(priority = 4)
    public void verifyEmployeesOnLeaveTodayCard() {
        Assert.assertTrue(
                dashboard.isEmployeesOnLeaveTodayDisplayed(),
                "Employees on Leave Today card is not displayed"
        );
    }

    @Test(priority = 5)
    public void verifyEmployeeDistributionBySubUnit() {
        Assert.assertTrue(
                dashboard.isEmpDistBySubUnitDisplayed(),
                "Employee Distribution by Sub Unit is not displayed"
        );
    }

    @Test(priority = 4)
    public void verifyEmployeeDistributionByLocation() {
        Assert.assertTrue(
                dashboard.isEmpDistByLocationDisplayed(),
                "Employee Distribution by Location is not displayed"
        );
    }
}
