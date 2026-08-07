package jspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingDisabledElement
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new ChromeDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

          driver.get("https://practicetestautomation.com/practice-test-exceptions/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          JavascriptExecutor executor = (JavascriptExecutor) driver;

          WebElement foodInputField = driver.findElement(By.cssSelector("input.input-field"));

          executor.executeScript("arguments[0].removeAttribute(\"disabled\")",foodInputField);

          foodInputField.clear();

          foodInputField.sendKeys("Achari Paneer Tikka");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
