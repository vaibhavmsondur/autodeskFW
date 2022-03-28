package com.crm.autodeskSelenium.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * It is developed to use property file
 * @author VAIBHAV
 *
 */
public class FileUtility {
	
	/**
	 * it is used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\main\\resources\\commonData\\credentials.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
}
