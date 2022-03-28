package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSelenium.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerLastCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "manager");
		
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		//List<WebElement> checkBoxesClick = driver.findElements(By.xpath("//input[@type='checkbox' and @name='selected_id']"));
		WebElement checkBox = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[1]"));
		checkBox.click();
		

		
	}
}
