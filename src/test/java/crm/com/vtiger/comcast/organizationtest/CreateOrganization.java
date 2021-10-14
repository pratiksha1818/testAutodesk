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
import com.vtiger.autodesk.pomreposiratorylib.CreateNewOrganization;
import com.vtiger.autodesk.pomreposiratorylib.Home;
import com.vtiger.autodesk.pomreposiratorylib.Login;
import com.vtiger.autodesk.pomreposiratorylib.Organization;
import com.vtiger.autodesk.pomreposiratorylib.OrganizationInfo;
@Test  
public class CreateOrganization  {
	public void CreateOrganization() throws Throwable
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
	   String ORGNAME=elib.getExcelData("sheet1", 1 , 2)+" "+ju.getRandomData();
	   
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
	   //step3:navigate to organization
	   Home hp=new Home(driver);
	   hp.getOrganizationLnk().click();
	   //step4:create organization
	 Organization op=new Organization(driver);
	 op.getCreateOrgImg().click();
	   //step5:create org
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
		 //step7:logout
		 hp.logout();
		 //step:8
		 driver.close();
		 
	 }
		 
	 }	   
}
