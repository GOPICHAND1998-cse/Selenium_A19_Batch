package robotpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class PerformingMouseActions
{
    public static void main(String[] args)
    {
      try
      {
//          WebDriver driver = new ChromeDriver();
//
//          driver.manage().window().maximize();

          Robot robot = new Robot();

          Thread.sleep(2000);

//          robot.mouseMove(500,500);
//
//          Thread.sleep(2000);
//
//          robot.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
//          robot.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);

//          robot.mouseWheel(30);

          robot.keyPress(KeyEvent.VK_WINDOWS);
          robot.keyRelease(KeyEvent.VK_WINDOWS);

          Thread.sleep(2000);

          robot.keyPress(KeyEvent.VK_I);
          robot.keyRelease(KeyEvent.VK_I);

          Thread.sleep(2000);

          robot.keyPress(KeyEvent.VK_N);
          robot.keyRelease(KeyEvent.VK_N);



      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
