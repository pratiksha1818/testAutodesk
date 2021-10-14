package crm.com.vtiger.testscripts;

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

public class TC_23Emailoptoutboxenableornot {
@Test
public void emailoptoutboxenabledornot() throws Throwable {
	WebDriver driver=null;
	   WebDriverUtility wlib=new WebDriverUtility();
	   JSONfileUtility json=new JSONfileUtility();
	   ExcelfileUtility exc=new ExcelfileUtility();
	   javaUtility   ju=new javaUtility();
	   
	   //read all common data from jason
	   String USERNAME=json.readDataFromJason("username");
	   String PASSWORD=json.readDataFromJason("password");
	   String URL=json.readDataFromJason("url");
	   String BROWSER=json.readDataFromJason("browser");
	   String LASTNAME=exc.getExcelData("sheet1", 3 , 2);
	   String ORGNAME=exc.getExcelData("sheet1", 1 , 2);
	   String Expextedvalue="no";
	   
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
	   
	   //implicitywait util page load  and maximize
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
      driver.findElement(By.name("lastname")).sendKeys(LASTNAME+" "+ju.getRandomData());
      //save and signout
	   driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	    String Actualvalue = driver.findElement(By.id("mouseArea_Email Opt Out")).getText();
	   System.out.println(Actualvalue);
	   if(Actualvalue.contains(Expextedvalue)) {
		   System.out.println(" notenable");
		   }
		   else {
  			   System.out.println("enable");
  			   }
		   WebElement logo = driver.findElement(By.xpath("(//img[@style=\"padding: 0px;padding-left:5px\"])[1]"));
	  		  wlib.mouseOver(driver, logo);
	  		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	   }
	 
}

