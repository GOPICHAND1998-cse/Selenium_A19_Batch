package utilspackage;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtils
{
    FileInputStream fis;

    public String getConfigData(String key)
    {
        String data;

        try
        {
            fis = new FileInputStream("./src/test/resources/CommonDataFolder/Config.properties") ;

            Properties property = new Properties();

            property.load(fis);
            data = property.getProperty(key);

            return data;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
