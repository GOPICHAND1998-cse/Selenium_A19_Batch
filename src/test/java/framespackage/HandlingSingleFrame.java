package framespackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingSingleFrame
{
    public static void main(String[] args)
    {
        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

            driver.get("https://anniebesant.org/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            Actions actions = new Actions(driver);

            actions.scrollToElement(driver.findElement(By.xpath("//p[contains(text(),\"2007 - 2026 All Rights Reserved © Annie Besant Women's College\")]")))
                    .perform();

            Thread.sleep(2000);

//            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'https://www.google.com/maps/embed?pb')]")));

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@src,'https://www.google.com/maps/embed?pb')]")));

//            driver.switchTo().frame(1);

            driver.findElement(By.xpath("//button[@aria-label='Show street map']"))
                    .click();

//            driver.switchTo().;

            

            driver.findElement(By.xpath("//a[text()='About us']"))
                    .click();



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
