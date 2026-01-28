package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.applitools.eyes.selenium.Eyes;

public class BaseTest {

    protected static WebDriver driver;
    protected Properties prop;
    protected Eyes eyes;

    public static WebDriver getDriver() {
        return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws IOException {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    options
            );

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444"),
                    options
            );
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        FileInputStream fs = new FileInputStream(
            "D:\\seleniumwebdriver\\Automationproject\\organehrm\\src\\main\\java\\configration\\config.properties"
        );
        prop = new Properties();
        prop.load(fs);

        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
