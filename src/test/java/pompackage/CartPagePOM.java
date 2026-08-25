package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePOM
{
    @FindBy(xpath = "//div[@data-test='inventory-item']")
    private WebElement productCards;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkOutButton;

    public CartPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getProductCards() {
        return productCards;
    }

    public WebElement getCheckOutButton() {
        return checkOutButton;
    }
}
