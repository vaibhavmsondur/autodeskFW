package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository for Create New Campaign
 * @author VAIBHAV
 *
 */
public class CreateNewCampaign extends WebDriverUtility{
	
	//Declaration
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement productIconImage;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//Initialization
	public CreateNewCampaign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter Method
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getProductIconImage() {
		return productIconImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Library
	/**
	 * This method is used to campaign Name And Click On Icon
	 * @param campaignName
	 */
	public void campaignNameAndClickOnIcon(String campaignName) {
		campaignNameTextField.sendKeys(campaignName);
		productIconImage.click();
	}
	/**
	 * This method is used to switch to window
	 * @param driver
	 * @param window
	 */
	public void switchTo(WebDriver driver, String window) {
		switchToWindow(driver, window);
	}
	/**
	 * This method is used to search And Click
	 * @param driver
	 * @param productName
	 */
	public void searchAndClick(WebDriver driver, String productName) {
		OrganizationSearchInContactsPage os= new OrganizationSearchInContactsPage(driver);
		os.getOrganizationName(driver, productName);
	}
	/**
	 * This method is used to click On Save Button
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
}
