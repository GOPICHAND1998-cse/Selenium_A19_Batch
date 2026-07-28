package notificationpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NotificationPopUp
{
    public static void main(String[] args) {

        try
        {
//            ChromeOptions options = new ChromeOptions();
//
//            options.setBinary("C:\\Users\\User\\AppData\\Local\\Programs\\Opera\\opera.exe");

//            Map<String, Object> prefs = new HashMap<>();
//
//            prefs.put("profile.default_content_setting_values.geolocation",2);
//
//            ChromeOptions options = new ChromeOptions();
//
//            options.setExperimentalOption("prefs",prefs);
//
//            options.addArguments("--disable-notifications");
//
//            WebDriver driver = new ChromeDriver(options);

            FirefoxOptions options = new FirefoxOptions();

            options.addPreference("dom.webnotifications.enabled",false);
            options.addPreference("geo.enabled",false);

            WebDriver driver = new FirefoxDriver(options);

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.easemytrip.com/");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
