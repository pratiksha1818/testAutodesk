package com.crm.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * this class contains generic methods to read data from property file
 * @author pratikshsa
 *
 */
public class PropertyFileUtility {
/**
 * this method read data from proprty file
 * @throws Throwable 
 * 
 */
	 public String getPropertyFileData(String key) throws Throwable {
		 FileInputStream fis =new FileInputStream("./data//commondata.properties");
		 Properties p=new Properties();
		 p.load(fis);
		 String value=p.getProperty(key);
		 return value;
		 
	 }
}
