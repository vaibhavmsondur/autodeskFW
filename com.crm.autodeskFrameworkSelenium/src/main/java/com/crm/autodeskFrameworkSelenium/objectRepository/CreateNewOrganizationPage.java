package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository for Create New Organization
 * @author VAIBHAV
 *
 */
public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getter Method
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	//Business Library
	/**
	 * This method is used to Create New Organization
	 * @param organizationName
	 * @param industryName
	 */
	public void createNewOrganization(String organizationName, String industryName,String typeName) {
		organizationNameTextField.sendKeys(organizationName);
		select(industryDropDown, industryName);
		select(typeDropDown, typeName);
		saveButton.click();
	}
	/**
	 * This method is used to Create New Organization
	 * @param organizationName
	 */
	public void createNewOrganization(String organizationName) {
		organizationNameTextField.sendKeys(organizationName);
		saveButton.click();
	}
}
