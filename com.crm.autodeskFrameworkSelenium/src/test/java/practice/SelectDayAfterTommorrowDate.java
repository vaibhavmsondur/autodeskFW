package practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDayAfterTommorrowDate {

	public static void main(String[] args) {
		LocalDateTime ldt= LocalDateTime.now().plusDays(2);
		int date = ldt.getDayOfMonth();
		int year = ldt.getYear();
		String month = ldt.getMonth().toString();
		String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
		String monthAndYear= actualMonth+" "+year;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		Actions act= new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String xpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(xpath)).click();
	
	}

}
