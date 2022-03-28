
package com.crm.autodeskSelenium.campaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.genericUtility.BaseClass;
import com.crm.autodeskSelenium.objectRepository.CampaignInformationPage;
import com.crm.autodeskSelenium.objectRepository.CampaignsPage;
import com.crm.autodeskSelenium.objectRepository.CreateNewCampaign;
import com.crm.autodeskSelenium.objectRepository.CreateNewProductPage;
import com.crm.autodeskSelenium.objectRepository.HomePage;
import com.crm.autodeskSelenium.objectRepository.ProductInformationPage;
import com.crm.autodeskSelenium.objectRepository.ProductsPage;

public class CreateCampaignWithProductTest extends BaseClass {
	
	@Test
	public void createCampaignWithProduct() throws Throwable {
		
		String productName= eObj.getDataFromExcel("organisation", 1, 2);
		String campaignName = eObj.getDataFromExcel("organisation", 1, 3);
		
		int ranNum = jObj.getRandomNumber();
		productName=productName+ranNum;
		campaignName=campaignName+ranNum;
				
		//Click on Products Link
		HomePage hp = new HomePage(driver);
		hp.clickOnProducts();
				
		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnAddIconImage();
				
		CreateNewProductPage cNPP = new CreateNewProductPage(driver);
		cNPP.createProduct(productName);
				
		ProductInformationPage pIP = new ProductInformationPage(driver);
		//Verify
		String actualProductName = pIP.getProductName();
		Assert.assertEquals(actualProductName.contains(productName), true);
		
		wObj.waitForElementToBeClickAble(driver, hp.getMoreLink());
		hp.clickOnCampaigns(driver);
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnAddIconImage();
		
		CreateNewCampaign cNC = new CreateNewCampaign(driver);
		cNC.campaignNameAndClickOnIcon(campaignName);
		cNC.switchTo(driver, "Products");
		cNC.searchAndClick(driver, productName);
		cNC.switchTo(driver, "Campaigns" );
		cNC.clickOnSaveButton();
		CampaignInformationPage cIP= new CampaignInformationPage(driver);
		//Verify
		String productNameActual = cIP.getProductNameText();
		Assert.assertEquals(productNameActual.contains(productName), true);
	}
}
