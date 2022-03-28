package com.crm.autodeskSelenium.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.genericUtility.BaseClass;

public class CreateContactWithOrgAndDateTest extends BaseClass {
	
	@Test
	public void createContactWithOrgAndDate() throws Throwable {
		
		String orgName= eObj.getDataFromExcel("contacts", 1, 0);
		String lname= eObj.getDataFromExcel("contacts", 1, 2);
		
		int ranNum = jObj.getRandomNumber();
		orgName=orgName+ranNum;
		lname=lname+ranNum;
		// click on Organization Link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// create organization and save it
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validate the organization created
		String actualOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		Assert.assertEquals(actualOrgName.contains(orgName), true);
		
		WebElement contactsLink = driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Contacts']"));
		wObj.waitForElementToBeClickAble(driver, contactsLink);
		// click on Contacts Link
		contactsLink.click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
							
		// create Contacts and save it
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='account_id']/../img")).click();
		wObj.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		
		wObj.switchToWindow(driver, "Contacts");
		
		WebElement dateData = driver.findElement(By.id("jscal_field_support_start_date"));
		dateData.clear();
		String date = jObj.getsystemDateYYYYMMDD();
		dateData.sendKeys(date);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Verify
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(actualLastName.contains(lname), true);
		
		String actuaOrgName= driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		
		Assert.assertEquals(actuaOrgName.contains(orgName), true);
		
		String actualDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		Assert.assertEquals(actualDate.contains(date), true);
		
	}
}
