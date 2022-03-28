package com.crm.autodeskFrameworkSelenium.organization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskFrameworkSelenium.genericUtility.BaseClass;
import com.crm.autodeskFrameworkSelenium.objectRepository.CreateNewOrganizationPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.HomePage;
import com.crm.autodeskFrameworkSelenium.objectRepository.OrganizationInformationPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.OrganizationsPage;

public class CreateOrgWithIndustryTest extends BaseClass {
	@Test(groups="intergrationTest")
	public void createOrgWithIndustry()  throws Throwable {
			
			String orgName= eObj.getDataFromExcel("organisation", 1, 0);
			String domainName= eObj.getDataFromExcel("organisation", 1, 1);
			String type = eObj.getDataFromExcel("organisation", 1, 4);
			
			int ranNum = jObj.getRandomNumber();
			orgName=orgName+ranNum;
			
			// click on Organization Link
			HomePage hp= new HomePage(driver);
			hp.clickOnOrganizations();
			
			// create organization and save it
			OrganizationsPage op= new OrganizationsPage(driver);
			op.clickOnAddIconImage();
			
			// create organization and save it
			CreateNewOrganizationPage cNO= new CreateNewOrganizationPage(driver);
			cNO.createNewOrganization(orgName, domainName, type);
			
			//Validate the organization created
			OrganizationInformationPage oIP= new OrganizationInformationPage(driver);
			String actualOrgName = oIP.getOrgInfoName();
			Assert.assertEquals(actualOrgName.contains(orgName), true);
			
			//Validate the Industry and Type
			String actualIndustry = oIP.getIndustryInfoName();
			Assert.assertEquals(actualIndustry.contains(domainName), true);
			
			String actualType = oIP.getTypeInfoName();
			Assert.assertEquals(actualType.contains(type), true);
	}
}
