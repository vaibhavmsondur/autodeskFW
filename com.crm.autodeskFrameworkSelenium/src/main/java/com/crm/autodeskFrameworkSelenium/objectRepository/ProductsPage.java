package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Object Repository for Products Page
 * @author VAIBHAV
 *
 */
public class ProductsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement addIconImage;
	
	//Initialization
	public ProductsPage(WebDriver driver) {
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
