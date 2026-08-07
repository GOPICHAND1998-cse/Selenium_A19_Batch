package screenshotpackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.time.Duration;

public class CapturingScreenshot
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.zepto.com/");

            Thread.sleep(2000);

            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File tempFile  = screenshot.getScreenshotAs(OutputType.FILE);

            File srcFile = new File("./ScreenshotFolder/CaptureSS.png");

            FileHandler.copy(tempFile,srcFile);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
