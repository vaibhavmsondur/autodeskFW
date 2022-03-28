package autodeskFrameworkSelenium.VtigerLeads;

import org.openqa.selenium.WebDriver;

public class HomePageVtiger {
	static WebDriver driver;
	
	static {
		String actualHomePageTitle = driver.getTitle();
		String expectedHomePageTitle =" Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if (actualHomePageTitle.contains(expectedHomePageTitle)) {
			System.out.println("PASS : Home Page is Correct");
		} else {
			System.err.println("FAIL : Home Page is InCorrect ");
		}
	}
	
	public HomePageVtiger(WebDriver driver) {
		
	}
	
}
