package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;

public class FetcghingDataFromCustomSheet
{
    public static void main(String[] args)
    {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet newSheet = workbook.getSheet("LogInCustomSheet");

            int firstRow = newSheet.getFirstRowNum();

            int lastRow = newSheet.getLastRowNum();

            Row newrRow = newSheet.getRow(firstRow);

            int firstCell = newrRow.getFirstCellNum();

            int lastCell = newrRow.getLastCellNum();

            for(int r=firstRow+1;r<=lastRow;r++)
            {
                Row newRow = newSheet.getRow(r);

                for(int c=firstCell;c<lastCell;c++)
                {
                    System.out.print(newRow.getCell(c).toString()+" ~~");
                }
                System.out.println();
            }



        }
        catch (Exception e)
        {

            e.printStackTrace();
        }

    }
}
