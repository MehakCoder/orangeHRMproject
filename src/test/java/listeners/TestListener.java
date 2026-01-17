// listeners/TestListener.java
package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testcases.BaseTest;

public class TestListener implements ITestListener {

    private static final DateTimeFormatter TS_FMT = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        try {
            driver = BaseTest.getDriver(); // ensure this returns the correct WebDriver (ThreadLocal-safe)
            if (driver == null) {
                Reporter.log("Screenshot skipped: WebDriver is null for " + result.getName());
                return;
            }
            if (!(driver instanceof TakesScreenshot)) {
                Reporter.log("Screenshot skipped: driver does not support TakesScreenshot");
                return;
            }

            String name = result.getTestClass().getName() + "_" + result.getName();
            String ts = LocalDateTime.now().format(TS_FMT);
            Path destDir = Paths.get("screenshots");
            Files.createDirectories(destDir);
            Path dest = destDir.resolve(name + "_" + ts + ".png");

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);

            Reporter.log("Saved screenshot: " + dest.toString());
            // Optionally add HTML link to TestNG report:
            Reporter.log("<a href=\"" + dest.toString() + "\">Screenshot</a>");
        } catch (IOException e) {
            Reporter.log("Failed to save screenshot: " + e.getMessage());
        } catch (Exception e) {
            Reporter.log("Screenshot error: " + e.toString());
        }
    }

    // other ITestListener methods can be left empty or implemented as needed
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}
