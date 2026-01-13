package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties prop;

    @BeforeClass
    public void setup() throws IOException {

        // ✅ Initialize Properties
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/config.properties"
        );
        prop.load(fis);

        // ✅ Initialize Driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Initialize Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ✅ Open URL
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
