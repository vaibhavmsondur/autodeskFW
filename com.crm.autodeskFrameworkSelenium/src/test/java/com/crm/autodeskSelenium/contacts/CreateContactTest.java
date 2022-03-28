package com.crm.autodeskSelenium.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.genericUtility.BaseClass;
import com.crm.autodeskSelenium.objectRepository.ContactInformationPage;
import com.crm.autodeskSelenium.objectRepository.ContactsPage;
import com.crm.autodeskSelenium.objectRepository.CreateNewContactPage;
import com.crm.autodeskSelenium.objectRepository.HomePage;

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
