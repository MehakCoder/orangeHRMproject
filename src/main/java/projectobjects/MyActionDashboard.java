package projectobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyActionDashboard extends Dashboard {

	WebDriverWait wait;

	public MyActionDashboard(WebDriver driver) {
		super(driver);//connect Dashboard.java
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//-------Pending Self Review-------------
	public void clickPendingSelfReview() {
		wait.until(ExpectedConditions.elementToBeClickable(pendingSelfReview)).click();
	}
	
	public boolean isManageReviewsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(manageReviewsHeader)).isDisplayed();
	}
	
	//Candidate to Interview
	public void clickCandidateToInterview() {
		wait.until(ExpectedConditions.elementToBeClickable(candidateToInterview)).click();
	}
	
	public boolean isRecruitmentPageDisplayed() {
		        return wait.until(ExpectedConditions.visibilityOf(recruitmentHeader))
		                   .isDisplayed();
		    
	}
	
}
