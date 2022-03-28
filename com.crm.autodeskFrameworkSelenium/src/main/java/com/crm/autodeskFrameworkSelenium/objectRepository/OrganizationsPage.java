package com.crm.autodeskFrameworkSelenium.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;
/**
 * Object Repository for Organizations Page
 * @author VAIBHAV
 *
 */
public class OrganizationsPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement addIconImage;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private List<WebElement> organisationNames;
	
	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(xpath="//img[@src='themes/images/next.gif']")
	private WebElement nextButtonImage;
	
	@FindBy(name = "Accounts_listViewCountContainerName")
	private WebElement countNumber;
	
	@FindBy(xpath="//tr[@class='lvtColData']/descendant::a[text()='TYSS9102']")
	private WebElement lastRow;
	
	@FindBy(name = "submit")
	private WebElement searchButton;
	
	@FindBy(id="bas_searchfield")
	private WebElement dropDown;
	
	//Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Getter Method
	public WebElement getAddIconImage() {
		return addIconImage;
	}
	
	public List<WebElement> getOrganisationNames() {
		return organisationNames;
	}
	public WebElement getNextButtonImage() {
		return nextButtonImage;
	}
	
	public WebElement getLastRow() {
		return lastRow;
	}
	public WebElement getCountNumber() {
		return countNumber;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getDropDown() {
		return dropDown;
	}
	//Business Library
	/**
	 * This method is used to click on Add Icon Image
	 */
	public void clickOnAddIconImage() {
		addIconImage.click();
	}
	/**
	 * This method is used to search For All Organizations
	 * @param driver
	 * @throws Throwable
	 */
	public void searchForAllOrganizations(WebDriver driver) throws Throwable {
		String count= countNumber.getText();
		String splitNum = count.split(" ")[1];
		int actualCount=Integer.parseInt(splitNum);
		
		for (int i=0; i < actualCount; i++) {
			List<WebElement> organisationName = driver.findElements(By.xpath("//a[@title='Organizations']"));
			for (WebElement ele : organisationName) {
				System.out.println("OrgName "+ele.getText());
			}
			if (i<actualCount-1) {
				nextButtonImage.click();
			}
			Thread.sleep(3000);
		}
	}
	
	/**
	 * This method is used to search For All Organizations And Click
	 * @param driver
	 * @param orgName
	 * @throws Throwable
	 */
	public void searchForAllOrganizationsAndClick(WebDriver driver,String orgName) throws Throwable {
		searchTextField.sendKeys(orgName);
		select(dropDown, 1);
		searchButton.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='lvt small']/descendant::a[text()='"+orgName+"']")).click();
	}
	
	/**
	 * This method is used to verify For Deleted Org
	 * @param driver
	 * @param orgName
	 * @return
	 */
	public List<WebElement> verifyForDeletedOrg(WebDriver driver,String orgName) {
		List<WebElement> organisationName = driver.findElements(By.xpath("//a[@title='Organizations']"));
		return organisationName;
	}
	
}
