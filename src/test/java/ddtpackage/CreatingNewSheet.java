package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreatingNewSheet
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet newSheet = workbook.createSheet("NewLogInSheet");

            Row newSheetRow =newSheet.createRow(0);

            newSheetRow.createCell(0).setCellValue("New Dummy Data");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            workbook.write(fos);

            workbook.close();


        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
}
