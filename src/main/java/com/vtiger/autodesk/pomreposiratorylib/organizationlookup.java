package com.vtiger.autodesk.pomreposiratorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericutility.WebDriverUtility;

public class organizationlookup extends WebDriverUtility {
	 public organizationlookup(WebDriver driver) {
			PageFactory.initElements(driver, this);
			}
     @FindBy(id="search_txt")
      private WebElement searchbox;
     @FindBy(name="search")
     private WebElement searchBtn;
     /*
     @FindBy(xpath="//table[@class='small']//tbody//tr[@class='lvtColData']//td//a")
     private WebElement selectorg;
     "we cant store dynamic element in findBy so use directly  driver.find"
     */
     
     
	
	
	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void searchOrgInLookup(WebDriver driver,String orgname) {
		searchbox.sendKeys(orgname);
		searchBtn.click();
		 WebElement selectorg = driver.findElement(By.xpath("//a[text()='"+orgname+"']"));
		waitForElementVisibility(driver, selectorg);
		selectorg.click();
	 
	}
}
