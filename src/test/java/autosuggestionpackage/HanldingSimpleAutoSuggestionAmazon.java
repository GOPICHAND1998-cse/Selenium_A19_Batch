package autosuggestionpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HanldingSimpleAutoSuggestionAmazon
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new FirefoxDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

          driver.get("https://www.amazon.in/");

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")))
                  .sendKeys("Samsung Galaxy s26");

          List<WebElement> allSuggestions = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='two-pane-results-container']/descendant::div[@role='row']/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"))));

          for(WebElement suggestion : allSuggestions)
          {
            if (suggestion.getText().equals("samsung galaxy s26 fe"))
              {
                  suggestion.click();
                  break;
              }
          }

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
