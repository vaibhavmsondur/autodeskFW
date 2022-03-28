package com.crm.autodeskSelenium.organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.genericUtility.BaseClass;
import com.crm.autodeskSelenium.objectRepository.CreateNewOrganizationPage;
import com.crm.autodeskSelenium.objectRepository.HomePage;
import com.crm.autodeskSelenium.objectRepository.OrganizationInformationPage;
import com.crm.autodeskSelenium.objectRepository.OrganizationsPage;

@Listeners(com.crm.autodeskSelenium.genericUtility.ListenersImplementationClass.class)
public class CreateOrgTest extends BaseClass {

	@Test(groups="functionalTest")
	public void createOrg() throws Throwable {
			
			String orgName= eObj.getDataFromExcel("organisation", 1, 0);
			
			int ranNum = jObj.getRandomNumber();
			orgName=orgName+ranNum;
			
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
	}
}
