package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projectobjects.Login_page;
import projectobjects.MyInfo;

public class MyInfoTest extends BaseTest {

    private MyInfo myInfo;

    @Test(priority =0)
    public void setupTest() {

        Login_page login = new Login_page(driver);
        login.login("Admin", "admin123");

        myInfo = new MyInfo(driver);
        myInfo.openMyInfo();
    }

    @Test(priority = 1)
    public void verifyPersonalDetails() {
        Assert.assertEquals(
                myInfo.getSectionHeaderText(),
                "Contact Details",
                "Personal Details page not loaded"
        );
    }

    @Test(priority = 1)
    public void verifyContactDetails() {
        myInfo.openContactDetails();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Contact Details");
    }

    @Test(priority = 2)
    public void verifyEmergencyContacts() {
        myInfo.openEmergencyContacts();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Assigned Emergency Contacts");
    }

    @Test(priority = 3)
    public void verifyDependents() {
        myInfo.openDependents();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Assigned Dependents");
    }

    @Test(priority = 4)
    public void verifyImmigration() {
        myInfo.openImmigration();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Assigned Immigration Records");
    }

    @Test(priority = 5)
    public void verifyJob() {
        myInfo.openJob();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Job Details");
    }

    @Test(priority = 6)
    public void verifySalary() {
        myInfo.openSalary();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Assigned Salary Components");
    }

    @Test(priority = 7)
    public void verifyQualifications() {
        myInfo.openQualifications();
        Assert.assertEquals(myInfo.getSectionHeaderText(), "Qualifications");
    }

    @Test(priority = 8)
    public void verifyMemberships() {
        myInfo.openMemberships();
        Assert.assertEquals(myInfo.getSectionHeaderText(), " Assigned Memberships");
    }
}
