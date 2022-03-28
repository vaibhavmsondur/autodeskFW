package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Campaigns Page
 * @author VAIBHAV
 *
 */
public class CampaignsPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement addIconImage;
	
	//Initialization
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getter Method
	public WebElement getAddIconImage() {
		return addIconImage;
	}
	
	//Business Library
	/**
	 * This method is used to click On Add Icon Image
	 */
	public void clickOnAddIconImage() {
		addIconImage.click();
	}
}
