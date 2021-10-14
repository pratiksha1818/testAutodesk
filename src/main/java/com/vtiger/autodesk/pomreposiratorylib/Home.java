package com.vtiger.autodesk.pomreposiratorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericutility.WebDriverUtility;

public class Home {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	public void logout() {
		wlib.mouseOver(driver, getAdministratorImg());
		signOutLnk.click();
		
	}
	
	
	
	
	
	


}
