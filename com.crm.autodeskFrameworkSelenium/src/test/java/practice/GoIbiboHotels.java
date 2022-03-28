package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbiboHotels {

	public static void main(String[] args) throws Throwable {
//		LocalDateTime ldt= LocalDateTime.now();
//		int date = ldt.getDayOfMonth();
//		int year = ldt.getYear();
//		String month = ldt.getMonth().toString();
//		String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
//		String monthAndYear = actualMonth+" "+year;
//		int datePlus = LocalDateTime.now().plusDays(1).getDayOfMonth();
//		System.out.println(datePlus);
		String cityName="Bengaluru";
		String checkInDate = "31";
		String checkOutDate="1";
		String year = "2022";
		String checkInMonth = "March";
		String  checkOutMonth= "April";
		String checkInMonthAndYear = checkInMonth+" "+year;
		String checkOutMonthAndYear= checkOutMonth+" "+year;
		int noOfChildren=3;
		int noOfAdults=2;
		int noOfRooms=1;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		driver.get("https://www.goibibo.com");
		
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.xpath("//h4[text()='India']/parent::div/child::input[@name='CountryType']")).click();
		WebElement city = driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']"));
		city.sendKeys(cityName);
		//city.sendKeys(Keys.ARROW_DOWN);
		//Thread.sleep(250);
		//city.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']/following-sibling::ul")).click();
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		String checkInXpath = "//span[text()='"+checkInMonthAndYear+"']/ancestor::div[contains(@class,'CalenderMonthContainer')]/child::div[contains(@class,'CalendarMainWrapperDiv')]/descendant::span[text()='"+checkInDate+"']";
		driver.findElement(By.xpath(checkInXpath)).click();
		String checkOutXpath = "//span[text()='"+checkOutMonthAndYear+"']/ancestor::div[contains(@class,'CalenderMonthContainer')]/child::div[contains(@class,'CalendarMainWrapperDiv')]/descendant::span[text()='"+checkOutDate+"']";
		driver.findElement(By.xpath(checkOutXpath)).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		
		for (int i = 0; i < noOfChildren; i++) {
			driver.findElement(By.xpath("//span[text()='Children']/following-sibling::div/span[text()='+']")).click();
		}
		
		for (int i = 2; i < noOfAdults; i++) {
			driver.findElement(By.xpath("//span[text()='Adults']/following-sibling::div/span[text()='+']")).click();
		}
		
		for (int i = 1; i < noOfRooms; i++) {
			driver.findElement(By.xpath("//span[text()='Rooms']/following-sibling::div/span[text()='+']")).click();
		}
		
		for (int i = 1; i <= noOfChildren; i++) {
			driver.findElement(By.xpath("//span[text()='Child ' and text()='"+i+"']//following-sibling::div/child::h4")).click();
			driver.findElement(By.xpath("//li[text()='"+i+"']")).click();
		}
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		WebElement allHotelsTab = driver.findElement(By.xpath("//span[text()='All Hotels']"));
		wait.until(ExpectedConditions.visibilityOf(allHotelsTab));
		List<WebElement> listOfHotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
		int count=1;
		for (WebElement ele : listOfHotels) {
			System.out.println("HotelName"+count+": "+ele.getText());
			count++;
		}
		
	}

}
