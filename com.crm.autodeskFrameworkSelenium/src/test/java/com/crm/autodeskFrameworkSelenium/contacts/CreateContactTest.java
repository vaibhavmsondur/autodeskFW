package com.crm.autodeskFrameworkSelenium.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskFrameworkSelenium.genericUtility.BaseClass;
import com.crm.autodeskFrameworkSelenium.objectRepository.ContactInformationPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.ContactsPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.CreateNewContactPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.HomePage;

public class CreateContactTest extends BaseClass {

	@Test(groups="functionalTest")
	public void createContact() throws Throwable {
		
		String orgName= eObj.getDataFromExcel("contacts", 1, 0);
		String productName = eObj.getDataFromExcel("contacts", 1, 1);
		String lname= eObj.getDataFromExcel("contacts", 1, 2);
		
		int ranNum = jObj.getRandomNumber();
		orgName=orgName+ranNum;
		productName=productName+ranNum;
		lname=lname+ranNum;
		
		// click on Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
					
		// create Contacts and save it
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnAddIconImage();
		
		CreateNewContactPage cNCP = new CreateNewContactPage(driver);
		cNCP.createContact(lname);
		
		//Verify
		ContactInformationPage cIP = new ContactInformationPage(driver);
		String actualLastName = cIP.getLastNameForContact();
		Assert.assertEquals(actualLastName.contains(lname), true);
		
	}

}
