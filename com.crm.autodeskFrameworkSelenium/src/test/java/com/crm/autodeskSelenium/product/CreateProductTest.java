package com.crm.autodeskSelenium.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.genericUtility.BaseClass;
import com.crm.autodeskSelenium.objectRepository.CreateNewProductPage;
import com.crm.autodeskSelenium.objectRepository.HomePage;
import com.crm.autodeskSelenium.objectRepository.ProductInformationPage;
import com.crm.autodeskSelenium.objectRepository.ProductsPage;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProduct() throws Throwable {
		
		String productName= eObj.getDataFromExcel("organisation", 1, 2);
		
		int ranNum = jObj.getRandomNumber();
		productName=productName+ranNum;
		
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
	}
}
