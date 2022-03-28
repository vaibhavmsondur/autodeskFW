package practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClearTripSelectFlight {

	public static void main(String[] args) {
		LocalDateTime ldt= LocalDateTime.now().plusDays(2);
		int date = ldt.getDayOfMonth();
		int year = ldt.getYear();
		String month = ldt.getMonth().toString();
		String actualMonth = month.substring(0, 1)+month.substring(1,3).toLowerCase();
		String dateMonthAndYear= actualMonth+" "+date+" "+year;
		System.out.println(dateMonthAndYear);
		String srcPlace="Bangalore";
		String destPlace="Kalaburagi";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait= new WebDriverWait(driver, 20);
		driver.get("https://www.cleartrip.com");

		driver.findElement(By.xpath("//h4[text()='From']/following-sibling::div/descendant::input")).sendKeys(srcPlace);
		driver.findElement(By.xpath("//div[text()='Suggestions']/parent::ul/descendant::p[contains(text(),'"+srcPlace+"')]")).click();
		driver.findElement(By.xpath("//h4[text()='To']/following-sibling::div/descendant::input")).sendKeys(destPlace);
		driver.findElement(By.xpath("//div[text()='Suggestions']/parent::ul/descendant::p[contains(text(),'"+destPlace+"')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]/child::button")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+dateMonthAndYear+"')]")).click();
		driver.findElement(By.xpath("//button[text()='Search flights']")).click();
		
	}

}
