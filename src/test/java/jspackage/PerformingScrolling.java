package jspackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PerformingScrolling
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

            JavascriptExecutor executor = (JavascriptExecutor) driver;

            executor.executeScript("document.querySelector(\"a[href='/images/flags/original/it.webp']\").scrollIntoView({\n" +
                    "    behavior: \"smooth\", block : \"start\"});");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
