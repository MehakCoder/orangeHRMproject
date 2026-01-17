// java
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import projectobjects.Admin;
import projectobjects.Dashboard;
import projectobjects.Login_page;
import projectobjects.PIM;

public class PIMTest extends BaseTest {

    protected PIM pim;

    @BeforeClass
    public void pimSetup() {
        pim = new PIM(driver);   // ✅ direct usage
    }

    @Test(priority = 1)
    public void verifyLoginAndDashboardLoad() {
        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        Dashboard dashboard = new Dashboard(driver);
        dashboard.waitForDashboardLoad();
    }

    @Test(priority = 2)
    public void verifyPIMMenuNavigation() {
        pim.clickPIMMenu();
        Assert.assertEquals(pim.getPIMHeading(), "PIM");
    }

    @Test(priority = 3)
    public void verifyEmployeeListNavigation() {
        pim.clickPIMMenu();
        pim.clickEmployeeList();
        Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeeList"));
    }

    @Test(priority = 4)
    public void verifyAddEmployeeNavigation() {
        pim.clickPIMMenu();
        pim.clickAddEmployee();
        Assert.assertTrue(driver.getCurrentUrl().contains("addEmployee"));
    }

    @Test(priority = 5)
    public void verifyConfigurationDropdownClickable() {
        pim.clickPIMMenu();
        pim.clickConfiguration();

        Assert.assertTrue(
            pim.isOptionalFieldsVisible(),
            "Configuration dropdown did not expand"
        );
    }

    @Test(priority = 6)
    public void verifyReportNavigation() {
        pim.clickPIMMenu();
        pim.clickReports();
        Assert.assertTrue(driver.getCurrentUrl().contains("viewDefinedPredefinedReports"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
