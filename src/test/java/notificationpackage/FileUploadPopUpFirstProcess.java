package notificationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadPopUpFirstProcess
{
    public static void main(String[] args) throws Exception
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://demoqa.com/upload-download");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@id='uploadFile']"))
                .sendKeys("src\\test\\resources\\DummyUpload.txt");
    }
}
