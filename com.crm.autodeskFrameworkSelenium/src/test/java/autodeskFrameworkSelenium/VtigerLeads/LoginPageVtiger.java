package autodeskFrameworkSelenium.VtigerLeads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageVtiger {
	static WebDriver driver;
	static {
		String actualTitle=driver.getTitle();
		String expectedTitle="vtiger CRM 5 - Commercial Open Source CRM";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("PASS: The Login Page is Correct");
		} else {
			System.err.println("FAIL: The Login Page is InCorrect");
		}
	}
	
	public LoginPageVtiger(WebDriver driver) {
	//	driver=this.driver;
	}

	public void login(WebDriver driver, String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	}
}
