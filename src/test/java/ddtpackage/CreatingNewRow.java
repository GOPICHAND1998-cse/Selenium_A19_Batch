package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreatingNewRow
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("LogInSheet");

            Row newRow = sheet.createRow(6);

            newRow.createCell(0).setCellValue("dummyMail@gmail.com");

            newRow.createCell(1).setCellValue("Password@12345");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            workbook.write(fos);

            workbook.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
