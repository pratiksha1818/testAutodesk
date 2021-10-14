package com.crm.autodesk.tests;

import org.testng.annotations.Test;

import com.crm.vtiger.genericutility.BaseClass;
import com.crm.vtiger.genericutility.ExcelfileUtility;
import com.vtiger.autodesk.pomreposiratorylib.ContactInformation;
import com.vtiger.autodesk.pomreposiratorylib.CreateNewContact;
import com.vtiger.autodesk.pomreposiratorylib.Home;

public class CreateContactTest extends BaseClass {
	@Test(groups= {"smoketest"})
public void CreateContact()  throws Throwable {
	  /*read test data*/
	 String LASTNAME=elib.getExcelData("sheet1", 3 , 2)+" "+ju.getRandomData();
	 //step:navigate to contact page
	   Home hp=new Home(driver);
	   hp.getContactLnk().click();
	   //step4:click on create contact icon
	   CreateNewContact cnc=new CreateNewContact(driver);
	   cnc.createcon(LASTNAME);
	   ContactInformation coninfo=new ContactInformation(driver);
		  String actualmsg = coninfo.getSuccessfullMsg().getText();
		   if(actualmsg.contains(LASTNAME) ) {
			   System.out.println("contact created sucessfully");}
			 else{
			System.out.println("contact Not created sucessfully");
		 }
		   @Test(groups= {"smoketest"})
		   public void CreateContact()  throws Throwable {
}
}
