package utilspackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserUtils
{
    WebDriver driver;

    public void openBrowser(String name)
    {
        switch (name.toLowerCase())
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:throw new InvalidArgumentException("Invalid browser");
        }

    }

    public void maximizeBrowser()
    {
        driver.manage().window().maximize();

    }

    public void openURL(String url)
    {
        driver.get(url);
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void waitForPageLoad(int num)
    {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(num));
    }

    public void waitforEleentLoad(int num)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }
}
