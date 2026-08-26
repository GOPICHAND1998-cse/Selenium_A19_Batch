package orangehrmpompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMSideMenuPOM
{
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement seacrchField;

    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement adminLink;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElement pimLink;

    public OrangeHRMSideMenuPOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getSeacrchField() {
        return seacrchField;
    }

    public WebElement getAdminLink() {
        return adminLink;
    }

    public WebElement getPimLink() {
        return pimLink;
    }
}
