package com.crm.autodeskSelenium.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.genericUtility.BaseClass;
import com.crm.autodeskSelenium.objectRepository.ContactInformationPage;
import com.crm.autodeskSelenium.objectRepository.ContactsPage;
import com.crm.autodeskSelenium.objectRepository.CreateNewContactPage;
import com.crm.autodeskSelenium.objectRepository.CreateNewOrganizationPage;
import com.crm.autodeskSelenium.objectRepository.HomePage;
import com.crm.autodeskSelenium.objectRepository.OrganizationInformationPage;
import com.crm.autodeskSelenium.objectRepository.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseClass{

	@Test(groups="intergrationTest")
	public void createContactWithOrgTest() throws Throwable {
		String orgName= eObj.getDataFromExcel("contacts", 1, 0);
		String lname= eObj.getDataFromExcel("contacts", 1, 2);
		
		int ranNum = jObj.getRandomNumber();
		orgName=orgName+ranNum;
		lname=lname+ranNum;
		
		// click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		
		// create organization and save it
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnAddIconImage();
		
		CreateNewOrganizationPage cNO = new CreateNewOrganizationPage(driver);
		cNO.createNewOrganization(orgName);
		
		//Validate the organization created
		OrganizationInformationPage oIP = new OrganizationInformationPage(driver);
		String actualOrgName = oIP.getOrgInfoName();
		Assert.assertEquals(actualOrgName.contains(orgName), true);
		
		wObj.waitForElementToBeClickAble(driver, hp.getContactsLink());
		// click on Contacts Link
		hp.clickOnContacts();
		
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnAddIconImage();
							
		// create Contacts and save it
		CreateNewContactPage cNCP = new CreateNewContactPage(driver);
		cNCP.clickOnAddOrg(driver, lname);
		cNCP.switchToWindowForContact(driver, "Accounts");
		cNCP.clickOnOrgForContact(driver, orgName);
		cNCP.switchToWindowForContact(driver, "Contacts");
		cNCP.clickOnsaveButton();
		
		//Verify
		ContactInformationPage cIP = new ContactInformationPage(driver);
		
		String actualLastName = cIP.getLastNameForContact();
		Assert.assertEquals(actualLastName.contains(lname), true);
		
		String actuaOrgName= cIP.getOrgNameForContact();
		Assert.assertEquals(actuaOrgName.contains(orgName), true);
		
	}
}