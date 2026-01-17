package utilites;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            System.out.println("Driver is null. Screenshot not captured.");
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String screenshotDir = System.getProperty("user.dir") + "/screenshots";
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();   // ✅ create folder
        }

        String screenshotPath =
                screenshotDir + "/" + testName + "_" + timestamp + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(screenshotPath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
