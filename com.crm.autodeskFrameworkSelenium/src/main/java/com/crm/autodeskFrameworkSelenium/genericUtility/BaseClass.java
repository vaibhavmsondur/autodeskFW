package com.crm.autodeskFrameworkSelenium.genericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodeskFrameworkSelenium.objectRepository.HomePage;
import com.crm.autodeskFrameworkSelenium.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class is for the chronology of Annotations
 * @author VAIBHAV
 *
 */
public class BaseClass {
	public WebDriver driver= null;
	public WebDriverUtility wObj= new WebDriverUtility();
	public FileUtility fObj= new FileUtility();
	public JavaUtility jObj = new JavaUtility();
	public ExcelUtility eObj= new ExcelUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void bs() {
		System.out.println("Data Connection");
	}
	
	@BeforeTest(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void bt() {
		System.out.println("Parallel execution started");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void bc() throws Throwable {
		String browser = fObj.getPropertyKeyValue("browser");
		String url = fObj.getPropertyKeyValue("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		wObj.waitForPageToLoad(driver);
		driver.get(url);
		sDriver=driver;
	}
	
	@BeforeMethod(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void bm() throws Throwable {
		String username = fObj.getPropertyKeyValue("username");
		String password = fObj.getPropertyKeyValue("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
	}
	
	@AfterMethod(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void am() {
		HomePage hp = new HomePage(driver);
		hp.logOut(driver);
	}
	
	@AfterClass(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void ac() {
		driver.quit();
	}
	
	@AfterTest(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void at() {
		System.out.println("Parallel execution close");
	}
	
	@AfterSuite(groups = {"functionalTest", "intergrationTest","endToEndTest"})
	public void as() {
		System.out.println("Data connection closed");
	}
}
