package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pompackage.CartPagePOM;
import pompackage.InventoryPagePOM;
import pompackage.LogInPagePOM;
import pompackage.NavBarPOM;
import utilspackage.ActionsUtils;
import utilspackage.BrowserUtils;
import utilspackage.PropertyFileUtils;

public class Using_POM_Utils
{
    public static String user;
    public static String password;
    public static String browser;
    public static String url;

    static PropertyFileUtils property = new PropertyFileUtils();
    static BrowserUtils browserUtil = new BrowserUtils();
    static ActionsUtils action;
    static LogInPagePOM login;
    static NavBarPOM navBar;
    static InventoryPagePOM inventory;
    static CartPagePOM cart;

    static WebDriver driver;

    public static void main(String[] args)
    {
        try
        {
          browser = property.getConfigData("browser");
          url = property.getConfigData("url");
          user = property.getConfigData("user");
          password = property.getConfigData("password");

          browserUtil.openBrowser(browser);
          browserUtil.openURL(url);
          browserUtil.maximizeBrowser();
          browserUtil.waitforElementLoad(10);

          driver = browserUtil.getDriver();

          action = new ActionsUtils(driver);

          login = new LogInPagePOM(driver);
          inventory = new InventoryPagePOM(driver);
          cart = new CartPagePOM(driver);
          navBar = new NavBarPOM(driver);

          action.writeInInputField(login.getUserNameField(),user);
          action.writeInInputField(login.getPasswordField(),password);
          action.clickOnElement(login.getLogInButton());

          for(WebElement product : inventory.getAllProducts())
          {
               String productName = product.findElement(By.xpath(".//descendant::div[contains(@class,'inventory_item_name')]")).getText();

               if (productName.equals("Sauce Labs Bolt T-Shirt"))
               {
                   product.findElement(By.xpath(".//descendant::button")).click();
                   break;
               }
          }

          action.clickOnElement(navBar.getCartIcon());

          action.clickOnElement(cart.getCheckOutButton());




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
