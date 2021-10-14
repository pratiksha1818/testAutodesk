package testScript;

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
import com.crm.vtiger.genericutility.javaUtility;

public class TC_02ReapetCreateContactWithOrganization {
	@Test
	public void CreatecontactwithOrganization() throws Throwable {
   WebDriver driver=null;
   JSONfileUtility json=new JSONfileUtility();
   ExcelfileUtility exc=new ExcelfileUtility();
   javaUtility   ju=new javaUtility();
    WebDriverUtility  wlib=new  WebDriverUtility();
    //read common data
    String USERNAME =json.readDataFromJason("username");
    String PASSWORD =json.readDataFromJason("password");
    String URL =json.readDataFromJason("url");
    String BROWSER =json.readDataFromJason("browser");
    String LASTNAME =exc.getExcelData("sheet1", 3, 2);
    
    //choose browser
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
    //implicity wait to fully load the page
    wlib.waitUntilPageLoad(driver);
    wlib.maximizeWindow(driver);
    driver.get(URL);
    //login to page
    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//create contact 
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME+""+ju.getRandomData());;
	driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
	//
	wlib.switchToWindow(driver, "Accounts");
	driver.findElement(By.xpath("//a[text()='gooduivtiger']")).click();
	//switch back to original window save and signout
	wlib.switchToWindow(driver, "Contacts&action");
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	WebElement logo = driver.findElement(By.xpath("(//img[@style=\"padding: 0px;padding-left:5px\"])[1]"));
	  wlib.mouseOver(driver, logo);
	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	}
	}
