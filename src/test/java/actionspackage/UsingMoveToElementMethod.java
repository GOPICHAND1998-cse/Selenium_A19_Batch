package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class UsingMoveToElementMethod
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

            driver.get("https://drdo.gov.in/drdo/en/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.moveToElement(driver.findElement(By.xpath("//a[text()='Organisation']")))
                    .pause(Duration.ofSeconds(1))
                    .perform();

            // click on technology cluster link from drop down
            action.click(driver.findElement(By.xpath("//ul[@class='navbar-nav menu new-dropdown-content']/child::li/child::a[text()='Technology Clusters']")))
                    .perform();

            action.click(driver.findElement(By.xpath("//button[text()='Deny all']")))
                            .perform();

            action.moveToElement(driver.findElement(By.xpath("//div[@class='view-content']/descendant::div[.='Armament & Combat Engineering Systems (ACE)']")))
                    .perform();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
