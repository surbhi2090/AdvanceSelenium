package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility
{
	/**
	 * This method is used for login to vtiger application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Mittal
	 */
	public String getKeyAndValuePair(String Key) throws Throwable
	{

		FileInputStream login = new FileInputStream("./src/test/resources/VtigerLoginPropertiesFile7pm.properties");
		Properties pro = new Properties();
		pro.load(login);
		
		String Value = pro.getProperty(Key);
		return Value;
	}
}
