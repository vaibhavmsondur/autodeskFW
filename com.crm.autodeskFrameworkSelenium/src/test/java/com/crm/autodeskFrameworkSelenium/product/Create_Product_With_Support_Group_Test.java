package com.crm.autodeskFrameworkSelenium.product;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodeskFrameworkSelenium.genericUtility.BaseClass;
import com.crm.autodeskFrameworkSelenium.objectRepository.HomePage;
import com.crm.autodeskFrameworkSelenium.objectRepository.LoginPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.ProductInformationPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.ProductPopUpPage;

public class Create_Product_With_Support_Group_Test extends BaseClass{

	@Test(groups="endToEndTest")
	public void createProductWithSupportGroup() throws Throwable {
		int ranNum = jObj.getRandomNumber();
		
		String createProductDropDown = eObj.getDataFromExcel("products", 1, 0);
		String productName = eObj.getDataFromExcel("products", 1, 1);
		String handlerDropDownValue = eObj.getDataFromExcel("products", 2, 2);
		String expectedLoginPageTitle = eObj.getDataFromExcel("products", 1, 3);
		String expectedHomePageTitle = eObj.getDataFromExcel("products", 1, 4);
		String expectedProductPageTitle = eObj.getDataFromExcel("products", 1, 5);
		
		
		productName=productName+ranNum;
		
		 LoginPage lp = new LoginPage(driver); //Verify Login Page is Displayed String
		 String actualLoginPageTitle = lp.getLoginPageTitleText(driver);
		 Assert.assertEquals(actualLoginPageTitle.contains(expectedLoginPageTitle), true);
		
		//verify HomePage is displayed
		HomePage hp = new HomePage(driver);
		String actualHomePageTitle = hp.getHomePageTitleText(driver);
		Assert.assertEquals(actualHomePageTitle.contains(expectedHomePageTitle), true);
		
		hp.clickOnNewProductFromQuickCreate(createProductDropDown);
		
		ProductPopUpPage popUpPage = new ProductPopUpPage(driver);
		wObj.waitForElementToBeClickAble(driver, popUpPage.getProductNameTextField());
		
		//Verify the Product Pop up is displayed
		String actualProductPageTitle = popUpPage.getProductHeaderTextName();
		Assert.assertEquals(actualProductPageTitle.contains(expectedProductPageTitle), true);
		
		//actions on Product PopUp
		popUpPage.createProduct(productName, handlerDropDownValue);
		
		ProductInformationPage productInfoPage = new ProductInformationPage(driver);
		String actualProductInfoText = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actualProductInfoText.contains(productName), true);
		
		//Verify Login Page is Displayed
		
		 String actualLoginPageTitle2 = lp.getLoginPageTitleText(driver);
		 Assert.assertEquals(actualLoginPageTitle2.contains(expectedLoginPageTitle), true);
		 
	}

}
