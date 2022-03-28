package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Create New Product Page
 * @author VAIBHAV
 *
 */
public class CreateNewProductPage {
	//Declaration
	@FindBy(name = "productname")
	private WebElement productnameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//Initialization
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter Methods
	public WebElement getProductnameTextField() {
		return productnameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Library
	/**
	 * This method is used to Create Product
	 * @param productName
	 */
	public void createProduct(String productName) {
		productnameTextField.sendKeys(productName);
		saveButton.click();
	}
	
}
