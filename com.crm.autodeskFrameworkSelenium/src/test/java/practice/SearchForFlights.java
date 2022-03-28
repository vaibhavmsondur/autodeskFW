package practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchForFlights {

	public static void main(String[] args) {
		LocalDateTime ldt= LocalDateTime.now();
		int date = ldt.getDayOfMonth();
		int year = ldt.getYear();
		String month = ldt.getMonth().toString();
		String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
		String monthAndYear= actualMonth+" "+year;
		String srcPlace="Bangalore";
		String destPlace="Pune";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		driver.get("https://www.makemytrip.com/");
		Actions act= new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		try {
			driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		} catch (Exception e) {
			System.out.println("PopUp not present");
		}
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		//driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(srcPlace);
		driver.findElement(By.xpath("//p[contains(@class,'blackText') and contains(text(),'"+srcPlace+"')]")).click();
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(destPlace);
		driver.findElement(By.xpath("//p[contains(@class,'blackText') and contains(text(),'"+destPlace+"')]")).click();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String xpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(xpath)).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
	
		WebElement ele = driver.findElement(By.xpath("//p[text()='Flights from ']"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		List<WebElement> flightsList = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
		
		for (WebElement flight : flightsList) {
			System.out.println("Flight Company Name :"+flight.getText());
		}
	}

}
