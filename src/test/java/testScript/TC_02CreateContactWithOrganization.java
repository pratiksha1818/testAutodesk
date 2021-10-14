package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutility.ExcelfileUtility;
import com.crm.vtiger.genericutility.JSONfileUtility;
import com.crm.vtiger.genericutility.WebDriverUtility;
import com.crm.vtiger.genericutility.javaUtility;



public class TC_02CreateContactWithOrganization {
	WebDriver driver;
	@Test
	public void CreateContactWithOrganization() throws Throwable
	{
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
		
		String contactName=eu.getExcelData("sheet1", 1, 2);
		String OrgName=eu.getExcelData("sheet1", 1, 3);
		
		//choose the browser
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("opera")) {
			driver=new OperaDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		//implicit wait to load page & maximize it
			wlib.waitUntilPageLoad(driver);
			wlib.maximizeWindow(driver);
			driver.get(URL);
		//login to page
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			//create contact 
			   driver.findElement(By.linkText("Contacts")).click();
	           driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
	          driver.findElement(By.name("lastname")).sendKeys(contactName+" "+jau.getRandomData());
	          //navigate to + symbol of organization
	          driver.findElement(By.xpath("//img[@title='Select']")).click();
	          //switch to organization window
	          wlib.switchToWindow(driver,"Accounts");
	          driver.findElement(By.id("search_txt")).sendKeys(OrgName);
	          driver.findElement(By.name("search")).click();
	          driver.findElement(By.linkText("gooduivtiger")).click();
	          //switch back to orignal window
	          wlib.switchToWindow(driver, "Contacts&action");
	          driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	          // WebElement signout= driver.findElement(By.xpath("//span[@class='small']"));
	          WebElement signout= driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
	          wlib.mouseOver(driver,signout);
	          driver.findElement(By.linkText("Sign Out")).click();
	          }
   }

