package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Campaign Information Page
 * @author VAIBHAV
 *
 */
public class CampaignInformationPage {
	//Declaration
	@FindBy(id = "mouseArea_Product")
	private WebElement verifyProductName;
	
	//Initialization
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter Method
	public WebElement getVerifyProductName() {
		return verifyProductName;
	}
	
	//Business Library
	/**
	 * This method is used to get Product Name Text
	 * @return
	 */
	public String getProductNameText() {
		return verifyProductName.getText();
	}
	
}
