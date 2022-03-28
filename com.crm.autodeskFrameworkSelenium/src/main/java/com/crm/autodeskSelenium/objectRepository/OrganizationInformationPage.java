package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository for Organization Information Page
 * @author VAIBHAV
 *
 */
public class OrganizationInformationPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgName;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryName;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeName;
	
	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement deleteButton;
	
	
	//Initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getter Method
	public WebElement getOrgName() {
		return orgName;
	}
	
	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getTypeName() {
		return typeName;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	//Business Library
	/**
	 * This method is used to get Org Info Name
	 * @return
	 */
	public String getOrgInfoName() {
		return orgName.getText();
	}
	
	/**
	 * This method is used to get Industry Info Name
	 * @return
	 */
	public String getIndustryInfoName() {
		return industryName.getText();
	}
	
	/**
	 * This method is used to get Type Info Name
	 * @return
	 */
	public String getTypeInfoName() {
		return typeName.getText();
	}
	/**
	 * This method is used to click On Delete Button
	 * @param driver
	 */
	public void clickOnDeleteButton(WebDriver driver) {
		deleteButton.click();
		switchToAlertWindowAndAccept(driver);
	}
}
