package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;

/**
 * Object Repository for Product PopUp Page
 * @author VAIBHAV
 *
 */
public class ProductPopUpPage extends WebDriverUtility {
	//Declaration
	@FindBy(xpath = "//td[@class='mailSubHeader']")
	private WebElement productHeaderText;
	
	@FindBy(name = "productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath = "//input[ @value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement handlerDropDown;
	
	@FindBy(xpath = "//table[@class='qcTransport']/descendant::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//Initialization
	public ProductPopUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Getter Method
	public WebElement getProductHeaderText() {
		return productHeaderText;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getHandlerDropDown() {
		return handlerDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Library
	/**
	 * This method is used to get Product Header Text Name
	 * @return
	 */
	public String getProductHeaderTextName() {
		return productHeaderText.getText();
	}
	/**
	 * This method is used to create Product
	 * @param productName
	 * @param option
	 */
	public void createProduct(String productName, String option) {
		productNameTextField.sendKeys(productName);
		groupRadioButton.click();
		select(handlerDropDown, option);
		saveButton.click();
	}
}
