package com.crm.vtiger.genericutility;

import java.util.Date;
import java.util.Random;

public class javaUtility {
	/**
	 * author @pratiksha
	 */
	
	/**
	 * this method is generate number to avoid duplicate
	 * @return
	 */
	 public static String getRandomData()
	 {
		 Random random=new Random();
		 int ran=random.nextInt(1000);
		 return ""+ran;
		 
	 }
	 /**
	  * @pratiksha
	  * this method will return the current date
	  * @return
	  */
	 public static String getCurrentDate() {
		 Date date=new Date();
		 String currentDate=date.toString();
		 return currentDate;
		 
	 }

}
