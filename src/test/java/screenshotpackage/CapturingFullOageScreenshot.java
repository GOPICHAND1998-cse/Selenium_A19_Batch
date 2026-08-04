package screenshotpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.time.Duration;

public class CapturingFullOageScreenshot
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

          driver.get("https://www.amazon.in/");

          TakesScreenshot screenshot = (TakesScreenshot) driver;

          Thread.sleep(2000);

          File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

          File srcFile = new File("./ScreenshotFolder/DemoSS.png");

          FileHandler.copy(tempFile,srcFile);

          WebElement searchIcon = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

          File tempElementFile = searchIcon.getScreenshotAs(OutputType.FILE);
          File srcElementFile = new File("./ScreenshotFolder/DemoElementSS.png");

          FileHandler.copy(tempElementFile,srcElementFile);

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
