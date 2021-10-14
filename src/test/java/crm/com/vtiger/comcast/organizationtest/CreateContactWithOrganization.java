package crm.com.vtiger.comcast.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutility.ExcelfileUtility;
import com.crm.vtiger.genericutility.JSONfileUtility;
import com.crm.vtiger.genericutility.WebDriverUtility;
import com.crm.vtiger.genericutility.javaUtility;
import com.vtiger.autodesk.pomreposiratorylib.CreateNewContact;
import com.vtiger.autodesk.pomreposiratorylib.CreateNewOrganization;
import com.vtiger.autodesk.pomreposiratorylib.Home;
import com.vtiger.autodesk.pomreposiratorylib.Login;
import com.vtiger.autodesk.pomreposiratorylib.Organization;
import com.vtiger.autodesk.pomreposiratorylib.OrganizationInfo;
import com.vtiger.autodesk.pomreposiratorylib.organizationlookup;
@Test  
public class CreateContactWithOrganization 
{
public void CreateContactWithOrganization() throws Throwable
	 {
		// step1:Object creation of utility file
		  WebDriver driver=null;
		   WebDriverUtility wlib=new WebDriverUtility();
		   JSONfileUtility json=new JSONfileUtility();
		   ExcelfileUtility elib=new ExcelfileUtility();
		   javaUtility   ju=new javaUtility();
		//step2:read common data from json
		   String USERNAME=json.readDataFromJason("username");
		   String PASSWORD=json.readDataFromJason("password");
		   String URL=json.readDataFromJason("url");
		   String BROWSER=json.readDataFromJason("browser");
		//step3:read test data from excel
		   String LASTNAME=elib.getExcelData("contact", 5 , 2)+" "+ju.getRandomData();
		   String ORGNAME=elib.getExcelData("contact", 5 , 3)+" "+ju.getRandomData();
		//step4:launch browser
		   if(BROWSER.equals("chrome")) {
		    	driver=new ChromeDriver();
		    	}
		   else if(BROWSER.equals("firefox")){
			   driver=new FirefoxDriver();
		    }
		   else if(BROWSER.equals("opera")){
			   driver=new OperaDriver();
		    }
		   else {
			   driver=new ChromeDriver();
		   }
       //step5implicitywait util page load  and maximize
		   
		   wlib.waitUntilPageLoad(driver);
		   wlib.maximizeWindow(driver);
		   driver.get(URL);
		//step6:login to app
		   Login lp=new Login(driver);
		   lp.loginToApp(USERNAME, PASSWORD);
		   //step7:create org (precondition) 
		   Home hp=new Home(driver);
		   hp.getOrganizationLnk().click();
		   Organization op=new Organization(driver);
			 op.getCreateOrgImg().click();
			 CreateNewOrganization cnop=new CreateNewOrganization(driver);
			 {
			 cnop.createOrg(ORGNAME);
			 //step6:verify
			 OrganizationInfo orginfop=new OrganizationInfo(driver);
			 wlib.waitForElementVisibility(driver,  orginfop.getSuccessfullMsg());
			 
			String actSucMsg= orginfop.getSuccessfullMsg().getText();
			 if(actSucMsg.contains(ORGNAME)) {
				 System.out.println("org created sucessfully==>pass");}
				 else {
					 System.out.println("org not created sucessfully==>failed"); 
				 }
		//step6:navigate to contact link
			// wlib.waitForElementVisibility(driver, hp.getContactLnk());
			 hp.getContactLnk().click();
		//step7:navigate to create contact img and provide mandatory details and navigate to org lookup
			 
			 CreateNewContact cnc=new CreateNewContact(driver);
			 cnc.createconwithorg(LASTNAME, ORGNAME);
		
		//step9:switch to new window
	    //step10:navigate to search box provide org name
		//step11:click on search button and navigate to result and select org
			 wlib.switchToWindow(driver, "Accounts&action");
			 organizationlookup orglp= new organizationlookup(driver);
			 orglp.searchOrgInLookup(driver, ORGNAME);
		
		//step12:switch back to parent window
			 wlib.switchToWindow(driver, "Contacts&action");
		//step13:save and logout
			 cnc.getSaveBtn().click();
			 System.out.println("contact succsessfully created along with"+" "+ORGNAME +" ");
			 hp.logout();
			 driver.close();
		   }

	}
}
