package notificationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HandlingSavePasswordManagerPopUP
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new FirefoxDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));

          driver.get("https://www.zoho.com/crm/free-crm.html");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

          driver.findElement(By.xpath("//a[text()='Sign In']"))
                  .click();

          driver.findElement(By.xpath("//input[@id='login_id']"))
                  .sendKeys("");

          driver.findElement(By.xpath("//button[@id='nextbtn']"))
                  .click();

          driver.findElement(By.xpath("//input[@id='password']"))
                  .sendKeys("");




          driver.navigate().to("");










          driver.findElement(By.xpath("//button[@id='nextbtn']"))
                  .click();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
