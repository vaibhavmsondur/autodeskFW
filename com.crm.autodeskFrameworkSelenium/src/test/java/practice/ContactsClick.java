package practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsClick {
	public void contactsClick(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contacts']")));
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	}
	
	public void contactsDetails(WebDriver driver, String lname) {
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	public void contactsDetails(WebDriver driver, String lname,String orgName) throws Throwable {
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		Iterator<String> it= allWindowIds.iterator();
		while (it.hasNext()) {
			String windowId= it.next();
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains("Accounts")) {
				break;
			}
		}
		List<WebElement> orgNames = driver.findElements(By.xpath("//a[text()]"));
		for (WebElement ele : orgNames) {
			if (ele.getText().equalsIgnoreCase(orgName)) {
				ele.click();
				break;
			}
		}
		Iterator<String> it1= allWindowIds.iterator();
		while (it1.hasNext()) {
			String windowId= it1.next();
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains("Contacts")) {
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}
