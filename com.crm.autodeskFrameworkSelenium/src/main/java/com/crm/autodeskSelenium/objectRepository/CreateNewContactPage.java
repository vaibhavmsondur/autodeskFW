package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository of Create New Contact Page
 * @author VAIBHAV
 *
 */
public class CreateNewContactPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgAddIconImage;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	//Initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getter Method
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getOrgAddIconImage() {
		return orgAddIconImage;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Library
	/**
	 *  This method is used to create Contacts
	 * @param lastName
	 */
	public void createContact(String lastName) {
		lastNameTextField.sendKeys(lastName);
		saveButton.click();
	}
	/**
	 *  This method is used to click on Add Organization
	 * @param driver
	 * @param lastName
	 */
	public void clickOnAddOrg(WebDriver driver, String lastName) {
		lastNameTextField.sendKeys(lastName);
		orgAddIconImage.click();
	}
	/**
	 *  This method is used to Switch the Window
	 * @param driver
	 * @param window
	 */
	public void switchToWindowForContact(WebDriver driver, String window) {
		switchToWindow(driver, window);
	}
	/**
	 *  This method is used to click on Organization for Contact
	 * @param driver
	 * @param orgName
	 */
	public void clickOnOrgForContact(WebDriver driver, String orgName) {
		OrganizationSearchInContactsPage oSICP = new OrganizationSearchInContactsPage(driver);
		oSICP.getOrganizationName(driver, orgName);
	}
	/**
	 *  This method is used to click on Save Button
	 */
	public void clickOnsaveButton() {
		saveButton.click();
	}
}
