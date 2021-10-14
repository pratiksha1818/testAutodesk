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
import com.vtiger.autodesk.pomreposiratorylib.ContactInformation;
import com.vtiger.autodesk.pomreposiratorylib.CreateNewContact;
import com.vtiger.autodesk.pomreposiratorylib.Home;
import com.vtiger.autodesk.pomreposiratorylib.Login;
@Test  
public class CreateContact {
	
	public void  CreateContact() throws Throwable
	{
		 /*Create objects*/
		   WebDriver driver=null;
		   WebDriverUtility wlib=new WebDriverUtility();
		   JSONfileUtility json=new JSONfileUtility();
		   ExcelfileUtility elib=new ExcelfileUtility();
		   javaUtility   ju=new javaUtility();
		   /*read common data from json*/
		   String USERNAME=json.readDataFromJason("username");
		   String PASSWORD=json.readDataFromJason("password");
		   String URL=json.readDataFromJason("url");
		   String BROWSER=json.readDataFromJason("browser");
		   /*read test data*/
		   String LASTNAME=elib.getExcelData("sheet1", 3 , 2)+" "+ju.getRandomData();
		   
		   /*step:launch browser*/
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
			   System.out.println("invalid browser");
		   }
		   //implicitywait util page load  and maximize
		   
		   wlib.waitUntilPageLoad(driver);
		   wlib.maximizeWindow(driver);
		   driver.get(URL);
		   //Step2:login to application
		   Login lp=new Login(driver);
		   lp.loginToApp(USERNAME, PASSWORD);
		   //step3:navigate to contact page
		   Home hp=new Home(driver);
		   hp.getContactLnk().click();
		   
		   //step4:click on create contact icon
		   
		   
		   CreateNewContact cnc=new CreateNewContact(driver);
		   cnc.createcon(LASTNAME);
		   //step5:verify the contact with expected lastname
		   ContactInformation coninfo=new ContactInformation(driver);
		  String actualmsg = coninfo.getSuccessfullMsg().getText();
		   if(actualmsg.contains(LASTNAME) ) {
			   System.out.println("contact created sucessfully");}
			   else{
				   System.out.println("contact Notcreated sucessfully");
			   }
		   //step6:logout
			 hp.logout();
			 //step:7
			 driver.close();
		   }
				   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
	}		   

