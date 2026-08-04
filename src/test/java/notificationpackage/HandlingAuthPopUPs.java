package notificationpackage;

import org.openqa.selenium.Credentials;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.function.Supplier;

public class HandlingAuthPopUPs
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            HasAuthentication auth = (HasAuthentication)driver;

//            auth.register(new Supplier<Credentials>() {
//                @Override
//                public Credentials get() {
//                    return new UsernameAndPassword("admin","admin");
//                }
//            });

            auth.register(()-> new UsernameAndPassword("admin","admin"));

            driver.get("https://the-internet.herokuapp.com/basic_auth");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
