package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodeskSelenium.objectRepository.ContactsPage;
import com.crm.autodeskSelenium.objectRepository.HomePage;
import com.crm.autodeskSelenium.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderForVTiger {

	@Test(dataProvider = "getData")
	public void createContact(String name, String mobileNo) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "manager");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnContacts();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnAddIconImage();
		
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.id("mobile")).sendKeys(mobileNo);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		hp.logOut(driver);
		driver.quit();
		
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData() {
		Object[][] objArray = new Object[5][2];
		
		objArray[0][0]="Vaibhav";
		objArray[0][1]="9738412660";
		
		objArray[1][0]="Vebs";
		objArray[1][1]="8660027018";
		
		objArray[2][0]="Vai";
		objArray[2][1]="8147088225";
		
		objArray[3][0]="Vaish";
		objArray[3][1]="7795529522";
		
		objArray[4][0]="Sonu";
		objArray[4][1]="9880991135";
		
		return objArray;
	}
}
