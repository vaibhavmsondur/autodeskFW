package com.crm.autodeskSeleniumFramework.vtiger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation {

	public static void main(String[] args) throws Exception {
		
		Random ran= new Random();
		int rannum= ran.nextInt(1000);
		String orgName= "TestYantra"+rannum;
		
		ExcelLib lib = new ExcelLib();
		String username = lib.getLibData("credentials",0,0);
		String password = lib.getLibData("credentials",0,1);
		
		ChromeOptions option= new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitbutton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actualName.contains(orgName)) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		WebElement logoutbutton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions= new Actions(driver);
		actions.moveToElement(logoutbutton).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
