package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository of Contacts Page
 * @author VAIBHAV
 *
 */
public class ContactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement addIconImage;
	
	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter
	public WebElement getAddIconImage() {
		return addIconImage;
	}
	
	//Business Library
	/**
	 * This method is used to click on AddIconImage
	 */
	public void clickOnAddIconImage() {
		addIconImage.click();
	}
}
