package jspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClickingUSingJS
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            WebElement ourFlag = driver.findElement(By.cssSelector("img[src='/images/flags/w240/in.webp']"));

            WebElement italyFlag= driver.findElement(By.xpath("//img[@src='/images/flags/w240/it.webp']"));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

//            executor.executeScript("document.querySelector(\"img[src='/images/flags/w240/in.webp']\").click()");

            executor.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'start'});arguments[1].click()",italyFlag,ourFlag);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

