package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import projectobjects.Login_page;
import projectobjects.MyInfo;


public class MyInfoTest extends BaseTest {

    private MyInfo myInfo;

    @BeforeMethod
    public void setupTest() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        // ✅ wait for dashboard load
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("dashboard"));

        myInfo = new MyInfo(driver);
        myInfo.openMyInfo();
    }


    @Test
    public void verifyMyInfoPageLoaded() {
        String header = myInfo.getMyInfoHeading();
        Assert.assertTrue(
                header.contains("Personal") || header.contains("PIM"),
                "My Info page not loaded"
        );
    }

    @Test
    public void verifyPersonalDetails() {
        myInfo.goToPersonalDetails();
    }

    @Test
    public void verifyContactDetails() {
        myInfo.goToContactDetails();
    }

    @Test
    public void verifyEmergencyContacts() {
        MyInfo.goToEmergencyContacts();
    }

    @Test
    public void verifyDependents() {
        MyInfo.goToDependents();
    }

    @Test
    public void verifyImmigration() {
        MyInfo.goToImmigration();
    }

    @Test
    public void verifyJob() {
        myInfo.goToJob();
    }

    @Test
    public void verifySalary() {
        myInfo.goToSalary();
    }

    @Test
    public void verifyReportTo() {
        myInfo.goToReportTo();
    }

    @Test
    public void verifyQualifications() {
        myInfo.goToQualifications();
    }

    @Test
    public void verifyMemberships() {
        myInfo.goToMemberships();
    }
}
