package autodeskFrameworkSelenium.VtigerLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodeskFrameworkSelenium.genericUtility.ExcelUtility;
import com.crm.autodeskFrameworkSelenium.genericUtility.FileUtility;
import com.crm.autodeskFrameworkSelenium.genericUtility.JavaUtility;
import com.crm.autodeskFrameworkSelenium.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateALeadTC002 {

	public static void main(String[] args) throws Throwable {
		JavaUtility jObj= new JavaUtility();
		WebDriverUtility wObj= new WebDriverUtility();
		ExcelUtility eObj= new ExcelUtility();
		FileUtility fObj= new FileUtility();
		
		int ranNum = jObj.getRandomNumber();
		
		String browser = fObj.getPropertyKeyValue("browser");
		String url = fObj.getPropertyKeyValue("url");
		String username = fObj.getPropertyKeyValue("username");
		String password = fObj.getPropertyKeyValue("password");
		
		String firstName = eObj.getDataFromExcelLeads("leadsData", 1, 2);
		String lastName = eObj.getDataFromExcelLeads("leadsData", 1, 3);
		String company = eObj.getDataFromExcelLeads("leadsData", 1, 4);
		String title = eObj.getDataFromExcelLeads("leadsData", 1, 5);
		String annualRevenue = eObj.getDataFromExcelLeads("leadsData", 1, 6);
		String noOfEmployees = eObj.getDataFromExcelLeads("leadsData", 1, 7);
		String mobileNo = eObj.getDataFromExcelLeads("leadsData", 1, 8);
		String email = eObj.getDataFromExcelLeads("leadsData", 1, 9);
		String leadStatus = eObj.getDataFromExcelLeads("leadsData", 1, 10);
		
		String streetDetails = eObj.getDataFromExcelLeads("leadsData", 1, 12);
		String postalCode = eObj.getDataFromExcelLeads("leadsData", 1, 13);
		String country = eObj.getDataFromExcelLeads("leadsData", 1, 14);
		String city = eObj.getDataFromExcelLeads("leadsData", 1, 15);
		String state = eObj.getDataFromExcelLeads("leadsData", 1, 16);
		
		firstName=firstName+ranNum;
		lastName=lastName+ranNum;
		company=company+ranNum;
		
		WebDriver driver= null;
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
		wObj.waitForPageToLoad(driver);
		driver.get(url);
		
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.contains(url)) {
			System.out.println(url+" is correct:PASS");
		} else {
			System.err.println(url+" is incorrect:FAIL");
		}
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		String expectedHomeTitle = "Home";
		String actualHomeTitle= driver.getCurrentUrl();
		
		if (actualHomeTitle.contains(expectedHomeTitle)) {
			System.out.println(expectedHomeTitle+" is correct:PASS");
		} else {
			System.err.println(expectedHomeTitle+" is incorrect:FAIL");
		}
		
		//click on Leads
		WebElement leadsLink = driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[.='Leads']"));
		leadsLink.click();
		String expectedLeadsTitle = "Leads";
		String actualLeadsTitle= driver.getCurrentUrl();
		//verify
		if (actualLeadsTitle.contains(expectedLeadsTitle)) {
			System.out.println(expectedLeadsTitle+" is correct:PASS");
		} else {
			System.err.println(expectedLeadsTitle+" is incorrect:FAIL");
		}
		
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		String expectedCreateLeadsTitle ="Lead Information";
		String actualCreateLeadsTitle= driver.findElement(By.xpath("//td[@class='detailedViewHeader']/b")).getText();
		if (actualCreateLeadsTitle.contains(expectedCreateLeadsTitle)) {
			System.out.println(expectedCreateLeadsTitle+" is correct:PASS");
		} else {
			System.err.println(expectedCreateLeadsTitle+" is incorrect:FAIL");
		}
		WebElement salutation = driver.findElement(By.name("salutationtype"));
		wObj.select(salutation, "Mr.");
		
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("company")).sendKeys(company);
		driver.findElement(By.id("designation")).sendKeys(title);
		driver.findElement(By.id("mobile")).sendKeys(mobileNo);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("annualrevenue")).clear();
		driver.findElement(By.name("annualrevenue")).sendKeys(annualRevenue);
		driver.findElement(By.id("noofemployees")).sendKeys(noOfEmployees);
		WebElement statusLead = driver.findElement(By.name("leadstatus"));
		wObj.select(statusLead, leadStatus);
		driver.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		driver.findElement(By.name("lane")).sendKeys(streetDetails);
		driver.findElement(By.name("code")).sendKeys(postalCode);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualVerificationHeader = driver.findElement(By.className("dvHeaderText")).getText();
		if (actualVerificationHeader.contains(lastName)) {
			System.out.println(lastName+" is correct:PASS");
		} else {
			System.err.println(lastName+" is incorrect:FAIL");
		}
		
		driver.findElement(By.xpath("//td[@class='tabSelected']//a[.='Leads']")).click();
		String actualtableLastName = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[contains(.,'"+lastName+"')]/td[3]")).getText();
		if (actualtableLastName.contains(lastName)) {
			System.out.println(lastName+" is correct:PASS");
		} else {
			System.err.println(lastName+" is incorrect:FAIL");
		}

	}

}
