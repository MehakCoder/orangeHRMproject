package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    public void setUp() throws IOException {

        // 1️⃣ Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 2️⃣ Load config
        FileInputStream fs = new FileInputStream(
                "D:\\seleniumwebdriver\\Automationproject\\organehrm\\src\\main\\java\\configration\\config.properties");
        prop = new Properties();
        prop.load(fs);

        // 3️⃣ Open application URL ONLY
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
