package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsClick {
	public void productsClick(WebDriver driver) {
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	}
	
	public void productDetails(WebDriver driver, String productName) {
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}
