package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario3 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fin= new FileInputStream(".\\src\\main\\resources\\commonData\\credentials.properties");
		Properties prop = new Properties();
		prop.load(fin);
		
		FileInputStream fexcel= new FileInputStream(".\\src\\test\\resources\\OrganisationTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fexcel);
		
		Sheet sheet = wb.getSheet("organisation");
		
		String orgName= sheet.getRow(1).getCell(0).getStringCellValue();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String lname= sheet.getRow(2).getCell(0).getStringCellValue();
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		orgName=orgName+ranNum;
		lname=lname+ranNum;
		WebDriver driver=null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else {
			System.err.println("Provide Valid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		LoginPage1 lp= new LoginPage1();
		lp.login(driver, username, password);
		
		OrganisationsClick oc= new OrganisationsClick();
		oc.organisationClick(driver);
		oc.organisationDetails(driver, orgName);
		Thread.sleep(5000);
		
		ContactsClick cc= new ContactsClick();
		cc.contactsClick(driver);
		cc.contactsDetails(driver, lname);
		
		Thread.sleep(5000);
		oc.logOut(driver);
		
		driver.quit();
	}

}
