package com.crm.autodeskFrameworkSelenium.genericUtility;

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
	public String getPropertyKeyValue(String key) {
		FileInputStream fis;
		String value=null;
		try {
			fis = new FileInputStream(IPathConstants.PROPERTYFILE_PATH);
			Properties prop = new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
