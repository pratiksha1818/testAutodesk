package com.vtiger.autodesk.pomreposiratorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;
 public WebElement getSuccessfullMsg() {
	 return succesfullMsg;
 }
}
