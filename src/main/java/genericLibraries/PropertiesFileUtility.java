package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of reusable methods related to properties
 * @author sunil
 *
 */
public class PropertiesFileUtility {
	private Properties property;
	/**
	 * This method is used to read the data from properties
	 * @param path
	 */
	public void propertiesFileInitialization(String path)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to modify the data into properties file
	 * @param key
	 * @param value
	 * @param path
	 * @param message
	 */
	public void modifyPropertiesFile(String key, String value, String path, String message)
	{
		property.put(key, value);
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.store(fos, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch the property from properties file
	 * @param key
	 * @return
	 */
	public String fetchProperty( String key)
	{
		
		return property.getProperty(key);
	}
}
