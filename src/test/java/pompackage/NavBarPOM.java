package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPOM
{
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuIcon;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement cartIcon;

    public NavBarPOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getMenuIcon() {
        return menuIcon;
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }
}
