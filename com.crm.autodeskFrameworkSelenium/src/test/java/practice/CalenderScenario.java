package practice;

import com.crm.autodeskSelenium.genericUtility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderScenario {

	public static void main(String[] args) throws Throwable {
//		JavaUtility jObj= new JavaUtility();
//		WebDriverUtility wObj= new WebDriverUtility();
		ExcelUtility eObj= new ExcelUtility();
		
		String month = eObj.getDateDataString("date", 1, 0);
		String datee = eObj.getDateDataString("date", 1, 1);
		String year= eObj.getDateDataString("date", 1, 2);
		String formatDate= month+" "+datee+" "+year;
		System.out.println(formatDate);
		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
		
		//String date = jObj.getsystemDateMonDDYYYY();
		

//		driver.manage().window().maximize();
//		wObj.waitForPageToLoad(driver);
//		driver.get("https://www.cleartrip.com/");
//		
//		driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]/child::button")).click();
//		while (true) {
//			try {
//				driver.findElement(By.xpath("//div[contains(@aria-label,'"+formatDate+"')]")).click();
//				break;
//			} catch (Exception e) {
//				driver.findElement(By.cssSelector("svg[data-testid='rightArrow']")).click();
//			}
//		}
	}
}
