package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UsingClickAndHoldMethod
{
    public static void main(String[] args) {

        try{

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            driver.get("https://yonobusiness.sbi.bank.in/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            Actions action = new Actions(driver);

            action.click(driver.findElement(By.xpath("//span[@class='ng-tns-c2785778308-3 icon-cancel']")))
                    .pause(Duration.ofSeconds(1))
                    .click(driver.findElement(By.xpath("//div[@id='login-dropdown']")))
                    .pause(Duration.ofSeconds(1))
                    .click(driver.findElement(By.xpath("//li[@id='loginOfmenu']")))
                    .perform();

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

            Thread.sleep(2000);

            List<String> lang = new ArrayList();

            lang.add("\"Ruby\",\"Javascript\",\"Python\"");


            WebElement passwordField = wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))));

           action.sendKeys(passwordField,"Password@1234")
                   .pause(Duration.ofSeconds(2))
                   .clickAndHold(driver.findElement(By.xpath("//img[@src='assets/img/Revamp/icon_eye_close.svg']")))
                   .pause(Duration.ofSeconds(2))
                   .release()
                   .perform();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
