package com.crm.autodesk.tests;

import org.testng.annotations.Test;

import com.crm.vtiger.genericutility.BaseClass;
import com.vtiger.autodesk.pomreposiratorylib.ContactInformation;
import com.vtiger.autodesk.pomreposiratorylib.CreateNewContact;
import com.vtiger.autodesk.pomreposiratorylib.Home;

public class NotifyOwnerBoxIsEnableOrNotTest extends BaseClass {
	
	@Test(groups= {"smoketest"})
	public void NotifyOwnerBoxIsEnableOrNot() throws Throwable {
		
		 /*read test data*/
		   String LASTNAME=elib.getExcelData("contact", 1 , 2)+" "+ju.getRandomData();
		   String EXPMSG=elib.getExcelData("contact", 3 , 2);
		   //step3:navigate to contact page
		   Home hp=new Home(driver);
		   hp.getContactLnk().click();
		   
		   //step4:click on create contact icon
		   CreateNewContact cnc=new CreateNewContact(driver);
		   cnc.createcon(LASTNAME);
		   //step5:verify the contact with donotcallbox
		   ContactInformation coninfo=new ContactInformation(driver);
		   wlib.waitForElementVisibility(driver, coninfo.getNotifyMsg());
		  String actualmsg = coninfo.getNotifyMsg().getText();
		  System.out.println(actualmsg);
		  if(actualmsg.contains(EXPMSG)) {
			  System.out.println("Notify Owner Box not Enable");}
			  else {
				  System.out.println("Notify Owner Box Enable");
			  }
	}
}
