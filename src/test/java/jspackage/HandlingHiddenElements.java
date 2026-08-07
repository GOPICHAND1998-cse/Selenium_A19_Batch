package jspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingHiddenElements
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.facebook.com/reg/?entry_point=login&next=");

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

           WebElement customGendar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Gender (optional)']/preceding-sibling::input")));

            JavascriptExecutor executor = (JavascriptExecutor)driver;

            executor.executeScript("arguments[0].value='Sunflower'",customGendar);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
