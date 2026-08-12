package ddtpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromProperty
{
    static WebDriver driver;
    static String browser;
    static String url;
    static String user;
    static String password;

    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFolder/Config.properties");

            Properties property = new Properties();

            property.load(fis);

            browser = property.getProperty("browser");
            url = property.getProperty("url");
            user = property.getProperty("user");
            password = property.getProperty("password");


            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default: throw new Exception("Invalid BrowserName");
            }

            driver.get(url);



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
