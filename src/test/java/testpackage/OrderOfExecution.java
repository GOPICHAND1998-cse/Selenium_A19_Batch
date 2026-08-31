package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrderOfExecution
{
    @Test(priority = 1)
    public void logIn()
    {
        Reporter.log("Login is succesful",true);
    }

    @Test(priority = 2)
    public void friendRequest()
    {
        Reporter.log("FriendRequest is Sent",true);
    }

    @Test(priority = 3)
    public void notification()
    {
        Reporter.log("Friend Request Notification is received",true);
    }
}
