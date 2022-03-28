package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Contact Information Page
 * @author VAIBHAV
 *
 */
public class ContactInformationPage {
	
	//Declaration
	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastNameVerify;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgNameVerify;
	
	//Initialization
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter Method
	public WebElement getLastNameVerify() {
		return lastNameVerify;
	}

	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}
	
	//Business Library
	/**
	 * This method is used to get OrgName For Contact
	 * @return
	 */
	public String getOrgNameForContact() {
		return orgNameVerify.getText();
	}
	/**
	 * This method is used to get Last Name For Contact
	 * @return
	 */
	public String getLastNameForContact() {
		return lastNameVerify.getText();
	}
}
