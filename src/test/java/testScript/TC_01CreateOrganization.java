package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutility.ExcelfileUtility;
import com.crm.vtiger.genericutility.JSONfileUtility;
import com.crm.vtiger.genericutility.WebDriverUtility;
import com.crm.vtiger.genericutility.fileUtility;
import com.crm.vtiger.genericutility.javaUtility;


public class TC_01CreateOrganization {
	
@Test
public static void createOraganization() throws Throwable {
	WebDriver driver=null;

      //create object of all necesarry classes
		JSONfileUtility jsonLib=new JSONfileUtility();
		javaUtility jau=new javaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelfileUtility eu=new ExcelfileUtility();
		
		
		//read common data
		String USERNAME = jsonLib.readDataFromJason("username");
		String PASSWORD = jsonLib.readDataFromJason("password");
		String URL = jsonLib.readDataFromJason("url");
		String BROWSER = jsonLib.readDataFromJason("browser");
		String OrganizationName =eu.getExcelData("sheet1", 1, 2);
       

       
     //choose browser
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("opera")) {
			driver=new OperaDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		//implicit wait until all page load fully
			wlib.waitUntilPageLoad(driver);
			wlib.maximizeWindow(driver);
			driver.get(URL);
		//login to page
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			//create Organizations 
			   driver.findElement(By.linkText("Organizations")).click();
	           driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	          driver.findElement(By.xpath("//table[@class='small']/tbody/tr[3]/td[2]/input[@name='accountname']")).sendKeys(OrganizationName+" "+jau.getRandomData());
	          driver.findElement(By.xpath("//table[@class='small']/tbody/tr[1]/td[1]/div/input[@name='button']")).click();
	          Thread.sleep(2000);
	         
	          WebElement signout= driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
	          wlib.mouseOver(driver,signout);
	          driver.findElement(By.linkText("Sign Out")).click();
	          }
  // http://localhost:8888/index.php?action=DetailView&module=Accounts&parenttab=Marketing&record=230&viewname=0&start=
	//http://localhost:8888/index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing
}
