package crm.com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutility.ExcelfileUtility;
import com.crm.vtiger.genericutility.JSONfileUtility;
import com.crm.vtiger.genericutility.WebDriverUtility;
import com.crm.vtiger.genericutility.javaUtility;

public class TC_42CreateDocumentForExistingContact {
@Test
public void CreateDocumentForExistingContact() throws Throwable {
	
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
	   String Expextedvalue=" no";
	   
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
	   
	   //implicitywait util page load and maximize
	   wlib.waitUntilPageLoad(driver);
	   wlib.maximizeWindow(driver);
	   driver.get(URL);
	   //login to page
	   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   driver.findElement(By.id("submitButton")).click();
	   //navigate to contact
	   driver.findElement(By.linkText("Contacts")).click();
	   driver.findElement(By.xpath("//table[@class='lvt small']//tbody//tr[5]//td[3]//a")).click();
	   driver.findElement(By.xpath("(//table[@class='small'])[3]//tr[1]//td[4][@class='dvtUnSelectedCell']")).click();
	   driver.findElement(By.id("show_Contacts_Documents")).click();
	   driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
	   driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys("Index");
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
}
