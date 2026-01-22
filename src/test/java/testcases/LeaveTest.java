package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import projectobjects.Dashboard;
import projectobjects.Leave;
import projectobjects.Login_page;

public class LeaveTest extends BaseTest {

	@Test(priority = 0)
    public void verifyLoginAndDashboardLoad() {
        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");
    }


    @Test(priority = 1)
    public void verifyLeavePage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        Assert.assertEquals(leave.getLeaveHeading(), "Leave");
    }

    @Test(priority = 2)
    public void verifyLeaveListPage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        leave.clickLeaveList();
        Assert.assertTrue(driver.getCurrentUrl().contains("viewLeaveList"));
    }

    @Test(priority = 3)
    public void verifyMyLeavePage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        leave.clickMyLeave();
        Assert.assertTrue(driver.getCurrentUrl().contains("viewMyLeaveList"));
    }

    @Test(priority = 3)
    public void verifyApplyLeavePage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        leave.clickApplyLeave();
        Assert.assertTrue(driver.getCurrentUrl().contains("applyLeave"));
    }

    @Test(priority = 4)
    public void verifyAddEntitlementsPage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        leave.clickAddEntitlements();
        Assert.assertTrue(driver.getCurrentUrl().contains("addLeaveEntitlement"));
    }

    @Test(priority = 4)
    public void verifyLeaveUsageReportPage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        leave.clickLeaveUsageReport();
        Assert.assertTrue(driver.getCurrentUrl().contains("viewLeaveUsageReport"));
    }

    @Test(priority = 4)
    public void verifyLeavePeriodPage() {
        Leave leave = new Leave(driver);
        leave.openLeavePage();
        leave.clickLeavePeriod();
        Assert.assertTrue(driver.getCurrentUrl().contains("defineLeavePeriod"));
    }
}
