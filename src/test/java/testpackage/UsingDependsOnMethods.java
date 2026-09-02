package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingDependsOnMethods
{
    //dependsOnMethods----> one functionality using which we can establish the dependency between two or more test methods
    // We Will use one Attribute ~ dependsOnMethods

    @Test(enabled = false)
    public void logIn()
    {
        Reporter.log("LogIn is successful",true);
    }

    @Test(dependsOnMethods = "logIn")
    public void searchProduct()
    {
        Reporter.log("Product is searched",true);
    }

    @Test(dependsOnMethods = "searchProduct")
    public void selectDesiredProduct()
    {
        Reporter.log("The desired product is selected",true);
    }
    @Test(dependsOnMethods = "selectDesiredProduct")
    public void addProductToCart()
    {
        Reporter.log("The product is added to cart",true);
    }
    @Test(dependsOnMethods = "addProductToCart")
    public void goToCart()
    {
        Reporter.log("Redirected to Cart page",true);
    }
    @Test(dependsOnMethods = {"GoToCart","addProductToCart"})
    public void purchaseProduct()
    {
        Reporter.log("Product is purchased",true);
    }
}
