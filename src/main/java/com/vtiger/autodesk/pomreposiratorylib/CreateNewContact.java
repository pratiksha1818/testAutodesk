package com.vtiger.autodesk.pomreposiratorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
  public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
    @FindBy(name="lastname")
    private WebElement lastnameEdt;
  
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createconBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orglookupimg;

	public void createcon(String Lastname) {
		createconBtn.click();
		lastnameEdt.sendKeys(Lastname);
		saveBtn.click();}
   public WebElement getSaveBtn() {
		return saveBtn;
	}
public void createconwithorg(String lastname,String orgname) {
			createconBtn.click();
			lastnameEdt.sendKeys(lastname);
			orglookupimg.click();
			
		
	}
	
}
