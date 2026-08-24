package ddtpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pompackage.LogInPagePOM;
import utilspackage.ActionsUtils;
import utilspackage.BrowserUtils;
import utilspackage.PropertyFileUtils;



public class LogInUsingUtils
{
    public static String user;
    public static String password;
    public static String browser;
    public static String url;

  static PropertyFileUtils property = new PropertyFileUtils();
  static BrowserUtils browserUtil = new BrowserUtils();

  static WebDriver driver;

    public static void main(String[] args) {

        try
        {
         user = property.getConfigData("user");
         url = property.getConfigData("url");
         browser = property.getConfigData("browser");
         password = property.getConfigData("password");

         browserUtil.openBrowser(browser);
         browserUtil.maximizeBrowser();
         browserUtil.openURL(url);
         browserUtil.waitForPageLoad(10);
         browserUtil.waitforEleentLoad(10);

         driver= browserUtil.getDriver();

            ActionsUtils action = new ActionsUtils(driver);

            LogInPagePOM logIn = new LogInPagePOM(driver);

//         driver.findElement(By.xpath("//input[@id='user-name']"))
//                 .sendKeys("standard_user");
//
//         driver.findElement(By.xpath("//input[@id='password']"))
//                 .sendKeys("secret_sauce");
//
//         driver.findElement(By.xpath("//input[@id='login-button']"))
//                 .click();

            action.writeInInputField(logIn.getUserNameField(),user);
            action.writeInInputField(logIn.getPasswordField(),password);
            action.clickOnElement(logIn.getLogInButton());




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
