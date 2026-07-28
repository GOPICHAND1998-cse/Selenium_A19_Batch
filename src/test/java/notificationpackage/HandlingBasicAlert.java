package notificationpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingBasicAlert
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://vinothqaacademy.com/alert-and-popup/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          driver.findElement(By.xpath("//button[text()='Alert Box']"))
                  .click();

          Thread.sleep(2000);

          Alert alert  = driver.switchTo().alert();

          alert.accept();

          Thread.sleep(2000);

          driver.findElement(By.xpath("//button[text()='Confirm Alert Box']"))
                  .click();

          Thread.sleep(2000);

          alert.dismiss();

          Thread.sleep(2000);

          driver.findElement(By.xpath("//button[text()='Prompt Alert Box']"))
                  .click();

          Thread.sleep(2000);

          alert.sendKeys("Yes");

          Thread.sleep(1000);

//          alert.accept();

          alert.dismiss();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
