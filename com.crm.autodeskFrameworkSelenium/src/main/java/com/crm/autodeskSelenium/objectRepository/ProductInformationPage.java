package com.crm.autodeskSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Product Information Page
 * @author VAIBHAV
 *
 */
public class ProductInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderText;
	
	@FindBy(id = "mouseArea_Product Name")
	private WebElement productNameText;
	//Initialization
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter Method
	public WebElement getProductNameText() {
		return productNameText;
	}
	
	public WebElement getProductHeaderText() {
		return productHeaderText;
	}

	//Business Library
	/**
	 * This method is used to get Product Name Text
	 * @return
	 */
	public String getProductName() {
		return productNameText.getText();
	}
	/**
	 * This method is used to get Product Header Name
	 * @return
	 */
	public String getProductHeaderName() {
		return productHeaderText.getText();
	}
}
