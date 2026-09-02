package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingInvocationCount
{
//    @Test
//    public void login1()
//    {
//        for(int i=0;i<=5;i++)
//        {
//            Reporter.log("LogIn 1 is successful",true);
//        }
//
//        Reporter.log("Dummy test",true);
//    }

    @Test(invocationCount = 5)
    public void doLogIn2()
    {
        Reporter.log("LogIn 2 is successful",true);

        Reporter.log("Dummy test",true);
    }
}
