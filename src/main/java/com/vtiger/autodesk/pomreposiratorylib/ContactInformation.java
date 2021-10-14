package com.vtiger.autodesk.pomreposiratorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {

	public ContactInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;
	
   public WebElement getSuccessfullMsg() {
	 return succesfullMsg;
}
     @FindBy(id="mouseArea_Do Not Call")
	  private WebElement donotcallMsg;
     
  public WebElement getDonotcallMsg() {
		return donotcallMsg;
	}
  @FindBy(id="mouseArea_Email Opt Out")
  private WebElement emailoutMsg;

   public WebElement getEmailoutMsg() {
	return emailoutMsg;
   }
   @FindBy(id="mouseArea_Notify Owner")
	private WebElement notifyMsg;


	public WebElement getNotifyMsg() {
	return notifyMsg;
}

	public WebElement getRefboxMsg() {
		return refboxMsg;
	}								
    @FindAll({@FindBy(id="mouseArea_Reference"),@FindBy(xpath="//input[@class='dvtCellInfo']")})
    private WebElement refboxMsg;
                                                           
    public WebElement getrefboxMsg() {
	return refboxMsg;
	
    }					
}
