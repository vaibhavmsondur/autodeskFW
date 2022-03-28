package com.crm.autodeskFrameworkSelenium.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository for Organization Search In Contacts Page
 * @author VAIBHAV
 *
 */
public class OrganizationSearchInContactsPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	//Initialization
	public OrganizationSearchInContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Getter Method
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	//Business Library
	/**
	 * This method is used to get Organization Name
	 * @param driver
	 * @param orgName
	 */
	public void getOrganizationName(WebDriver driver,String orgName) {
		searchTextField.sendKeys(orgName);
		searchButton.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
	}
	/**
	 * This method is used to search For All Organizations And Click
	 * @param driver
	 * @param orgName
	 * @throws Throwable
	 */
	public void searchForAllOrganizationsAndClick(WebDriver driver,String orgName) throws Throwable {
		searchTextField.sendKeys(orgName);
		searchButton.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		}
	
}
