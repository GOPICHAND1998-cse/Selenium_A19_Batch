package testpackage;

import orangehrmpompackage.OrangeHRMLogInPagePOM;
import orangehrmpompackage.OrangeHRMSideMenuPOM;
import org.openqa.selenium.WebDriver;
import utilspackage.ActionsUtils;
import utilspackage.BrowserUtils;
import utilspackage.PropertyFileUtils;

public class LogInToAdminOrangeHRM
{
    public static String orangeHrmUser;
    public static String orangeHrmlPassword;
    public static String orangeHrmUrl;
    public static String browser;

    public static PropertyFileUtils property ;
    public static BrowserUtils browserUtil;
    public static ActionsUtils action;

    public static OrangeHRMLogInPagePOM logIn;
    public static OrangeHRMSideMenuPOM sideMenu;

    public static WebDriver driver;

    public static void main(String[] args)
    {

       property = new PropertyFileUtils();

       browser = property.getConfigData("browser");
       orangeHrmUser = property.getConfigData("orangeHrmUser");
       orangeHrmlPassword = property.getConfigData("orangeHrmlPassword");
       orangeHrmUrl = property.getConfigData("orangeHrmUrl");

       browserUtil = new BrowserUtils();

       browserUtil.openBrowser(browser);

       browserUtil.openURL(orangeHrmUrl);

       browserUtil.waitForPageLoad(10);

       browserUtil.waitforElementLoad(20);

       browserUtil.maximizeBrowser();

       driver = browserUtil.getDriver();

       action = new ActionsUtils(driver);

       logIn = new OrangeHRMLogInPagePOM(driver);

       sideMenu = new OrangeHRMSideMenuPOM(driver);

       action.writeInInputField(logIn.getUserNameField(),orangeHrmUser);
       action.writeInInputField(logIn.getPasswordField(),orangeHrmlPassword);
       action.clickOnElement(logIn.getLogInButton());

       action.clickOnElement(sideMenu.getPimLink());







    }
}
