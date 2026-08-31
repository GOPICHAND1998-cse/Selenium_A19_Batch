package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTestNGScript
{
    @Test
    public void m2()
    {
        Reporter.log("This is an dummy Test Method2",true);
    }

    @Test
    public void m4()
    {
        Reporter.log("This is an dummy Test Method4",true);
    }

    @Test
    public void m1()
    {
        Reporter.log("This is an dummy Test Method1",true);
    }

    @Test
    public void m3()
    {
        Reporter.log("This is an dummy Test Method3",true);
    }
}


