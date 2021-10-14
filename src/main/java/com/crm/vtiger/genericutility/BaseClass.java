package com.crm.vtiger.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtiger.autodesk.pomreposiratorylib.Home;
import com.vtiger.autodesk.pomreposiratorylib.Login;

/**
 * this method contains basic configuration annotation of testNG
 * @author adran
 *
 */
public class BaseClass {
	  public WebDriver driver;
	   //public   DataBaseUtility dlib= new DataBaseUtility();
	   public JSONfileUtility jlib=new JSONfileUtility();
	   public    WebDriverUtility wlib=new WebDriverUtility();
	   public    JSONfileUtility json=new JSONfileUtility();
	   public   ExcelfileUtility elib=new ExcelfileUtility();
	   public   javaUtility   ju=new javaUtility();
	   @BeforeSuite(groups= {"regressiontest","smoketest"})
	   public void coonectDb() {
		   //dLib.connectToDB();
		   System.out.println("====DB connecting sucessfull====");
	   }
	  @Parameters(value={"browser"}) //chrome,firefox
	   @BeforeClass(groups= {"regressiontest","smoketest"})
	   //public void launBrowser() throws Throwable {
	   public void launcbrowser(@Optional("chrome") String browserValue) throws Throwable {
		  System.out.println("launching browser:"+browserValue );
		   //read data from jason
		   String URL=json.readDataFromJason("url");
		   //String BROWSER=json.readDataFromJason("browser");
		   if(browserValue.equals("chrome")) {
		    	driver=new ChromeDriver();
		    	}
		   else if(browserValue.equals("firefox")){
			   driver=new FirefoxDriver();
		    }
		   else if(browserValue.equals("opera")){
			   driver=new OperaDriver();
		    }
		   else {
			   System.out.println("invalid browser");
		   }
		   System.out.println("browser launching succesfully");
		   wlib.maximizeWindow(driver);
		   wlib.waitUntilPageLoad(driver);
		   driver.get(URL);
	   }
	   @BeforeMethod(groups= {"regressiontest","smoketest"})
	   public void loginToApp() throws Throwable {
		   //read data from jason file
		   String USERNAME=json.readDataFromJason("username");
		   String PASSWORD=json.readDataFromJason("password");
		   //login to app
		   Login lp=new Login(driver);
		   lp.loginToApp(USERNAME, PASSWORD);
		   System.out.println("====login to app sucessfull====");
	   }
	   @AfterMethod(groups= {"regressiontest"})
	   public void logoutfromapp() {
		   Home hp=new Home(driver);
		   hp.logout();
	   System.out.println("===logout from the app===");
	   }
	   @AfterClass(groups= {"regressiontest","smoketest"})
	   public void closeBrowser() {
		   driver.close();
		   System.out.println("====browser closed succesfully===");
	   }
	   @AfterSuite(groups= {"regressiontest","smoketest"})
	   public void closeDB() {
		   //dLib.closeDb();
		   System.out.println("==DB connection close==");
		   
		   
		   
		   
		   
	   }
	   

}
