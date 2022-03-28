package properties;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerProperties {

	public static void main(String[] args) {
		WebDriver driver= null;
		try {
			FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\commonData\\credentials.properties");
			Properties prop = new Properties();
			prop.load(fin);
			
			String browser = prop.getProperty("browser");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password=prop.getProperty("password");
			
			System.out.println(browser);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			
			//Runtime Polymorphism
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				System.out.println("Driver Launched "+ browser);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				System.out.println("Driver Launched "+ browser);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
		}catch (Exception e){
			System.err.println("Please Provide Valid Browser");
		}
	}
}
