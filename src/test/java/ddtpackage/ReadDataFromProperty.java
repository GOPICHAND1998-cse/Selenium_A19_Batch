package ddtpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
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

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            driver.findElement(By.xpath("//input[@id='user-name']"))
                    .sendKeys(user);

            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys(password);

            driver.findElement(By.xpath("//input[@id='login-button']"))
                    .click();

            driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"))
                    .click();

            String selectedProductName = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"))
                    .getText();

            FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonDataFolder/Config.properties");

            property.setProperty("ProductName",selectedProductName);

            property.store(fos,"Updated by SDET Pritam");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
