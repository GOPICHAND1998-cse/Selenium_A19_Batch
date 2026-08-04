package webdriverpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExecution
{
    public static void main(String[] args) throws Exception {

        WebDriver driver  = new ChromeDriver();

        driver.get("https://www.amazon.in/");

        Thread.sleep(4000);

        System.out.println(driver.getTitle());

    }
}
