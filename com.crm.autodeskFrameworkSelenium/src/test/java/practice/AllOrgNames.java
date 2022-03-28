package practice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodeskFrameworkSelenium.genericUtility.ExcelUtility;
import com.crm.autodeskFrameworkSelenium.genericUtility.FileUtility;
import com.crm.autodeskFrameworkSelenium.genericUtility.JavaUtility;
import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;
import com.crm.autodeskFrameworkSelenium.objectRepository.CreateNewOrganizationPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.HomePage;
import com.crm.autodeskFrameworkSelenium.objectRepository.LoginPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.OrganizationInformationPage;
import com.crm.autodeskFrameworkSelenium.objectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllOrgNames {

	public static void main(String[] args) throws Throwable {

		JavaUtility jObj = new JavaUtility();
		WebDriverUtility wObj = new WebDriverUtility();
		ExcelUtility eObj= new ExcelUtility();
		FileUtility fObj= new FileUtility();
		
		String orgName= eObj.getDataFromExcel("organisation", 1, 0);
		
		String browser = fObj.getPropertyKeyValue("browser");
		String url = fObj.getPropertyKeyValue("url");
		String username = fObj.getPropertyKeyValue("username");
		String password = fObj.getPropertyKeyValue("password");
		
		int ranNum = jObj.getRandomNumber();
		orgName=orgName+ranNum;
		WebDriver driver=null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		
		LoginPage lp= new LoginPage(driver);
		driver.manage().window().maximize();
		wObj.waitForPageToLoad(driver);
		
		driver.get(url);
		// Login
		lp.login(username, password);
		
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
		if (actualOrgName.contains(orgName)) {
			System.out.println(orgName+" is correct :PASS");
		}else {
			System.err.println(orgName+" is incorrect :FAIL");
		}	

		hp.clickOnOrganizations();
		op.searchForAllOrganizations(driver);
		op.searchForAllOrganizationsAndClick(driver, orgName);
		oIP.clickOnDeleteButton(driver);
		List<WebElement> webElements = op.verifyForDeletedOrg(driver, orgName);
		for (WebElement ele : webElements) {
			if (ele.getText().contains(orgName)) {
				System.err.println("FAIL :The OrgName is Not deleted");
				break;
			}
		}
		hp.logOut(driver);
	}

}
