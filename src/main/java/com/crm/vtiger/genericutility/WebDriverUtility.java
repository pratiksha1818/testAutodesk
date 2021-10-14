package com.crm.vtiger.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * author @pratiksha
	 */
	/**
	 * this method wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method wait for 20 seconds for page to loading
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * this method will maximize the window
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * this method will wait until element become clickable
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count =0;
		while(count<40) {
			try {
				element.click();
				break;
			}
			catch(Throwable e){
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * this method enables user to handle dropdown using visibile text
	 */
	public void SelectOption(WebElement element,String option) {
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * this ,method enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method perform the mouseover actions
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method perform right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
			
	}
	/**
	 * this method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();	
		while(it.hasNext())
		{
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle)) {
				break;
				
			}
		}
	}
	/**
	 * this method will cancel the alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method used for scrolling action in web page
	 * @param driver
	 * @param element
	 */
	
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	/**
	 * this method is use toswitch to frame by using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	 public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	 /**
	  * this method is use to take screenshot along with currentdate
	  * @param driver
	  * @param screenshotName
	  * @return
	  */
	 public String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable 
	 {
		 String screenshotPath="./screenshot/"+screenshotName+javaUtility.getCurrentDate()+".PNG"; 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File(screenshotPath);
		 Files.copy(src, dest);
		 return screenshotPath;
	 }
	 /**
	  * this method is use to press enter
	 * @throws AWTException 
	  * 
	  */
	 public void pressEnterKey() throws AWTException {
		 Robot rc=new Robot();
		 rc.keyPress(KeyEvent.VK_ENTER);
		 rc.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}















