package com.crm.vtiger.genericutility;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

/**
 * 
 * @author pratiksha
 *
 */
public class JSONfileUtility {
	/**
	 * this methods reads the data from json file
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String readDataFromJason(String key) throws Throwable
	{
		//read the data from json file
		FileReader file=new FileReader("./Data//commondata.json");
		//convert the json file into java object
		JSONParser jsonobj=new JSONParser();
		Object jobj=jsonobj.parse(file);
		//type cast java obj to hashmap
		HashMap map=(HashMap)jobj;
		String value=map.get(key).toString();
		//return value
		return value;

		
	} 
}

