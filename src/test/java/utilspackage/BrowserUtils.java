package utilspackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BrowserUtils
{
    WebDriver driver;

    public void openBrowser(String name)
    {
        switch (name.toLowerCase())
        {
            case "chrome":
                Map<String, Object> prefs = new HashMap<>();

                prefs.put("profile.password_manager_leak_detection",false);

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs",prefs);
                options.addArguments("-disable-features=PasswordLeakDetection");

                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addPreference("signon.firefoxRelay.feature",false);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                Map<String, Object> prefs1 = new HashMap<>();

                prefs1.put("profile.password_manager_leak_detection",false);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setExperimentalOption("prefs",prefs1);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:throw new InvalidArgumentException("Invalid browser");
        }

    }

    public void maximizeBrowser()
    {
        driver.manage().window().maximize();
    }

    public WebDriver getDriver()
    {
        return driver;
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

    public void waitforElementLoad(int num)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }
}
