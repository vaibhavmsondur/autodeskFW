package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository for Home Page
 * @author VAIBHAV
 *
 */
public class HomePage extends WebDriverUtility {
	
	//Declaration
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logOutIconImage;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logOutLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(id = "qccombo")
	private WebElement quickCreateDropDown;

	public WebElement getQuickCreateDropDown() {
		return quickCreateDropDown;
	}

	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getters Method
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	public WebElement getLogOutIconImage() {
		return logOutIconImage;
	}
	public WebElement getLogOutLink() {
		return logOutLink;
	}
	
	public WebElement getContactsLink() {
		return contactsLink;
	}
    
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	//Business Library
	/**
	 * This method is used to click on Organizations
	 */
	public void clickOnOrganizations() {
		organizationsLink.click();
	}
	/**
	 * This method is used to click on Logout Link
	 * @param driver
	 */
	public void logOut(WebDriver driver) {
		mouseOverOnElement(driver, logOutIconImage);
		logOutLink.click();
	}
	/**
	 * This method is used to click on Contacts
	 */
	public void clickOnContacts() {
		contactsLink.click();
	}
	/**
	 * This method is used to click on Products
	 */
	public void clickOnProducts() {
		productsLink.click();
	}
	/**
	 * This method is used to click on Campaigns
	 * @param driver
	 */
	public void clickOnCampaigns(WebDriver driver) {
		mouseOverOnElement(driver, moreLink);
		campaignsLink.click();
	}
	
	/**
	 * This method is used to click On New Product From QuickCreate
	 * @param option
	 */
	public void clickOnNewProductFromQuickCreate(String option) {
		select(option, quickCreateDropDown);
	}
	
	/**
	 * This method is used to get Home Page Title Text
	 * @return
	 */
	public String getHomePageTitleText(WebDriver driver) {
		return driver.getTitle();
	}
}
